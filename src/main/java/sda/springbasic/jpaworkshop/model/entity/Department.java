package sda.springbasic.jpaworkshop.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import sda.springbasic.jpaworkshop.model.Address;

import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employee> employees;

    public Department(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
