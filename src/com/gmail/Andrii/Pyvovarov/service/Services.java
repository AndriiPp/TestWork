package com.gmail.Andrii.Pyvovarov.service;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;
import com.gmail.Andrii.Pyvovarov.data.primitives.QuestionType;
import com.gmail.Andrii.Pyvovarov.data.primitives.ResponseType;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;
import com.gmail.Andrii.Pyvovarov.util.Constans;
import com.gmail.Andrii.Pyvovarov.util.Validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Services {

    private List<String> result;

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
                result.add(Integer.toString(sumSec / countMached));
            } else {
                entry.getKey().setAnswerAverageTime(Constans.DASH);
                result.add(Constans.DASH);
            }
        }

}

    private boolean compareTypeQuestion(QuestionType questionTypeD, QuestionType questionTypeC) {
        return questionTypeD.getQuestionType().equals(Constans.ASTERISK) ||
                questionTypeD.equals(questionTypeC);

    }

    private boolean compareTypeServise(Service serviceD, Service serviceC) {
        return serviceD.getService().equals(Constans.ASTERISK) || serviceD.equals(serviceC);
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

        return responseTypeD.getResponceType().equals(Constans.ASTERISK) || responseTypeD.equals(responseTypeC);
    }

    private boolean compareDateLineQueryLine(DataLine dataLine, QueryLine queryLine) {
        return compareTypeServise(dataLine.getService(), queryLine.getService())
                && compareTypeQuestion(queryLine.getQuestionType(), dataLine.getQuestionType())
                && compareTypeResponse(dataLine.getResponseType(), queryLine.getResponseType())
                && compareDate(dataLine.getDateLine(), queryLine.getDateRange().getDateStart(), queryLine.getDateRange().getDateEnd());
    }
}
