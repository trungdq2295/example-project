package design_pattern.structure.facade;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(30, 20);
        Viewport viewport = new Viewport(buffer, 30, 20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewport(viewport);
        console.render();

        // this is facade
        Console console2 = Console.newConsole(30,20);
    }
}


class Buffer {
    private char[] characters;

    private int lineWidth;

    public Buffer(int lineHeight, int lineWidth) {
        this.lineWidth = lineWidth;
        characters = new char[lineWidth * lineHeight];
    }

    public char charAt(int x, int y) {
        return characters[y * lineWidth + x];
    }
}

class Viewport {

    private final Buffer buffer;

    private final int width;
    private final int height;
    private final int offsetX;
    private final int offsety;

    public Viewport(Buffer buffer, int width, int height, int offsetX, int offsety) {
        this.buffer = buffer;
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsety = offsety;
    }

    public char charAt(int x, int y) {
        return buffer.charAt(x + offsetX, y + offsety);
    }
}

class Console {
    private List<Viewport> viewport = new ArrayList<>();

    int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewport(Viewport viewport) {
        this.viewport.add(viewport);
    }

    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(width, height);
        Viewport viewport = new Viewport(buffer, width, height, 0, 0);
        Console console = new Console(width, height);
        console.addViewport(viewport);
        return console;
    }

    public void render() {
        for (int i = 0; i < height; ++i) {
            for (int x = 0; x < width; ++x) {
                for (Viewport vp : this.viewport) {
                    System.out.println(vp.charAt(x, i));
                }
            }
            System.out.println();
        }
    }
}


