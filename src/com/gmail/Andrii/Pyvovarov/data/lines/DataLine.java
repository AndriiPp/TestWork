package com.gmail.Andrii.Pyvovarov.data.lines;

import com.gmail.Andrii.Pyvovarov.data.primitives.QuestionType;
import com.gmail.Andrii.Pyvovarov.data.primitives.ResponseType;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;

public class DataLine extends Line {

    private String dateLine;
    private int time;


    public DataLine(Service service, QuestionType questionType, ResponseType responseType) {
        super(service, questionType, responseType);
    }

    public DataLine() {

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public String getDateLine() {
        return dateLine;
    }

    public void setDateLine(String dateLine) {
        this.dateLine = dateLine;
    }

}
