package DB.DAO;

import DB.DBConnector;
import DB.Table;
import DB.model.Car;
import DB.model.Item;
import DB.model.User;
import DB.tables.ItemTable;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDAO implements DAO<Item> {

    private static String insert = "INSERT INTO " + Table.item + "( " +ItemTable.item_name  +" ,"+ ItemTable.car_id + " ," + ItemTable.user_id + " ," + ItemTable.text+" ) VALUES (?, ?, ?,? )";


    public void add(Item item, Car car, User user) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {

            try {
                DBConnector dbConnector = new DBConnector();
                PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(insert);
                preparedStatement.setString(1, item.getItem_name());
                preparedStatement.setInt(2, car.getCar_id());
                preparedStatement.setInt(3,user.getUser_id());
                preparedStatement.setString(4, item.getContent());
                preparedStatement.executeUpdate();
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
  public String getItems(ResultSet rs) throws SQLException{
        String item_name = rs.getString("item_name");
        return item_name;
        }



    public int getCarIdByItemName(Item item){
        String select = "SELECT "+ ItemTable.car_id+" FROM " + Table.item +" WHERE item_name = '"+item.getItem_name()+" ';";
        ResultSet resSet = null;
        try {
            DBConnector dbConnector = new DBConnector();
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            System.out.println(statement);;
            resSet = statement.executeQuery();
            int car_id = 0 ;
            while (resSet.next()) {
                car_id = resSet.getInt("car_id");
                boolean bool =  resSet.wasNull();
                if(!bool) {
                    return car_id;
                }
            }
            System.out.println("car id"+car_id);


        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }



//    public boolean getItemByCarId (Item item) throws
//            NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException
//    {
//        String select = "SELECT * FROM " + Table.item + " WHERE " + ItemTable.car_id+ "= '" + car.getCar_name() + "';";
//        ResultSet resSet = null;
//        try {
//            DBConnector dbConnector = new DBConnector();
//            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
//            System.out.println(statement);
//            System.out.println(car.getCar_name());
//            resSet = statement.executeQuery();
//            while (resSet.next()) {
//                String name = resSet.getString("name");
//                boolean bool = resSet.wasNull();
//                if (!bool) {
//                    System.out.print("name: " + name + ",");
//                    return true;
//                }
//            }
//
//
//        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

    public ArrayList<String> getItemByCarId(Car car)throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException{
        String select = "SELECT * FROM " + Table.item +" WHERE " + ItemTable.car_id + "= '"+car.getCar_id()+"' ;";
        ResultSet resSet = null;
        try {
            DBConnector dbConnector = new DBConnector();
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            System.out.println(statement);
            System.out.println(car.getCar_name());
            resSet = statement.executeQuery();
            ArrayList <String> text = new  ArrayList<>();
            while (resSet.next()) {
                text.add(resSet.getString("item_name"));
                text.add(resSet.getString("text"));
                boolean bool =  resSet.wasNull();
                if(!bool)  {
                    return text;
                }
            }
            System.out.println(text);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }





    @Override
    public Optional<Item> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Item> getAll() {
       return null;
    }

    public ArrayList<String> ItemListGET(){
        ArrayList<String> res = new ArrayList<>();
        String select = "SELECT "+ ItemTable.item_name+" FROM auto_fan." + Table.item +" ;";
        try {
            DBConnector dbConnector = new DBConnector();
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                res.add(getItems(rs));
            }
        } catch (SQLException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return res;

    }

    @Override
    public void add(Item item) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {

    }


    @Override
    public void update(Item item) {

    }

    @Override
    public void delete(Item item) {

    }
}
