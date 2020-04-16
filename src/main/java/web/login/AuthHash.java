package web.login;

import java.util.HashMap;
import java.util.Map;

public class AuthHash implements Auth {

  private final Map<String, String> db = new HashMap<String, String>(){{
    put("user", "123");
    put("admin", "234");
    put("manager", "345");
  }};

  @Override
  public boolean check(String name, String password) {
    return db.containsKey(name) && db.get(name).equals(password);
  }
}

