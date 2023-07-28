package Classes;

import java.util.Date;

public class Contato{

    public static String nome;
    public static int idade;
    public static Date data_cadastro;

    public Contato (String nome, int idade, Date data_cadastro){
        this.nome         = nome;
        this.idade        = idade;
        this.data_cadastro = data_cadastro;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Contato.nome = nome;
    }

    public static int getIdade() {
        return idade;
    }

    public static void setIdade(int idade) {
        Contato.idade = idade;
    }

    public static Date getData_cadastro() {
        return data_cadastro;
    }

    public static void setData_cadastro(Date data_cadastro) {
        Contato.data_cadastro = data_cadastro;
    }
}
