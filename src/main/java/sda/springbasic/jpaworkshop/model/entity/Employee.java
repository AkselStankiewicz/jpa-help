package sda.springbasic.jpaworkshop.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYEES")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstName;
    private String lastName;
//    @Column(name = "zarobki", nullable = false)
    private BigDecimal salary;
    private LocalDate contractEnd;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    @OneToOne
    private EntryCard entryCard;

}
