package DB.DAO;

import DB.DBConnector;
import DB.Table;
import DB.model.Car;
import DB.tables.CarParametrsTable;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDAO implements  DAO<Car> {
    private static Connection connection;
    private static CarDAO carDAO;
    DBConnector dbConnector = new DBConnector();

    private static String insert = "INSERT INTO " + Table.carParTable + "( " + CarParametrsTable.name + " ," + CarParametrsTable.power + " ," + CarParametrsTable.weight + " ," + CarParametrsTable.max_speed + " ," + CarParametrsTable.waste + " ," + CarParametrsTable.acceliration + ", " + CarParametrsTable.country + " ," + CarParametrsTable.body + " ) VALUES (?, ?, ?, ?, ?, ?, ? ,? )";


    @Override
    public Optional<Car> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public void add(Car car) throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
        if (!getCarByName(car)) {
            try {
                DBConnector dbConnector = new DBConnector();
                PreparedStatement preparedStatement = dbConnector.getConnection().prepareStatement(insert);
                preparedStatement.setString(1, car.getCar_name());
                preparedStatement.setString(2, car.getPower());
                preparedStatement.setString(3, car.getWeight());
                preparedStatement.setString(4, car.getMax_speed());
                preparedStatement.setString(5, car.getWaste());
                preparedStatement.setString(6, car.getAcceleration());
                preparedStatement.setString(7, car.getCountry());
                preparedStatement.setString(8,car.getBody());
                preparedStatement.executeUpdate();
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }


    public  int getCarId(Car car)throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException{
        String select = "SELECT "+CarParametrsTable.car_id+" FROM " + Table.carParTable +" WHERE " + CarParametrsTable.name + "= '"+car.getCar_name()+"' ;";
        ResultSet resSet = null;
        try {
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            resSet = statement.executeQuery();
            while (resSet.next()) {
                int id =  resSet.getInt("car_id");
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


    public ArrayList<String> getCarParametrsById(Car car)throws NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException{
        String select = "SELECT * FROM " + Table.carParTable +" WHERE " + CarParametrsTable.car_id + "= '"+car.getCar_id()+"' ;";
        ResultSet resSet = null;
        try {
            PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
            resSet = statement.executeQuery();
            ArrayList<String> arrayList = new ArrayList<>();
            while (resSet.next()) {
                arrayList.add(resSet.getString("name"));
                arrayList.add(resSet.getString("power")) ;
                arrayList.add(resSet.getString("weight"));
                arrayList.add(resSet.getString("max_speed"));
                arrayList.add(resSet.getString("waste")) ;
                arrayList.add(resSet.getString("acceliration"));
                arrayList.add(resSet.getString("country"));
                arrayList.add(resSet.getString("body")) ;
                boolean bool =  resSet.wasNull();
                if(!bool)  {
                    return arrayList;
                }
            }



        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }






        @Override
        public void update (Car car){

        }

        @Override
        public void delete (Car car){

        }

        public boolean getCarByName (Car car) throws
        NoSuchMethodException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException
        {
            String select = "SELECT * FROM " + Table.carParTable + " WHERE " + CarParametrsTable.name + "= '" + car.getCar_name() + "';";
            ResultSet resSet = null;
            try {
                PreparedStatement statement = dbConnector.getConnection().prepareStatement(select);
                resSet = statement.executeQuery();
                while (resSet.next()) {
                    String name = resSet.getString("name");
                    boolean bool = resSet.wasNull();
                    if (!bool) {
                        return true;
                    }
                }


            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | SQLException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return false;
        }


    }
