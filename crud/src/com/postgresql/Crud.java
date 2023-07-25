package com.postgresql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {
    private final String url = "jdbc:postgresql://localhost/";

    private final String db_name = "agenda";
    private final String user = "postgres";
    private final String password = "nkrevg32";


    public Connection connect(){

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url+db_name, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public Boolean CreateTable(Connection connection_db, String table_name){

        Statement statement;

        try {
            String query = "create table " + table_name + " (\n" +
                    "id Serial primary key,\n" +
                    "nome varchar,\n" +
                    "idade int,\n" +
                    "dataCadastro date\n" +
                    ")";
            statement = connection_db.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela "+ table_name + " criado com sucesso!");
        } catch (Exception e){
            System.out.println("Fail to create table: "+ e);
            return false;
        }
        return true;
    }


    public Boolean Add(Connection connection_db, String registro){

        Statement statement;

        try {
            String query= "insert into " + registro;
            statement=connection_db.createStatement();
            statement.executeUpdate(query);
            System.out.println("Inserted successfully!");
        } catch (Exception e){
            System.out.println(" Fail to insert to Table. "+ e);
            return false;
        }

        return true;
    }

}
