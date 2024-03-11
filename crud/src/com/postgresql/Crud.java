package com.postgresql;

import Classes.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Crud {
    private final String url = "jdbc:postgresql://localhost/";

    private final String db_name = "contato";
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
                    "datacadastro date\n" +
                    ")";
            statement = connection_db.createStatement();
            statement.executeUpdate(query);
            System.out.println("Tabela " + table_name + " criado com sucesso!");
        } catch (Exception e){
            System.out.println("Fail to create table: "+ e);
            return false;
        }
        return true;
    }


    public Boolean Add(Connection connection_db, String registro){

        Statement statement;

        try {
            String query = "insert into " + registro;
            statement    = connection_db.createStatement();

            statement.executeUpdate(query);

            System.out.println("Inserted successfully!");
        } catch (Exception e){
            System.out.println(" Fail to insert to Table. "+ e);
            return false;
        }

        return true;
    }


    public Boolean Update(Connection connection_db, String registro){

        Statement statement;

        try {
            String query = "update into " + registro;
            statement    = connection_db.createStatement();
            statement.executeUpdate(query);
            System.out.println("Inserted successfully!");
        } catch (Exception e){
            System.out.println(" Fail to update Table. "+ e);
            return false;
        }

        return true;
    }

    public List<Contato> GetList(Connection connection_db, String table_name){
        List<Contato> Contatos = new ArrayList<Contato>();

        Statement statement;
        String    table;
        ResultSet sql_result;
        String    nome;
        int       idade;
        Date      datacadastro;


        try{
            String query = "select * from "+ table_name;
            statement    = connection_db.createStatement();

            sql_result = statement.executeQuery(query);
            while(sql_result.next()){
                nome  = sql_result.getString("nome");
                idade = sql_result.getInt("idade");
                datacadastro = sql_result.getDate("datacadastro");

                Contato contato = new Contato(nome, idade,datacadastro);
                Contatos.add(contato);
            }
        } catch (SQLException sql){
            System.out.println(sql);
        }

        return Contatos;
    }


}
