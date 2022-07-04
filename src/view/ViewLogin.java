package view;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import banco.Armazenamento;
import models.Medico;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

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
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setTitle("LOGIN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 142, 46, 14);
		getContentPane().add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtLogin.setBounds(116, 136, 258, 26);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(60, 194, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSenha.setBounds(116, 188, 258, 26);
		getContentPane().add(txtSenha);

		JButton btnNewButton = new JButton("Logar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkLogin(txtLogin.getText(), new String(txtSenha.getPassword()))) {

					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!!!");
					ViewAreaTrabalho trabalho = new ViewAreaTrabalho();
					trabalho.setVisible(true);
					trabalho.setAlwaysOnTop(false);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(183, 242, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Fazer Cadastro");
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastro cadastro = new ViewCadastro();
				cadastro.setVisible(true);
				cadastro.setAlwaysOnTop(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(60, 289, 131, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Esqueci a Senha");
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEsqueceuSenha esqueceuSenha = new ViewEsqueceuSenha();
				esqueceuSenha.setVisible(true);
				esqueceuSenha.setAlwaysOnTop(false);
				dispose();
			}
		});
		btnNewButton_2.setBounds(264, 289, 131, 23);
		getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ViewLogin.class.getResource("/imagem/REAL HOSPITAL BRUNA SANTOS.jpg")));
		lblNewLabel_2.setBounds(0, 0, 455, 319);
		getContentPane().add(lblNewLabel_2);
	}
	
	public static boolean checkLogin(String login, String senha) {
		
		for (Medico medico : Armazenamento.medicos) {
			if (medico.getNome().equals(login) && medico.getSenha().equals(senha)) {
				Medico.medico = (medico.getNome()); 	
				Medico.especialidade = (medico.getEspecializacao());
				Medico.numerocrm = (medico.getCrm());
				Medico.numerocpf = (medico.getCpf());
				Medico.enderecoEmail = (medico.getEmail());
				return true;
			}
		}
		return false;
	}
		

}
