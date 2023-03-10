package se.iths.guessinggamemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    User user;

  private List<User> users = new ArrayList<>();

    public boolean checkUserExists(String user) {
        for (User u : users) {
            if (u.getUsername().equals(user)) {
                return true;
            }
        }return false;
    }

     public String welcomeUser(String user) {
         if (checkUserExists(user)) {
             return ("Welcome back, " + user);
         } else {
             addUser(user);
             return ("Welcome, " + user);
         }
     }

    public void addUser(String user) {
        User newUser = new User(user);
        users.add(newUser);
    }

    public List<User> getUsers() {
        return users;
    }
}
