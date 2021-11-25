package com.enbaev;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registr extends HttpServlet {
   public static String name;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/registr.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        name = req.getParameter("FIRST_NAME");
        String lastName = req.getParameter("LAST_NAME");
        String women = req.getParameter("WOMEN");
        String men = req.getParameter("MEN");
        String password = req.getParameter("USER_PASSWORD");
        String userAgree = req.getParameter("agree");
        if (!CheckForRegistration.checkNullForRegistration(name, lastName, women, men, password)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/emptyLine.jsp");
            requestDispatcher.forward(req, resp);
        } else if (!CheckForRegistration.checkCorrectPassword(password)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/errorPassword.jsp");
            requestDispatcher.forward(req, resp);
        } else if (CheckForRegistration.checkAgree(userAgree)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/notAgree.jsp");
            requestDispatcher.forward(req, resp);
        } else if (!CheckForRegistration.checkNameLastNameContainsNumber(name, lastName)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/errorName.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/success.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
