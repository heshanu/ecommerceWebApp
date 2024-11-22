package com.example.EcommerceWebAppMonolatic.repo;

import com.example.EcommerceWebAppMonolatic.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {
}
