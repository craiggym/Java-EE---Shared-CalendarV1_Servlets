package com.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by BHARATH on 2/26/2016.
 */
@WebServlet(name = "EventServlet",
        urlPatterns = {"/welcome", "/event"})
public class EventServlet extends HttpServlet {
    public static Calendar date = Calendar.getInstance();
    public static Map<String, Event> eventDatabase = new LinkedHashMap<>();

    /************************************
     * doPost Method
     * Create and view events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***************************************/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("home");
            return;
        }

        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.createEventPage(request, response);
                break;
            case "create_event":
                    this.addEvent(request,response);
                     break;
            case "view":
                this.userHome(request, response);
                break;
            default:
                this.userHome(request, response);
                break;
        }
    }

    /************************************
     * doGet Method
     * View events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***************************************/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") == null) {
            response.sendRedirect("home");
            return;
        }

        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            default:
                this.userHome(request, response);
                break;
        }
    }

    /*********************************************************
     * CreateEventPage
     * Allow the user to create events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ********************************************************/
    private void createEventPage(HttpServletRequest request,HttpServletResponse response)
        throws ServletException, IOException
        {
            request.getRequestDispatcher("/WEB-INF/jsp/view/createEvent.jsp")//to create an event
                    .forward(request, response);
        }
    /*********************************************************
     * addEvent
     * Allow the user to create events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ********************************************************/
    private void addEvent(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{

        //HttpSession session = request.getSession(false); Check if this is necessary
     //   String eventName=request.getParameter("eventName");
     //   String eventDescription=request.getParameter("Description");
     //   String eventDate=request.getParameter("eventDate");
        //HttpSession session=request.getSession(false);

        // Test event //
        Event testEvent = new Event("Golfing", date.getTime(), "Going to golf with the boss");
        eventDatabase.put(request.getParameter("username"),testEvent);
        System.out.println("Events database:\n " + eventDatabase);
        // end test event

       // session.setAttribute("eventName",eventName);
     //   session.setAttribute("eventDate",eventDate);
     //   session.setAttribute("Description",eventDescription);
    //    EventServlet.Created.put("eventDate","eventName");
     //   session.setAttribute("Created",this.Created);


        request.getRequestDispatcher("/WEB-INF/jsp/view/welcome.jsp")//User's Home page
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
             HttpSession session = request.getSession(false);
             String username =(String)session.getAttribute("username");

        request.getRequestDispatcher("/WEB-INF/jsp/view/welcome.jsp")//User's Home page
                .forward(request, response);
        }





}
