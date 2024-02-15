package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.springbasic.jpaworkshop.model.entity.Department;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
