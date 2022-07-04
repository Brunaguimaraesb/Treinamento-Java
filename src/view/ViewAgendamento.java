package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import banco.Armazenamento;
import models.Paciente;

public class ViewAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNomeTipo;

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
					ViewAgendamento frame = new ViewAgendamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAgendamento frame = new ViewAgendamento();
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
	public ViewAgendamento() {
		setTitle("AGENDAMENTO");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAreaTrabalho().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(356, 8, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 103, 410, 205);
		contentPane.add(textArea);
		
		List <Paciente> pacientes = Armazenamento.pacientes;
		String pacienteConcatenado = "";
		for(int i = 0; i<pacientes.size(); i++) {
			pacienteConcatenado = pacienteConcatenado + (i+1) + " " 
					+ pacientes.get(i).getNome()+ " | " 
					+ pacientes.get(i).getTipoAtendimento()+ " | " 
					+ pacientes.get(i).getDataAgendamento()+"\n";
		}
		
		textArea.setText(pacienteConcatenado);
				
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		textField = new JTextField(dtf.format(LocalDateTime.now()));
		textField.setForeground(Color.DARK_GRAY);
		textField.setBackground(new Color(211, 211, 211));
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setEditable(false);
		textField.setBounds(0, 38, 155, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtNomeTipo = new JTextField();
		txtNomeTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNomeTipo.setText("     NOME    |     TIPO     |     DATA ");
		txtNomeTipo.setEditable(false);
		txtNomeTipo.setBounds(137, 71, 206, 25);
		contentPane.add(txtNomeTipo);
		txtNomeTipo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(ViewAgendamento.class.getResource("/imagem/AGEND.jpg")));
		lblNewLabel_5.setBounds(0, 0, 455, 319);
		contentPane.add(lblNewLabel_5);
	}

}
