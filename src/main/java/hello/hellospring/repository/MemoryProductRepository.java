package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryProductRepository implements ProductRepository{
    private static final Map<Long, Product> productStore = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Product save(Product product) {
        product.setId(++sequence);
        productStore.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productStore.get(id));
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productStore.values().stream()
                .filter(product -> product.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Product> findProductAll() {
        return new ArrayList<>(productStore.values());
    }
    public void clearProductStore() {
        productStore.clear();
    }
}

