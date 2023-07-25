//import com.postgresql.App;
import com.postgresql.Crud;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Crud crud = new Crud();
        try {
            Connection connection_db  = crud.connect();

            crud.CreateTable(connection_db, "contatos");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(" finalizando ");
    }
}