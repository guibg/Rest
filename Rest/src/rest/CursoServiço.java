package rest;

public interface CursoServi�o {

	public Response addCurso(Curso p);

	public Response deleteCurso(int id);

	public Curso getCurso(int id);

	public Curso[] getAllCursos();
}
