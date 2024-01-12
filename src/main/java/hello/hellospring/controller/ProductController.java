package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/new")
    public String createForm() {
        return "products/createProductsForm";
    }

    @PostMapping("/products/new")
    public String create(ProductsForm form) {
        Product product = new Product();
        product.setName(form.getName());
        product.setPrice(form.getPrice());

        productService.createProduct(product);

        return "redirect:/";
    }

    @GetMapping("/products")
    public String userList(Model model) {
        List<Product> products = productService.findProducts();
        model.addAttribute("products", products);
        return "products/productsList";
    }
}
