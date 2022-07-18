package email.repository;

import email.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList;

    static {
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "English", 5, true, "no"));
        emailList.add(new Email(2, "Vietnamese", 15, false, "no"));
        emailList.add(new Email(3, "Chinese", 25, true, "no"));
        emailList.add(new Email(4, "Japanese", 5, true, "no"));
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);
    }

    @Override
    public void update(Email email) {
        for (Email item : emailList) {
            if (email.getId() == item.getId()) {
                emailList.remove(item);
                emailList.add(email);
                return;
            }
        }
    }

    @Override
    public Email findById(int id) {
        for (Email items : emailList) {
            if (items.getId() == id) {
                return items;
            }
        }
        return null;
    }

    @Override
    public List<String> findLanguage() {
        List<String> temps = new LinkedList<>();
        temps.add("English");
        temps.add("Vietnamese");
        temps.add("Chinese");
        temps.add("Japanese");
        return temps;
    }

    @Override
    public List<Integer> findPageSize() {
        List<Integer> temp = new LinkedList<>();
        temp.add(5);
        temp.add(10);
        temp.add(15);
        temp.add(25);
        temp.add(50);
        temp.add(100);
        return temp;
    }
}
