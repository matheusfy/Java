import com.postgresql.Crud;

import java.sql.Connection;

public class Main {


    public static void main(String[] args) {

        Crud crud = new Crud();
        Utils utility = new Utils();

        try {
            Connection connection_db  = crud.connect();

            try {
                // # Cria tabela
                crud.CreateTable(connection_db, "contatos");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            try {
                // # Adiciona linhas na tabela
                String registro = utility.reg_contato("contatos","matheus", 27, "25-Jul-2023");
                crud.Add(connection_db, registro);

            } catch(Exception e) {
                System.out.println("Erro ao tentar salvar no banco. "+ e);
            }

        } catch (Exception e) {
          System.out.println("Connection fail. " + e);
        }


        System.out.println(" finalizando ");
    }

}