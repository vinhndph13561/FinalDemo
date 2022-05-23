package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUserName(String userName);
    boolean existsUserByUserName(String userName);
}
