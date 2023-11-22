package sesson12.bai_tap.productManagement.BOImpl;

import sesson12.bai_tap.productManagement.BO.ProductService;
import sesson12.bai_tap.productManagement.DAO.ProductRepository;
import sesson12.bai_tap.productManagement.DAOImpl.ProductRepositoryImp;
import sesson12.bai_tap.productManagement.DTO.Product;

public class ProductServiceImp implements ProductService {
    private static final ProductRepository repository = new ProductRepositoryImp();

    @Override
    public void addProduct(Product product) {
        repository.addProduct(product);
        System.out.println("Product added successfully!");
    }

    @Override
    public void setProduct(String id) {
        if(repository.searchProductById(id) != null){
            repository.setProduct(id);
            System.out.println("Edit successfully!");
            return;
        }
        System.out.println("No products found!");
    }

    @Override
    public void removeProduct(String idRemove) {
        if(repository.searchProductById(idRemove) != null){
            Product product = repository.removeProduct(idRemove);
            System.out.println(product.getName() + " has been removed");
            return;
        }
        System.out.println("No products found!");
    }

    @Override
    public void displayProduct() {
        if (repository.getSize() != 0){
            repository.displayProduct();
            return;
        }
        System.out.println("Empty list!");
    }

    @Override
    public void searchProduct(String name) {
        Product product = repository.searchProduct(name);
        if (product != null){
            System.out.println(product);
        } else {
            System.out.println("No products found!");
        }
    }
}
