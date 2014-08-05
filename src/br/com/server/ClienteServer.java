package br.com.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.bean.Cliente;
import br.com.model.EntityManagerConnection;
import br.com.model.ClienteModel;

@Path("/cliente")
public class ClienteServer {

	@GET
	@Path("/cliente/{ID}")
	@Produces("application/json")
	public Cliente getCliente(@PathParam("ID") int id){
		ClienteModel model = new ClienteModel(EntityManagerConnection.getEntityManager());
		return model.get(id);
	}
	
	@GET
	@Path("/clientes")
	@Produces("application/json")
	public List<Cliente> getClientes(){
		ClienteModel model = new ClienteModel(EntityManagerConnection.getEntityManager());
		return model.getAll();
	}
	
	@POST
	@Path("/insert")
	@Produces("application/json")
	@Consumes("application/json")
	public Cliente insert(Cliente cliente){
		ClienteModel model = new ClienteModel(EntityManagerConnection.getEntityManager());
		return model.insert(cliente);
	}
	
	@POST
	@Path("/edit")
	@Produces("application/json")
	@Consumes("application/json")
	public Cliente edit(Cliente cliente){
		ClienteModel model = new ClienteModel(EntityManagerConnection.getEntityManager());
		return model.update(cliente);
	}
	
	@GET
	@Path("/delete/{ID}")
	@Produces("application/json")
	public Cliente delete(@PathParam("ID") int id){
		ClienteModel model = new ClienteModel(EntityManagerConnection.getEntityManager());
		return model.delete(id);
	}
	
	
}
