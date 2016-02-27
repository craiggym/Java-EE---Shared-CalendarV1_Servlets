package com.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by BHARATH on 2/26/2016.
 */
@WebServlet(name = "UserHomeServlet", urlPatterns = {"/loginsuccess"})
public class UserHomeServlet extends HttpServlet {

    private Map<Integer, event> eventDatabase = new LinkedHashMap<>();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //PrintWriter out=response.getWriter();
        //out.println("hello");if(request.getSession().getAttribute("username") == null)
        {
            response.sendRedirect("login");
            return;
        }

        String action = request.getParameter("action");
        if(action == null)
            action = "list";
        switch(action)
        {
            case "create":
                this.showTicketForm(request, response);
                break;
            case "view":
                this.viewTicket(request, response);
                break;
            case "download":
                this.downloadAttachment(request, response);
                break;
            case "list":
            default:
                this.listTickets(request, response);
                break;
        }

        PrintWriter out=response.getWriter();
        out.println("hello");

    }
}
