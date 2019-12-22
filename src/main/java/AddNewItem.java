import DB.DAO.CarDAO;
import DB.DAO.ItemDAO;
import DB.model.Car;
import DB.model.Item;
import DB.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewItem extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String car_name = httpServletRequest.getParameter("car_name");
        String power = httpServletRequest.getParameter("power");
        String weight = httpServletRequest.getParameter("weight");
        String max_speed = httpServletRequest.getParameter("max_speed");
        String waste = httpServletRequest.getParameter("waste");
        String acceleration = httpServletRequest.getParameter("acceleration");
        String country = httpServletRequest.getParameter("country");
        String body = httpServletRequest.getParameter("body");
        String item_name = httpServletRequest.getParameter("name");
        String text = httpServletRequest.getParameter("item");
        try {
            dataCheck(car_name, power, weight,max_speed, waste, acceleration, country, body, text, item_name, httpServletResponse, httpServletRequest);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            httpServletRequest.getRequestDispatcher("WEB-INF\\DuplicateItem.jsp").forward(httpServletRequest, httpServletResponse);
        }
    }

    private static void dataCheck(String car_name , String power ,  String weight , String max_speed,String waste,
                                  String acceleration,String country, String body, String text,String name, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException, NoSuchMethodException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        boolean correct_data = true;
        String pattern = "^[0-9]*";
        Pattern patternnumber = Pattern.compile(pattern);
        Matcher matcherPower = patternnumber.matcher(power);
        Matcher matcherWeight = patternnumber.matcher(weight);
        Matcher matcherSpeed = patternnumber.matcher(max_speed);
        Matcher matcherWaste = patternnumber.matcher(waste);
        Matcher matcherAcceleration = patternnumber.matcher(acceleration);
        if ((!matcherPower.matches())||(!matcherWeight.matches())||(!matcherSpeed.matches())||(!matcherWaste.matches())||(!matcherAcceleration.matches()))  correct_data=false;
        if (car_name.equals(" ")) correct_data=false;
        if (correct_data){
            Car car = new Car(car_name,power,max_speed,weight,waste,acceleration,country,body);
            CarDAO carDAO = new CarDAO();
            carDAO.add(car);
            int car_id = carDAO.getCarId(car);
            car.setCar_id(car_id);
            request.getSession().getAttribute("id");
            User user = new User();
            user.setUser_id((Integer)request.getSession().getAttribute("id"));
            int user_id = user.getUser_id();
            Item item = new Item(user.getUser_id(),name,text,car.getCar_id());
            ItemDAO itemDAO = new ItemDAO();
            itemDAO.add(item,car,user);
            request.getRequestDispatcher("WEB-INF\\StartPage.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("WEB-INF\\ItemInterFaile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF\\ItemEnter.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
