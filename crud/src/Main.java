import Classes.Contato;
import Classes.Utils;
import com.postgresql.Crud;

import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        String table_name = "contatos";
        Crud crud = new Crud();
        Connection connection_db;

        // Teste do banco
        try {
            connection_db = crud.connect();

            try {
                // # Cria tabela
                crud.CreateTable(connection_db, "contatos");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            TesteBanco(connection_db, table_name, crud);

            System.out.println("Teste finalizando");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    private static void TesteBanco(Connection connection_db, String table_name, Crud crud) {

        Utils utility = new Utils();
        List<Contato> Contatos;

        try {
            // # Adiciona linhas na tabela
            String registro = utility.reg_contato(table_name, "matheus", 27, "25-Jul-2023");
            crud.Add(connection_db, registro);

        } catch (Exception e) {
            System.out.println("Erro ao tentar salvar no banco. " + e);
        }

        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate;
            Contatos = crud.GetList(connection_db, table_name);

            for (Contato contato : Contatos) {
                strDate = dateFormat.format(Contato.getData_cadastro());
                System.out.println(Contato.getNome() + " " + Contato.getIdade() + " " + strDate);
            }

        } catch (Exception e) {

        }
    }
}