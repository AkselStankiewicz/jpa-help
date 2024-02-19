package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sda.springbasic.jpaworkshop.model.entity.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);

    Optional<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "select min(salary) from employees", nativeQuery = true)
    BigDecimal findLowestSalary();

    @Query(value = "select max(salary) from employees", nativeQuery = true)
    BigDecimal findHighestSalary();

    @Query("select e from Employee e where e.salary = :salary")
    Employee findEmployeeByMinOrMaxSalary(@Param("salary") BigDecimal salary);
}
