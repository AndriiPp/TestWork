package com.gmail.Andrii.Pyvovarov.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OutputData {

    public static void outResult(List<String> result, String outFile){

        outToConsol(result);
        outToFile(result,outFile);
    }

    private static void outToConsol(List<String> result){
        for (String value :result){
            System.out.println(value);
        }
    }

    private  static void  outToFile(List<String> result, String outTofile){
        Path file = Paths.get(outTofile);
        try {
            Files.write(file, result, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
