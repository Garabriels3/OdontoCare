package br.com.odonto.view;

//Author: Felipe Pereira dos Santos(21192057)
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odonto.controller.ClientController;
import br.com.odonto.controller.EmployeeController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteEmployeeView extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCpf;
	private JTextField txtCPF;
	private JPanel draggSecondPanel;
	private JButton btnMinimize;
	private JButton btnClose;
	private JButton btnAlterar;
	private JLabel lblResultado;
	private EmployeeController employeeController;
	private int x,y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployeeView frame = new DeleteEmployeeView();
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
	public DeleteEmployeeView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 194);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 20, 204);
		contentPane.add(panel);
		
		lblResultado = new JLabel("New label");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblResultado.setForeground(new Color(204, 0, 0));
		lblResultado.setBounds(20, 166, 276, 14);
		contentPane.add(lblResultado);
		lblResultado.setVisible(false);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(48, 49, 37, 17);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(Color.DARK_GRAY);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCPF.setBounds(48, 67, 222, 42);
		contentPane.add(txtCPF);
		
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
		draggSecondPanel.setLayout(null);
		draggSecondPanel.setBackground(Color.WHITE);
		draggSecondPanel.setBounds(0, 0, 208, 45);
		contentPane.add(draggSecondPanel);
		
		btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setFocusable(false);
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(207, 0, 45, 45);
		contentPane.add(btnMinimize);
		
		btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setFocusable(false);
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(251, 0, 45, 45);
		contentPane.add(btnClose);
		
		btnAlterar = new JButton("Excluir");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				String cpf = txtCPF.getText();
				employeeController = new EmployeeController();
				try {
					success = employeeController.excludeEmployeeData(cpf);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {
					lblResultado.setText("Funcionário excluido com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
				}else {
					lblResultado.setText("Erro ao excluir o funcionário");
					lblResultado.setVisible(true);
				}
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setFocusable(false);
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(0, 102, 255));
		btnAlterar.setBounds(68, 124, 184, 31);
		contentPane.add(btnAlterar);
		
	}
}
