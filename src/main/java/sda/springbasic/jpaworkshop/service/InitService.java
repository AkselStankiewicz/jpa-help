package sda.springbasic.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import sda.springbasic.jpaworkshop.model.Address;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.model.entity.Employee;
import sda.springbasic.jpaworkshop.model.entity.EntryCard;
import sda.springbasic.jpaworkshop.repository.DepartmentRepository;
import sda.springbasic.jpaworkshop.repository.EmployeeRepository;
import sda.springbasic.jpaworkshop.repository.EntryCardRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EntryCardRepository entryCardRepository;

    public void createSimpleData() {

        Department department1 = new Department();
        department1.setName("IT");
        department1.setAddress(new Address("Poland", "Warsaw", "Nowy Świat", "00-001"));
        departmentRepository.save(department1);

        Department department2 = new Department();
        department2.setName("Sales");
        department2.setAddress(new Address("Poland", "Krakow", "Rynek Główny", "31-042"));
        departmentRepository.save(department2);

        Department department3 = new Department();
        department3.setName("Marketing");
        department3.setAddress(new Address("Poland", "Wroclaw", "Rynek", "50-001"));
        departmentRepository.save(department3);

        Department department4 = new Department();
        department4.setName("Finance");
        department4.setAddress(new Address("Poland", "Gdansk", "Targ Węglowy", "80-827"));
        departmentRepository.save(department4);

        Department department5 = new Department();
        department5.setName("HR");
        department5.setAddress(new Address("Poland", "Poznan", "Stary Rynek", "61-772"));
        departmentRepository.save(department5);

        EntryCard entryCard1 = new EntryCard();
        entryCard1.setUuid(UUID.randomUUID());

        EntryCard entryCard2 = new EntryCard();
        entryCard2.setUuid(UUID.randomUUID());

        EntryCard entryCard3 = new EntryCard();
        entryCard3.setUuid(UUID.randomUUID());

        entryCardRepository.save(entryCard1);
        entryCardRepository.save(entryCard2);
        entryCardRepository.save(entryCard3);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

        employee1.setFirstName("Andrzej");
        employee1.setLastName("Kowalski");
        employee1.setSalary(BigDecimal.valueOf(9000));
        employee1.setContractEnd(LocalDate.of(2025, Month.DECEMBER,3));
        employee1.setDepartment(department4);
        employee1.setEntryCard(entryCard1);

        employee2.setFirstName("Mariusz");
        employee2.setLastName("Pudzianowski");
        employee2.setSalary(BigDecimal.valueOf(19000));
        employee2.setContractEnd(LocalDate.of(2025,Month.JULY,3));
        employee2.setDepartment(department2);
        employee2.setEntryCard(entryCard2);

        employee3.setFirstName("Bożena");
        employee3.setLastName("Poleska");
        employee3.setSalary(BigDecimal.valueOf(4000));
        employee3.setContractEnd(LocalDate.of(2025,Month.FEBRUARY,3));
        employee3.setDepartment(department1);
        employee3.setEntryCard(entryCard3);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }
}
