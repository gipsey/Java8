package org.davidd.presentation;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Consumer;

public class Example {

    @Test
    public void example1_methodReference() {
        FileFilter filter = File::isHidden;
        File[] files = new File("E://").listFiles(filter);

        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    @Test
    public void example2_methodReference() {
        Consumer<String> methodRef = System.out::println;

        methodRef.accept("Hello");
    }


}
