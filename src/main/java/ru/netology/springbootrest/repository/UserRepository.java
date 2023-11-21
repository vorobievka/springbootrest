package ru.netology.springbootrest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private String user;
    private String password;

    Authorities write = Authorities.WRITE;
    Authorities read = Authorities.READ;
    Authorities delete = Authorities.DELETE;
    Map<String, List<Authorities>> map = new HashMap<>();
    Map<String, String> pass = new HashMap<>();
    List<Authorities> invalidCredentials = new ArrayList<Authorities>();

    public UserRepository() {
        List<Authorities> adminAuthority = new ArrayList<Authorities>();
        adminAuthority.add(read);
        adminAuthority.add(write);
        adminAuthority.add(delete);
        map.put("admin", adminAuthority);
        pass.put("admin", "123456");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (pass.get(user).equals(password)) {
            return map.get(user);
        }
        return invalidCredentials;
    }
}

