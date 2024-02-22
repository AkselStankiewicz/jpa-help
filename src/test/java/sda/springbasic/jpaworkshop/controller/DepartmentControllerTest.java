package sda.springbasic.jpaworkshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sda.springbasic.jpaworkshop.model.Address;
import sda.springbasic.jpaworkshop.model.dto.DepartmentDto;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.service.DepartmentService;
import sda.springbasic.jpaworkshop.service.mapper.DepartmentMapper;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = DepartmentController.class)
//@AutoConfigureMockMvc(addFilters = false)
//@ExtendWith(MockitoExtension.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @MockBean
    private DepartmentMapper mapper;

    @Test
    void findByName() throws Exception {
        //given
        String departmentName = "IT";
        var department = new Department();
        department.setName(departmentName);

        Mockito.when(departmentService.findDepartmentByName(departmentName))
                .thenReturn(department);
        //when//then
        mockMvc.perform(get("/departments/findByName")
                .param("name", departmentName))
//                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(departmentName));
    }

    @Test
    void addDepartment() throws Exception {

    }

    @Test
    void findAllByAddress_City() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void findAllByName() {
    }

    @Test
    void updateDepartment() {
    }

    @Test
    void testAddDepartment() throws Exception {
        //given
        String departmentName = "IT";
        DepartmentDto dto = new DepartmentDto();
        dto.setName(departmentName);
        dto.setAddress(
                new Address("England", "London", "Some Street", "12131")
        );
        Department entity = mapper.toEntity(dto);

        Mockito.when(departmentService.addDepartmentByDto(dto)).thenReturn(entity);

        //when//then
        mockMvc.perform(post("/departments/addDepartmentWithDto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(departmentName));
    }
}