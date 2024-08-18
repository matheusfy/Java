package Factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import Repository.UsuarioRepository;

public class UserFactory {
  
    Properties propriedades;
    public UserFactory(){  
      this.propriedades = new Properties();
      readProperties();
    }

    private void readProperties(){
      File file = new File("C:\\Users\\mathe\\IdeaProjects\\Java\\DependencyInversion\\src\\resources\\config.properties");
      FileReader reader;
      try {
        reader = new FileReader(file);
        propriedades.load(reader);
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public UsuarioRepository getInstance(String userInstance){
      
      try {
      
        String className = propriedades.getProperty(userInstance);
        Class<?> classe = Class.forName(className);
        return (UsuarioRepository) classe.getConstructor().newInstance();
      
      } catch (Exception e) {
            e.printStackTrace();
          }
          
      return null;
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }
}
