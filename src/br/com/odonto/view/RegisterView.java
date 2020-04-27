package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtNameComplete;
	private JTextField txtPhone;
	private JTextField txtBirthday;
	private JTextField txtCep;
	private JTextField txtNeighborhood;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtStreet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setForeground(new Color(65, 105, 225));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(65, 105, 225), null, new Color(123, 104, 238), new Color(65, 105, 225)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setForeground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 30, 489);
		contentPane.add(panel);
		
		JLabel lblNome = new JLabel("NOME COMPLETO");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNome.setBounds(48, 87, 159, 20);
		contentPane.add(lblNome);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(Color.DARK_GRAY);
		txtCPF.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtCPF.setBounds(50, 46, 380, 30);
		contentPane.add(txtCPF);
		
		txtNameComplete = new JTextField();
		txtNameComplete.setForeground(Color.DARK_GRAY);
		txtNameComplete.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNameComplete.setColumns(10);
		txtNameComplete.setCaretColor(SystemColor.textInactiveText);
		txtNameComplete.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtNameComplete.setBounds(50, 112, 380, 30);
		contentPane.add(txtNameComplete);
		
		txtPhone = new JTextField();
		txtPhone.setForeground(Color.DARK_GRAY);
		txtPhone.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setCaretColor(SystemColor.textInactiveText);
		txtPhone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtPhone.setBounds(50, 175, 380, 30);
		contentPane.add(txtPhone);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCpf.setBounds(49, 25, 43, 20);
		contentPane.add(lblCpf);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCelular.setBounds(48, 153, 85, 20);
		contentPane.add(lblCelular);
		
		txtBirthday = new JTextField();
		txtBirthday.setForeground(Color.DARK_GRAY);
		txtBirthday.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtBirthday.setColumns(10);
		txtBirthday.setCaretColor(SystemColor.textInactiveText);
		txtBirthday.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtBirthday.setBounds(50, 241, 380, 30);
		contentPane.add(txtBirthday);
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO");
		lblDataDeNascimento.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(48, 216, 201, 20);
		contentPane.add(lblDataDeNascimento);
		
		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(894, 0, 45, 45);
		contentPane.add(btnClose);
		
		JButton btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(849, 0, 45, 45);
		contentPane.add(btnMinimize);
		
		JLabel lblSe = new JLabel("SEXO");
		lblSe.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSe.setBounds(48, 282, 65, 20);
		contentPane.add(lblSe);
		
		JComboBox cbSex = new JComboBox();
		cbSex.setBackground(new Color(220, 220, 220));
		cbSex.setForeground(new Color(0, 0, 0));
		cbSex.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbSex.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cbSex.setBounds(51, 306, 379, 37);
		contentPane.add(cbSex);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCep.setBounds(522, 39, 43, 20);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setForeground(Color.DARK_GRAY);
		txtCep.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCep.setColumns(10);
		txtCep.setCaretColor(SystemColor.textInactiveText);
		txtCep.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtCep.setBounds(522, 70, 380, 30);
		contentPane.add(txtCep);
		
		txtStreet = new JTextField();
		txtStreet.setForeground(Color.DARK_GRAY);
		txtStreet.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		txtStreet.setCaretColor(SystemColor.textInactiveText);
		txtStreet.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtStreet.setBounds(522, 148, 380, 30);
		contentPane.add(txtStreet);
		
		JLabel lblLogradouro = new JLabel("LOGRADOURO");
		lblLogradouro.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblLogradouro.setBounds(522, 117, 127, 20);
		contentPane.add(lblLogradouro);
		
		txtNeighborhood = new JTextField();
		txtNeighborhood.setForeground(Color.DARK_GRAY);
		txtNeighborhood.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNeighborhood.setColumns(10);
		txtNeighborhood.setCaretColor(SystemColor.textInactiveText);
		txtNeighborhood.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtNeighborhood.setBounds(522, 230, 380, 30);
		contentPane.add(txtNeighborhood);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBairro.setBounds(522, 199, 95, 20);
		contentPane.add(lblBairro);
		
		txtCity = new JTextField();
		txtCity.setForeground(Color.DARK_GRAY);
		txtCity.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setCaretColor(SystemColor.textInactiveText);
		txtCity.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtCity.setBounds(522, 313, 380, 30);
		contentPane.add(txtCity);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCidade.setBounds(522, 282, 95, 20);
		contentPane.add(lblCidade);
		
		txtState = new JTextField();
		txtState.setForeground(Color.DARK_GRAY);
		txtState.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtState.setColumns(10);
		txtState.setCaretColor(SystemColor.textInactiveText);
		txtState.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtState.setBounds(522, 388, 380, 30);
		contentPane.add(txtState);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEstado.setBounds(522, 354, 95, 20);
		contentPane.add(lblEstado);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setBounds(48, 365, 184, 40);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(0, 102, 255));
		btnAlterar.setBounds(246, 365, 184, 40);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Consultar");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(0, 102, 255));
		btnExcluir.setBounds(50, 416, 184, 40);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Excluir");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(0, 102, 255));
		btnConsultar.setBounds(246, 416, 184, 40);
		contentPane.add(btnConsultar);
		
		JPanel draggWindow = new JPanel();
		draggWindow.setBackground(Color.WHITE);
		draggWindow.setBounds(29, 4, 810, 20);
		contentPane.add(draggWindow);
		
		draggWindow.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point cordinate = e.getLocationOnScreen();
				setLocation(cordinate);
			}
		});
	}
}
