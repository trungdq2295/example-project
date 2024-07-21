package com.trungnguyen.sec02.assignment;

import com.trungnguyen.common.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileServiceImpl implements FileService{
    @Override
    public Mono<String> read(String fileName) {
        return Mono.fromCallable(() -> {
            Path path = Paths.get(fileName);
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                    path, StandardOpenOption.READ
            );
            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());
            var value = fileChannel.read(buffer,0);
            return value.get().toString();
        });
    }

    @Override
    public Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> {
            Path path = Paths.get(fileName);
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            AsynchronousFileChannel fileChannel = null;
            try {
                fileChannel = AsynchronousFileChannel.open(
                        path, StandardOpenOption.WRITE, StandardOpenOption.CREATE
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fileChannel.write(buffer, 1);
        });
    }

    @Override
    public Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> {
            try{
                Files.deleteIfExists(Path.of(fileName));
            }catch (Exception e){

            }
        }).subscribeOn(Schedulers.boundedElastic()).then();
    }


    public static void main(String[] args) {
        FileService abc = new FileServiceImpl();
        abc.write("TN.txt", "This is a test")
                .subscribe(Util.subscriber("write"));
        Util.sleepSeconds(2);
        abc.read("TN.txt")
                .subscribe(Util.subscriber("read"));
        abc.delete("TN.txt")
                .subscribe(Util.subscriber("delete"));
    }
}
