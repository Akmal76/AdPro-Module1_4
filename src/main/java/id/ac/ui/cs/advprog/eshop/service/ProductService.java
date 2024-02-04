package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    public Product create (Product product);

    public List <Product> findAll();
    public Product findProductById (String productId);
    public Product update (Product product);
    public void delete (Product product);
}