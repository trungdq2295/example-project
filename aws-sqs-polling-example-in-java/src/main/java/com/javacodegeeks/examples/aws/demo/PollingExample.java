package com.javacodegeeks.examples.aws.demo;

import java.time.Instant;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.DeleteQueueRequest;
import software.amazon.awssdk.services.sqs.model.DeleteQueueResponse;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class PollingExample {

    private static final Logger logger = LogManager.getLogger(PollingExample.class);

    /**
     * Hard-coded constants for example purpose only
     */
    private static final String REGION = "ap-southeast-2";
    private static final String QUEUE_NAME = "MyQueue";

    /**
     * The JSON object mapper.
     */
    private static ObjectMapper objectMapper;
    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    private SqsClient sqsClient;

    public static void main(String[] args) {
        boolean useLongPolling = false;

        // if "useLongPolling" argument is specified
        if (args != null && args.length == 1 && "useLongPolling".equals(args[0])) {
            useLongPolling = true;
        }

        PollingExample example = new PollingExample();

        // create the queue
        example.createQueue(QUEUE_NAME);

        // start the consumer
        ExecutorService consumerExecutorService = Executors.newSingleThreadExecutor();
        MyConsumer myConsumer = new MyConsumer(QUEUE_NAME, example.getSqsClient(), useLongPolling);
        Future<?> consumerResult = consumerExecutorService.submit(myConsumer);

        // sleep 3 seconds before sending a message
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // do nothing
        }

        // send a message
        ExecutorService producerExecutorService = Executors.newSingleThreadExecutor();
        MyProducer producer = new MyProducer(QUEUE_NAME, example.getSqsClient());
        Future<?> producerResult = producerExecutorService.submit(producer);
        // block util the producer finishes
        try {
            producerResult.get();
        } catch (InterruptedException | ExecutionException e) {
            // do nothing
        }

        // block util the consumer finishes
        try {
            consumerResult.get();
        } catch (InterruptedException | ExecutionException e) {
            // do nothing
        }

        // delete the queue
        example.deleteQueue(QUEUE_NAME);

        // shut down thread pools
        producerExecutorService.shutdown();
        try {
            if (!producerExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                producerExecutorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            producerExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        consumerExecutorService.shutdown();
        try {
            if (!consumerExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                consumerExecutorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            consumerExecutorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Constructor.
     */
    public PollingExample() {
        // create a SQS client
        this.sqsClient = SqsClient.builder().region(Region.of(REGION)).build();
    }

    /**
     * Create a standard/fifo queue.
     *
     * @param queueName          the queue name. FIFO queue name must end with
     *                           ".fifo".
     * @param longPollingSeconds an integer great than 0 will enables long polling
     * @param visibilityTimeout  a period of time a message is hidden from other
     *                           consumers
     * @return The queue URL
     */
    public String createQueue(String queueName) {
        logger.info("Create queue {} in region {}", queueName, REGION);
        CreateQueueRequest request = CreateQueueRequest.builder().queueName(queueName).build();
        this.sqsClient.createQueue(request);
        String queueUrl = getQueueUrl(queueName);
        logger.info("Queue URL: {}", queueUrl);
        return queueUrl;
    }

    /**
     * Delete the given queue.
     *
     * @param queueName the queue name
     */
    public void deleteQueue(String queueName) {
        logger.info("Delete queue {}", queueName);
        String queueUrl = getQueueUrl(queueName);
        DeleteQueueRequest deleteQueueRequest = DeleteQueueRequest.builder().queueUrl(queueUrl).build();
        DeleteQueueResponse deleteQueueResponse = this.sqsClient.deleteQueue(deleteQueueRequest);
        if (deleteQueueResponse.sdkHttpResponse().isSuccessful()) {
            logger.info("Queue {} deleted.", queueName);
        } else {
            logger.error("Failed to delete queue {}: {} - {}", queueName, deleteQueueResponse.sdkHttpResponse().statusCode(),
                    deleteQueueResponse.sdkHttpResponse().statusText());
        }
    }

    /**
     * Get the queue url by queue name.
     * 
     * @param queueName
     * @return the queue url
     */
    private String getQueueUrl(String queueName) {
        GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
        GetQueueUrlResponse getQueueUrlResponse = this.sqsClient.getQueueUrl(getQueueUrlRequest);
        return getQueueUrlResponse.queueUrl();
    }

    /**
     * @return the sqsClient
     */
    public SqsClient getSqsClient() {
        return sqsClient;
    }

    /**
     * MyEvent POJO.
     */
    private static class MyEvent {
        private String id;
        private Instant timeStamp;
        private String source;
        private String payload;

        public MyEvent() {
            this.timeStamp = Instant.now();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Instant getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(Instant timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getPayload() {
            return payload;
        }

        public void setPayload(String payload) {
            this.payload = payload;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", MyEvent.class.getSimpleName() + "[", "]")
                    .add("id='" + id + "'")
                    .add("timeStamp=" + timeStamp)
                    .add("source='" + source + "'")
                    .add("payload='" + payload + "'")
                    .toString();
        }
    }

    /**
     * An AWS SQS message producer.
     */
    private static class MyProducer implements Runnable {
        private static final Logger logger = LogManager.getLogger(MyProducer.class);
        private final String queueName;
        private final SqsClient sqsClient;

        public MyProducer(String queueName, SqsClient sqsClient) {
            this.queueName = queueName;
            this.sqsClient = sqsClient;
        }

        @Override
        public void run() {
            // sample message
            MyEvent myEvent = new MyEvent();
            myEvent.setId(UUID.randomUUID().toString());
            myEvent.setSource(Thread.currentThread().getName());
            myEvent.setPayload("AWS SQS polling example.");

            String message = null;
            try {
                message = objectMapper.writeValueAsString(myEvent);
            } catch (JsonProcessingException e) {
                logger.error(e);
            }

            if (message != null) {
                String queueUrl = getQueueUrl(this.queueName);
                SendMessageRequest.Builder builder = SendMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .messageBody(message);
                // send the message
                logger.info("Sending message to queue {}", this.queueName);
                this.sqsClient.sendMessage(builder.build());
            }
        }

        /**
         * Get the queue url by queue name.
         * 
         * @param queueName
         * @return the queue url
         */
        private String getQueueUrl(String queueName) {
            GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
            GetQueueUrlResponse getQueueUrlResponse = this.sqsClient.getQueueUrl(getQueueUrlRequest);
            return getQueueUrlResponse.queueUrl();
        }
    }

    /**
     * A runnable task run by a thread to simulate a user application consuming
     * messages from the queue.
     */
    private static class MyConsumer implements Runnable {
        private static final Logger logger = LogManager.getLogger(MyConsumer.class);
        private static final Integer LONG_POLLING_SECONDS = 20;
        private static final int MAX_POLLING_ATTEMPTS = 10;
        private final String queueName;
        private final SqsClient sqsClient;
        private final boolean useLongPolling;

        /**
         * Constructor.
         * 
         * @param queueName
         * @param sqsClient
         * @param useLongPolling
         */
        public MyConsumer(String queueName, SqsClient sqsClient, boolean useLongPolling) {
            this.queueName = queueName;
            this.sqsClient = sqsClient;
            this.useLongPolling = useLongPolling;
        }

        @Override
        public void run() {
            logger.info("{} poll messages from {}...", this.useLongPolling ? "Long" : "Short", this.queueName);

            // polling
            String queueUrl = getQueueUrl(queueName);
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .waitTimeSeconds(this.useLongPolling ? LONG_POLLING_SECONDS : 0) // forces long polling or short polling
                    .build();

            // try MAX_ATTEMPTS times for demo purpose instead of self spinning forever
            int attempt = 1;
            do {
                logger.info("Polling attempt #{}", attempt);
                List<Message> messages = this.sqsClient.receiveMessage(receiveMessageRequest).messages();
                // return when any message is available instead of polling again
                if (!messages.isEmpty()) {
                    logger.info("{} messages received.", messages.size());

                    // process and delete message
                    for (Message message : messages) {
                        processMessage(message);
                        deleteMessage(this.queueName, message);
                    }

                    break;
                }
                
                attempt++;
                
                // sleep 500ms between each attempt
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // do nothing
                }
            } while (attempt <= MAX_POLLING_ATTEMPTS);
        }

        /**
         * Process message.
         * 
         * @param message the message
         */
        private void processMessage(Message message) {
            logger.info("Processing message {}", message.messageId());

            // deserialise message body
            MyEvent myEvent = null;
            try {
                myEvent = objectMapper.readValue(message.body(), MyEvent.class);
            } catch (JsonProcessingException e) {
                logger.error(e);
            }

            logger.info("Message processed: MyEvent={}", myEvent == null ? null : myEvent.toString());
        }

        /**
         * Delete the message from the queue.
         * 
         * @param queueName the queue name
         * @param message   the message to be deleted
         */
        private void deleteMessage(String queueName, Message message) {
            String queueUrl = getQueueUrl(queueName);
            logger.info("Deleting message {} from queue: {}", message.messageId(), queueName);
            DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder().queueUrl(queueUrl).receiptHandle(message.receiptHandle())
                    .build();
            this.sqsClient.deleteMessage(deleteMessageRequest);
        }

        /**
         * Get the queue url by queue name.
         * 
         * @param queueName
         * @return the queue url
         */
        private String getQueueUrl(String queueName) {
            GetQueueUrlRequest getQueueUrlRequest = GetQueueUrlRequest.builder().queueName(queueName).build();
            GetQueueUrlResponse getQueueUrlResponse = this.sqsClient.getQueueUrl(getQueueUrlRequest);
            return getQueueUrlResponse.queueUrl();
        }
    }

}
