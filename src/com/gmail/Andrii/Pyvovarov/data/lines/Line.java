package com.gmail.Andrii.Pyvovarov.data.lines;

import com.gmail.Andrii.Pyvovarov.data.primitives.QuestionType;
import com.gmail.Andrii.Pyvovarov.data.primitives.ResponseType;
import com.gmail.Andrii.Pyvovarov.data.primitives.Service;

public abstract class Line {

    private Service service;
    private QuestionType questionType;
    private ResponseType responseType;

    public Line(Service service, QuestionType questionType, ResponseType responseType) {
        this.service = service;
        this.questionType = questionType;
        this.responseType = responseType;
    }

    public Line(){

    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }


}
