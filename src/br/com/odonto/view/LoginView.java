package br.com.odonto.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.ComponentOrientation;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

import br.com.odonto.DAO.ClientRegisterDao;
import br.com.odonto.controller.LoginController;
import br.com.odonto.util.ConnectionFactory;

import javax.swing.UIManager;

public class LoginView extends JFrame {
	// MARK: Attributes
	private JPanel background;
	private LoginController loginController;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;
	private ClientRegisterView crv;
	private LoginView lv;
	private EmployeeRegisterView erv;
	private SchedulingView sch;
	int x,y;
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		// MARK Properties_Screen
		setBounds(new Rectangle(0, 0, 0, 0));
		setAlwaysOnTop(true);
		setUndecorated(true);
		setForeground(SystemColor.textHighlight);
		setBackground(SystemColor.textHighlight);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 719, 502);
		this.setLocationRelativeTo(null);
		background = new JPanel();
		background.setAutoscrolls(true);
		background.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		background.setBackground(new Color(255, 255, 255));
		background.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), new Color(169, 169, 169)));
		setContentPane(background);
		background.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 365, 502);
		background.add(panel);
		panel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setCaretColor(UIManager.getColor("ComboBox.disabledForeground"));
		txtEmail.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtEmail.setBounds(440, 188, 222, 42);
		background.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnClose = new JButton("X");
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(674, 0, 45, 45);
		background.add(btnClose);
		
		JButton btnMinimize = new JButton("-");
		btnMinimize.setForeground(new Color(255, 255, 255));
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(630, 0, 45, 45);
		background.add(btnMinimize);
		
		JButton btnSignUp = new JButton("Login");
		
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(0, 102, 255));
		btnSignUp.setBounds(456, 329, 184, 45);
		background.add(btnSignUp);
		
		JLabel lblSingUp = new JLabel("Sign In");
		lblSingUp.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblSingUp.setForeground(Color.LIGHT_GRAY);
		lblSingUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingUp.setBounds(361, 56, 358, 53);
		background.add(lblSingUp);
		
		JLabel lblEmail2 = new JLabel("Email");
		lblEmail2.setForeground(Color.BLACK);
		lblEmail2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail2.setBounds(440, 166, 37, 17);
		background.add(lblEmail2);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSenha.setBounds(440, 246, 46, 14);
		background.add(lblSenha);
		
		JButton btnResetPassword = new JButton("Clique aqui para redefinir sua senha!");
		btnResetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnResetPassword.setForeground(new Color(51, 51, 255));
		btnResetPassword.setBackground(new Color(255, 255, 255));
		btnResetPassword.setBorder(null);
		btnResetPassword.setBounds(410, 457, 279, 23);
		background.add(btnResetPassword);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setForeground(Color.BLACK);
		txtSenha.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtSenha.setBounds(440, 265, 222, 42);
		background.add(txtSenha);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(381, 80, -16, -18);
		background.add(horizontalBox);
		
		JPanel draggSecondPanel = new JPanel();
		draggSecondPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		draggSecondPanel.setBackground(Color.WHITE);
		draggSecondPanel.setBounds(0, 0, 631, 45);
		background.add(draggSecondPanel);
		
		JLabel lblErro = new JLabel("Email ou senha invalidos!");
		lblErro.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblErro.setForeground(new Color(204, 0, 0));
		lblErro.setBounds(361, 126, 358, 21);
		background.add(lblErro);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					erv = new EmployeeRegisterView();
					lv = new LoginView();
					erv.setLocationRelativeTo(null);
					erv.setVisible(true);
					lv.setVisible(false);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(0, 102, 255));
		btnCadastrar.setBounds(456, 390, 184, 45);
		background.add(btnCadastrar);
		lblErro.setVisible(false);
		
		// MARK: ACTIONS
		
		 
		// Method to make screen draggable through a JLabel bar
		draggSecondPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		// Method to make Login
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginController = LoginController.getINSTANCE();
				try {
					boolean check = loginController.verificarLogin(txtSenha.getText(), txtEmail.getText());
				if(check) {
					lblErro.setVisible(false);
					sch = new SchedulingView();
					lv = new LoginView();
					sch.setLocationRelativeTo(null);
					sch.setVisible(true);
					lv.setVisible(false);
					dispose();
				}else {
					lblErro.setVisible(true);
				}
				}catch(Exception err){
					JOptionPane.showMessageDialog(null, "Erro: " + err);
				}
				
			}
		});
		//Method to make close Screen with custom button
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// Method to make Minimize Screen with custom Button
		btnMinimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
	}
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}