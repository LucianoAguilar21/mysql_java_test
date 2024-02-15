package controllers.userController;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import services.userServices.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/api/users/find_all")
public class FindAllUsersController extends HttpServlet {
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = userService.findAllUsers();

        System.out.println(users);
        String json = new Gson().toJson(users);
        resp.setContentType("application/json");
        resp.getWriter().write(json);

    }
}
