package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import banco.Armazenamento;
import models.Medico;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewCadastro extends JFrame {
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JTextField txtCRM;
	private JTextField txtEspecializacao;
	private JTextField txtSenha;
	private JTextField txtConfirmaSenha;
	private JTextField txtPe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.err.println(ex);
		} catch (InstantiationException ex) {
			System.err.println(ex);
		} catch (IllegalAccessException ex) {
			System.err.println(ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
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
	public ViewCadastro() {
		setTitle("CADASTRO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Especializa\u00E7\u00E3o");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(25, 140, 92, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(84, 173, 37, 14);
		getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico medico = new Medico();
				medico.setNome(txtNome.getText());
				medico.setCpf(txtCPF.getText());
				medico.setEspecializacao(txtEspecializacao.getText());
				medico.setCrm(txtCRM.getText());
				medico.setEmail(txtEmail.getText());
				medico.setSenha(txtSenha.getText());

				medico.medico = txtNome.getText();
				medico.especialidade = txtEspecializacao.getText();
				medico.numerocrm = txtCRM.getText();
				medico.numerocpf = txtCPF.getText();
				medico.enderecoEmail = txtEmail.getText();
				
				if (medico.getNome().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o seu nome!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				/*
				 * if(!medico.getNome().matches("^[a-zA-Z]+$")) {
				 * JOptionPane.showMessageDialog(null, "Preencha corretamente seu nome!!!",
				 * "Atenção", JOptionPane.ERROR_MESSAGE); return; }
				 */
				if (medico.getCpf().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o seu CPF!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Armazenamento.VerificarCPF(txtCPF.getText())) {
					JOptionPane.showMessageDialog(null, "CPF já é cadastrado", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}				
				if ((medico.getCpf().length() != 14 )) {//com 14 pois conta com 2 pontos e 1 - do evento keytyped
					JOptionPane.showMessageDialog(null, "O CPF só pode conter números e precisa ter 11 digitos!!!",
							"Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (medico.getEspecializacao().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha a sua Especialização!!!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (medico.getCrm().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o seu CRM!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (medico.getEmail().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o seu email!!!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (medico.getSenha().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha a sua senha!!!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (medico.getSenha().length() < 8) {
					JOptionPane.showMessageDialog(null, "Sua senha deve conter no mínimo 8 caracteres.", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!medico.getSenha().equals(txtConfirmaSenha.getText())) {
					JOptionPane.showMessageDialog(null, "As senhas precisam ser iguais!!!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!");

				Armazenamento.medicos.add(medico);
				new ViewLogin().setVisible(true);
				dispose();
			}

		});
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(90, 285, 105, 25);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewLogin().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(261, 285, 105, 25);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("Nome");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(80, 73, 46, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(93, 107, 29, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("CRM");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(272, 107, 37, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtPe = new JTextField();
		txtPe.setBackground(Color.WHITE);
		txtPe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPe.setText(" PE");
		txtPe.setEditable(false);
		txtPe.setColumns(10);
		txtPe.setBounds(398, 103, 29, 25);
		getContentPane().add(txtPe);
		
		txtCPF = new JTextField();
		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCPF.getText().length() == 3) {
					txtCPF.setText(txtCPF.getText()+".");
				}
				if(txtCPF.getText().length() == 7) {
					txtCPF.setText(txtCPF.getText()+".");
				}
				if(txtCPF.getText().length() == 11) {
					txtCPF.setText(txtCPF.getText()+"-");
				}
				if(txtCPF.getText().length() == 14) {
					e.consume();
				}
			}
		});
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCPF.setBounds(127, 103, 131, 25);
		getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNome.setBounds(127, 70, 300, 25);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setBounds(127, 169, 300, 25);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtCRM = new JTextField();
		txtCRM.setBounds(308, 103, 80, 25);
		getContentPane().add(txtCRM);
		txtCRM.setColumns(10);

		txtEspecializacao = new JTextField();
		txtEspecializacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEspecializacao.setBounds(127, 136, 300, 25);
		getContentPane().add(txtEspecializacao);
		txtEspecializacao.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSenha.setBounds(127, 202, 300, 25);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);

		txtConfirmaSenha = new JTextField();
		txtConfirmaSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtConfirmaSenha.setBounds(127, 235, 300, 25);
		getContentPane().add(txtConfirmaSenha);
		txtConfirmaSenha.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(78, 206, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_6 = new JLabel("Confirmar Senha");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 239, 114, 14);
		getContentPane().add(lblNewLabel_6);
	
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(ViewCadastro.class.getResource("/imagem/RH BS.jpg")));
		lblNewLabel_8.setBounds(0, 0, 455, 319);
		getContentPane().add(lblNewLabel_8);
	}
}
