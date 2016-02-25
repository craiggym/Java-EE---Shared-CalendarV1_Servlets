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
        name = "storeServlet",
        urlPatterns = {"/shop", "/userRegister", "/main"}
)
public class StoreServlet extends HttpServlet
{
    public class User{
        public User(String name, String pass){ // Constructor for User
            this.name=name;
            this.password=pass;
        }

        private LinkedList<String> events = new LinkedList<>(); // user events
        private String name; // user's name
        private String password; // user's password
    } // Close class User

    // pre-defined users
    User neil = new User("Neil", "Armstrong");
    User abraham = new User("Abraham", "Lincoln");
    User cesar = new User("Cesar", "Chavez");
    User pocahontas = new User("Pocahontas", "Rebeccarolfe");

    private final Map<Integer, User> db = new Hashtable<>(); // database
    public StoreServlet() // Constructor for StoreServlet
    {
        this.db.put(0001, neil);
        this.db.put(0002, abraham);
        this.db.put(0003, cesar);
        this.db.put(0004, pocahontas);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        if(action == null || action == "main")
            action = "goHome";

        switch(action)
        {
            case "userRegister":
                this.userRegister(request, response);
                break;

            case "emptyCart":
                this.emptyCart(request, response);
                break;

            case "viewCart":
                this.viewCart(request, response);
                break;

            case "goHome":
            default:
                this.goHome(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("name");
        if(action == null || action=="a")
            action = "goHome";

        switch(action)
        {
            case "userRegister":
                this.userRegister(request, response);
                break;

            case "emptyCart":
                this.emptyCart(request, response);
                break;

            case "viewCart":
                this.viewCart(request, response);
                break;

            case "goHome":
            default:
                this.confirmation(request, response);
                break;
        }
    }

    /************************************************************************
     * Title: userRegister
     * Description: Brings user to the register page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***********************************************************************/
    private void userRegister(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/register.jsp")
                .forward(request, response);
    }

    /************************************************************************
     * Title: addToCart
     * Description: Adds item to card
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***********************************************************************/
    private void addToCart(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException
    {
        int productId;
        try
        {
            productId = Integer.parseInt(request.getParameter("productId"));
        }
        catch(Exception e)
        {
            response.sendRedirect("shop");
            return;
        }

        HttpSession session = request.getSession();
        if(session.getAttribute("cart") == null)
            session.setAttribute("cart", new Hashtable<Integer, Integer>());

        @SuppressWarnings("unchecked")
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>)session.getAttribute("cart");
        if(!cart.containsKey(productId))
            cart.put(productId, 0);
        cart.put(productId, cart.get(productId) + 1);

        response.sendRedirect("shop?action=viewCart");
    }

    private void emptyCart(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().removeAttribute("cart");
        response.sendRedirect("shop?action=viewCart");
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/view/viewCart.jsp")
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
        request.getRequestDispatcher("/WEB-INF/jsp/view/browse.jsp")
               .forward(request, response);
    }

    /************************************************************************
     * Title: confirmation
     * Description: The index home page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     ***********************************************************************/
    private void confirmation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        request.getRequestDispatcher("/WEB-INF/jsp/view/registerSuccess.jsp")
                .forward(request, response);
    }
}
