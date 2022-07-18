package email.repository;

import email.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();

    void save(Email email);

    void update(Email email);

    Email findById(int id);

    List<String> findLanguage();

    List<Integer> findPageSize();
}
