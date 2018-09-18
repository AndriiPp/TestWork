package com.gmail.Andrii.Pyvovarov.data.primitives;

public class Service {

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

    private String service;
    private Variation variation;

    public static class Variation {
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


    }

}
