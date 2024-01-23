package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaProductRepository implements ProductRepository {

    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByName(String name) {
        List<Product> result = em.createQuery("select p from Product m where p.name = :name", Product.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Product> findProductAll() {
        return em.createQuery("select p from Member p", Product.class)
                .getResultList();
    }
}
