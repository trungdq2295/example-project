package sec04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {


    public static void main(String[] args) {
        String gmailPattern = "[a-zA-Z-\\d]+@gmail\\.com";
        Pattern pattern = Pattern.compile(gmailPattern);
        String sampleText = " abcxyz 123s1ome-email123@gmail.com. chickendje02@gmail.abc.com And some Text";
        Matcher m = pattern.matcher(sampleText);
        if(m.find()){
            String gmailAddress = m.group();
            System.out.println(gmailAddress);
        }

        String sampleText123 = "There are three sentences in this string. Are you sure? Yes!";
        String[] setennces = sampleText123.split("[!?]");
        System.out.println(setennces[0]);

    }
}
