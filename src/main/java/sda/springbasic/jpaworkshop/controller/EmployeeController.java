package sda.springbasic.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.springbasic.jpaworkshop.model.dto.EmployeeDto;
import sda.springbasic.jpaworkshop.model.entity.Employee;
import sda.springbasic.jpaworkshop.service.EmployeeService;

import java.util.List;

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

    @GetMapping("/findByLastName")
    private ResponseEntity<List<EmployeeDto>> findByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(service.findByLastName(lastName));
    }

    @PostMapping("/updateSalary")
    private ResponseEntity<EmployeeDto> updateSalary(@RequestBody EmployeeDto dto) {
        return ResponseEntity.ok(service.updateSalary(dto));
    }

    @GetMapping("/lowestSalary")
    private ResponseEntity<EmployeeDto> findLowestWageEmployee(@RequestParam String minOrMax) {
        return ResponseEntity.ok(service.findLowestWageEmployee(minOrMax));
    }

}
