package com.example.firstchallengeback.dao.repository;

import com.example.firstchallengeback.dao.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
