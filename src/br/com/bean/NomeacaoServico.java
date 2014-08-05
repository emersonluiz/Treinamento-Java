package br.com.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
public class NomeacaoServico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_nomeacao")
	private Nomeacao nomeacao;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_servico")
	private Servico servico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlTransient
	public Nomeacao getNomeacao() {
		return nomeacao;
	}
	public void setNomeacao(Nomeacao nomeacao) {
		this.nomeacao = nomeacao;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
}
