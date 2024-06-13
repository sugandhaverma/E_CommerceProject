package org.scaler.e_commerceproject.exception;

public class ProductNotFound extends Exception {
    public ProductNotFound(String productNptFound) {
        super(productNptFound);
    }
}
