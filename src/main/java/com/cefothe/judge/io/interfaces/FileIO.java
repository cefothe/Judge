package com.cefothe.judge.io.interfaces;

import java.io.File;
import java.io.IOException;

/**
 * Created by cefothe on 10.01.17.
 */
public interface FileIO {
    StringBuffer read(String fileName) throws IOException;
    void write(String fileContent, String destination, String fileName) throws IOException;
}
