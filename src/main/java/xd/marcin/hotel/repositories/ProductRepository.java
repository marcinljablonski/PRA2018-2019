package xd.marcin.hotel.repositories;

import xd.marcin.hotel.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

    Product findByProductId(String productId);

    @Query("select count(*) from Product p where p.id = ?1")
    Integer checkIfExist(Integer id);
}
