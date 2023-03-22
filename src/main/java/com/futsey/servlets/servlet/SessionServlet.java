package com.futsey.servlets.servlet;

import com.futsey.servlets.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {

    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var userAttribute = (UserDTO) session.getAttribute(USER);
        if (userAttribute == null) {
            userAttribute = UserDTO.builder()
                    .id(22L)
                    .mail("test@gmail.com")
                    .build();
            session.setAttribute(USER, userAttribute);
        }

    }
}
