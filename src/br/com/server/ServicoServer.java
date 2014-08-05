package br.com.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.bean.Servico;
import br.com.model.EntityManagerConnection;
import br.com.model.ServicoModel;

@Path("/servico")
public class ServicoServer {
	
	@GET
	@Path("/servico/{ID}")
	@Produces("application/json")
	public Servico getServico(@PathParam("ID") int id){
		ServicoModel model = new ServicoModel(EntityManagerConnection.getEntityManager());
		return model.get(id);
	}
	
	@GET
	@Path("/servicos")
	@Produces("application/json")
	public List<Servico> getServicos(){
		ServicoModel model = new ServicoModel(EntityManagerConnection.getEntityManager());
		return model.getAll();
	}
	
	@POST
	@Path("/insert")
	@Produces("application/json")
	@Consumes("application/json")
	public Servico insert(Servico servico){
		ServicoModel model = new ServicoModel(EntityManagerConnection.getEntityManager());
		return model.insert(servico);
	}
	
	@POST
	@Path("/edit")
	@Produces("application/json")
	@Consumes("application/json")
	public Servico edit(Servico servico){
		ServicoModel model = new ServicoModel(EntityManagerConnection.getEntityManager());
		return model.update(servico);
	}
	
	@GET
	@Path("/delete/{ID}")
	@Produces("application/json")
	public Servico delete(@PathParam("ID") int id){
		ServicoModel model = new ServicoModel(EntityManagerConnection.getEntityManager());
		return model.delete(id);
	}
	

}
