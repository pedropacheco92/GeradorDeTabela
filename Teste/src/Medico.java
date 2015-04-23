public class Medico {

	private String nome;
	private int handle;

	Medico(String nome, int handle) {
		this.nome = nome;
		this.handle = handle;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setHandle(int handle) {
		this.handle = handle;
	}

	public String getNome() {
		return this.nome;
	}

	public int getHandle() {
		return this.handle;
	}

}