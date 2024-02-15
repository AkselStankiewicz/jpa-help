package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.springbasic.jpaworkshop.model.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
