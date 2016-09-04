package com.codekul.ecommerce.repository;

import com.codekul.ecommerce.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by aniruddha on 3/9/16.
 */
@RepositoryRestResource(collectionResourceRel = "userData", path = "userData")
public interface UserDataRepository extends JpaRepository<UserData,Long> {
    UserData findByUserNameAndPassword(String userName,String password);
}
