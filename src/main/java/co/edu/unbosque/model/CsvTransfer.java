package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;

public class CsvTransfer {

    private List<Recibo> csvList;

    public CsvTransfer() {}

    public void setCsvList(List<Recibo> csvList) {
        this.csvList = csvList;
    }

    public List<Recibo> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<>();
    }
}