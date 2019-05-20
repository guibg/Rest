package rest;

public interface CursoServiço {

	public Response addCurso(Curso p);

	public Response deleteCurso(int id);

	public Curso getCurso(int id);

	public Curso[] getAllCursos();
}
