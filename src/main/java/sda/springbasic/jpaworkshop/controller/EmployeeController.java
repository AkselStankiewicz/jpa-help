package sda.springbasic.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.springbasic.jpaworkshop.model.entity.Employee;
import sda.springbasic.jpaworkshop.service.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping("/addEmployee")
    private ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return ResponseEntity.ok().build();
    }

}
