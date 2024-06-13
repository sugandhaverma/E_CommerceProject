package org.scaler.e_commerceproject.service;

import org.scaler.e_commerceproject.exception.ProductNotFound;
import org.scaler.e_commerceproject.modals.Product;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFound;

    Product updateProduct(long id);

    Product deleteProduct(long id);

    Product createProduct(Product p);
    Product[] getAllProducts();
}
