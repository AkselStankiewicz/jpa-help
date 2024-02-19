package sda.springbasic.jpaworkshop.service.mapper;

import org.springframework.stereotype.Component;
import sda.springbasic.jpaworkshop.model.dto.DepartmentDto;
import sda.springbasic.jpaworkshop.model.entity.Department;

@Component
public class DepartmentMapper {
    public DepartmentDto toDto(Department entity) {

        DepartmentDto dto = new DepartmentDto();
        dto.setAddress(entity.getAddress());
        dto.setName(entity.getName());

        return dto;
    }

    public Department toEntity (DepartmentDto dto) {

        Department entity = new Department();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());

        return entity;
    }
}
