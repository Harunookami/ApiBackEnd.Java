package com.ApiBackEnd.java.Repository;

import com.ApiBackEnd.java.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

     Optional<UserModel> findByLogin(String login);

     List<UserModel> findAll();

}
