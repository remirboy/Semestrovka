import DB.DAO.CarDAO;
import DB.DAO.ItemDAO;
import DB.model.Car;
import DB.model.Item;
import DB.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ItemGet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            String item_name = httpServletRequest.getParameter("item_name");
            Item item = new Item();
            item.setItem_name(item_name);
            ItemDAO itemDAO = new ItemDAO();
            int car_id = itemDAO.getCarIdByItemName(item);
            CarDAO carDAO = new CarDAO();
            Car car = new Car();
            car.setCar_id(car_id);
            carDAO.getCarParametrsById(car);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("car_id",car.getCar_id());
            httpServletRequest.getRequestDispatcher("WEB-INF\\Item.jsp").forward(httpServletRequest,httpServletResponse);
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

    }


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {


    }
}
