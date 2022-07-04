package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import banco.Armazenamento;
import models.Medico;
import models.Pessoa;

public class ViewAreaTrabalho extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

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
					ViewAreaTrabalho frame = new ViewAreaTrabalho();
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
	public ViewAreaTrabalho() {
		setTitle("\u00C1REA DE TRABALHO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNewLabel);
				
		textField = new JTextField("OLÁ " + Medico.medico.toUpperCase()+ " SEJA BEM VINDO(A)!!");
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(new Color(211, 211, 211));
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setBounds(160, 5, 290, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Meu Perfil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPerfil perfil = new ViewPerfil();
				perfil.setVisible(true);
				perfil.setAlwaysOnTop(false);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(43, 101, 161, 28);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista de Pacientes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPacientes paciente = new ViewPacientes();
				paciente.setVisible(true);
				paciente.setAlwaysOnTop(false);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(251, 101, 161, 28);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Enfermeiros");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEnfermeiros enfermeiro = new ViewEnfermeiros();
				enfermeiro.setVisible(true);
				enfermeiro.setAlwaysOnTop(false);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(43, 187, 161, 28);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewLogin().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setBounds(178, 260, 95, 28);
		getContentPane().add(btnNewButton_4);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    				
		textField_1 = new JTextField(dtf.format(LocalDateTime.now()));
		textField_1.setEditable(false);
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setBackground(new Color(211, 211, 211));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(0, 36, 155, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Agendamento");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAgendamento agendamento = new ViewAgendamento();
				agendamento.setVisible(true);
				agendamento.setAlwaysOnTop(false);
				dispose();
			}
		});
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(251, 187, 161, 28);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewAreaTrabalho.class.getResource("/imagem/FUNDO HBS.jpg")));
		lblNewLabel_1.setBounds(0, 0, 455, 319);
		getContentPane().add(lblNewLabel_1);
	}
}
