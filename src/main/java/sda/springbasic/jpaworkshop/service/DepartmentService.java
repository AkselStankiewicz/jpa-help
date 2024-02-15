package sda.springbasic.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.repository.DepartmentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repo;

    public Department findDepartmentByName(String name) {
        Optional<Department> optDep = repo.findByName(name);

        return optDep.orElseGet(Department::new);
    }
}
