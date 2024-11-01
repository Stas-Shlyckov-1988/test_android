import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "mpeegy";
        String password = "procedure";
 
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение к базе данных успешно установлено!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных:");
            e.printStackTrace();
        }
    }
}