package hello.hellospring.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Member member;
    private List<Product> productList;
    private Long totalPrice;
    private List<Product> products;



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart() {
        products = new ArrayList<>();
    }

    public void addToCart(Product product) {
        products.add(product);
    }
}
