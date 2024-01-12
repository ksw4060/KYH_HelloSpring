package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.domain.Product;
import hello.hellospring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Long createProduct(Product product) {
        // 같은 이름이 있는 중복 회원이 있으면 안된다.
        validateDuplicateProduct(product);

        productRepository.save(product);
        return product.getId();
    }

    /**
     *
     * 상품이름 중복에 대한 유효성 검사
     */
    private void validateDuplicateProduct(Product product) {
        productRepository.findByName(product.getName())
                .ifPresent(p -> {
                    throw new IllegalStateException("이미 존재하는 상품입니다.");
                });
    }

    /**
     * 전체 상품 조회
     */
    public List<Product> findProducts() {

        return productRepository.findProductAll();
    }
    /**
     * 회원 조회
     */
    public Optional<Product> findOneProduct(Long productId) {
        return productRepository.findById(productId);
    }
}
