package com.gmail.Andrii.Pyvovarov.data.lines;

import com.gmail.Andrii.Pyvovarov.data.primitives.DateRange;
import com.gmail.Andrii.Pyvovarov.data.primitives.QuestionType;
import com.gmail.Andrii.Pyvovarov.data.primitives.ResponseType;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;

public class QueryLine extends Line {
    private String queryLine;
    private DateRange dateRange;

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }

    public QueryLine() {

    }

    public QueryLine(Service service, QuestionType questionType, ResponseType responseType) {
        super(service, questionType, responseType);
    }

    public String getQueryLine() {
        return queryLine;
    }

    public void setQueryLine(String queryLine) {
        this.queryLine = queryLine;
    }


}
