package Classes;

public class Login {
	protected String nome;
	protected String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean validalogin(String nome,String senha){
		if(this.getNome().equals(nome)&&this.getSenha().equals(senha)){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	
}
