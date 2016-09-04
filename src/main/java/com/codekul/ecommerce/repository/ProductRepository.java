package com.codekul.ecommerce.repository;

import com.codekul.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by aniruddha on 4/9/16.
 */
@RepositoryRestResource(collectionResourceRel = "product",path = "product")
public interface ProductRepository extends JpaRepository<Product,Long>{
}
