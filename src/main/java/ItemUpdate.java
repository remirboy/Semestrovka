import DB.DAO.ItemDAO;
import DB.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ItemUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF\\ItemUpdate.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String item_change = httpServletRequest.getParameter("item");
        Item item = new Item();
        HttpSession session = httpServletRequest.getSession();
        item.setItem_name(session.getAttribute("item_name").toString());
        item.setContent(item_change);
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.update(item);
        httpServletRequest.getRequestDispatcher("WEB-INF\\StartPage.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
