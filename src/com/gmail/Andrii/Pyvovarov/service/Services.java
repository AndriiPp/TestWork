package com.gmail.Andrii.Pyvovarov.service;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;
import com.gmail.Andrii.Pyvovarov.data.primitives.QuestionType;
import com.gmail.Andrii.Pyvovarov.data.primitives.ResponseType;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;
import com.gmail.Andrii.Pyvovarov.util.Validator;

import javax.swing.text.html.parser.Entity;
import java.security.KeyStore;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Services {

    private static final String ASTERISK = "*";
    private List result;

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }


    public void matching(Map<QueryLine, List<DataLine>> data) {


        result = new ArrayList<String>();
        for (Map.Entry<QueryLine, List<DataLine>> entry : data.entrySet()) {
            int countMached = 0;
            int sumSec = 0;
            for (DataLine dataLine : entry.getValue()) {
                if (compareDateLineQueryLine(dataLine, entry.getKey())) {
                    sumSec += dataLine.getTime();
                    countMached++;
                }
            }
            if (countMached != 0) {
                result.add(sumSec / countMached);
            } else {
                entry.getKey().setAnswerAverageTime("-");
                result.add("-");
            }
        }

}

    private boolean compareTypeQuestion(QuestionType questionTypeD, QuestionType questionTypeC) {
        return questionTypeD.getQuestionType().equals(ASTERISK) ||
                questionTypeD.equals(questionTypeC);

    }

    private boolean compareTypeServise(Service serviceD, Service serviceC) {
        return serviceD.getService().equals(ASTERISK) || serviceD.equals(serviceC);
    }

    private boolean compareDate(String dateC, String dateStart, String dateEnd) {

        DateFormat df = new SimpleDateFormat(Validator.DATE);

        Date dateStartobj = null;
        Date dateCobj = null;
        Date dateEndobj = null;
        try {
            dateCobj = df.parse(dateC);
            dateStartobj = df.parse(dateStart);
            if (dateEnd == null) {
                return dateC.equals(dateStart);
            } else dateEndobj = df.parse(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateCobj.after(dateStartobj) && dateCobj.before(dateEndobj);
    }

    private boolean compareTypeResponse(ResponseType responseTypeD, ResponseType responseTypeC) {

        return responseTypeD.getResponceType().equals(ASTERISK) || responseTypeD.equals(responseTypeC);
    }

    private boolean compareDateLineQueryLine(DataLine dataLine, QueryLine queryLine) {
        return compareTypeServise(dataLine.getService(), queryLine.getService())
                && compareTypeQuestion(queryLine.getQuestionType(), dataLine.getQuestionType())
                && compareTypeResponse(dataLine.getResponseType(), queryLine.getResponseType())
                && compareDate(dataLine.getDateLine(), queryLine.getDateRange().getDateStart(), queryLine.getDateRange().getDateEnd());
    }

    /*private boolean compareDateLineQueryLine(DataLine dataLine, QueryLine queryLine) {
        Boolean BOL1 = compareTypeServise(dataLine.getService(), queryLine.getService());
        Boolean BOL2 = compareTypeQuestion(queryLine.getQuestionType(), dataLine.getQuestionType());
        Boolean BOL3 = compareTypeResponse(dataLine.getResponseType(), queryLine.getResponseType());
        Boolean BOL4 = compareDate(dataLine.getDateLine(), queryLine.getDateRange().getDateStart(), queryLine.getDateRange().getDateEnd());
        return true;
    }*/
}
