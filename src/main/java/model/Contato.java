package model;

public class Contato {
	
	private long id;
	private String nome, telefone, email;
	
	public Contato(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public Contato(String nome, String telefone, String email) {
		this(nome, telefone);
		this.email = email;
	}
	
	public Contato(long id, String nome, String telefone) {
		this(nome, telefone);
		this.id = id;
	}

	public Contato(long id, String nome, String telefone, String email) {
		this(nome, telefone, email);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setId(long id) {
		this.id = id;
		
	}

}
