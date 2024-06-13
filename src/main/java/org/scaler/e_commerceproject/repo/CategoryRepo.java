package org.scaler.e_commerceproject.repo;

import org.scaler.e_commerceproject.modals.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
