import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
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

public class LoginScreen extends JFrame {

	private JPanel background;
	private JTextField textField;
	private JPasswordField passwordField;
	int mouseX;
	int mouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setBounds(new Rectangle(500, 500, 0, 0));
		setAlwaysOnTop(true);
		setUndecorated(true);
		setForeground(SystemColor.textHighlight);
		setBackground(SystemColor.textHighlight);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 719, 502);
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
		draggScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		draggScreen.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int cordinateX = e.getXOnScreen();
				int cordinateY = e.getXOnScreen();
				
				setLocation(cordinateX - mouseX, cordinateY - mouseY);
			}
		});
		draggScreen.setBounds(0, 0, 300, 44);
		panel.add(draggScreen);
		
		textField = new JTextField();
		textField.setBounds(440, 183, 184, 42);
		background.add(textField);
		textField.setColumns(10);
		
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
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setBounds(440, 322, 184, 45);
		background.add(btnNewButton);
		
		JLabel lblSingUp = new JLabel("Sing Up");
		lblSingUp.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblSingUp.setForeground(new Color(192, 192, 192));
		lblSingUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingUp.setBounds(440, 91, 184, 53);
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
		
		JButton btnCliqueAquiPara = new JButton("Clique aqui para redefinir sua senha!");
		btnCliqueAquiPara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliqueAquiPara.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCliqueAquiPara.setForeground(new Color(51, 51, 255));
		btnCliqueAquiPara.setBackground(new Color(255, 255, 255));
		btnCliqueAquiPara.setBorder(null);
		btnCliqueAquiPara.setBounds(392, 394, 279, 23);
		background.add(btnCliqueAquiPara);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(440, 249, 184, 42);
		background.add(passwordField);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(381, 80, -16, -18);
		background.add(horizontalBox);
		
		// MARK: BUTTONS ACTIONS
		
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
	}
}
