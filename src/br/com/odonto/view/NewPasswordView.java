package br.com.odonto.view;

//AUTHOR: Felipe Pereira dos Santos(21192057)
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odonto.controller.LoginController;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class NewPasswordView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JLabel lblCpf;
	private JLabel lblCpf_1;
	private JTextField txtEmail;
	private JLabel lblCpf_2;
	private JPanel draggSecondPanel;
	private int x,y;
	private JButton btnMinimize;
	private JButton btnClose;
	private JPanel panel;
	private JButton btnAlterar;
	private JLabel lblError;
	private LoginController loginController;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPasswordView frame = new NewPasswordView();
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
	public NewPasswordView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblError = new JLabel("New label");
		lblError.setVisible(false);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblError.setForeground(new Color(204, 0, 0));
		lblError.setBounds(30, 310, 263, 14);
		contentPane.add(lblError);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 20, 397);
		contentPane.add(panel);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(Color.DARK_GRAY);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCPF.setBounds(71, 61, 222, 42);
		contentPane.add(txtCPF);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(71, 43, 37, 17);
		contentPane.add(lblCpf);
		
		lblCpf_1 = new JLabel("Email");
		lblCpf_1.setForeground(Color.BLACK);
		lblCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf_1.setBounds(71, 112, 37, 17);
		contentPane.add(lblCpf_1);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setCaretColor(SystemColor.textInactiveText);
		txtEmail.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtEmail.setBounds(71, 130, 222, 42);
		contentPane.add(txtEmail);
		
		lblCpf_2 = new JLabel("Nova Senha");
		lblCpf_2.setForeground(Color.BLACK);
		lblCpf_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf_2.setBounds(71, 183, 68, 16);
		contentPane.add(lblCpf_2);
		
		draggSecondPanel = new JPanel();
		draggSecondPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		draggSecondPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		draggSecondPanel.setBackground(Color.WHITE);
		draggSecondPanel.setBounds(0, 0, 251, 45);
		contentPane.add(draggSecondPanel);
		draggSecondPanel.setLayout(null);
		
		btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setBounds(248, 0, 45, 45);
		contentPane.add(btnMinimize);
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		
		btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(292, 0, 45, 45);
		contentPane.add(btnClose);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		
		btnAlterar = new JButton("Alterar senha");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean success = false;
					String cpf = txtCPF.getText();
					String email = txtEmail.getText();
					String password = txtPassword.getText();
					loginController = new LoginController();
					success = loginController.saveNewPassword(cpf, email, password);
					if(success) {
						lblError.setText("Senha alterada com sucesso");
						lblError.setVisible(true);
						txtCPF.setText(null);
						txtEmail.setText(null);
						txtPassword.setText(null);
					}else {
						lblError.setText("Erro ao alterar a senha");
						lblError.setVisible(true);
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(0, 102, 255));
		btnAlterar.setBounds(81, 254, 184, 45);
		contentPane.add(btnAlterar);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPassword.setForeground(UIManager.getColor("ScrollBar.trackHighlightForeground"));
		txtPassword.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtPassword.setBounds(71, 201, 222, 42);
	//	txtPassword.setBounds(81, 191, 169, 52);
		contentPane.add(txtPassword);
		
	}
}
