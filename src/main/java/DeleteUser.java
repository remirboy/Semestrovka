import DB.DAO.UserDAO;
import DB.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class DeleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        User user = new User();
        user.setUser_id((Integer) session.getAttribute("id"));
        UserDAO userDAO =new UserDAO();
        userDAO.delete(user.getUser_id());
        session.setAttribute("user",null);
        session.setAttribute("id",null);
        httpServletRequest.getRequestDispatcher("WEB-INF\\StartPage.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF\\UserDelete.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
