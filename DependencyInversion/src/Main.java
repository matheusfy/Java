import Repository.UsuarioRepository;
import Factory.UserFactory;


public class Main {
  public static void main(String[] args) {
    UserFactory factory = new UserFactory();

    UsuarioRepository repository = factory.getInstance("00002");
    if (repository != null){
      repository.logar();
    }
    
    repository = factory.getInstance("00001");
    if (repository != null){
      repository.logar();
    }
  }
}