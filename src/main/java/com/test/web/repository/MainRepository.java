package com.test.web.repository;

import com.test.web.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<UserEntity,Long> {

}
