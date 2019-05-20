package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "curso")
public class Curso {

	String nome;

	private int id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
