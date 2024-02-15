package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.springbasic.jpaworkshop.model.entity.EntryCard;

public interface EntryCardRepository extends JpaRepository<EntryCard, Long> {
}
