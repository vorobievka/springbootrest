package ru.netology.springbootrest.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private String user;
    private String password;
    final Authorities write = Authorities.WRITE;
    final Authorities read = Authorities.READ;
    final Authorities delete = Authorities.DELETE;
    final Map<String, List<Authorities>> map = new HashMap<>();
    final Map<String, String> pass = new HashMap<>();
    final List<Authorities> invalidCredentials = new ArrayList<Authorities>();

    public UserRepository() {
        List<Authorities> adminAuthority = new ArrayList<Authorities>();
        adminAuthority.add(read);
        adminAuthority.add(write);
        adminAuthority.add(delete);
        map.put("admin", adminAuthority);
        pass.put("admin", "123456");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (map.containsKey(user)) {
            if (pass.get(user).equals(password) && pass.containsKey(user)) {
                return map.get(user);
            }
        }
        return invalidCredentials;
    }
}

