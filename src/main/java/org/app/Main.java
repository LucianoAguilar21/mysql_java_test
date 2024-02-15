package org.app;

import services.userServices.UserService;


public class Main {
    public static void main(String[] args)  {


        UserService userService = new UserService();
        System.out.println(userService.findAllUsers());
    }
}