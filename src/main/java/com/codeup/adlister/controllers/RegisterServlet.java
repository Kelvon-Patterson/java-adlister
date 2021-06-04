package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.apache.commons.validator.routines.EmailValidator;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
//        boolean allowLocal = true;
//        boolean valid = EmailValidator.getInstance(allowLocal).isValid(email);

        // TODO: ensure the submitted information is valid
        if(email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || !password.equals(confirmPassword)){
            response.sendRedirect("/WEB-INF/register");
        }
                // TODO: create a new user based off of the submitted information
        User registeredUser = new User(username,email,password);
        DaoFactory.getUsersDao().insert(registeredUser);
        // TODO: if a user was successfully created, send them to their profile


    }
}
