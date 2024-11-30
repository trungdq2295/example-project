package stringexample;

public class StringExample {


    public static void main(String[] args) {

        var smart = """
                barn owl\n\n
                wise
                """;
        var cleaver = """
                  barn owl\n\n
              wise
          """;
        var sly = """
                barn owl\n\n
                wise""";
//        System.out.println(cleaver);
//        System.out.println(smart.stripIndent());
//        System.out.println(cleaver.strip());
//        System.out.println(sly.strip());
//
//        System.out.println(smart.equals(smart.strip()));
//        System.out.println(cleaver.equals(cleaver.strip()));
//        System.out.println(sly.equals(sly.strip()));
//
//
//        System.out.println(sly.equals(sly.indent(0)));
//        System.out.println(smart.equals(smart.indent(0)));
//        System.out.println(cleaver.equals(cleaver.indent(0)));
//
//        System.out.println(sly.equals(sly.strip()));
//        System.out.println(smart.equals(smart.strip()));
//        System.out.println(cleaver.equals(cleaver.strip()));
//
//        System.out.println(sly.equals(sly.stripIndent()));
//        System.out.println(smart.equals(smart.stripIndent()));
        System.out.println(cleaver.equals(cleaver.stripIndent()));
        System.out.println(cleaver.stripIndent());
    }
}

class abc{
    public static void main(String[] args) {
        String textBlock = """
                Line 1
                  Line 2
                Line 3
                """;

        String strippedText = textBlock.stripIndent();

        System.out.println("Original text block:");
        System.out.println(textBlock);
        System.out.print("a");
        System.out.println("Stripped text block:");
        System.out.println(strippedText);
        System.out.print("a");
    }
}
