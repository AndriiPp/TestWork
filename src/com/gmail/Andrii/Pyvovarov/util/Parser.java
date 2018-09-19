package com.gmail.Andrii.Pyvovarov.util;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;
import com.gmail.Andrii.Pyvovarov.data.primitives.DateRange;
import com.gmail.Andrii.Pyvovarov.data.primitives.QuestionType;
import com.gmail.Andrii.Pyvovarov.data.primitives.ResponseType;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    private DateRange constructDateRange(String dateRangeString) {
            String dateFrom;
            String dateTo;
            String[] datePeriods = dateRangeString.split(Validator.DATE_SPLITER);
            DateRange datePeriod = null;
            if (datePeriods.length == 1) {
                dateFrom = datePeriods[0];
                datePeriod = new DateRange(dateFrom, null);
                return datePeriod;
            } else {
                dateFrom = datePeriods[0];
                dateTo = datePeriods[1];
            }
            return new DateRange(dateFrom, dateTo);

    }

    private Service constructService(String servise) {
        Service service = null;
        if (Validator.checkServise(servise)) {
            String[] serviceContains = servise.split(Validator.POINT);
            String serviceId = serviceContains[0];
            if (serviceCheckVariation(serviceContains)) {
                service = new Service(serviceId, createVariation(serviceContains[1]));
            } else {
                service = new Service(serviceId, null);
            }
            return service;
        } else return null;
    }

    private QuestionType constructQuestionType(String questionTypeLine) {
        QuestionType questionType = null;
        if (Validator.checkTypeQuestion(questionTypeLine)) {

            String[] questionTypeContains = questionTypeLine.split(Validator.POINT);
            String questionTypeContain = questionTypeContains[0];

            if (questionTypeContains.length > 2) {
                questionType = new QuestionType(questionTypeContain,
                        new QuestionType.CategoryQuestionType(questionTypeContains[1],
                                new QuestionType.CategoryQuestionType.SubCategory(questionTypeContains[2])));
            } else if (questionTypeContains.length == 2) {
                questionType = new QuestionType(questionTypeContain, new QuestionType.CategoryQuestionType(questionTypeContains[1], null));
            } else {
                questionType = new QuestionType(questionTypeContain);
            }
            return questionType;


        } else return null;

    }

    private ResponseType constructResponseType(String responseType) {
        if (Validator.checkResponseType(responseType)) {
            return new ResponseType(responseType);
        } else return null;
    }


    private boolean serviceCheckVariation(String[] serviceContains) {
        return serviceContains.length == 2;
    }

    private Service.Variation createVariation(String variation) {
        return new Service.Variation(variation);
    }

    public void parseFile(String filePath) throws IOException {

        Map<QueryLine, List<DataLine>> QueryLineandDataLine = new LinkedHashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            List<DataLine> dataLines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                String[] linePart = line.split(Validator.SPACE_SPLITER);

                if (Validator.checkTypeLine_C(linePart[0])) {
                    DataLine dataLine = new DataLine();
                    dataLine.setService(constructService(linePart[1]));
                    dataLine.setQuestionType(constructQuestionType(linePart[2]));
                    dataLine.setResponseType(constructResponseType(linePart[3]));
                    dataLine.setDateLine(linePart[4]);
                    dataLine.setTime(Integer.parseInt(linePart[5]));
                    dataLines.add(dataLine);

                } else {

                    QueryLine queryLine = new QueryLine();
                    queryLine.setService(constructService(linePart[1]));
                    queryLine.setQuestionType(constructQuestionType(linePart[2]));
                    queryLine.setResponseType(constructResponseType(linePart[3]));
                    queryLine.setDateRange(constructDateRange(linePart[4]));
                    QueryLineandDataLine.put(queryLine,dataLines);
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}