package com.example.authmvc.repositories;

import com.example.authmvc.entities.TodoEntity;
import com.example.authmvc.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByUser(UserEntity userEntity);
}
