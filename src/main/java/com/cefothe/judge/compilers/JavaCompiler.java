package com.cefothe.judge.compilers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cefothe on 13.07.16.
 */
public class JavaCompiler implements  Compiler {

    @Override
    public void compile(String directory, String className) throws IOException {

                    Process process = new ProcessBuilder("javac",directory+className)
                            .redirectErrorStream(true)
                            .start();
         BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //Throw same exeption
        if(!(br.readLine()!=null && br.readLine().isEmpty())){
            System.out.println("Error");
        }
    }
}
