package design_pattern.structure.flyweight;

import java.util.ArrayList;
import java.util.List;

public class DemoTextFormatting {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        FormattedText text = new FormattedText("This is a brave word");
        text.capitalize(10, 15);
        System.out.println(text);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        BetterFormattedText bft = new BetterFormattedText("This is a brave word");
        bft.getRange(13, 18).capitalize = true;
        System.out.println(bft);
        System.out.println(System.currentTimeMillis() - start);
    }
}

class FormattedText {
    private String plainText;

    private boolean[] capitalize;

    public FormattedText(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end) {
        for (int i = start; i < end; i++) {
            capitalize[i] = true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            sb.append(capitalize[i] ? Character.toUpperCase(c) : c);
        }
        return sb.toString();
    }
}

class BetterFormattedText {

    private String plainText;

    private List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange range = new TextRange(start, end);
        formatting.add(range);
        return range;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            for (TextRange range : formatting) {
                if (range.covers(i) && range.capitalize) {
                    c = Character.toUpperCase(c);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public class TextRange {
        public int start;
        public int end;

        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }
    }
}
