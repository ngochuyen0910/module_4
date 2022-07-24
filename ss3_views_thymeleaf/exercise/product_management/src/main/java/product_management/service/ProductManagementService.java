package product_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.repository.IProductManagementRepository;

import java.util.List;

@Service
public class ProductManagementService implements IProductManagementService {
    @Autowired
    private IProductManagementRepository productManagementRepository;

    @Override
    public List<Product> findAll() {
        return productManagementRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productManagementRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productManagementRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productManagementRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        productManagementRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productManagementRepository.findByName(name);
    }
}
