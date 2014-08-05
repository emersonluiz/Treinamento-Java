package br.com.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.bean.Cliente;
import br.com.bean.Nomeacao;
import br.com.bean.NomeacaoServico;
import br.com.bean.Servico;
import br.com.server.NomeacaoServer;

public class NomeacaoTeste {
	
static NomeacaoServer ns;
	
	@BeforeClass
	public static void initTeste(){
		ns = new NomeacaoServer();
	}
	
	@Test
	public void setNomeacao(){
		Nomeacao nomeacao = new Nomeacao();
		Cliente cliente = new Cliente();		
		List<NomeacaoServico> list = new ArrayList<>();	
		
		cliente.setId(1);		
		nomeacao.setNumero(0001);
		nomeacao.setCliente(cliente);
		
		NomeacaoServico nomeacaoServico = new NomeacaoServico();
		Servico servico = new Servico();
		servico.setId(1);
		nomeacaoServico.setServico(servico);
		nomeacaoServico.setNomeacao(nomeacao);
		list.add(nomeacaoServico);
		
		nomeacao.setNomeacaoServicos(list);
		
		assertNotNull(ns.insert(nomeacao));
	}
	
	@Test
	public void editNomeacao(){
		Nomeacao nomeacao = ns.getNomeacao(3);
		nomeacao.setNumero(0002);
		ns.edit(nomeacao);
		assertEquals(nomeacao.getId(),3);
	}

	@Test
	public void getNomeacao(){
		Nomeacao nom = ns.getNomeacao(3);
		assertEquals(nom.getId(),3);
	}
	
	@Test
	public void getNomeacoes(){
		assertNotNull(ns.getNomeacoes());
	}
	
	@Test
	public void delete(){
		Nomeacao nom = ns.delete(8);
		assertEquals(nom.getId(),8);
	}
	
	@Test
	public void deleteServico(){
		NomeacaoServico nomServ = ns.deleteServico(12);
		assertEquals(nomServ.getId(),12);
	}
	
}
