package org.scaler.e_commerceproject.service;

import org.scaler.e_commerceproject.dtos.FakeStoreRequestDto;
import org.scaler.e_commerceproject.dtos.FakeStoreResponseDto;
import org.scaler.e_commerceproject.exception.ProductNotFound;
import org.scaler.e_commerceproject.modals.Category;
import org.scaler.e_commerceproject.modals.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }



    @Override
    public Product getProductById(long id) throws ProductNotFound {
        FakeStoreResponseDto fdto =  restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);

        if(fdto == null){
            throw new ProductNotFound("Product not found");
        }
        // if response is there convert the response into product...

        return   ConvertFakeStoreDtoToProduct(fdto);
    }

    public Product ConvertFakeStoreDtoToProduct(FakeStoreResponseDto fdto){
        Product p = new Product();
        p.setId(fdto.getId());
        p.setDescription(fdto.getDescription());
        p.setTitle(fdto.getTitle());
        p.setPrice(fdto.getPrice());
        p.setImage(fdto.getImage());

        Category cat = new Category();
        cat.setTitle(fdto.getCategory());
        p.setCategory(cat);

        return  p;
    }

    public FakeStoreRequestDto ConvertToFakeStoreRequest(Product p){
         FakeStoreRequestDto requestDto = new FakeStoreRequestDto();
      requestDto.setCategory(p.getCategory().getTitle());
      requestDto.setDescription(p.getDescription());
      requestDto.setPrice(p.getPrice());
      requestDto.setImage(p.getImage());
      requestDto.setTitle(p.getTitle());
      return requestDto;
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

        FakeStoreRequestDto fakeStoreRequestDto = ConvertToFakeStoreRequest(p);
        FakeStoreResponseDto response = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreRequestDto, FakeStoreResponseDto.class);
    //response here because it will give id with product
        if(response == null){
            throw new RuntimeException("product is null");
        }
        return ConvertFakeStoreDtoToProduct(response);
        //because user understand product that why conversion .user dont understand reponse.
    }

    @Override
    public Product[] getAllProducts() {
        FakeStoreResponseDto[] fdto = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreResponseDto[].class);

        Product[] products = new Product[fdto.length];
        for(int i=0;i<fdto.length;i++){
            products[i] = ConvertFakeStoreDtoToProduct(fdto[i]);
        }
        return products;
    }
}
