package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.springbasic.jpaworkshop.model.entity.Floor;

public interface FloorRepository extends JpaRepository<Floor, Long> {
}
