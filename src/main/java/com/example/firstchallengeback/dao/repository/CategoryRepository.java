package com.example.firstchallengeback.dao.repository;

import com.example.firstchallengeback.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
