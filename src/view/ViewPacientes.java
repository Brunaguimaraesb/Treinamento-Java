package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Armazenamento;
import models.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewPacientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField txtPaciente;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JFormattedTextField txtChegada;
	private JTextField txtData;

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
					ViewPacientes frame = new ViewPacientes();
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
	public ViewPacientes() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(70, 72, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		textField = new JTextField(dtf.format(LocalDateTime.now()));
		textField.setForeground(Color.DARK_GRAY);
		textField.setEditable(false);
		textField.setBackground(new Color(211, 211, 211));
		textField.setBounds(0, 39, 155, 22);
		textField.setBackground(new Color(211, 211, 211));
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Ordem de Chegada");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 106, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(143, 70, 302, 25);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtData.setColumns(10);
		txtData.setBounds(143, 137, 302, 25);
		contentPane.add(txtData);
		
		txtData.setText(dtf.format(LocalDateTime.now()));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"URG\u00CANCIA", "ELETIVA", "ROTINA"}));
		comboBox.setBounds(340, 103, 105, 23);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 203, 435, 105);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente paciente = new Paciente();
				paciente.setNome(txtPaciente.getText());
				paciente.setTipoAtendimento(comboBox.getSelectedItem().toString());
				paciente.setDataAgendamento(txtData.getText());
				
				if(paciente.getNome().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do paciente!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(paciente.getDataAgendamento().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha a data!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
								
				Armazenamento.pacientes.add(paciente);
				
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
								
				String nome = paciente.getNome()+ " " + paciente.getTipoAtendimento() + "\n";
				
				textArea.setText(nome);
			}
			
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 169, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Armazenamento.pacientes.remove(Integer.parseInt(txtChegada.getText())-1);
				
				JOptionPane.showMessageDialog(null, "Removido com sucesso!!!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(114, 169, 98, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoConsulta = Integer.parseInt(txtChegada.getText())-1;
				Paciente paciente = Armazenamento.pacientes.get(posicaoConsulta);
				String nome = paciente.getNome()+ " " + paciente.getTipoAtendimento() + "\n";
				
				textArea.setText(nome);
				
			}
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(233, 169, 103, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Listar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <Paciente> pacientes = Armazenamento.pacientes;
				String pacienteConcatenado = "";
				for(int i = 0; i<pacientes.size(); i++) {
					pacienteConcatenado = pacienteConcatenado + (i+1) + " " 
							+ pacientes.get(i).getTipoAtendimento() + " " 
							+ pacientes.get(i).getNome()+"\n";
				}
				
				textArea.setText(pacienteConcatenado);
			}
		});
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(356, 169, 89, 23);
		contentPane.add(btnNewButton_3);
		
		txtChegada = new JFormattedTextField();
		txtChegada.setBounds(143, 102, 48, 25);
		contentPane.add(txtChegada);
				
		JButton btnNewButton_4 = new JButton("Voltar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAreaTrabalho().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(356, 11, 89, 23);
		contentPane.add(btnNewButton_4);
				
		JLabel lblNewLabel_3 = new JLabel("Tipo de Atendimento");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(203, 106, 143, 14);
		contentPane.add(lblNewLabel_3);
				
		JLabel lblNewLabel_2_1 = new JLabel("Data de Atendimento");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(0, 142, 144, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon(ViewPacientes.class.getResource("/imagem/pac.jpg")));
		lblNewLabel.setBounds(0, 0, 455, 319);
		contentPane.add(lblNewLabel);
	}
}
