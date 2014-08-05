package br.com.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Nomeacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private int numero;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	@OneToMany(mappedBy="nomeacao",cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	private List<NomeacaoServico> nomeacaoServicos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<NomeacaoServico> getNomeacaoServicos() {
		return nomeacaoServicos;
	}
	public void setNomeacaoServicos(List<NomeacaoServico> nomeacaoServicos) {
		this.nomeacaoServicos = nomeacaoServicos;
	}


}
