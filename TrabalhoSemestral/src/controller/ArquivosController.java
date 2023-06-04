package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import br.edu.fateczl.filaobj.Fila;
import br.edu.fateczl.listaobject.Lista;
import model.Aluno;
import model.Grupos;

public class ArquivosController implements IArquivosController, ActionListener {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField cad_id;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField rec_id1;
	private JTextField rec_id2;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextArea textArea_3;

	public ArquivosController(JTextField textField, JTextField textField_1, JTextField cad_id, JTextField textField_5,
			JTextField textField_6, JTextField textField_7, JTextField textField_8, JTextArea textArea_1,
			JComboBox comboBox, JTextArea textArea_2, JComboBox comboBox_1, JTextArea textArea, JTextField rec_id1,
			JTextField rec_id2, JTextArea textArea_3) {
		this.textField = textField;
		this.textField_1 = textField_1;
		this.cad_id = cad_id;
		this.textField_5 = textField_5;
		this.textField_6 = textField_6;
		this.textField_7 = textField_7;
		this.textField_8 = textField_8;
		this.textArea_1 = textArea_1;
		this.comboBox = comboBox;
		this.textArea_2 = textArea_2;
		this.comboBox_1 = comboBox_1;
		this.textArea = textArea;
		this.rec_id1 = rec_id1;
		this.rec_id2 = rec_id2;
		this.textArea_3 = textArea_3;

		vetGrupos = new Lista[10];
		for (int i = 0; i < 10; i++) {
			vetGrupos[i] = new Lista();
		}
	}

	String path = "C://TEMP";
	
	Fila alunosFila = new Fila();
	Fila gruposFila = new Fila();

	Lista[] vetGrupos;

