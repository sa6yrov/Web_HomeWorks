import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DbConnection {
    private final static String url = "jdbc:postgresql://localhost:5432/ClassWork51";
    private final static String user = "postgres";
    private final static String password = "postgres";

    public static Connection connect() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Car> getCars() {
        String SQL = "select * from cars";
        List<Car> carList = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("manufacture_year"),
                        rs.getString("model"),
                        rs.getInt("price"),
                        rs.getString("color")
                );
                carList.add(car);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return carList;
    }

    public List<Auto> getAuto() {
        String SQL = "select * from auto";
        List<Auto> autos = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getInt("id"),
                        rs.getString("licence")
                );
                autos.add(auto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return autos;
    }
}
