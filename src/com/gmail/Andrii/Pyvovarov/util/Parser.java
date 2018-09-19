package com.gmail.Andrii.Pyvovarov.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {


    public void parseFile(String filePath) throws IOException {


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {

               String [] linePart =  line.split(Validator.SPACE_SPLITER);

               if(Validator.checkTypeQuestion(linePart[0])){

               }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();


        }
    }
}