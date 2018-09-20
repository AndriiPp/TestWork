package com.gmail.Andrii.Pyvovarov;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;
import com.gmail.Andrii.Pyvovarov.service.Services;
import com.gmail.Andrii.Pyvovarov.util.OutputData;
import com.gmail.Andrii.Pyvovarov.util.Parser;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    private static String filePathInput;
    private static String filePathOutput;

    public static void main(String[] args) {
        Map<QueryLine, List<DataLine>> data = null;
        Parser parser = new Parser();
        Services services = new Services();
        OutputData outputData = new OutputData();
        getFiles(args);
        try {
            data = parser.parseFile(filePathInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        services.matching(data);
        List<String> result = services.getResult();
        outputData.outResult(result,filePathOutput);
    }

    private static void getFiles(String[] args) {
        filePathInput = args[0];
        filePathOutput = args[1];
    }
}
