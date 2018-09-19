package com.gmail.Andrii.Pyvovarov.data.primitives;

import java.util.Objects;

public class LineType {

    private String lineType;

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        LineType lineType = (LineType) obj;
        return lineType.getLineType().equals(this.getLineType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLineType());
    }
}
