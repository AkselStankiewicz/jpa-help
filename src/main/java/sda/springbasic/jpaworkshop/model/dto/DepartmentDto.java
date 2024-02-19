package sda.springbasic.jpaworkshop.model.dto;

import lombok.Data;
import sda.springbasic.jpaworkshop.model.Address;

@Data
public class DepartmentDto {
    private String name;
    private Address address;
}
