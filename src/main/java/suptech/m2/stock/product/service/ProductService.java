package suptech.m2.stock.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import suptech.m2.stock.product.Product;
import suptech.m2.stock.product.ProductRepository;

@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) throws RuntimeException{
        if(product.getRef().trim().startsWith("R00")){
            return productRepository.save(product);
        }
        throw new RuntimeException("product must have an reference starting with R00");
    }

    public Page<Product> getProducts(Pageable pageable) throws RuntimeException{
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductsByLabel(String label,Pageable pageable) throws RuntimeException{
        if(label!=null && !label.trim().equals(""))
            //return productRepository.findProductByLabel(label,pageable);
            return productRepository.findByLabelContains(label,pageable);
        throw new RuntimeException("label must be non null");
    }
}
