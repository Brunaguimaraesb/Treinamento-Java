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
import javax.swing.JPanel;
import javax.swing.JTextField;

import banco.Armazenamento;
import models.Medico;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewEsqueceuSenha extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtNovaSenha;
	private JTextField txtConfirmaSenha;

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
					ViewEsqueceuSenha frame = new ViewEsqueceuSenha();
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
	public ViewEsqueceuSenha() {
		setTitle("REDEFINI\u00C7\u00C3O DE SENHA");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(118, 74, 29, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nova Senha");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(58, 136, 89, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Confirmar Senha");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(22, 196, 125, 14);
		contentPane.add(lblNewLabel_3);

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
		txtCPF.setBounds(157, 70, 258, 26);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		txtNovaSenha = new JTextField();
		txtNovaSenha.setBounds(157, 132, 258, 26);
		contentPane.add(txtNovaSenha);
		txtNovaSenha.setColumns(10);

		txtConfirmaSenha = new JTextField();
		txtConfirmaSenha.setBounds(157, 192, 258, 26);
		contentPane.add(txtConfirmaSenha);
		txtConfirmaSenha.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtCPF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o seu CPF!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!Armazenamento.VerificarCPF(txtCPF.getText())) {
					JOptionPane.showMessageDialog(null, "CPF não cadastrado", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}	
				
				if (txtNovaSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha a sua senha!!!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
								
				if (txtNovaSenha.getText().length() < 8) {
					JOptionPane.showMessageDialog(null, "Sua senha deve conter no mínimo 8 caracteres.", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!txtNovaSenha.getText().equals(txtConfirmaSenha.getText())) {
					JOptionPane.showMessageDialog(null, "As senhas precisam ser iguais!!!", "Atenção",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (Armazenamento.VerificarNovaSenha(txtNovaSenha.getText())) {
					JOptionPane.showMessageDialog(null, "Senha igual a anterior", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (Medico medico : Armazenamento.medicos) {
					if (medico.getCpf().equals(txtCPF.getText())) {
						medico.setSenha(txtNovaSenha.getText());
						break;
					}
				}

				JOptionPane.showMessageDialog(null, "Senha modificada com sucesso!!!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
				new ViewLogin().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(34, 139, 34));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(92, 271, 131, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewLogin().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(265, 271, 131, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewEsqueceuSenha.class.getResource("/imagem/FUNDO RED.jpg")));
		lblNewLabel.setBounds(0, 0, 455, 319);
		contentPane.add(lblNewLabel);
	}
}
