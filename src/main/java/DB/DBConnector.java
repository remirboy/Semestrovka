package DB;


        import java.lang.reflect.InvocationTargetException;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DBConnector extends Configs{
    Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        String con = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbname;
        connection = DriverManager.getConnection(con,dbUser,dbPass);
        return connection;
    }
}