import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileProductDataSource implements ProductDataSource {
    private String filename;

    public TextFileProductDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\t");
                if (line.length < 4) {
                    continue;
                }
                String type = line[0];
                String code = line[1];
                String description = line[2];
                int points = Integer.parseInt(line[3]);

                switch (type) {
                    case "Car":
                        products.add(new Car(code, description, points));
                        break;
                    case "Van":
                        products.add(new Van(code, description, points));
                        break;
                    case "Motorcycle":
                        products.add(new Motorcycle(code, description, points));
                        break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}
