package sesson17.bai_tap.productFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("A01", "T-Shirt", "Chanel", 1200000));
        products.add(new Product("A02", "Sweeter", "Prada", 5000000));
        products.add(new Product("A03", "Cardigan", "Louis Vuitton", 6500000));
        products.add(new Product("B01", "Jean", "Chanel", 2200000));
        products.add(new Product("B02", "Short", "Hermes", 1700000));
        writeToFile("H:\\codegym\\module2\\learn\\src\\sesson17\\bai_tap\\productFile\\product.txt", products);
        List<Product> productList = readDataFromFile("H:\\codegym\\module2\\learn\\src\\sesson17\\bai_tap\\productFile\\product.txt");
        for (Product p: productList){
            System.out.println(p);
        }
    }
}
