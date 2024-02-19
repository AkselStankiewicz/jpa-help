package sda.springbasic.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.springbasic.jpaworkshop.exceptions.NoSuchEmployeeInBaseException;
import sda.springbasic.jpaworkshop.model.dto.EmployeeDto;
import sda.springbasic.jpaworkshop.model.entity.Employee;
import sda.springbasic.jpaworkshop.repository.EmployeeRepository;
import sda.springbasic.jpaworkshop.service.mapper.EmployeeMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public List<EmployeeDto> findByLastName(String lastName) {
        List<Employee> byLastName = repo.findByLastName(lastName);
        if (byLastName.isEmpty()) {
            throw new NoSuchEmployeeInBaseException();
        }
        return byLastName.stream()
                .map(mapper::toDto)
                .toList();
    }

    public EmployeeDto updateSalary(EmployeeDto dto) {
        Optional<Employee> employee = repo.findByFirstNameAndLastName(dto.getFirstName(), dto.getLastName());
        if (employee.isEmpty()) {
            throw new NoSuchEmployeeInBaseException();
        }
        Employee employee1 = employee.get();
        employee1.setSalary(dto.getSalary());
        repo.save(employee1);
        return mapper.toDto(employee1);
    }

    public EmployeeDto findLowestWageEmployee(String minOrMax) {
        BigDecimal salary;
        if (minOrMax.equals("min")) {
            salary = repo.findLowestSalary();
        } else if(minOrMax.equals("max")){
            salary = repo.findHighestSalary();
        } else {
            throw new RuntimeException("Wrong param.");
        }
        return mapper.toDto(repo.findEmployeeByMinOrMaxSalary(salary));
    }
}
