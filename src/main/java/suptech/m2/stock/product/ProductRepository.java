package suptech.m2.stock.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,String> {
    Page<Product> findProductByLabel(String label, Pageable pageable);
    Page<Product> findByLabelContains(String keyword, Pageable pageable);

    Page<Product> findByLabelLike(String keyword, Pageable pageable);

    @Query("from Product p where p.label like '%:keyword%'")
    Page<Product> findByLabelLikeV2(String keyword, Pageable pageable);
}
