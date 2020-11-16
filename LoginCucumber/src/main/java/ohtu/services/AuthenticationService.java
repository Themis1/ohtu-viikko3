package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import java.lang.Character;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password

        Boolean user = false;
        if (username.length() > 3){
            user = true;
        }

        Boolean kirjain = false;
        Boolean numero = false;

        for (int merkki = 0; merkki < password.length(); merkki++) { 
            //tama = password[merkki];
            if (Character.isLetter(password.charAt(merkki))) {
                kirjain = true;
            }
            if (Character.isDigit(password.charAt(merkki))) {
                numero = true;
            }
        }
        if (user == true && kirjain == true && numero == true && password.length() > 7) {
            return false;
        }

        return true;
    }
}
