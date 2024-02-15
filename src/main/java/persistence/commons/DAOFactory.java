package persistence.commons;

import persistence.dao.UserDAO;
import persistence.dao.UserDAOImpl;

public class DAOFactory {

    public static UserDAO getUserDAO(){
        return new UserDAOImpl();
    }
}
