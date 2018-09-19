package com.gmail.Andrii.Pyvovarov.service;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;

import javax.swing.text.html.parser.Entity;
import java.security.KeyStore;
import java.util.List;
import java.util.Map;

public class Services {

    public void matching(Map<QueryLine, List<DataLine>> data) {


        for (Map.Entry<QueryLine, List<DataLine>> entry : data.entrySet()) {

            for (DataLine dataLine : entry.getValue()) {


            }

        }

    }

    private boolean compareTypeQuestion(){
        return true;
    }

    private boolean compareTypeServise(){
        return true;
    }

    private boolean dateFilterMatch(){
        return true;
    }

    private boolean responceTypeMatch(){
        return true;
    }

}
