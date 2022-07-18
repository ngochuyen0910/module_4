package product_management.repository;

import org.springframework.stereotype.Repository;
import product_management.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductManagementRepository implements IProductManagementRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Vision", 23000, "Black", "Honda"));
        productList.add(new Product(2, "SH", 54000, "White", "Honda"));
        productList.add(new Product(3, "Lead", 27000, "Red", "Honda"));
        productList.add(new Product(4, "Janus", 23000, "Blue", "Yamaha"));
        productList.add(new Product(5, "AB", 34000, "Black", "Honda"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(productList.indexOf(new Product(id)));
    }

    @Override
    public void update(int id, Product product) {
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescribe(product.getDescribe());
                product1.setProducer(product.getProducer());
            }
        }
    }

    @Override
    public void remove(int id) {
        productList.remove(findById(id));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                products.add(product);
            }
        }
        return products;
    }
}
