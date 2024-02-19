package sda.springbasic.jpaworkshop.service.mapper;

import org.springframework.stereotype.Component;
import sda.springbasic.jpaworkshop.model.dto.EmployeeDto;
import sda.springbasic.jpaworkshop.model.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setSalary(employee.getSalary());
        dto.setContractEnd(employee.getContractEnd());
        return dto;
    }

    public Employee toEntity(EmployeeDto dto) {
        Employee entity = new Employee();
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setSalary(dto.getSalary());
        entity.setContractEnd(dto.getContractEnd());
        return entity;
    }
}
