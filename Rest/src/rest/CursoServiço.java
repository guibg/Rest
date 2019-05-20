package rest;

public interface CursoServišo {

	public Response addCurso(Curso p);

	public Response deleteCurso(int id);

	public Curso getCurso(int id);

	public Curso[] getAllCursos();
}
