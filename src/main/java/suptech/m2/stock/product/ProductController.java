package suptech.m2.stock.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import suptech.m2.stock.product.service.IProductService;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    public String getProducts(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword
    ){
        try {
            if(page<0)
                page = 0 ;
            Page<Product> products = null;
            if(keyword.equals(""))
                products = productService.getProducts(PageRequest.of(page,size));
            else
                products = productService.getProductsByLabel(keyword, PageRequest.of(page,size));

            model.addAttribute("products",products);
            model.addAttribute("pages",new int[products.getTotalPages()]);
            model.addAttribute("current_page", page);
        }catch (RuntimeException exception){
            model.addAttribute("error", exception.getMessage());
        }

        return "products";
    }

    @GetMapping(path = "/formProduct")
    public String addProduct(Model model){
        model.addAttribute("product",new Product());
        return "formProduct";
    }

    @PostMapping(path = "/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult result){
        if(result.hasErrors()) return "formProduct" ;
        productService.saveProduct(product);
        return "formProduct";
    }


}
