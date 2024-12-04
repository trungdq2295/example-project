package sec04;


import java.time.LocalDate;
import java.time.Month;

public class HomeWork {


    public static void main(String[] args) {

        var text = """
                ant antelope \s \n
                cat "kitten"
                "seal sea lion"\s
                """;

        var date = LocalDate.of(2022, Month.FEBRUARY, 28);
        System.out.println(text);
    }
}

