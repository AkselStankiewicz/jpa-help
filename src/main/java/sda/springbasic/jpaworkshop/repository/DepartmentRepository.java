package sda.springbasic.jpaworkshop.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import sda.springbasic.jpaworkshop.model.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Department> findAllByAddress_City(String city);

    void deleteById(@NonNull Long id);



}
