package lab.crazyspark.test;

import java.io.IOException;
import java.nio.charset.Charset;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class TestJavaCSV {
    // private static String filePath = "/app/work/aml/web/test.csv";
    private static String filePath = "./test.csv";

    public static void main(String[] args) {
        read();
        // write();
    }

    public static void read() {
        try {
            CsvReader csvReader = new CsvReader(filePath, ',', Charset.forName("UTF8"));
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                System.out.println(csvReader.getRawRecord());
                System.out.println(csvReader.get("编号"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write() {
        try {
            CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("UTF8"));
            String[] headers = { "编号", "姓名", "年龄" };
            String[] content = { "12365", "张山", "34" };
            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}