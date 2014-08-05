package br.com.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.bean.Cliente;
import br.com.server.ClienteServer;

public class ClienteTeste {

	static ClienteServer ns;
	
	@BeforeClass
	public static void initTeste(){
		ns = new ClienteServer();
	}
	
	@Test
	public void setCliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Emerson");
		assertNotNull(ns.insert(cliente));
	}
	
	@Test
	public void editCliente(){
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNome("Emerson Luiz");
		cliente = ns.edit(cliente);
		assertEquals(cliente.getId(),1);
	}

	@Test
	public void getCliente(){
		assertEquals(ns.getCliente(2).getId(),2);
	}
	
	@Test
	public void getClientes(){
		assertNotNull(ns.getClientes());
	}
	
	@Test
	public void delete(){
		assertEquals(ns.delete(10).getId(),10);
	}
	
}
