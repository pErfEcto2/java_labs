package lab2;

import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class task13 {
    public static void main(String[] args) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter("test.csv"));
        writer.writeNext(new String[]{"Name", "Age"});
        writer.writeNext(new String[]{"Alice", "25"});
        writer.close();
        System.out.println("CSV file created!");
    }
}
