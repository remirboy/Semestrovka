package DB.DAO;

import DB.DBConnector;
import DB.Table;
import DB.model.User;
import DB.tables.UserTable;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.sql.*;

public class UserDAO implements  DAO<User>{
    private static Connection connection;
    private static UserDAO userDAO;
    DBConnector dbConnector = new DBConnector();

    private static String insert = "INSERT INTO "+ Table.user +"( " + UserTable.email+" ," + UserTable.password+" ,"+UserTable.role+" ) VALUES (?, ?, ?)";

//"SELECT * FROM user "+ Table.user +" WHERE email= "+

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public void add(User user) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
        if (!getUserByLogin(user)){
            try {
                DBConnector dbConnector = new DBConnector();
                PreparedStatement preparedStatement =dbConnector.getConnection().prepareStatement(insert);
                preparedStatement.setString(1, user.getEmail());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3,user.getRole());
               preparedStatement.executeUpdate();
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException  | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }catch (SQLException e){
                System.out.println("Already exists");
            }


//            if (!("SELECT * FROM user "+ Table.user +" WHERE email= "+ user.getEmail()+";").equals(user.getEmail())) {
//                preparedStatement.setString(1, user.getEmail());
//                preparedStatement.setString(2, user.getPassword());
//                preparedStatement.setString(3,user.getRole());
//                preparedStatement.executeUpdate();
//            }
//            else {
//                System.out.println("Already exist");
//            }

        }
        else System.out.println("Already exists");

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
        delete(user.getUser_id());

    }



    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(
                    "DELETE FROM user WHERE user_id=?;"
            );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public boolean getUserByLogin(User user) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
        String select = "SELECT * FROM " + Table.user +" WHERE " + UserTable.email + "= '"+user.getEmail()+"'  AND "+UserTable.password+" = '"+user.getPassword()+"' ;";
        ResultSet resSet = null;
        try {
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            resSet = statement.executeQuery();
            while (resSet.next()) {
                String email =  resSet.getString("email");
                String password =  resSet.getString("password");
                boolean bool =  resSet.wasNull();
                if(!bool)  {
                    return true;
                }
            }


        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException  | SQLException| IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
    public  int getUserId(User user)throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException{
        String select = "SELECT "+UserTable.user_id+" FROM " + Table.user +" WHERE " + UserTable.email + "= '"+user.getEmail()+"'  AND "+UserTable.password+" = '"+user.getPassword()+"' ;";
        ResultSet resSet = null;
        try {
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            resSet = statement.executeQuery();
            while (resSet.next()) {
                int id =  resSet.getInt("user_id");
                boolean bool =  resSet.wasNull();
                if(!bool)  {
                    return id;
                }
            }


        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    }

