package sda.springbasic.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.service.DepartmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Department> findByName(@PathVariable String name) {
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
}
