package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.Armazenamento;
import models.Enfermeiros;
import models.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEnfermeiros extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnfermeiro;
	private JTextField txtSetor;
	private JTextField textField_2;
	private JTextField textField_3;

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
					ViewEnfermeiros frame = new ViewEnfermeiros();
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
	public ViewEnfermeiros() {
		setTitle("ENFERMEIROS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 471, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
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
				
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MANH\u00C3", "TARDE", "NOITE"}));
		comboBox.setBounds(333, 112, 112, 23);
		contentPane.add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 203, 435, 105);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enfermeiros enfermeiro = new Enfermeiros();
				enfermeiro.setNome(txtEnfermeiro.getText());
				enfermeiro.setTurno(comboBox.getSelectedItem().toString());
				
				if(enfermeiro.getNome().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o nome do enfermeiro!!!", "Atenção", JOptionPane.ERROR_MESSAGE);
					return;
				}
								
				Armazenamento.enfermeiros.add(enfermeiro);
				
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!!!");
								
				String nome = enfermeiro.getNome()+ " " + enfermeiro.getTurno() + "\n";
				
				textArea.setText(nome);
			}
			
		});
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 169, 89, 23);
		contentPane.add(btnNewButton_1);
					
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Armazenamento.enfermeiros.remove(Integer.parseInt(txtSetor.getText())-1);
				
				JOptionPane.showMessageDialog(null, "Removido com sucesso!!!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(114, 169, 98, 23);
		contentPane.add(btnNewButton_2);
				
		JButton btnNewButton_3 = new JButton("Consultar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoSetor = Integer.parseInt(txtSetor.getText())-1;
				Enfermeiros enfermeiro = Armazenamento.enfermeiros.get(posicaoSetor);
				String nome = enfermeiro.getNome()+ " " + enfermeiro.getTurno() + "\n";
				
				textArea.setText(nome);
				
			}
			
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setBounds(233, 169, 103, 23);
		contentPane.add(btnNewButton_3);
			
		JButton btnNewButton_4 = new JButton("Listar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List <Enfermeiros> enfermeiros = Armazenamento.enfermeiros;
				String enfermeirosConcatenado = "";
				for(int i = 0; i<enfermeiros.size(); i++) {
					enfermeirosConcatenado = enfermeirosConcatenado + (i+1) + " " 
							+ enfermeiros.get(i).getNome()+ " " 
							+ enfermeiros.get(i).getTurno()+"\n";
				}
				
				textArea.setText(enfermeirosConcatenado);
			}
		});
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(356, 169, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("Enfermeiro");			
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 73, 89, 14);
		contentPane.add(lblNewLabel_1);
				
		JLabel lblNewLabel_2 = new JLabel("Setor");				
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(48, 115, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Turno do Enfermeiro");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(193, 115, 143, 14);
		contentPane.add(lblNewLabel_3);
				
		txtEnfermeiro = new JTextField();
		txtEnfermeiro.setBounds(102, 70, 313, 25);
		contentPane.add(txtEnfermeiro);
		txtEnfermeiro.setColumns(10);
					
		txtSetor = new JTextField();
		txtSetor.setBounds(103, 112, 80, 25);
		contentPane.add(txtSetor);
		txtSetor.setColumns(10);
				
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		textField_2 = new JTextField(dtf.format(LocalDateTime.now()));
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setBackground(new Color(211, 211, 211));
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_2.setEditable(false);
		textField_2.setBounds(0, 37, 155, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 39, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewEnfermeiros.class.getResource("/imagem/enferm.jpg")));
		lblNewLabel.setBounds(0, 0, 455, 319);
		contentPane.add(lblNewLabel);
	}
}
