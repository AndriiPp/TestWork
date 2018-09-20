package com.gmail.Andrii.Pyvovarov.data.primitives;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Objects;

public class Service {
    private String service;
    private Variation variation;

    public Service(String service) {
        this.service = service;
    }

    public Service(String service, Variation variation) {
        this.service = service;
        this.variation = variation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Variation getVariation() {
        return variation;
    }

    public void setVariation(Variation variation) {
        this.variation = variation;
    }



    public static class Variation {
        private String type;

        public Variation(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Service service = (Service) obj;
        return  service.getService().equals(this.getService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getService());
    }
}
