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
import java.util.*;


/**
 * Created by BHARATH on 2/26/2016.
 */
@WebServlet(name = "EventServlet",
        urlPatterns = {"/welcome", "/event"})
public class EventServlet extends HttpServlet {
    public static Calendar date = Calendar.getInstance();
   // public static Map<Integer, Event> eventDatabase = new LinkedHashMap<>();
    //public static Map<Integer, Event> personalDatabase = new LinkedHashMap<>();
    public static Map<String, LinkedList<Event>> eventDatabase = new HashMap<>();
    public static LinkedList<Event> eventLinkedList = new LinkedList<>();
    int id=0;

    /************************************
     * doPost
     * Create and view events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***************************************/
    //public static Map<String, String> Liked = new LinkedHashMap<>();
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
            case "add_event":
                    this.addEvent(request,response);
                     break;
            case "viewAll":
                this.viewAll(request, response);
                break;
            default:
                System.out.println("Coult not link action to a switch case. Default loaded!");
                this.userHome(request, response);
                break;
        }
    }

    /************************************
     * doGet
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
            throws ServletException, IOException {

        // Taken from HTML form
        HttpSession session = request.getSession(false);
        String eventName = request.getParameter("eventName");
        String eventDescription = request.getParameter("Description");
        String username = (String) session.getAttribute("username");

        // Parsing the date passed from the HTML form //
        String string = request.getParameter("month"); // Passed from HTML
        String[] parser = string.split("_"); // Parse using the indicator
        String parseMonth = parser[1]; // Take what we want
        int monthWeight = Integer.parseInt(parseMonth);
        string = request.getParameter("date"); // Repeat for date...
        parser = string.split("_");
        String parsedDate = parser[1];
        int dateWeight = Integer.parseInt(parsedDate);

        String eventDate =  parseMonth + "-" + parsedDate + "-2016";



        // Pre-paring the container for the Event object
        session.setAttribute("eventName", eventName);
        session.setAttribute("Description", eventDescription);
        session.setAttribute("eventDate", eventDate);
        session.setAttribute("username", username);
        session.setAttribute("id", id++);
        Event createdNewEvent = new Event(eventName, eventDate, eventDescription, username, id); // Create event object

        // Check if the user has a set of events yet //
        LinkedList checkForNull = eventDatabase.get(username);
        if(checkForNull == null) eventLinkedList = new LinkedList<>(); // If no event set, create a new one

        eventLinkedList.add(createdNewEvent); // Append new event
        eventDatabase.put(username,eventLinkedList); // The appended linked list will overwrite pre-existing one

        request.setAttribute("eventDatabase", this.eventDatabase);
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
             request.setAttribute("eventDatabase", this.eventDatabase);

        request.getRequestDispatcher("/WEB-INF/jsp/view/welcome.jsp")//User's Home page
                .forward(request, response);
        }

    /*********************************************************
     *viewAll
     * Redirect to Home page displaying all events
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ********************************************************/
    private void viewAll(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        String username =(String)session.getAttribute("username");
        request.setAttribute("eventDatabase", this.eventDatabase);

        request.getRequestDispatcher("/WEB-INF/jsp/view/browse.jsp")//User's Home page
                .forward(request, response);
    }


}
