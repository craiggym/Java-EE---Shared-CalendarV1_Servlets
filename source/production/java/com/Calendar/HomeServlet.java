package com.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;

@WebServlet(
        name = "HomeServlet",
        urlPatterns = {"/home","/loginservlet"}
)
public class HomeServlet extends HttpServlet
{
    private static final Map<String, String> userDatabase = new Hashtable<>();

    static {
        userDatabase.put("Neil", "Armstrong");
        userDatabase.put("th", "th");
        userDatabase.put("Cesar", "Chavez");
        userDatabase.put("test", "a");
    }

    /*****************************************************
     * doPost Method
     * Goes directly to doGet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ****************************************************/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request,response);
    }

    /****************************************************
     * doGet Method
     * Handles user requests relating to logging in, logging out, adding, and going home
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***************************************************/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if(action == null)
            action = "goHome";

        switch(action)
        {
            case "userAdd":
                this.userAdd(request, response);
                break;
            case "login":
                this.login(request, response);
                break;
            case "logout":
                this.logout(request, response);
                break;
            case "goHome":
                this.goHome(request, response);
                break;

            default:
                this.goHome(request, response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("user");
        String password=request.getParameter("pass");
        if(username == null || password == null ||
                !HomeServlet.userDatabase.containsKey(username) ||
                !password.equals(HomeServlet.userDatabase.get(username)))
        {
            if(!HomeServlet.userDatabase.containsKey(username) ||
                    !password.equals(HomeServlet.userDatabase.get(username)))
                request.getRequestDispatcher("/WEB-INF/jsp/view/browseIncorrect.jsp")
                        .forward(request, response);

            request.getRequestDispatcher("/WEB-INF/jsp/view/browse.jsp")
                    .forward(request, response);
        }
        else
        {
            HttpSession session = request.getSession(true);
            String id=session.getId();
            session.setAttribute("username",username);
            response.sendRedirect("event");
        }
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
        request.getRequestDispatcher("/WEB-INF/jsp/view/logout.jsp")
                .forward(request, response);
    }

    /************************************************************************
     * Title: goHome
     * Description: The index home page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***********************************************************************/
    private void goHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //request.setAttribute("Created",EventServlet.Created);
        request.setAttribute("allEvents",EventServlet.eventDatabase);
        request.getRequestDispatcher("/WEB-INF/jsp/view/browse.jsp")
               .forward(request, response);
    }

    /*********************************************************************
     * Title: userAdd
     * Description: Adds user to "database"
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***********************************************************************/
    private void userAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String fname = request.getParameter("fname");
        String pass = request.getParameter("pass");

        HomeServlet.userDatabase.put(fname,pass);
        
        request.getRequestDispatcher("/WEB-INF/jsp/view/registerSuccess.jsp")
                .forward(request, response);
    }
}
