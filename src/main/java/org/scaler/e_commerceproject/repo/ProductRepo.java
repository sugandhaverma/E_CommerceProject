package org.scaler.e_commerceproject.repo;

import org.scaler.e_commerceproject.modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
