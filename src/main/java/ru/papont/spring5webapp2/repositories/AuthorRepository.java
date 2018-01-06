package ru.papont.spring5webapp2.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.papont.spring5webapp2.model.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
