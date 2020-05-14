package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class SchedulingView extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnMinimize;
	private JButton btnClose;
	private JPanel draggWindow;
	private JLabel lblAgendamentos;
	private int x,y;
	private NewSchedulingView nsch;
	private ClientRegisterView crv;
	private SchedulingView sch;
	private JButton btnCadastroCliente;
	private JButton btnNovoAgendamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchedulingView frame = new SchedulingView();
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
	public SchedulingView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 30, 435);
		panel.setForeground(new Color(0, 102, 255));
		panel.setBackground(new Color(0, 102, 255));
		contentPane.add(panel);
		
		btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setBounds(703, 0, 45, 45);
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		contentPane.add(btnMinimize);
		
		btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(748, 0, 45, 45);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		contentPane.add(btnClose);
		
		draggWindow = new JPanel();
		draggWindow.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		draggWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		draggWindow.setBounds(0, 0, 705, 45);
		draggWindow.setLayout(null);
		draggWindow.setBackground(Color.WHITE);
		contentPane.add(draggWindow);
		
		lblAgendamentos = new JLabel("Agendamentos");
		lblAgendamentos.setBounds(226, 0, 337, 45);
		draggWindow.add(lblAgendamentos);
		lblAgendamentos.setBackground(Color.WHITE);
		lblAgendamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendamentos.setForeground(Color.LIGHT_GRAY);
		lblAgendamentos.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		btnCadastroCliente = new JButton("Cadastrar Cliente");
		btnCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crv = new ClientRegisterView();
					sch = new SchedulingView();
					crv.setLocationRelativeTo(null);
					crv.setVisible(true);
					sch.setVisible(false);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastroCliente.setForeground(Color.WHITE);
		btnCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastroCliente.setBorder(null);
		btnCadastroCliente.setBackground(new Color(0, 102, 255));
		btnCadastroCliente.setBounds(584, 71, 184, 45);
		contentPane.add(btnCadastroCliente);
		
		btnNovoAgendamento = new JButton("Marcar Agendamento");
		btnNovoAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nsch = new NewSchedulingView();
					sch = new SchedulingView();
					nsch.setLocationRelativeTo(null);
					nsch.setVisible(true);
					sch.setVisible(false);
					dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNovoAgendamento.setForeground(Color.WHITE);
		btnNovoAgendamento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovoAgendamento.setBorder(null);
		btnNovoAgendamento.setBackground(new Color(0, 102, 255));
		btnNovoAgendamento.setBounds(584, 132, 184, 45);
		contentPane.add(btnNovoAgendamento);
	}
}
