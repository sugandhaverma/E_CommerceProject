package org.scaler.e_commerceproject.controller;

import org.scaler.e_commerceproject.exception.ProductNotFound;
import org.scaler.e_commerceproject.modals.Product;
import org.scaler.e_commerceproject.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService ps;

      public ProductController(@Qualifier("SelfProductService")ProductService productService){
        this.ps = productService;
   }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFound {

         Product p = ps.getProductById(id);
//
        return new ResponseEntity<>(p, HttpStatus.OK);
//     }  catch(ArithmeticException ae){
//              return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return ps.getProductById(id);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
          Product[] products = ps.getAllProducts();
        return List.of(products);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
          //validation here...
        return ps.createProduct(product);
    }

    @PutMapping ("/")
    public Product updateProduct(@RequestBody Product product) {
        return new Product();
    }

    @DeleteMapping("/")
    public void deleteProduct() {
        return;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        return;
    }
}
