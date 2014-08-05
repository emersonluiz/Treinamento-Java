package br.com.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.bean.Servico;
import br.com.server.ServicoServer;

public class ServicoTeste {

	static ServicoServer ns;
	
	@BeforeClass
	public static void initTeste(){
		ns = new ServicoServer();
	}
	
	@Test
	public void setServico(){
		Servico servico = new Servico();
		servico.setNome("Trabalho");
		assertNotNull(ns.insert(servico));
	}
	
	@Test
	public void editServico(){
		Servico servico = new Servico();
		servico.setId(1);
		servico.setNome("Muito Trabalho");
		servico = ns.edit(servico);
		assertEquals(servico.getId(),1);
	}

	@Test
	public void getServico(){
		assertEquals(ns.getServico(1).getId(),1);
	}
	
	@Test
	public void getServicos(){
		assertNotNull(ns.getServicos());
	}
	
	@Test
	public void delete(){
		assertEquals(ns.delete(6).getId(),6);
	}
	
}
