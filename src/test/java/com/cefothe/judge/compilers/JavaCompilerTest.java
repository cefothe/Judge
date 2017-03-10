package com.cefothe.judge.compilers;

import com.cefothe.judge.common.ProgramLanguages;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Created by Stefan Angelov - Delta Source Bulgaria on 3/7/17.
 */
public class JavaCompilerTest {

    @Test
    public void compileJavaFile() throws IOException {
        File compilerDirectory = new File(JavaCompilerTest.class.getResource("/compiler").getFile());
        String fileName = "Test.java";
        ProgramLanguages programLanguages = ProgramLanguages.JAVA;
        programLanguages.compiler().compile(compilerDirectory.getAbsolutePath()+"/",fileName);
        File file = new File(JavaCompilerTest.class.getResource("/compiler/Test.class").getFile());
    }

    public void failCompileJavaFile() {

    }
}
