package sda.springbasic.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.service.DepartmentService;

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
}
