package sec04;

public class StringFormatting {

    public static void main(String[] args) {
        String greetingTemplate = "Hello, dear %s! Good %s!";
        String morning = "morning";
        String evening = "evening";
        String afternoon = "afternoon";
        String firstName = "TN";

        /*
            If you pass more argument, it will be ignored
            If you pass less, jvm wil throw exception during runtime
         */
        String formattedString = String.format(greetingTemplate, firstName, morning);
        System.out.println(formattedString);

        System.out.printf("You have %d computers available at store\n", 10);
    }
}
