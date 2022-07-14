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
    public Map<String, String> getData() {
        return translate;
    }
}
