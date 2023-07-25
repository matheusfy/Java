//import com.postgresql.App;
import java.sql.Connection;
import com.postgresql.App;


public class Main {
    public static void main(String[] args) {

        App app = new App();
        app.connect();
        System.out.println(" finalizando ");
    }
}