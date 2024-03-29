package sda.springbasic.jpaworkshop.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.springbasic.jpaworkshop.model.Address;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.repository.DepartmentRepository;
import sda.springbasic.jpaworkshop.service.mapper.DepartmentMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    private DepartmentService departmentService;
    private DepartmentRepository departmentRepository;
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
    @BeforeEach
    void setUp() {
        departmentRepository = Mockito.mock(DepartmentRepository.class);
        departmentService = new DepartmentService(departmentRepository, new DepartmentMapper());
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

    @Test
    void findAllByAddress_City() {
    }

    @Test
    void addDepartment() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateDepartmentById() {
    }

    @Test
    void findAllByName() {
    }

    @Test
    void addDepartmentByDto() {
    }

    @Test
    void updateDepartment() {
    }
}