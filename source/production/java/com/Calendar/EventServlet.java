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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by BHARATH on 2/26/2016.
 */
@WebServlet(name = "EventServlet",
        urlPatterns = {"/eventServlet", "/event"})
public class EventServlet extends HttpServlet {

    public static Map<Integer, Event> Created = new LinkedHashMap<>();
    int id=1;
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
            case "create_event":

                    this.addEvent(request,response);
                     break;
            case "Created_view":
                this.usercreated(request, response);
                break;
            case "logout":
                this.logout(request, response);
                break;
            case "userEventView":
                this.userview(request, response);
                break;

            default:
                this.userHome(request, response);
                break;
        }
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

        request.getRequestDispatcher("/WEB-INF/jsp/view/welcome.jsp")//to create an event
                .forward(request, response);
        HttpSession session = request.getSession(false);
        String eventName=request.getParameter("eventName");
        String eventDescription=request.getParameter("Description");
        String eventDate=request.getParameter("eventDate");
        String username=(String) session.getAttribute("username");
        //HttpSession session=request.getSession(false);

        session.setAttribute("eventName",eventName);
        session.setAttribute("eventDate",eventDate);
        //System.out.println(eventDate+eventName);
        session.setAttribute("Description",eventDescription);
        Event e=new Event();
        e.setUsername(username);
        e.setDescription(eventDescription);
        e.setEventDate(eventDate);
        e.setEventName(eventName);
        e.setId(id);


        EventServlet.Created.put(id,e);
        System.out.println("size of Map "+this.Created.size());
        id++;
        session.setAttribute("Created",this.Created);
        request.setAttribute("Created",this.Created);


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
        HttpSession session = request.getSession(false);
        session.invalidate();//to invalidate the session
        System.out.println("In Log out");
        request.getRequestDispatcher("/WEB-INF/jsp/view/logout.jsp")
                .forward(request, response);
    }
    private void userview(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/userView.jsp")
                .forward(request, response);
    }
    private void usercreated(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {

        request.setAttribute("Created", this.Created);


        request.getRequestDispatcher("/WEB-INF/jsp/view/usercreated.jsp")
                .forward(request, response);
    }





}
