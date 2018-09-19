package com.gmail.Andrii.Pyvovarov.data;

import com.gmail.Andrii.Pyvovarov.data.lines.DataLine;
import com.gmail.Andrii.Pyvovarov.data.lines.QueryLine;

import java.util.List;
import java.util.Map;

public class DataStructure {

    private Map<QueryLine, List<DataLine>> data;

    public Map<QueryLine, List<DataLine>> getData() {
        return data;
    }

    public void setData(Map<QueryLine, List<DataLine>> data) {
        this.data = data;
    }


}
