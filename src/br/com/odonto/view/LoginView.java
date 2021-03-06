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

import br.com.odonto.controller.LoginController;
import br.com.odonto.util.ConnectionFactory;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

// AUTHOR: Gabriel dos Santos Nascimento(21285136)

public class LoginView extends JFrame {
	// MARK: Attributes
	private JPanel background;
	private LoginController loginController;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnCadastrar;
	private ClientRegisterView crv;
	private LoginView loginView;
	private EmployeeRegisterView erv;
	private SchedulingView sch;
	private NewPasswordView npv;
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
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setCaretColor(UIManager.getColor("ComboBox.disabledForeground"));
		txtEmail.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtEmail.setBounds(440, 188, 222, 42);
		background.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnClose = new JButton("X");
		btnClose.setFocusable(false);
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(674, 0, 45, 45);
		background.add(btnClose);
		
		JButton btnMinimize = new JButton("-");
		btnMinimize.setFocusable(false);
		btnMinimize.setForeground(new Color(255, 255, 255));
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(630, 0, 45, 45);
		background.add(btnMinimize);
		
		JLabel lblLogotipo = new JLabel("1");
		lblLogotipo.setLabelFor(background);
		lblLogotipo.setBounds(0, 0, 323, 502);
		lblLogotipo.setIcon(new ImageIcon(LoginView.class.getResource("/images/logoDonto.png")));
		background.add(lblLogotipo);
		
		JButton btnSignUp = new JButton("Login");
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setFocusable(false);
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
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					npv = new NewPasswordView();
					loginView = new LoginView();
					npv.setLocationRelativeTo(null);
					npv.setVisible(true);
					npv.setAlwaysOnTop(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnResetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnResetPassword.setForeground(new Color(51, 51, 255));
		btnResetPassword.setBackground(new Color(255, 255, 255));
		btnResetPassword.setBorder(null);
		btnResetPassword.setBounds(410, 457, 279, 23);
		background.add(btnResetPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPassword.setForeground(UIManager.getColor("ScrollBar.trackHighlightForeground"));
		txtPassword.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtPassword.setBounds(440, 265, 222, 42);
		background.add(txtPassword);

		
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
		
		JLabel lblError = new JLabel("Email ou senha invalidos!");
		lblError.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblError.setForeground(new Color(204, 0, 0));
		lblError.setBounds(440, 112, 257, 14);
		background.add(lblError);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					erv = new EmployeeRegisterView();
					loginView = new LoginView();
					erv.setLocationRelativeTo(null);
					erv.setVisible(true);
					loginView.setVisible(false);
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
		lblError.setVisible(false);
		
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
				boolean success = false;
				loginController = new LoginController();
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				try {
					success = loginController.signIn(email, password);			
				}catch(Exception e2){
				 e2.printStackTrace();
				}
				if(success) {
					sch = new SchedulingView();
					loginView = new LoginView();
					sch.setLocationRelativeTo(null);
					sch.setVisible(true);
					loginView.setVisible(false);
					dispose();
				}else {
					lblError.setVisible(true);
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