package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;
/**
 * guarda el archivo csv leido que esta contenido en una lista para setearlo 
 * o tenerlo dentro del programa
 * @author Javier Villarreal, Camilo piza, Jorge yate, Camilo Gomes
 *
 */
public class CsvTransfer {

    private List<Recibo> csvList;
   
    public CsvTransfer() {}
    /**
     * establece la configuracion de la lista
     */
    public void setCsvList(List<Recibo> csvList) {
        this.csvList = csvList;
    }
    /**
     * su uso es para obtener la lista en la que se guarda el csv
     * @return arraylis con el csv
     */
    public List<Recibo> getCsvList() {
        if (csvList != null) return csvList;
        return new ArrayList<>();
    }
}