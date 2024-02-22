package sda.springbasic.jpaworkshop.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sda.springbasic.jpaworkshop.model.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepositoryV2 extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Department> findAllByAddress_City(String city);

//    @Query(value = "delete from Department d where d.id = :id")
    void deleteById(@NonNull @Param("id") Long id);

    @Query(value = "SELECT d from Department  d where d.name like :name")
    List<Department> findAllByName(@Param("name") String name);

    Optional<Department> findById(Long id);

}
