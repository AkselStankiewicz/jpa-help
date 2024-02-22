package sda.springbasic.jpaworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sda.springbasic.jpaworkshop.model.entity.test.Author;
import sda.springbasic.jpaworkshop.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository repo;

    @DeleteMapping("/deleteById")
    @Transactional // --> to powinno iść od serwisu
    public ResponseEntity<Void> deleteBooksById(@RequestParam Long id) {
        Optional<Author> authorById = repo.findById(id);
        authorById.ifPresent(a -> a.getBooks().clear());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Void> findAll() {
        List<Author> authors = repo.findAll();
        System.out.println("*****************************************");
        authors.stream()
                .map(Author::getBooks)
                .forEach(System.out::println);
        System.out.println("*****************************************");
        return ResponseEntity.ok().build();
    }
}
