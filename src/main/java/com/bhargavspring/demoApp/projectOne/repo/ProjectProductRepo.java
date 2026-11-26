package com.bhargavspring.demoApp.projectOne.repo;

import com.bhargavspring.demoApp.projectOne.model.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectProductRepo extends JpaRepository<ProjectProduct, Integer> {
}
