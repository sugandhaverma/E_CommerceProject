package org.scaler.e_commerceproject.repo;

import org.scaler.e_commerceproject.modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    Optional<Product> findByTitle(String title);
    List<Product> findByTitleAndDescription(String title, String description);
    Product save(Product product);

}
