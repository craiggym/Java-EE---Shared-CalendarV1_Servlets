package com.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by BHARATH on 2/26/2016.
 */
@WebServlet(name = "UserHomeServlet",
        urlPatterns = {"/loginsuccess","/welcome"})
public class UserHomeServlet extends HttpServlet {

    private Map<Integer, event> eventDatabase = new LinkedHashMap<>();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("home");
            return;
        }

        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.createEvent(request, response);
                break;
            case "view":
                this.userHome(request, response);
                break;
            case "logout":
                this.logout(request, response);
                break;
            default:
                this.userHome(request, response);
                break;
        }
    }

    /*********************************************************
     * CreateEvent
     * Allow the user to create events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ********************************************************/
    private void createEvent(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException
        {
            request.getRequestDispatcher("/WEB-INF/jsp/view/createEvent.jsp")//to create an event
                    .forward(request, response);
        }
    /*********************************************************
     *userHome
     * Redirect to userHome page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ********************************************************/
    private void userHome(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
         {
        request.getRequestDispatcher("/WEB-INF/jsp/view/welcome.jsp")//User's Home page
                .forward(request, response);
        }
    /*********************************************************
     *logout
     * Logs the user out
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ********************************************************/
    private void logout(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.invalidate();//to invalidate the session
        request.getRequestDispatcher("/WEB-INF/jsp/view/logout.jsp")
                .forward(request, response);
    }




}
