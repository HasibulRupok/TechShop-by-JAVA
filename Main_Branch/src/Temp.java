import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Temp {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\Users\\Rupok\\Desktop\\A_OOP\\TechShop\\src\\Files\\saleDetails");
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        reader.close();
        System.out.println(line);
    }
}
