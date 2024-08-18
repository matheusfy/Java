package Repository;

public class UsuarioDAO implements UsuarioRepository {

		public UsuarioDAO(){

		}

		@Override
		public void logar() {
				System.out.println("logando no usuario DAO");
		}
}
