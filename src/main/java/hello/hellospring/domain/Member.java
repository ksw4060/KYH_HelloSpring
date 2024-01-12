package hello.hellospring.domain;

public class Member {

    private Long id;
    private String name;
    private Cart cart;
    public Member() {
        cart = new Cart();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addToCart(Product product) {
        cart.addToCart(product);
    }
}
