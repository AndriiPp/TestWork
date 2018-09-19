package com.gmail.Andrii.Pyvovarov.util;

public class Validator {

    public static final String TYPE_QUESTION_C = "C";
    public static final String TYPE_QUESTION_D = "D";
    public static final String TYPE_QUESTION = "(C|D)";
    public static final String RESPONSE_TYPE = "(P|N)*";
    public static final String SERVISE = "((10|[1-9])(\\.[1-3])?)|\\*";
    public static final String QUESTION = "((10|[1-9])(\\.[1-9]|[1][0-9]|20)(\\.[1-5])?)?)|\\*";
    public static final String DATE = "dd.MM.yyyy";
    public static final String TIME = "\\d{1,6}";
    public static final String SPACE_SPLITER = " ";
    public static final String POINT = "\\.";
    public static final String DATE_SPLITER = "\\-";


    public static Boolean checkTypeQuestion_C(String typeQuestion) {
        if (typeQuestion.matches(TYPE_QUESTION_C))
            return true;
        else
            return false;
    }

    public static Boolean checkServise(String servise) {
        if (servise.matches(SERVISE)) {
            return true;
        }

        return false;
    }

    public static Boolean checkResponseType(String responseType) {
        if (responseType.matches(RESPONSE_TYPE)) {
            return true;
        }
        return false;
    }

}
