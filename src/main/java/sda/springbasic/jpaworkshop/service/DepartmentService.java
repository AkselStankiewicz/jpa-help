package sda.springbasic.jpaworkshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.springbasic.jpaworkshop.exceptions.NoDepartmentInBaseException;
import sda.springbasic.jpaworkshop.exceptions.NoDepartmentsInCityException;
import sda.springbasic.jpaworkshop.model.dto.DepartmentDto;
import sda.springbasic.jpaworkshop.model.entity.Department;
import sda.springbasic.jpaworkshop.repository.DepartmentRepository;
import sda.springbasic.jpaworkshop.service.mapper.DepartmentMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repo;
    private final DepartmentMapper mapper;

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

    @Transactional(readOnly = true)
    public List<DepartmentDto> findAllByName(String name) {
        List<Department> allByName = repo.findAllByName(name);
        return allByName.stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional(rollbackFor = SQLException.class) // --> dzięki dodaniu rollbacka też save się nie wykona
    public Department addDepartmentByDto(DepartmentDto department){
        Department save = repo.save(mapper.toEntity(department));
//        throwSomeException(); --> poleci 500 i save się nie wykona
//        throwSQLException(); // --> tu zadziała, bo to jest unchecked exception i @Transactional go nie kmini
        return save;
    }

    public Department updateDepartment(Long id, DepartmentDto department) {
        Optional<Department> byId = repo.findById(id);
        if (byId.isPresent()) {
            Department toUpdate = byId.get();
            toUpdate.setName(department.getName());
            toUpdate.setAddress(department.getAddress());
        } else {
            throw new NoDepartmentInBaseException();
        }
        return repo.save(byId.get());
    }

    public void throwSomeException() {
        throw new RuntimeException("Nasz Wyjątek");
    }

    public void throwSQLException() throws SQLException {
        throw new SQLException("Nasz wyjątek");
    }
}
