package com.codecool.happiness_jar.user.repository;

import com.codecool.happiness_jar.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById (int userId);
}
