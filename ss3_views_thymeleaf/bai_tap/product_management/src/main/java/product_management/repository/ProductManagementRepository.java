package product_management.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import product_management.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductManagementRepository implements IProductManagementRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public ProductManagementRepository() {
    }
    @Modifying
    public List<Product> findAll() {
        TypedQuery<Product> query = this.entityManager.createQuery("SELECT s FROM Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(int id, Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(int id) {
        entityManager.merge(entityManager.merge(id));
    }

    @Override
   public List<Product> findByName(String name) {
//        List<Product> products = new ArrayList<>();
//        for (Product product : productList) {
//            if (product.getName().contains(name)) {
//                products.add(product);
//            }
//        }
//        return products;
//    }
        return null;
}
}