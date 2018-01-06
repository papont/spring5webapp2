package ru.papont.spring5webapp2.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.papont.spring5webapp2.model.Author;
import ru.papont.spring5webapp2.model.Book;
import ru.papont.spring5webapp2.model.Publisher;
import ru.papont.spring5webapp2.repositories.AuthorRepository;
import ru.papont.spring5webapp2.repositories.BookRepository;
import ru.papont.spring5webapp2.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Harper Collins address");
        Book ddd = new Book("Domain Driven Disign", "1234", harper);
        eric.getBooks().add(ddd);

        publisherRepository.save(harper);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worxs = new Publisher("Worx", "Worx address");
        Book noEJB = new Book("J2EE Development without EJB", "2345", worxs);
        rod.getBooks().add(noEJB);

        publisherRepository.save(worxs);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
