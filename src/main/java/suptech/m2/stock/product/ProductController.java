package suptech.m2.stock.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import suptech.m2.stock.product.service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getProducts(Model model){
        try {
            Page<Product> products = productService.getProducts(PageRequest.of(1,10));
            model.addAttribute("products",products);
        }catch (RuntimeException exception){
            model.addAttribute("error", exception.getMessage());
        }
        return "products";
    }


}
