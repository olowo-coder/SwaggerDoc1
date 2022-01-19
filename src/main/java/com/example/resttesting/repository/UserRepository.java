package com.example.resttesting.repository;

import com.example.resttesting.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <Users, Long>{
    Users findByUsername(String username);
}
