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
        Crud crud         = new Crud();
        Utils utility     = new Utils();
        List<Contato> Contatos;

        try {
            Connection connection_db  = crud.connect();

            /**** Criando tabela do banco *********/
            try {
                // # Cria tabela
                crud.CreateTable(connection_db, "contatos");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            /**** Adicionando contatos da tabela do banco *********/
            try {
                // # Adiciona linhas na tabela
                String registro = utility.reg_contato(table_name,"matheus", 27, "25-Jul-2023");
                crud.Add(connection_db, registro);

            } catch(Exception e) {
                System.out.println("Erro ao tentar salvar no banco. "+ e);
            }

            /**** Pegando lista de contatos da tabela do banco *********/
            try{
                DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
                String strDate;
                Contatos = crud.GetList(connection_db, table_name);

                for (Contato contato: Contatos){
                    strDate = dateFormat.format(contato.getData_cadastro());
                    System.out.println(contato.getNome() + " " + Integer.toString(contato.getIdade()) + " " + strDate);
                }

            } catch (Exception e) {

            }
        } catch (Exception e) {
          System.out.println("Connection fail. " + e);
        }



        System.out.println(" finalizando ");
    }

}