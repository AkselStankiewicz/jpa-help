package sda.springbasic.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sda.springbasic.jpaworkshop.exceptions.NoDepartmentInBaseException;
import sda.springbasic.jpaworkshop.exceptions.NoDepartmentsInCityException;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repo;

    public Department findDepartmentByName(String name) {
        Optional<Department> optDep = repo.findByName(name);

        return optDep.orElseThrow(NoDepartmentInBaseException::new);
    }

    public List<Department> findAllByAddress_City(String city) {
        List<Department> allByAddressCity = repo.findAllByAddress_City(city);
        if (allByAddressCity.isEmpty()) {
            throw new NoDepartmentsInCityException();
        }
        return allByAddressCity;
    }

    public Department addDepartment(Department department) {
        return repo.save(department);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Department updateDepartmentById(Department department) {
        return repo.save(department);
    }
}
