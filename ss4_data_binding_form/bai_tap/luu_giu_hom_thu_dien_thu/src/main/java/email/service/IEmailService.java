package email.service;

import email.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    void save(Email email);

    void update(Email email);

    Email findById(int id);

    List<String> findLanguage();

    List<Integer> findPageSize();
}
