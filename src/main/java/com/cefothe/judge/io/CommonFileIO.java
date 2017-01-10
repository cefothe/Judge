package com.cefothe.judge.io;

import com.cefothe.judge.io.interfaces.FileIO;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by cefothe on 10.01.17.
 */
@Component
public class CommonFileIO implements FileIO {

    @Override
    public StringBuffer read(String fileName) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            br.lines().forEach(a->{
                stringBuffer.append(a);
                stringBuffer.append(System.getProperty("line.separator"));
            });
        }
        return  stringBuffer;
    }

    @Override
    public void write(String fileContent, String destination, String fileName) throws IOException {
        try (
                OutputStream outputStream = new FileOutputStream(destination + fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))
        ) {
            bufferedWriter.write(fileContent);
        }
    }


}
