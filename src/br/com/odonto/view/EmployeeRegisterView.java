package br.com.odonto.view;

//AUTHOR: Felipe Pereira dos Santos(21192057)

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odonto.controller.EmployeeController;
import br.com.odonto.model.EmployeeModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EmployeeRegisterView extends JFrame {
	
	private EmployeeController employeeRegisterController;
	private EmployeeModel employee;
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
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private JPasswordField txtSenha;
	private int x,y;
	private JLabel lblResultado;

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
		panel.setBounds(0, 0, 30, 446);
		contentPane.add(panel);
		
		draggWindow = new JPanel();
		draggWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		draggWindow.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		draggWindow.setBackground(Color.WHITE);
		draggWindow.setBounds(0, 0, 706, 45);
		contentPane.add(draggWindow);
		draggWindow.setLayout(null);
		
		btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFocusable(false);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(703, 0, 45, 45);
		contentPane.add(btnMinimize);
		
		btnClose = new JButton("X");
		btnClose.setFocusable(false);
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
		
		lblNome = new JLabel("Nome Completo");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(51, 56, 43, 20);
		contentPane.add(lblCpf);
		
		lblFuno = new JLabel("Fun\u00E7\u00E3o");
		lblFuno.setForeground(Color.BLACK);
		lblFuno.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(50, 242, 201, 20);
		contentPane.add(lblEmail);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(50, 304, 201, 20);
		contentPane.add(lblSenha);
		
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
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(0, 102, 255));
		btnVoltar.setBounds(529, 298, 184, 45);
		contentPane.add(btnVoltar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFocusable(false);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				employeeRegisterController = EmployeeController.getINSTANCE();
				String cpf = txtCPF.getText();
				String nome = txtNome.getText();
				String funcao = txtFuncao.getText();
				String email = txtEmail.getText();
				String senha = txtSenha.getText();
				try {
					success = employeeRegisterController.saveEmployeeData(cpf, nome, funcao, email, senha);		
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {	
					lblResultado.setText("Cadastrado com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
					txtNome.setText(null);
					txtFuncao.setText(null);
					txtEmail.setText(null);
					txtSenha.setText(null);
				}else {
					lblResultado.setText("Erro ao cadastrar");
					lblResultado.setVisible(true);
				}
				
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		
		txtSenha = new JPasswordField();
		txtSenha.setCaretColor(SystemColor.textInactiveText);
		txtSenha.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtSenha.setBounds(52, 325, 380, 30);
		contentPane.add(txtSenha);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(50, 384, 382, 30);
		lblResultado.setVisible(false);
		contentPane.add(lblResultado);
	}
}
