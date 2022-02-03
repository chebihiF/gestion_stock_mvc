package suptech.m2.stock.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import suptech.m2.stock.product.Product;

public interface IProductService {
    Product saveProduct(Product product) throws RuntimeException;
    Page<Product> getProducts(Pageable pageable) throws RuntimeException;
    Page<Product> getProductsByLabel(String label,Pageable pageable) throws RuntimeException;
}
