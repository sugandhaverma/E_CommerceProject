package org.scaler.e_commerceproject.service;

import org.scaler.e_commerceproject.exception.ProductNotFound;
import org.scaler.e_commerceproject.modals.Category;
import org.scaler.e_commerceproject.modals.Product;
import org.scaler.e_commerceproject.repo.CategoryRepo;
import org.scaler.e_commerceproject.repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;


//@Primary
@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo;

    SelfProductService(ProductRepo productRepo,CategoryRepo categoryRepo){
       this.productRepo = productRepo;
       this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFound {
       Optional<Product> optionalProduct =  productRepo.findById(id);
       if(optionalProduct.isEmpty()){
           throw  new ProductNotFound("Product Not Found");
       }
       return optionalProduct.get();
    }

    @Override
    public Product updateProduct(long id) {
        return null;
    }

    @Override
    public Product deleteProduct(long id) {
        return null;
    }

    @Override
    public Product createProduct(Product p) {

        //Before savinproduct we need to create category in db
        Category category = p.getCategory();
        if (category.getId() == null) {
          Category savedCategory = categoryRepo.save(category);
          p.setCategory(savedCategory);
        }else{
            // we need to check if id exists
        }

       Product saveProduct = productRepo.save(p);
        Optional<Category> optionalCategory = categoryRepo.findById(category.getId());
       if (optionalCategory.isEmpty()) {
           throw new RuntimeException("Category is Empty");
       }
        saveProduct.setCategory(optionalCategory.get());
       return saveProduct;
    }

    @Override
    public Product[] getAllProducts() {
        return new Product[0];
    }
}
