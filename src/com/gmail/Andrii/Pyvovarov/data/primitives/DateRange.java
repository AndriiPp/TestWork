package com.gmail.Andrii.Pyvovarov.data.primitives;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        DateRange dateRange = (DateRange) obj;
        return dateRange.getDateStart().equals(this.getDateStart())
                && dateRange.getDateEnd().equals(this.getDateEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateStart(), getDateEnd());
    }

}
