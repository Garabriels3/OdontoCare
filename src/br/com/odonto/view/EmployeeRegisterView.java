package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeRegisterView extends JFrame {
	
	private EmployeeRegisterView erv;
	private LoginView lv;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel draggWindow;
	private JLabel lblCadastrar;
	private JButton btnMinimize;
	private JButton btnClose;
	private JLabel lblNome;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JTextField txtFuncao;
	private JLabel lblCpf;
	private JLabel lblFuno;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblSenha;
	private JTextField txtSenha;
	private JButton btnVoltar;
	private JButton btnCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeRegisterView frame = new EmployeeRegisterView();
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
	public EmployeeRegisterView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 102, 255));
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 30, 435);
		contentPane.add(panel);
		
		draggWindow = new JPanel();
		draggWindow.setLayout(null);
		draggWindow.setBackground(Color.WHITE);
		draggWindow.setBounds(30, 0, 676, 45);
		contentPane.add(draggWindow);
		
		btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(703, 0, 45, 45);
		contentPane.add(btnMinimize);
		
		btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(748, 0, 45, 45);
		contentPane.add(btnClose);
		
		lblNome = new JLabel("NOME COMPLETO");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNome.setBounds(50, 118, 159, 20);
		contentPane.add(lblNome);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(Color.DARK_GRAY);
		txtCPF.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCPF.setBounds(52, 77, 380, 30);
		contentPane.add(txtCPF);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setCaretColor(SystemColor.textInactiveText);
		txtNome.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtNome.setBounds(52, 139, 380, 30);
		contentPane.add(txtNome);
		
		txtFuncao = new JTextField();
		txtFuncao.setForeground(Color.DARK_GRAY);
		txtFuncao.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtFuncao.setColumns(10);
		txtFuncao.setCaretColor(SystemColor.textInactiveText);
		txtFuncao.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtFuncao.setBounds(52, 201, 380, 30);
		contentPane.add(txtFuncao);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCpf.setBounds(51, 56, 43, 20);
		contentPane.add(lblCpf);
		
		lblFuno = new JLabel("FUN\u00C7\u00C3O");
		lblFuno.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblFuno.setBounds(50, 180, 85, 20);
		contentPane.add(lblFuno);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setCaretColor(SystemColor.textInactiveText);
		txtEmail.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtEmail.setBounds(52, 263, 380, 30);
		contentPane.add(txtEmail);
		
		lblEmail = new JLabel("E-MAIL");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEmail.setBounds(50, 242, 201, 20);
		contentPane.add(lblEmail);
		
		lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSenha.setBounds(50, 304, 201, 20);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(Color.DARK_GRAY);
		txtSenha.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtSenha.setColumns(10);
		txtSenha.setCaretColor(SystemColor.textInactiveText);
		txtSenha.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtSenha.setBounds(52, 325, 380, 30);
		contentPane.add(txtSenha);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lv = new LoginView();
					erv = new EmployeeRegisterView();
					erv.setLocationRelativeTo(null);
					erv.setVisible(false);
					lv.setVisible(true);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(0, 102, 255));
		btnVoltar.setBounds(529, 298, 184, 45);
		contentPane.add(btnVoltar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(0, 102, 255));
		btnCadastrar.setBounds(529, 359, 184, 45);
		contentPane.add(btnCadastrar);
		
		lblCadastrar = new JLabel("Sign Up");
		lblCadastrar.setBounds(529, 180, 184, 76);
		contentPane.add(lblCadastrar);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setForeground(Color.LIGHT_GRAY);
		lblCadastrar.setFont(new Font("Verdana", Font.BOLD, 40));
	}
}
