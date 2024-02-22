package sda.springbasic.jpaworkshop.controller;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.springbasic.jpaworkshop.model.dto.DepartmentDto;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.service.DepartmentService;
import sda.springbasic.jpaworkshop.service.mapper.DepartmentMapper;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("/findByName")
    public ResponseEntity<Department> findByName(@PathParam("name") String name) {
        Department departmentByName = service.findDepartmentByName(name);
        return ResponseEntity.ok(departmentByName);
    }

    @GetMapping("/findAllByCity/{city}")
    public ResponseEntity<List<Department>> findAllByAddress_City(@PathVariable String city) {
        return ResponseEntity.ok(service.findAllByAddress_City(city));
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(service.addDepartment(department));
    }

    @PostMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Removed department with id: " + id);
    }

    @PostMapping("/updateById")
    public ResponseEntity<Department> updateById(@RequestBody Department department) {
        return ResponseEntity.ok(service.updateDepartmentById(department));
    }

    @GetMapping("/findAllByName/{name}")
    public ResponseEntity<List<DepartmentDto>> findAllByName(@PathVariable String name) {
        List<DepartmentDto> departmentsByName = service.findAllByName(name);
        return ResponseEntity.ok(departmentsByName);
    }

    @PostMapping("/updateDepartment/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto dto) {
        return ResponseEntity.ok(service.updateDepartment(id, dto));
    }

    @PostMapping("/addDepartmentWithDto")
    public ResponseEntity<Department> addDepartment(@RequestBody DepartmentDto department){
        return ResponseEntity.ok(service.addDepartmentByDto(department));
    }
}
