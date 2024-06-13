package org.scaler.e_commerceproject.Controller;

import org.hibernate.mapping.Array;
import org.junit.jupiter.api.Test;
import org.scaler.e_commerceproject.controller.ProductController;
import org.scaler.e_commerceproject.exception.ProductNotFound;
import org.scaler.e_commerceproject.modals.Product;
import org.scaler.e_commerceproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;


    @MockBean
    private ProductService productService;

    @Test
    void TestGetProductById() throws ProductNotFound {

        Product p = new Product();

        when(productService.getProductById(1L)).thenReturn(p);

        ResponseEntity<Product> ExpectedResponseEntity = new ResponseEntity<>(p, HttpStatus.OK);

        ResponseEntity<Product> ActualResponse =  productController.getProductById(1L);

        assertEquals(ExpectedResponseEntity, ActualResponse);

    }



    @Test
    void TestGetProductByIdError() throws ProductNotFound {

        ProductNotFound productNotFound = new ProductNotFound("Product not found..");

        when(productService.getProductById(1L)).thenThrow(productNotFound);


        assertThrows(ProductNotFound.class,()->productController.getProductById(1L));
    }


    @Test
    void TestGetAllProducts() {

        Product[] products = createThreeProducts();

        when(productService.getAllProducts()).thenReturn(products);
        List<Product> actualProducts =  productController.getAllProducts();
        assertEquals(products, actualProducts);

    }


    public Product[] createThreeProducts(){
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();

        ArrayList<Product> products = new ArrayList<>();

        products.add(p1);
        products.add(p2);
        products.add(p3);



        Product[] p = new Product[3];
        for(int i=0;i<3;i++){
            p[i]= products.get(i);
        }

        return p;
    }
}
