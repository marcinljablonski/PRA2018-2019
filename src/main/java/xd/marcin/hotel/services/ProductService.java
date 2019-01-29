package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Product;

public interface ProductService {

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Product> listAllProductsPaging(Integer pageNr, Integer howManyOnPage);

}
