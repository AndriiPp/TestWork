package com.gmail.Andrii.Pyvovarov.data.primitives;

public class DateRange {
    private String DateStart;
    private String DateEnd;

    public DateRange(String dateStart, String dateEnd) {
        DateStart = dateStart;
        DateEnd = dateEnd;
    }

    public DateRange(String dateStart) {

        DateStart = dateStart;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String dateStart) {
        DateStart = dateStart;
    }

    public String getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(String dateEnd) {
        DateEnd = dateEnd;
    }


}
