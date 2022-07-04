package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Medico;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ViewPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPerfil frame = new ViewPerfil();
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
	public ViewPerfil() {
		setTitle("PERFIL");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		textField = new JTextField(dtf.format(LocalDateTime.now()));
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(new Color(211, 211, 211));
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setEditable(false);
		textField.setBounds(0, 38, 155, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAreaTrabalho().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(356, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField(Medico.medico.toUpperCase());
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setBounds(131, 71, 290, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(Medico.numerocpf);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(131, 121, 290, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField(Medico.numerocrm);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(131, 170, 290, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(Medico.especialidade.toUpperCase());
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(131, 263, 290, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField(Medico.enderecoEmail.toLowerCase());
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(131, 216, 290, 25);
		contentPane.add(textField_4);
		
		lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(66, 75, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(80, 125, 29, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("CRM");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(75, 174, 34, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Especialidade");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(6, 220, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(68, 267, 41, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewPerfil.class.getResource("/imagem/PERFIL.jpg")));
		lblNewLabel.setBounds(0, 0, 455, 319);
		contentPane.add(lblNewLabel);
						
	}

}
