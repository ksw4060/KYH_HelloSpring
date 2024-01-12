package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartForm {
    private Member member;
    private Map<Product, Integer> productQuantities;

    public CartForm() {
        this.member = new Member();
        this.productQuantities = new HashMap<>();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Map<Product, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Product, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }
}
