package sda.springbasic.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.springbasic.jpaworkshop.model.entity.Employee;
import sda.springbasic.jpaworkshop.repository.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repo;

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

}
