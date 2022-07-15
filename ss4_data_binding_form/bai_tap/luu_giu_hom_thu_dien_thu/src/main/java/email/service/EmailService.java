package email.service;

import email.model.Email;
import email.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Override
    public void update(Email email) {
        emailRepository.update(email);
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }

    @Override
    public List<String> findLanguage() {
        return emailRepository.findLanguage();
    }

    @Override
    public List<Integer> findPageSize() {
        return emailRepository.findPageSize();
    }
}
