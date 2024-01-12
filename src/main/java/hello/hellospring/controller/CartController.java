package hello.hellospring.controller;

import hello.hellospring.domain.Cart;
import hello.hellospring.domain.Product;
import hello.hellospring.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    private String createForm() {
        return "cart/createCartForm";
    }

    @PostMapping("/cart")
    public String create(CartForm form) {
        Cart cart = new Cart();
        cart.setName(form.getName());
        cart.setPrice(form.getPrice());

        cartService.createProduct(product);

        return "redirect:/";
    }
}
