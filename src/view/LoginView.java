package view;
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
import javax.swing.UIManager;

public class LoginView extends JFrame {
	// MARK: Attributes
	private JPanel background;
	private JTextField emailTextField;
	private JPasswordField passwordTextField;

	
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
		background.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(100, 149, 237), new Color(100, 149, 237), new Color(0, 0, 0), new Color(169, 169, 169)));
		setContentPane(background);
		background.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 365, 502);
		background.add(panel);
		panel.setLayout(null);
		
		JLabel draggScreen = new JLabel("");
		draggScreen.setHorizontalAlignment(SwingConstants.CENTER);
		draggScreen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		draggScreen.setBounds(0, 0, 365, 44);
		panel.add(draggScreen);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		emailTextField.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		emailTextField.setCaretColor(UIManager.getColor("ComboBox.disabledForeground"));
		emailTextField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		emailTextField.setBounds(440, 183, 222, 42);
		background.add(emailTextField);
		emailTextField.setColumns(10);
		
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
		btnSignUp.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(0, 102, 255));
		btnSignUp.setBounds(456, 319, 184, 45);
		background.add(btnSignUp);
		
		JLabel lblSingUp = new JLabel("Sing Up");
		lblSingUp.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblSingUp.setForeground(new Color(192, 192, 192));
		lblSingUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingUp.setBounds(456, 90, 184, 53);
		background.add(lblSingUp);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel.setBounds(440, 168, 46, 14);
		background.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.LIGHT_GRAY);
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblSenha.setBounds(440, 235, 46, 14);
		background.add(lblSenha);
		
		JButton btnResetPassword = new JButton("Clique aqui para redefinir sua senha!");
		btnResetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResetPassword.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnResetPassword.setForeground(new Color(51, 51, 255));
		btnResetPassword.setBackground(new Color(255, 255, 255));
		btnResetPassword.setBorder(null);
		btnResetPassword.setBounds(410, 417, 279, 23);
		background.add(btnResetPassword);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordTextField.setForeground(UIManager.getColor("ScrollBar.trackHighlightForeground"));
		passwordTextField.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		passwordTextField.setBounds(440, 249, 222, 42);
		background.add(passwordTextField);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(381, 80, -16, -18);
		background.add(horizontalBox);
		
		JPanel draggSecondPanel = new JPanel();
		draggSecondPanel.setBackground(Color.WHITE);
		draggSecondPanel.setBounds(362, 0, 269, 45);
		background.add(draggSecondPanel);
		
		// MARK: ACTIONS
		
		 
		// Method to make screen draggable through a JLabel bar
		draggSecondPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point cordinate = e.getLocationOnScreen();
				setLocation(cordinate);
			}
		});
		draggScreen.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point cordinate = e.getLocationOnScreen();
				setLocation(cordinate);
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

	public static void main(String[] args) {
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