package br.com.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.bean.Nomeacao;
import br.com.bean.NomeacaoServico;
import br.com.model.EntityManagerConnection;
import br.com.model.NomeacaoModel;
import br.com.model.NomeacaoServicoModel;

@Path("/nomeacao")
public class NomeacaoServer {

	@GET
	@Path("/nomeacao/{ID}")
	@Produces("application/json")
	public Nomeacao getNomeacao(@PathParam("ID") int id){
		NomeacaoModel model = new NomeacaoModel(EntityManagerConnection.getEntityManager());
		return model.get(id);
	}
	
	@GET
	@Path("/nomeacoes")
	@Produces("application/json")
	public List<Nomeacao> getNomeacoes(){
		NomeacaoModel model = new NomeacaoModel(EntityManagerConnection.getEntityManager());
		return model.getAll();
	}
	
	@POST
	@Path("/insert")
	@Produces("application/json")
	@Consumes("application/json")
	public Nomeacao insert(Nomeacao nomeacao){
		nomeacao = setRelational(nomeacao);
		NomeacaoModel model = new NomeacaoModel(EntityManagerConnection.getEntityManager());
		return model.insert(nomeacao);
	}
	
	@POST
	@Path("/edit")
	@Produces("application/json")
	@Consumes("application/json")
	public Nomeacao edit(Nomeacao nomeacao){
		nomeacao = setRelational(nomeacao);
		NomeacaoModel model = new NomeacaoModel(EntityManagerConnection.getEntityManager());		
		return model.update(nomeacao);
	}
	
	@GET
	@Path("/delete/{ID}")
	@Produces("application/json")
	public Nomeacao delete(@PathParam("ID") int id){
		NomeacaoModel model = new NomeacaoModel(EntityManagerConnection.getEntityManager());
		return model.delete(id);
	}
	
	@GET
	@Path("/deleteServico/{ID}")
	@Produces("application/json")
	public NomeacaoServico deleteServico(@PathParam("ID") int id){
		NomeacaoServicoModel model = new NomeacaoServicoModel(EntityManagerConnection.getEntityManager());
		return model.delete(id);
	}
	
	private Nomeacao setRelational(Nomeacao nomeacao){
		for (NomeacaoServico nomeacaoServico : nomeacao.getNomeacaoServicos()) {
			if (nomeacaoServico.getServico() != null){
				if (nomeacaoServico.getServico().getId() != 0){
					nomeacaoServico.setNomeacao(nomeacao);
				}
			}
		}
		return nomeacao;
	}
	
}