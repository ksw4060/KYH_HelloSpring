package hello.hellospring.repository;

import hello.hellospring.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryProductRepositoryTest {
    MemoryProductRepository productRepository = new MemoryProductRepository();

    @AfterEach
    public void afterEach() { productRepository.clearProductStore();
    }




    @Test
    public void save() {
        Product product = new Product();
        product.setName("product1");
        product.setPrice(1000L);

        productRepository.save(product);

        Product result = productRepository.findById(product.getId()).get();
        assertThat(product).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Product product1 = new Product();
        product1.setName("product1");
        product1.setPrice(1000L);
        productRepository.save((product1));

        Product product2 = new Product();
        product2.setName("product2");
        product2.setPrice(2000L);
        productRepository.save((product2));

        Product result1 = productRepository.findByName("product1").get();
        Product result2 = productRepository.findByName("product2").get();

        assertThat(result1).isEqualTo(product1);
        assertThat(result2).isEqualTo(product2);
    }

    @Test
    public void findProductAll() {
        Product product3 = new Product();
        product3.setName("product3");
        productRepository.save((product3));

        Product product4 = new Product();
        product4.setName("product4");
        productRepository.save((product4));

        List<Product> result = productRepository.findProductAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
