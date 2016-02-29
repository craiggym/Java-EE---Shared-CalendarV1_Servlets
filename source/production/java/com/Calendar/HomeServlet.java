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
    // User class which holds username and password
    /*public class User{
        public User(String name, String pass){ // Constructor for User
            this.name=name;
            this.password=pass;
        }

        //private LinkedList<String> events = new LinkedList<>(); // user events
        private String name; // user's name
        private String password; // user's password
    } // Close class User
    // pre-defined users
    User neil = new User("Neil", "Armstrong");
    User abraham = new User("Abraham", "Lincoln");
    User cesar = new User("Cesar", "Chavez");
    User pocahontas = new User("Pocahontas", "Rebeccarolfe");

    private static int ID = 0; // Increment users ID while adding to database

    private final Map<Integer, User> db = new Hashtable<>(); // database
    public HomeServlet() // Constructor for HomeServlet
    {
        this.db.put(ID++, neil);
        this.db.put(ID++, abraham);
        this.db.put(ID++, cesar);
        this.db.put(ID++, pocahontas);
    }
*/
    private static final Map<String, String> userDatabase = new Hashtable<>();

    static {
        userDatabase.put("Neil", "Armstrong");
        userDatabase.put("th", "th");
        userDatabase.put("Cesar", "Chavez");
        userDatabase.put("Pocahontas", "Rebeccarolfe");
    }

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
            System.out.println("id is "+id);
            session.setAttribute("username",username);
            response.sendRedirect("event");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request,response);
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
        request.setAttribute("Created",EventServlet.Created);
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
        //User person = new User(fname, pass);
        //Hdb.put(ID++,person); // add the user
        HomeServlet.userDatabase.put(fname,pass);

        System.out.println("User " + fname + " added.");

        request.getRequestDispatcher("/WEB-INF/jsp/view/registerSuccess.jsp")
                .forward(request, response);
    }
}
