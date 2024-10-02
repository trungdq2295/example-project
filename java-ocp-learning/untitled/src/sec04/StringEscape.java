package sec04;

public class StringEscape {


    public static void main(String[] args) {


        System.out.println("My favourite book is \"The one thing\" by Gary Keller");
        System.out.println("path to the source code: D:\\Java\\sources");

        /*
            \t - tab
            \b - backspace => remove 1 text
            \n - new line
            \r - carriage return
            \f - form feed
            \' - single quote
            \" - double quotes
            \\back slash
            \\u - Unicode
            
         */
        System.out.println("hello World\b, abc");
        System.out.println("Good Evening\rCoders! ");
    }
}
