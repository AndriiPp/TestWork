package com.gmail.Andrii.Pyvovarov.data.primitives;

import java.util.Objects;

public class ResponseType {
    private String responceType;

    public ResponseType(String responceType) {
        this.responceType = responceType;
    }

    public String getResponceType() {
        return responceType;
    }

    public void setResponceType(String responceType) {
        this.responceType = responceType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        ResponseType lineType = (ResponseType) obj;
        return lineType.getResponceType().equals(this.getResponceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResponceType());
    }

}
