import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = new DbConnection();

        List<Auto> autos = dbConnection.getAuto();
        List<Car> carsList = dbConnection.getCars();

        HashMap<Auto, Car> cars = new HashMap<>();
        for (int i = 0; i < carsList.size(); i++) {
            cars.put(autos.get(i), carsList.get(i));
        }
        System.out.println(cars.size());


        for (Map.Entry<Auto, Car> entry : cars.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}
