package web.login;

import java.util.HashMap;
import java.util.Map;

public class AuthHash implements Auth {

  private final Map<String, String> database = new HashMap<String, String>(){{
    put("zeynab", "12345");
    put("alexey", "54321");
    put("mom", "1212");
  }};

  @Override
  public boolean check(String name, String password) {
    return database.containsKey(name) && database.get(name).equals(password);
  }
}

