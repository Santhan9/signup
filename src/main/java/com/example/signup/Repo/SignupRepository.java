package com.example.signup.Repo;

import com.example.signup.dao.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<Signup,Integer> {
}
