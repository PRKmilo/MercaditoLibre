package co.edu.unbosque.TestProject;

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

public class App {
    
	public List<Recibo> readFromPath(String localPath) {
        try {
            // Creating the path object representing the file to be read
            URI uri = ClassLoader.getSystemResource(localPath).toURI();
            Path path = Paths.get(uri);

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

            return csvTransfer.getCsvList();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {

        System.out.println("Reading a CSV using OpenCSV library");

        List<Recibo> result = new App().readFromPath("csv/data.csv");
        for (Recibo r : result) {
            System.out.println(r.toString());
        }
    }
}
