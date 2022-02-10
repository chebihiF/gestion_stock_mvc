package suptech.m2.stock.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import suptech.m2.stock.product.service.ProductService;

import java.time.LocalDate;

@Configuration
public class ProductConfig {

    private final ProductService productService;

    public ProductConfig(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public CommandLineRunner initProduct() {
        return args -> {
            try {
                productService.saveProduct(new Product("R001", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 25000, 10));
                productService.saveProduct(new Product("R002", "S10", LocalDate.now(), "512mo", 10000, 15));
                productService.saveProduct(new Product("R003", "Iphone 13", LocalDate.now(), "Appel Iphone 12 ", 25000, 100));
                productService.saveProduct(new Product("R004", "Note 1O", LocalDate.now(), "Sunsing note 10 ", 12000, 24));
                productService.saveProduct(new Product("R005", "TV DEll", LocalDate.now(), "65p UltraHD ... ", 5000, 34));
                productService.saveProduct(new Product("R006", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 25000, 19));
                productService.saveProduct(new Product("R007", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 3000, 10));
                productService.saveProduct(new Product("R008", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 25000, 10));
                productService.saveProduct(new Product("R009", "S10", LocalDate.now(), "512mo", 10000, 15));
                productService.saveProduct(new Product("R0010", "Iphone 13", LocalDate.now(), "Appel Iphone 12 ", 25000, 100));
                productService.saveProduct(new Product("R0011", "Note 1O", LocalDate.now(), "Sunsing note 10 ", 12000, 24));
                productService.saveProduct(new Product("R0012", "TV DEll", LocalDate.now(), "65p UltraHD ... ", 5000, 34));
                productService.saveProduct(new Product("R0013", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 25000, 19));
                productService.saveProduct(new Product("R0014", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 3000, 10));
                productService.saveProduct(new Product("R0015", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 25000, 10));
                productService.saveProduct(new Product("R0016", "S10", LocalDate.now(), "512mo", 10000, 15));
                productService.saveProduct(new Product("R0017", "Iphone 13", LocalDate.now(), "Appel Iphone 12 ", 25000, 100));
                productService.saveProduct(new Product("R0018", "Note 1O", LocalDate.now(), "Sunsing note 10 ", 12000, 24));
                productService.saveProduct(new Product("R0020", "TV DEll", LocalDate.now(), "65p UltraHD ... ", 5000, 34));
                productService.saveProduct(new Product("R0021", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 25000, 19));
                productService.saveProduct(new Product("R0022", "TV Sumsung", LocalDate.now(), "55p UltraHD ... ", 3000, 10));
            }catch (Exception ex){
                System.err.println(ex.getMessage());
            }
        };
    }
}
