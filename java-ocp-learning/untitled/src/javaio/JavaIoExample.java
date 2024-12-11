package javaio;

import java.io.*;
import java.nio.file.Paths;

public class JavaIoExample {

    public static void main(String[] args) throws IOException {
        OutputStream stream = new BufferedOutputStream(new FileOutputStream(Paths.get("").toFile()));
        ObjectOutputStream abc = new ObjectOutputStream(stream);
        InputStream stream1 = new BufferedInputStream(new FileInputStream(Paths.get("").toFile()));
    }
}
