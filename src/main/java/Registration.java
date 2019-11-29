import DB.DAO.UserDAO;
import DB.model.User;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Registration extends HttpServlet {
    private static String help = "help";

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("WEB-INF\\Registration.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("Repassword");
        String role = request.getParameter("role");
     /*   User user = new User();
        if(request.getParameter("safeMe") != null && request.getParameter("safeMe").equals("true")) {
            Cookie cookie = new Cookie("user_id", user.getUser_id() + "");
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);
        }*/
        try {
            dataCheck(email, password, rePassword,role, resp, request, help);
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
        }
    }



    private static void dataCheck(String email, String password, String rePassword, String role, HttpServletResponse response, HttpServletRequest request, String help) throws ServletException, IOException, NoSuchMethodException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        boolean correct_data = true;

        Pattern patternEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherEmail = patternEmail.matcher(email);
        help+="Conditions not met: ";
        if (!matcherEmail.matches())  correct_data=false;
        if (!password.equals(rePassword)) correct_data=false;
        if (!(password.length() > 6 && password.length() < 20)) correct_data=false;

        if (correct_data){
            String hashedPassword = DigestUtils.md5Hex(password);
            System.out.println(hashedPassword);
            User user = new User(email,hashedPassword,role);
            UserDAO userDAO = new UserDAO();
            userDAO.add(user);
            request.getRequestDispatcher("WEB-INF\\StartPage.jsp").forward(request, response);
            System.out.println("zaebal");
            }
        else{
            request.getRequestDispatcher("WEB-INF\\Registration.jsp").forward(request, response);
            HttpSession session = request.getSession();
            session.setAttribute("help", help);
        }
    }

   /* private static void signUp(String email, String password){
        String hashedPassword = DigestUtils.md5Hex(password);
        String insert = "INSERT INTO  " + Table.user +" ("+ UserTable.email+" ," + UserTable.password+") VALUES (?,?);";
        DBConnector dbConnector = new DBConnector();
        try {
            PreparedStatement statement = (PreparedStatement) dbConnector.getConnection().prepareStatement(insert);
            statement.setString(1,email);
            statement.setString(2, hashedPassword);

            statement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
//    private static void writeToCSVFile(String email, String password, String gender,
//                                       String country, String aboutMyself){
//        String hashedPassword = DigestUtils.md5Hex(password);
//        CSVWriter csvWriter = new CSVWriter();
//        csvWriter.writeToCSVFile  (email, hashedPassword, gender, country, aboutMyself);
//    }*/

}
