import DB.DAO.CarDAO;
import DB.DAO.ItemDAO;
import DB.model.Car;
import DB.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemGetByCarId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doPost(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        try {
            ItemDAO itemDAO = new ItemDAO();
            Car car = new Car();
            car.setCar_id(Integer.parseInt(httpServletRequest.getParameter("id")));
            CarDAO carDAO = new CarDAO();
            ArrayList<String> par;
            par = carDAO.getCarParametrsById(car);
            Item item = new Item();
            item.setCar_id(car.getCar_id());
            ArrayList<String> text;
            text = itemDAO.getItemByCarId(car);
            httpServletRequest.getSession().setAttribute("car_parametrs",par);
            httpServletRequest.getSession().setAttribute("item_parametrs",text);
            httpServletRequest.getRequestDispatcher("WEB-INF\\Item.jsp").forward(httpServletRequest,httpServletResponse);
        }
        catch (NoSuchMethodException e) {
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


}
