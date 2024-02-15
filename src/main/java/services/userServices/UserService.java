package services.userServices;

import models.User;
import persistence.commons.DAOFactory;

import java.util.List;

public class UserService {

    public List<User> findAllUsers(){
        return DAOFactory.getUserDAO().findAll();
    }
}
