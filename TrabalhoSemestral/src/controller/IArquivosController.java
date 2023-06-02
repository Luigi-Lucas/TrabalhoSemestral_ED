package controller;

import model.Grupos;

public interface IArquivosController {

	public void registrarAluno() throws Exception;

	public void registrarGrupo() throws Exception;

	public void adicionaGrupo(Grupos grupo) throws Exception;

	public void consultarGruposSubArea() throws Exception;

	public void registrarOrientacao(Grupos grupo) throws Exception;

	public void ultimaOrientacao() throws Exception;

	void consultarGrupoId() throws Exception;

}
