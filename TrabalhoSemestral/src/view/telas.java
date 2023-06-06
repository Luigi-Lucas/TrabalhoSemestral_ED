package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ArquivosController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class telas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField cad_id;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telas frame = new telas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telas() {
		setTitle("Sistema TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 476, 393);
		contentPane.add(tabbedPane);

		JPanel Alunos = new JPanel();
		Alunos.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Cadastro de Alunos", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 120, 215)));
		tabbedPane.addTab("Aluno", null, Alunos, "Cadastro de alunos");
		Alunos.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome do aluno");
		lblNewLabel.setBounds(10, 62, 97, 14);
		Alunos.add(lblNewLabel);

		JLabel lblRa = new JLabel("RA");
		lblRa.setBounds(10, 102, 80, 14);
		Alunos.add(lblRa);

		textField = new JTextField();
		textField.setBounds(111, 59, 283, 20);
		Alunos.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 99, 283, 20);
		Alunos.add(textField_1);

		JButton btnNewButton = new JButton("Gravar Aluno");
		btnNewButton.setBackground(new Color(216, 250, 220));
		btnNewButton.setBounds(111, 162, 108, 23);
		Alunos.add(btnNewButton);

		JButton btnExcluir = new JButton("Limpar");
		btnExcluir.setBackground(new Color(253, 216, 200));
		btnExcluir.setBounds(240, 162, 108, 23);
		Alunos.add(btnExcluir);

		JPanel grupos = new JPanel();
		grupos.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Cadastro de Grupo", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, SystemColor.textHighlight));
		tabbedPane.addTab("Grupo", null, grupos, "Cadastro de grupos");
		grupos.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID grupo");
		lblNewLabel_1.setBounds(21, 42, 81, 14);
		grupos.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Área do trabalho");
		lblNewLabel_2.setBounds(21, 77, 112, 14);
		grupos.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tema");
		lblNewLabel_3.setBounds(21, 118, 46, 14);
		grupos.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Orientador");
		lblNewLabel_4.setBounds(21, 157, 81, 14);
		grupos.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Integrantes do grupo:");
		lblNewLabel_5.setBounds(21, 182, 146, 14);
		grupos.add(lblNewLabel_5);

		cad_id = new JTextField();
		cad_id.setBounds(131, 39, 317, 20);
		grupos.add(cad_id);
		cad_id.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(131, 115, 317, 20);
		grupos.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(131, 154, 317, 20);
		grupos.add(textField_6);

		JButton btnNewButton_1 = new JButton("Gravar Grupo");
		btnNewButton_1.setBackground(new Color(216, 250, 220));
		btnNewButton_1.setBounds(106, 311, 120, 23);
		grupos.add(btnNewButton_1);

		JButton btnExcluir_1 = new JButton("Limpar");
		btnExcluir_1.setBackground(new Color(253, 216, 200));
		btnExcluir_1.setBounds(261, 311, 120, 23);
		grupos.add(btnExcluir_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Insira um nome por linha! - M\u00E1ximo de 4 Integrantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(122, 202, 332, 88);
		grupos.add(panel);
		panel.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 16, 320, 66);
		panel.add(textArea);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] {"Redes", "Dados", "Segurança da Informação", "Engenharia de Software", "Desenvolvimento de Software", "Sistemas de Informação", "Inteligência Artificial", "Cloud Computing", "Qualidade de Software"}));
		comboBox_1.setBounds(131, 73, 317, 22);
		grupos.add(comboBox_1);

		JPanel consultagp = new JPanel();
		consultagp.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Consultar grupo por ID", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(0, 128, 255)));
		tabbedPane.addTab("Consulta grupo", null, consultagp, "Consultar grupo por código");
		consultagp.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("ID Grupo");
		lblNewLabel_1_1.setBounds(10, 67, 85, 14);
		consultagp.add(lblNewLabel_1_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(87, 64, 357, 20);
		consultagp.add(textField_7);

		JButton btnNewButton_2 = new JButton("Consultar ID");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBackground(new Color(227, 252, 209));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(191, 95, 114, 23);
		consultagp.add(btnNewButton_2);

		JLabel lblNewLabel_2_1 = new JLabel("Informações do grupo:");
		lblNewLabel_2_1.setBounds(10, 147, 167, 14);
		consultagp.add(lblNewLabel_2_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea_1.setTabSize(12);
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(87, 172, 357, 167);
		consultagp.add(textArea_1);

		JPanel sub = new JPanel();
		sub.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Consultar grupo por Sub\u00E1rea", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null,
				new Color(0, 128, 255)));
		tabbedPane.addTab("Subárea", null, sub, "Consultar grupos em uma subárea específica");
		sub.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 39, 446, 295);
		sub.add(contentPane_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] {"Redes", "Dados", "Segurança da Informação", "Engenharia de Software", "Desenvolvimento de Software", "Sistemas de Informação", "Inteligência Artificial", "Cloud Computing", "Qualidade de Software"}));
		comboBox.setBounds(147, 44, 289, 22);
		contentPane_1.add(comboBox);

		JLabel lblNewLabel_1_2 = new JLabel("Selecione a subárea:");
		lblNewLabel_1_2.setBounds(10, 48, 127, 14);
		contentPane_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_2 = new JLabel("Grupos:");
		lblNewLabel_2_2.setBounds(10, 117, 46, 14);
		contentPane_1.add(lblNewLabel_2_2);

		JList list_1 = new JList();
		list_1.setBounds(120, 210, 111, -50);
		contentPane_1.add(list_1);

		JButton btnNewButton_2_1 = new JButton("Consultar Grupos");
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setBackground(new Color(227, 252, 209));
		btnNewButton_2_1.setBounds(182, 82, 133, 23);
		contentPane_1.add(btnNewButton_2_1);

		JPanel orient = new JPanel();
		orient.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Cadastro de Orienta\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null,
				SystemColor.textHighlight));
		tabbedPane.addTab("Orientação", null, orient, "inserir orientação para um grupo");
		orient.setLayout(null);

		JLabel lblNewLabel_8_1 = new JLabel("ID grupo:");
		lblNewLabel_8_1.setBounds(26, 72, 141, 14);
		orient.add(lblNewLabel_8_1);

		JTextField rec_id1 = new JTextField();
		rec_id1.setFont(new Font("Arial", Font.PLAIN, 13));
		rec_id1.setEditable(true);
		rec_id1.setBounds(110, 68, 320, 22);
		orient.add(rec_id1);

		JLabel lblNewLabel_9 = new JLabel("Digite sua orientação");
		lblNewLabel_9.setBounds(26, 116, 141, 14);
		orient.add(lblNewLabel_9);

		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.PLAIN, 13));
		textField_8.setBounds(110, 141, 320, 152);
		orient.add(textField_8);
		textField_8.setColumns(10);

		JButton btnNewButton_2_2 = new JButton("Gravar Orientacao");
		btnNewButton_2_2.setForeground(Color.BLACK);
		btnNewButton_2_2.setBackground(new Color(227, 252, 209));
		btnNewButton_2_2.setBounds(198, 304, 141, 23);
		orient.add(btnNewButton_2_2);

		JPanel cons_orient = new JPanel();
		cons_orient.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Consultar \u00FAltima orienta\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null,
				new Color(0, 128, 255)));
		tabbedPane.addTab("Última orientação", null, cons_orient, "consultar última orientação dada a um grupo");
		cons_orient.setLayout(null);

		JLabel lblNewLabel_8_1_1 = new JLabel("ID grupo:");
		lblNewLabel_8_1_1.setBounds(23, 67, 141, 14);
		cons_orient.add(lblNewLabel_8_1_1);

		JTextField rec_id2 = new JTextField();
		rec_id2.setFont(new Font("Arial", Font.PLAIN, 13));
		rec_id2.setBounds(107, 63, 320, 22);
		cons_orient.add(rec_id2);

		JLabel lblNewLabel_8_1_1_1 = new JLabel("Última orientação passada:");
		lblNewLabel_8_1_1_1.setBounds(23, 122, 177, 14);
		cons_orient.add(lblNewLabel_8_1_1_1);

		JList list_2 = new JList();
		list_2.setBounds(107, 134, 1, 1);
		cons_orient.add(list_2);

		JButton btnNewButton_2_1_1 = new JButton("Consultar Orientacao");
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setBackground(new Color(227, 252, 209));
		btnNewButton_2_1_1.setBounds(173, 96, 163, 23);
		cons_orient.add(btnNewButton_2_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(66, 117, 370, 178);
		contentPane_1.add(scrollPane);

		JTextArea textArea_2 = new JTextArea();
		scrollPane.setViewportView(textArea_2);
		textArea_2.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea_2.setEnabled(false);
		textArea_2.setEditable(false);
		textArea_2.setLineWrap(true);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);
		textArea_3.setFont(new Font("Arial", Font.PLAIN, 13));
		textArea_3.setEditable(false);
		textArea_3.setEnabled(false);
		textArea_3.setBounds(107, 147, 320, 193);
		cons_orient.add(textArea_3);

		ArquivosController aC = new ArquivosController(textField, textField_1, cad_id, textField_5, textField_6,
				textField_7, textField_8, textArea_1, comboBox, textArea_2, comboBox_1, textArea, rec_id1, rec_id2,
				textArea_3);
		
		JLabel lblParaMelhorFuncionamento = new JLabel("Para melhor funcionamento do programa, crie uma pasta com o nome \"TEMP\" no diretório C:\\");
		lblParaMelhorFuncionamento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblParaMelhorFuncionamento.setHorizontalAlignment(SwingConstants.LEFT);
		lblParaMelhorFuncionamento.setForeground(Color.RED);
		lblParaMelhorFuncionamento.setBounds(10, 329, 461, 14);
		Alunos.add(lblParaMelhorFuncionamento);
		
		btnNewButton.addActionListener(aC);
		btnNewButton_1.addActionListener(aC);
		btnNewButton_2.addActionListener(aC);
		btnNewButton_2_1.addActionListener(aC);
		btnNewButton_2_2.addActionListener(aC);
		btnNewButton_2_1_1.addActionListener(aC);
		btnExcluir.addActionListener(aC);
		btnExcluir_1.addActionListener(aC);
	}
}