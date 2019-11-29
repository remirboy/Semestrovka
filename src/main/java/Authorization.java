import DB.DAO.UserDAO;
import DB.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;



public class Authorization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF\\Authorization.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String email = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("password");
        try {
            login(email, password, httpServletRequest, httpServletResponse);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        httpServletRequest.getRequestDispatcher("WEB-INF\\StartPage.jsp").forward(httpServletRequest, httpServletResponse);


    }

    private void login(String email, String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException,ServletException,IOException {
        String hashedPassword = DigestUtils.md5Hex(password);
        User user = new User(email, hashedPassword);
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.getUserByLogin(user));
        System.out.println(userDAO.getUserId(user));
        int id = userDAO.getUserId(user);
        user.setUser_id(id);
        if (userDAO.getUserByLogin(user)) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", user.getEmail());
            session.setAttribute("id",userDAO.getUserId(user));
            System.out.println("ID_User: "+id);
        }
        else
            httpServletRequest.getRequestDispatcher("WEB-INF\\Authorization.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
