package rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/curso")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class CursoServiço1 implements CursoServiço {

	private static Map<Integer, Curso> Cursos = new HashMap<Integer, Curso>();

	@Override
	@POST
	@Path("/add")
	public Response addCurso(Curso curso) {
		Response response = new Response();
		if (Cursos.get(curso.getId()) != null) {
			response.setStatus(false);
			response.setMessage("Curso já existe");
			return response;
		}
		Cursos.put(curso.getId(), curso);
		response.setStatus(true);
		response.setMessage("Curso criado");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/delete")
	public Response deleteCurso(@PathParam("id") int id) {
		Response response = new Response();
		if (Cursos.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Curso não existe");
			return response;
		}
		Cursos.remove(id);
		response.setStatus(true);
		response.setMessage("Curso deletado");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Curso getCurso(@PathParam("id") int id) {
		return Cursos.get(id);
	}

	@GET
	@Path("/{id}/getTeste")
	public Curso getDummyCurso(@PathParam("id") int id) {
		Curso p = new Curso();
		p.setNome("cursoTeste");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public Curso[] getAllCursos() {
		Set<Integer> ids = Cursos.keySet();
		Curso[] curso = new Curso[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			curso[i] = Cursos.get(id);
			i++;
		}
		return curso;
	}
}
