package aula06;

public class ContaBanco {
	public int numConta;
	protected String tipo;
	private String dono;
	private float saldo;
	private boolean status;
	public void estadoAtual() {
		System.out.println("------------------------------");
		System.out.println("Conta: "+ this.getNumConta());
		System.out.println("Tipo: "+this.getTipo());
		System.out.println("Dono: "+ this.getDono());
		System.out.println("Saldo: "+ this.getSaldo());
		System.out.println("Status: "+this.getStatus());
		
	}	
	//Construtores
	
	public ContaBanco() {
		this.saldo = 0;
		this.status= false;
	}
	
	//MÉTODOS ESPECIAIS
	
	public void setNumConta(int n) {
		this.numConta = n;
	}
	
	public int getNumConta() {
		return this.numConta;
	}
	
	
	
	
	
	//Metodos Personalizados
	
	public void abrirConta(String t) {
		this.setTipo(t);
		this.setStatus(true);
		if (t == "CC") {
			this.setSaldo(50);
		} else if (t == "CP"){
			this.setSaldo(150);
		}
		System.out.println("Conta aberta com sucesso!");
	};
	
	public void fecharConta() {
		if(this.getSaldo() > 0) {
			System.out.println("Conta não pode ser fechada porque ainda tem dinheiro!");
		} else if (this.getSaldo() < 0) {
			System.out.println("Conta não pode ser fechada pois tem débito!");
		} else {
			this.setStatus(false);
			System.out.println("Conta fechada com sucesso!");
		}
	};
	
	public void depositar(float v) {
		if (this.getStatus()) {
			//this.saldo = this.saldo + v; direto no atributo
			this.setSaldo(this.getSaldo() + v);
			System.out.println("Depósito realizado com sucesso na Conta de "+this.getDono());
		}else {
			System.out.println("Impossível depositar em uma conta fechada!");
		}

	};
	
	public void sacar( float v) {
		if (this.getStatus()) {
			if (this.getSaldo() >= v) {
				this.setSaldo(this.getSaldo() - v);
				System.out.println("Saque realizado na conta de " + this.getDono());
			} else {
				System.out.println("Saldo insuficiente para saque!");
			}
		}else {
			System.out.println("Impossível sacar de uma conta fechada!");
		}
	}
	
	public void pagarMensal() {
		int v = 0;
		if (this.getTipo() == "CC") {
			v = 12;
		}else if(this.getTipo() == "CP") {
			v = 20;
		}
		if (this.getStatus()) {
			this.setSaldo(this.getSaldo() - v);
			System.out.println("Mensalidade paga com sucesso por "+ this.getDono());
		} else {
			System.out.println("Impossível pagar uma conta fechada!");
		}
	}
	
	//Metofos GETS e SETS
	

	
	public String getDono() {
		return dono;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
