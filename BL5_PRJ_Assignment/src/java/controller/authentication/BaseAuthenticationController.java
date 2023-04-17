/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;

/**
 *
 * @author sonnt
 */
public abstract class BaseAuthenticationController extends HttpServlet {
    private boolean isAuthen(HttpServletRequest req)
    {
        return req.getSession().getAttribute("account") != null;
    }
    
    protected abstract void processPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException;
    protected abstract void processGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isAuthen(req))
        {
            //write content
            Account account = (Account)req.getSession().getAttribute("account");
            processPost(req, resp, account);
        }
        else
            resp.getWriter().println("access denied!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isAuthen(req))
        {
            //write content
            Account account = (Account)req.getSession().getAttribute("account");
            processGet(req, resp, account);
        }
        else
            resp.getWriter().println("access denied!");
    }
    
}
