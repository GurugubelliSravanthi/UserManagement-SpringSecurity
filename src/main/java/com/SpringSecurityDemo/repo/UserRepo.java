package com.SpringSecurityDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurityDemo.entity.User;


public interface UserRepo extends JpaRepository<User,Integer>{


}