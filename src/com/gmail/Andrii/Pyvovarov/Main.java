package com.gmail.Andrii.Pyvovarov;

import com.gmail.Andrii.Pyvovarov.util.Parser;

import java.io.IOException;

public class Main {
    private static final String filePath1 = "C:\\Users\\Lev-\\Desktop\\1.txt";
    public static void main(String[] args) {
	// write your code here
        Parser parser = new Parser();

        try {
            parser.parseFile(filePath1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
