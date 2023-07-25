//import com.postgresql.App;
import java.sql.Connection;
import com.postgresql.App;


public class Main {
    public static void main(String[] args) {

        App app = new App();
        try {
            Connection connection_db  = app.connect();

            // se não estourar tenta fazer um add

            app.CreateTable(connection_db, "contatos");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(" finalizando ");
    }
}