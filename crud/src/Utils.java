public class Utils {
    public String reg_contato(String table_name, String nome, int idade, String data_registro){
        String registro = "";

        registro = String.format("%s(nome,idade,datacadastro) values('%s','%s','%s');", table_name, nome,idade,data_registro);

        return registro;
    }
}
