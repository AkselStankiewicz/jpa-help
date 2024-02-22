package sda.springbasic.jpaworkshop.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import sda.springbasic.jpaworkshop.model.Address;
import sda.springbasic.jpaworkshop.model.entity.Department;

import java.util.List;

@DataJpaTest
@Sql(scripts = "data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(scripts = "DELETE_ALL.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DepartmentRepositoryTestV2 {

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

        //when
        List<Department> departments = departmentRepository.findAllByName("IT");
        //then
        Assertions.assertEquals(1, departments.size());
    }

    @Test
    void findById() {
    }
}