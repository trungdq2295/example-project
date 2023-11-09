package design_pattern.structure.flyweight;


import java.util.List;

public class Excercise {
}


class Sentence {

    private String plainText;

    private List<WordToken> wordTokens;

    public Sentence(String plainText) {
        this.plainText = plainText;
        for (String s : plainText.split(" ")) {
            WordToken wordToken = new WordToken(s);
            wordTokens.add(wordToken);
        }
    }

    public WordToken getWord(int index) {
        return wordTokens.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (WordToken token : wordTokens) {
            sb.append(token.capitalize ? token.text.toUpperCase() : token.text);
        }
        return sb.toString();
    }

    class WordToken {

        private String text;
        public boolean capitalize;

        public WordToken(String text) {
            this.text = text;
        }
    }
}