package dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> translate = new HashMap<>();

    static {
        translate.put("hello", "xin chao");
        translate.put("pen", "cay but");
        translate.put("table", "cai ban");
    }

    @Override
    public String value(String vietnamese) {
        String result = translate.get(vietnamese);
        if (result == null) {
            return "khong dich duoc";
        }
        return result;
    }
}
