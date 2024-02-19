package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.springbasic.jpaworkshop.model.entity.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
