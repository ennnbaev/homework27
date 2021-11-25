package com.enbaev;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registr extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/registr.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("FIRST_NAME");
        String lastName = req.getParameter("LAST_NAME");
        String women = req.getParameter("WOMEN");
        String men = req.getParameter("MEN");
        String password = req.getParameter("USER_PASSWORD");
        String userAgree = req.getParameter("agree");
        if (!CheckForRegistration.checkNullForRegistration(name, lastName, women, men, password)) {
            resp.getWriter().println("Lines cannot be empty!");
        } else if (!CheckForRegistration.checkCorrectPassword(password)) {
            resp.getWriter().println("Password cannot be less than 6 characters");
        } else if (CheckForRegistration.checkAgree(userAgree)) {
            resp.getWriter().println("You have not confirmed the processing of data");
        } else if (!CheckForRegistration.checkNameLastNameContainsNumber(name, lastName)) {
            resp.getWriter().println("First and last name cannot contain numbers");
        } else {
            resp.getWriter().println(
                    "Congratulations " + name + " on successful registration");
        }
    }
}
