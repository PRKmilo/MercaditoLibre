package co.edu.unbosque.controller;

import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import co.edu.unbosque.model.CsvTransfer;
import co.edu.unbosque.model.Handlelist;
import co.edu.unbosque.model.Recibo;

public class App {
	
	final static List<Recibo> nums = new ArrayList<Recibo>();
	
    
    
	public List<Recibo> readFromPath(String localPath) {
        try {
            // Creating the path object representing the file to be read
            URI uri = ClassLoader.getSystemResource(localPath).toURI();
            Path path = Paths.get(uri);
            System.out.println("linea 30");
           
            // Creating the strategy to read the CSV and the bean for casting
            // Could be by header names or column positions
            HeaderColumnNameMappingStrategy ms = new HeaderColumnNameMappingStrategy();
            ms.setType(Recibo.class);
        
            // Reading the file, setting the strategy and custom separator
            Reader reader = Files.newBufferedReader(path);
            CsvToBean cb = new CsvToBeanBuilder(reader).withType(Recibo.class)
                    .withMappingStrategy(ms)
                    .withSeparator(',')
                    .build();
            
            // Extracting result previous to close the reader
            CsvTransfer csvTransfer = new CsvTransfer();
            csvTransfer.setCsvList(cb.parse());
            reader.close();
            System.out.println("linea 48");
            return csvTransfer.getCsvList();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

	  
}
