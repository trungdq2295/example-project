package design_pattern.creational.builder;

import java.util.ArrayList;
import java.util.List;

class Field {
    String value;

    String dataType;

    public Field(String value, String dataType) {
        this.value = value;
        this.dataType = dataType;
    }

    public String toString() {
        return dataType + " " + value;
    }
}

public class Code {

    String title;

    List<Field> field = new ArrayList<>();

    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(cb);
    }

}

class CodeBuilder {

    protected Code code = new Code();

    public CodeBuilder(String title) {
        code.title = title;
    }

    public CodeBuilder addField(String fieldName, String dataType) {
        Field field = new Field(fieldName,dataType);
        code.field.add(field);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("public class ").append(code.title);
        stringBuilder.append("\n");
        stringBuilder.append("{");
        stringBuilder.append("\n");
        code.field.forEach(item -> {
            stringBuilder.append("  public ").append(item).append(";\n");
        });
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}




