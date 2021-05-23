package net.togogo.servlet;

import net.togogo.service.UserService;
import net.togogo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUser")
public class DelUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService =new UserServiceImpl();
        String id = req.getParameter("id");
        int count = userService.deleteUserById(id);
        if(count>0){
            //跳转回 /index
            resp.sendRedirect(req.getContextPath()+"/index");

        }

    }
}
