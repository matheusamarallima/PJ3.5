package com.application.project3.repository;


import com.application.project3.entities.UserMain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<UserMain, String> {

    UserMain findById(Long id);

    UserMain findByUserId(String userId);

    UserMain findByPetName(String petName);

    UserMain findByUserIdAndPetName(String userId, String petName);


    List<UserMain> findAllByRole(String role);

    UserMain existsByUserId(String userId);

}
