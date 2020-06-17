package Classes;

public class Enigmas {
	protected String enig;
	protected int escolha;
	protected String resposta;
	protected String respostaUser;
	
	
	
	public String getRespostaUser() {
		return respostaUser;
	}
	public void setRespostaUser(String respostaUser) {
		this.respostaUser = respostaUser;
	}
	public Enigmas(int escolha) {
		super();
		this.escolha = escolha;
	}
	public String getEnig() {
		return enig;
	}
	public void setEnig(String enig) {
		this.enig = enig;
	}
	public int getEscolha() {
		return escolha;
	}
	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public void validaEnig(){
		switch(this.getEscolha()) {
		  case 1:
		    if(this.getResposta().equals(this.getRespostaUser())) {
		    	System.out.println("Dado Descoberto!!");
		    }else {
		    	System.out.println("Errou a Resposta!");
		    }
		    break;
		  case 2:
			  if(this.getResposta().equals(this.getRespostaUser())) {
			    	System.out.println("Dado Descoberto!!");
			    }else {
			    	System.out.println("Errou a Resposta!");
			    }
		    break;
		  case 3:
			  if(this.getResposta().equals(this.getRespostaUser()) && this.getResposta().equals("Eterna")) {
			    	System.out.println("Dado Descoberto!!");
			    }else {
			    	System.out.println("Errou a Resposta!");
			    }
			break;
		  case 4:
			  if(this.getResposta().equals(this.getRespostaUser()) && this.getResposta().equals("Heart")) {
			    	System.out.println("Dado Descoberto!!");
			    }else {
			    	System.out.println("Errou a Resposta!");
			    }
		    break;
		  case 5:
			  if(this.getResposta().equals(this.getRespostaUser()) && this.getResposta().equals("Thresh")) {
			    	System.out.println("Dado Descoberto!!");
			    }else {
			    	System.out.println("Errou a Resposta!");
			    }
		    break;
		}
	}
	
	public void escolheEnig(){
		switch(this.getEscolha()) {
		  case 1:
			System.out.println("B dhr zngnzbf gbqbf bf qvnf znf aãb fbzbf cerfbf?");
		    this.setEnig("B dhr zngnzbf gbqbf bf qvnf znf aãb fbzbf cerfbf?");
		    this.setResposta("fome");
		    break;
		  case 2:
			  System.out.println("vqnqr qr grfyn nb snyrpre");
			  this.setEnig("vqnqr qr grfyn nb snyrpre");
			  this.setResposta("86");
		    break;
		  case 3:
			  System.out.println("N ivqn ...... Wbnb 3:16 ");
			  this.setEnig("N ivqn ...... Wbnb 3:16 ");
			  this.setResposta("eterna");
			break;
		  case 4:
			  System.out.println("Gur ..... vf gur fgebatrfg zhfpyr ");
			  this.setEnig("Gur ..... vf gur fgebatrfg zhfpyr ");
			  this.setResposta("heart");
		    break;
		  case 5:
			  System.out.println("Dhr qryrvgr qr ntbavn inzbf vasevatve?");
			  this.setEnig("Dhr qryrvgr qr ntbavn inzbf vasevatve?");
			  this.setResposta("thresh");
		    break;
		}
	}
	
	

}
