package com.gmail.Andrii.Pyvovarov;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;
import com.gmail.Andrii.Pyvovarov.service.Services;
import com.gmail.Andrii.Pyvovarov.util.Parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String filePath1 = "C:\\Users\\Lev-\\Desktop\\1.txt";
    public static void main(String[] args) {
	// write your code here
        Parser parser = new Parser();
        Services services = new Services();
        try {
            Map<QueryLine, List<DataLine>> data = parser.parseFile(filePath1);
            services.matching(data);
             List result = services.getResult();
            int a =2;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
