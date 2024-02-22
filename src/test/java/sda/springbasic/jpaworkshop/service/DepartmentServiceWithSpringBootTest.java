package sda.springbasic.jpaworkshop.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sda.springbasic.jpaworkshop.model.Address;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.repository.DepartmentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentServiceWithSpringBootTest {

    @MockBean
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentService departmentService;

    static long start;
    static long end;

    @BeforeAll
    static void beforeAll() {
        start = System.nanoTime();
    }

    @AfterAll
    static void afterAll() {
        end = System.nanoTime();
        System.out.println("Czas wykonania: " + (end - start)/1000000 + "ms");
    }

    @Test
    void findDepartmentByName() {
        //given
        String departmentName = "IT";
        Department department = new Department();
        department.setName(departmentName);
        department.setAddress(new Address("England", "London", "Buckingham Street", "01-011"));

        Mockito.when(departmentRepository.findByName(departmentName))
                .thenReturn(Optional.of(department));
        //when

        Department departmentByName = departmentService.findDepartmentByName(departmentName);

        //then
        assertEquals(departmentName, departmentByName.getName());

    }

}
