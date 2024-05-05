package com.mayank.UserApplication.repositories;

import com.mayank.UserApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
