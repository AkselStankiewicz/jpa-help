package sda.springbasic.jpaworkshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sda.springbasic.jpaworkshop.model.Address;
import sda.springbasic.jpaworkshop.model.entity.Department;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void findByName() {
    }

    @Test
    void findAllByAddress_City() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findAllByName() {
        //given
        Department department = new Department();
        department.setName("IT");
        department.setAddress(new Address("Poland", "Warsaw", "Nowy Świat", "00-000"));
        departmentRepository.save(department);
        //when
        List<Department> departments = departmentRepository.findAllByName("IT");
        //then
        Assertions.assertEquals(1, departments.size());
    }

    @Test
    void findById() {
    }
}