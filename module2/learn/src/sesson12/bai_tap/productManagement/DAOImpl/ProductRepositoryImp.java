package sesson12.bai_tap.productManagement.DAOImpl;

import sesson12.bai_tap.productManagement.DAO.ProductRepository;
import sesson12.bai_tap.productManagement.DTO.Product;

import java.io.*;
import java.util.*;

public class ProductRepositoryImp implements ProductRepository {
    Scanner sc = new Scanner(System.in);
    private static final List<Product> productArrayList;
    private static final String SRC = "H:\\codegym\\module2\\learn\\src\\sesson12\\bai_tap\\productManagement\\data\\product.csv";
    static {
        productArrayList = createProductObj();
    }
    private static List<Product> createProductObj(){
        List<Product> productList = new ArrayList<>();
        try {
            File file = new File(SRC);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                String name = arr[0];
                String id = arr[1];
                int price = Integer.parseInt(arr[2].trim());
                productList.add(new Product(name, id, price));
            }
            bufferedReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
        catch (IOException e){
            System.err.println("There is some error!");
        }
        return productList;
    }
    private void setProductInFile(Product p){
        try {
            File inputFile = new File(SRC);
            File tempFile = new File("temp.csv");
            if (!inputFile.exists()){
                System.out.println("File not found!");
            }
            if (tempFile.exists()){
                System.out.println("Temp file exist!");
            }
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] arr = currentLine.split(",");
                if (Objects.equals(arr[2], p.getId())){
                    writer.write(p.getName() + "," + p.getId() + ", " + p.getPrice() + "\n");
                }else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();
            if (!inputFile.delete()) {
                System.out.println("Error deleting original file");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error renaming temporary file");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    private void removeProductInFile(Product p){
        try {
            File inputFile = new File(SRC);
            File tempFile = new File("temp.csv");
            if (!inputFile.exists()){
                System.out.println("File not found!");
            }
            if (tempFile.exists()){
                System.out.println("Temp file exist!");
            }
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] arr = currentLine.split(",");
                if (!Objects.equals(arr[2], p.getId())){
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();
            if (!inputFile.delete()) {
                System.out.println("Error deleting original file");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error renaming temporary file");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    private void writeProduct(Product p){
        try {
            File file = new File(SRC);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            String line = p.getName() + "," + p.getId() + ", " + p.getPrice();
            bufferedWriter.write("\n" + line);
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
        catch (IOException e){
            System.err.println("There is some error!");
        }
    }
    @Override
    public int getSize() {
        return productArrayList.size();
    }

    @Override
    public void addProduct(Product product) {
        productArrayList.add(product);
        writeProduct(product);
    }

    @Override
    public void setProduct(String id) {
        Product product = searchProductById(id);
        System.out.println("Enter your choice of the item you want to edit: ");
        String choice = sc.nextLine();
        switch (choice) {
            case "name":
                System.out.println("Enter the name you want to edit: ");
                String nameEdit = sc.nextLine();
                product.setName(nameEdit);
                break;
            case "id":
                System.out.println("Enter the id you want to edit: ");
                String idEdit = sc.nextLine();
                product.setId(idEdit);
                break;
            case "price":
                System.out.println("Enter the price you want to edit: ");
                int priceEdit = sc.nextInt();
                product.setPrice(priceEdit);
                break;
        }
        setProductInFile(product);
    }

    @Override
    public Product removeProduct(String idRemove) {
        Product product = searchProductById(idRemove);
        removeProductInFile(product);
        int index = productArrayList.indexOf(product);
        return productArrayList.remove(index);
    }

    @Override
    public void displayProduct() {
        sortProductList();
        for (Product product : productArrayList) {
            System.out.println(product);
        }
    }

    @Override
    public Product searchProductById(String id) {
        for (Product product : productArrayList) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
    @Override
    public Product searchProduct(String name) {
        for (Product product : productArrayList) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    @Override
    public void sortProductList() {
        Collections.sort(productArrayList);
    }
}
