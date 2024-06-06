package org.scaler.e_commerceproject.service;

import org.scaler.e_commerceproject.modals.Product;

public interface ProductService {
    Product getProductById(long id);

    Product updateProduct(long id);

    Product deleteProduct(long id);

    Product createProduct(Product p);
    Product[] getAllProducts();
}
