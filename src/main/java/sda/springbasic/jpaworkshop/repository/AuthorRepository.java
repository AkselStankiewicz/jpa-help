package sda.springbasic.jpaworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.springbasic.jpaworkshop.model.entity.test.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "SELECT a from Author a join fetch a.books") // rozwiązanie problemu n+1
    List<Author> findAll();
}
