package ru.papont.spring5webapp2.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.papont.spring5webapp2.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