	@Override
	public void registrarAluno() throws Exception {
		Aluno aluno = new Aluno();
		aluno.nomeAluno = textField.getText();
		aluno.ra = textField_1.getText();
		if (!aluno.nomeAluno.equals("") && !aluno.ra.equals("")) {
			if (aluno.ra.length() != 13) {
				JOptionPane.showMessageDialog(null, "RA deve ter 13 dígitos! Escolha um valor válido!", "ERRO",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (lerRa(aluno.ra) == true) {
				JOptionPane.showMessageDialog(null, "RA já cadastrado! Escolha um valor válido!", "ERRO",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				textField.setText("");
				textField_1.setText("");
				alunosFila.insert(aluno.nomeAluno + ";" + aluno.ra);
				String nome = "Alunos.csv";
				createFile(path, nome, alunosFila);
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Confirmação",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void registrarGrupo() throws Exception {
		String integrantes = "";
		Grupos grupo = new Grupos();
		grupo.integrantesGrupo = new Lista();
		String nomes = textArea.getText();
		if (!(nomes.isEmpty())) {
			String[] info = nomes.split("\n");
			for (int i = 0; i < info.length; i++) {
				if (lerAlunos(info[i]) == false) {
					JOptionPane.showMessageDialog(null, "Aluno(a) " + info[i] + " não possui um cadastro!", "ERRO",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (i == info.length - 1) {
					grupo.integrantesGrupo.addFirst(info[i]);
					integrantes += (String) grupo.integrantesGrupo.get(0);
					break;
				}
				grupo.integrantesGrupo.addFirst(info[i]);
				integrantes += (String) grupo.integrantesGrupo.get(0);
				integrantes += ", ";
			}
		}
		do {
			grupo.idGrupo = cad_id.getText();
			if (lerIdGrupoCadastro(grupo.idGrupo) == false) {
				JOptionPane.showMessageDialog(null, "ID já cadastrado! Escolha um valor válido!", "ERRO",
						JOptionPane.ERROR_MESSAGE);
				cad_id.setText("");
			}
		} while (lerIdGrupoCadastro(grupo.idGrupo) == false);
		grupo.orientador = textField_6.getText();
		grupo.tema = textField_5.getText();
		grupo.subArea = (String) comboBox_1.getSelectedItem();
		if (grupo.orientador.isEmpty() || grupo.tema.isEmpty() || grupo.idGrupo.isEmpty() || nomes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Grupo cadastrado com sucesso!", "Confirmação",
					JOptionPane.INFORMATION_MESSAGE);
			adicionaGrupo(grupo);
			gruposFila.insert(integrantes + ";" + grupo.idGrupo + ";" + grupo.orientador + ";" + grupo.tema + ";"
					+ grupo.subArea);
			String arquivo = "Grupos.csv";
			createFile(path, arquivo, gruposFila);
			textArea.setText("");
			cad_id.setText("");
			textField_6.setText("");
			textField_5.setText("");
		}
	}

	@Override
	public void adicionaGrupo(Grupos grupo) throws Exception {
		int hash = grupo.hashCode();
		Lista l = vetGrupos[hash];
		if (l.isEmpty()) {
			l.addFirst(grupo);
		} else {
			l.addLast(grupo);
		}
	}

	@Override
	public void consultarGruposSubArea() throws Exception {
		StringBuffer buffer = new StringBuffer();
		textArea_2.setText("");
		Grupos grupo = new Grupos();
		grupo.subArea = (String) comboBox.getSelectedItem();
		int posicao = grupo.hashCode();
		int tamanho = vetGrupos[posicao].size();
		for (int i = 0; i < tamanho; i++) {
			Grupos g = (Grupos) vetGrupos[posicao].get(i);
			buffer.append(g.toString() + "\n");
		}
		textArea_2.setText(buffer.toString());
	}

	public void consultarGrupoId() throws Exception {
		textArea_1.setText("");
		String idGrupo = textField_7.getText();
		if (!idGrupo.equals("")) {
			String grupo = buscarGrupo(idGrupo);
			if (grupo != "") {
				textArea_1.setText(grupo);
				textField_7.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "ID não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campo Vazio!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void registrarOrientacao(Grupos grupo) throws Exception {
		grupo.idGrupo = rec_id1.getText();
		rec_id1.setText("");
		if (lerIdGrupoCadastro(grupo.idGrupo) == false) {
			if (!grupo.idGrupo.equals("")) {
				int tamanho = vetGrupos.length;
				for (int i = 0; i < tamanho; i++) {
					int tamanhoLista = vetGrupos[i].size();
					for (int j = 0; j < tamanhoLista; i++) {
						Grupos g = (Grupos) vetGrupos[i].get(j);
						if (g.idGrupo.equals(grupo.idGrupo)) {
							String orientacao = textField_8.getText();
							textField_8.setText("");
							JOptionPane.showMessageDialog(null, "Orientação cadastrada com sucesso!", "Confirmação",
									JOptionPane.INFORMATION_MESSAGE);
							g.orientacoes = new Lista();
							if (g.orientacoes.isEmpty()) {
								g.orientacoes.addFirst((String) orientacao);
							} else {
								g.orientacoes.addLast((String) orientacao);
							}
							break;
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Campo Vazio!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void ultimaOrientacao() throws Exception {
		textArea_3.setText("");
		Grupos grupo = new Grupos();
		grupo.idGrupo = rec_id2.getText();
		rec_id2.setText("");
		if (lerIdGrupoCadastro(grupo.idGrupo) == false) {
			if (!grupo.idGrupo.equals("")) {
				int tamanho = vetGrupos.length;
				for (int i = 0; i < tamanho; i++) {
					int tamanhoLista = vetGrupos[i].size();
					for (int j = 0; j < tamanhoLista; i++) {
						Grupos g = (Grupos) vetGrupos[i].get(j);
						if (g.idGrupo.equals(grupo.idGrupo)) {
							int ultimo = g.orientacoes.size() - 1;
							String texto = "Ultima Orientacao do grupo de ID " + g.idGrupo + ": "
									+ g.orientacoes.get(ultimo);
							textArea_3.setText(texto);
							break;
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Campo Vazio!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "ID não Cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void createFile(String path, String nome, Fila f) throws Exception {
		File dir = new File(path);
		File arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			if (existe == false) {
				JOptionPane.showMessageDialog(null, "Arquivo criado na pasta TEMP!", "Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			int tamanho = f.size();
			for (int i = 0; i < tamanho; i++) {
				String conteudo = geraTxt(f);
				print.write(conteudo);
			}
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório inválido!");
		}
	}

	private String geraTxt(Fila f) throws Exception {
		StringBuffer buffer = new StringBuffer();
		String linha = (String) f.remove();
		buffer.append(linha + "\n");
		return buffer.toString();
	}

	public boolean lerAlunos(String aluno) throws Exception {//Verifica se um determinado aluno está cadastrado.
		String nome = "Alunos.csv";
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					if (linha.contains(aluno)) {
						return true;
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Crie a pasta TEMP no diretório C:/", "ERRO", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Arquivo Inválido");
		}
		return false;
	}
	
	public boolean lerRa(String ra) throws Exception { //Verifica se um determinado RA já está cadastrado.
		String nome = "Alunos.csv";
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] info = linha.split(";");
					if (info[1].equals(ra)) {
						return true;
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Crie a pasta TEMP no diretório C:\\ !!", "ERRO", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Arquivo Inválido");
		}
		return false;
	}

	public boolean lerIdGrupoCadastro(String id) throws IOException {
		String nome = "Grupos.csv";
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] info = linha.split(";");
					if (info[1].equals(id)) {
						return false;
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Crie a pasta TEMP no diretório C:\\ !!", "ERRO", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Arquivo Inválido");
		}
		return true;
	}

	private String buscarGrupo(String id) throws IOException {
		String nome = "Grupos.csv";
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(path, nome);
			if (arq.exists() && arq.isFile()) {
				FileInputStream fluxo = new FileInputStream(arq);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] info = linha.split(";");
					if (info[1].equals(id)) {
						return "Integrantes: " + info[0] + "\nID: " + info[1] + "\nProfessor Orientador: " + info[2]
								+ "\nTema do Trabalho: " + info[3] + "\nÁrea do Trabalho: " + info[4];
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Crie a pasta TEMP no diretório C:\\ !!", "ERRO", JOptionPane.ERROR_MESSAGE);
			throw new IOException("Arquivo Inválido");
		}
		return "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Gravar Aluno")) {
			try {
				registrarAluno();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Consultar ID")) {
			try {
				consultarGrupoId();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Consultar Grupos")) {
			try {
				consultarGruposSubArea();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Gravar Grupo")) {
			try {
				registrarGrupo();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Gravar Orientacao")) {
			try {
				Grupos grupo = new Grupos();
				registrarOrientacao(grupo);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Consultar Orientacao")) {
			try {
				ultimaOrientacao();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (cmd.equals("Limpar")) {
			textField.setText("");
			textField_1.setText("");
			textArea.setText("");
			cad_id.setText("");
			textField_5.setText("");
			textField_6.setText("");
		}
	}
}