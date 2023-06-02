package model;

import br.edu.fateczl.listaobject.Lista;

public class Grupos {

	public String idGrupo;
	public Lista integrantesGrupo;
	public String subArea;
	public String orientador;
	public String tema;
	public Lista orientacoes;

	@Override
	public int hashCode() {
		switch (subArea) {
		case "Redes":
			return 0;
		case "Dados":
			return 1;
		case "Segurança da Informação":
			return 2;
		case "Engenharia de Software":
			return 3;
		case "Desenvolvimento de Software":
			return 4;
		case "Sistemas de Informação":
			return 5;
		case "Inteligência Artificial":
			return 6;
		case "Cloud Computing":
			return 7;
		default:
			return 8;
		}
	}

	public String integrantes() {
		String integrantes = "";
		for (int i = integrantesGrupo.size() - 1; i >= 0; i--) {
			try {
				if (i == 0) {
					integrantes += (String) integrantesGrupo.get(i);
				} else {
					integrantes += (String) integrantesGrupo.get(i) + ", ";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return integrantes;
	}

	public String toString() {

		return "ID do Grupo: " + idGrupo + "\nIntegrantes do Grupo: " + integrantes() + "\nSubArea do Trabalho: "
				+ subArea + "\nProfessor Orientador: " + orientador + "\nTema do Trabalho: " + tema;
	}
}