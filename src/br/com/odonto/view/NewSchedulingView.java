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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class NewSchedulingView extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnMinimize;
	private JButton btnClose;
	private JPanel draggWindow;
	private JLabel lblNovoAgendamento;
	private JLabel lblNomeCompleto;
	private JTextField txtNome;
	private JLabel lblData;
	private JTextField textField_1;
	private JLabel lblDuraoDaConsulta;
	private JTextField txtDuracaoConsulta;
	private JTextField txtHorario;
	private JLabel lblHorario;
	private JTextField txtMotivoConsulta;
	private JLabel lblMotivoDaConsulta;
	private JLabel lblDentistaResponsvel;
	private JTextField txtDentista;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnVoltar;
	private NewSchedulingView nsch;
	private SchedulingView sch;
	private int x,y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSchedulingView frame = new NewSchedulingView();
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
	public NewSchedulingView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 436);
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
		draggWindow.setLayout(null);
		draggWindow.setBackground(Color.WHITE);
		draggWindow.setBounds(27, 0, 676, 45);
		contentPane.add(draggWindow);
		
		lblNovoAgendamento = new JLabel("Novo Agendamento");
		lblNovoAgendamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAgendamento.setForeground(Color.LIGHT_GRAY);
		lblNovoAgendamento.setFont(new Font("Verdana", Font.BOLD, 40));
		lblNovoAgendamento.setBackground(Color.WHITE);
		lblNovoAgendamento.setBounds(149, 0, 441, 50);
		draggWindow.add(lblNovoAgendamento);
		
		lblNomeCompleto = new JLabel("NOME COMPLETO");
		lblNomeCompleto.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNomeCompleto.setBounds(41, 56, 132, 20);
		contentPane.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.DARK_GRAY);
		txtNome.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setCaretColor(SystemColor.textInactiveText);
		txtNome.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtNome.setBounds(42, 77, 380, 30);
		contentPane.add(txtNome);
		
		lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblData.setBounds(40, 118, 36, 20);
		contentPane.add(lblData);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setCaretColor(SystemColor.textInactiveText);
		textField_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		textField_1.setBounds(42, 139, 98, 30);
		contentPane.add(textField_1);
		
		lblDuraoDaConsulta = new JLabel("DURA\u00C7\u00C3O DA CONSULTA");
		lblDuraoDaConsulta.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDuraoDaConsulta.setBounds(40, 180, 188, 20);
		contentPane.add(lblDuraoDaConsulta);
		
		txtDuracaoConsulta = new JTextField();
		txtDuracaoConsulta.setForeground(Color.DARK_GRAY);
		txtDuracaoConsulta.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtDuracaoConsulta.setColumns(10);
		txtDuracaoConsulta.setCaretColor(SystemColor.textInactiveText);
		txtDuracaoConsulta.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtDuracaoConsulta.setBounds(42, 201, 98, 30);
		contentPane.add(txtDuracaoConsulta);
		
		txtHorario = new JTextField();
		txtHorario.setForeground(Color.DARK_GRAY);
		txtHorario.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtHorario.setColumns(10);
		txtHorario.setCaretColor(SystemColor.textInactiveText);
		txtHorario.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtHorario.setBounds(245, 139, 98, 30);
		contentPane.add(txtHorario);
		
		lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorario.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblHorario.setBounds(243, 118, 54, 20);
		contentPane.add(lblHorario);
		
		txtMotivoConsulta = new JTextField();
		txtMotivoConsulta.setForeground(Color.DARK_GRAY);
		txtMotivoConsulta.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtMotivoConsulta.setColumns(10);
		txtMotivoConsulta.setCaretColor(SystemColor.textInactiveText);
		txtMotivoConsulta.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtMotivoConsulta.setBounds(247, 201, 175, 30);
		contentPane.add(txtMotivoConsulta);
		
		lblMotivoDaConsulta = new JLabel("MOTIVO DA CONSULTA");
		lblMotivoDaConsulta.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblMotivoDaConsulta.setBounds(245, 180, 175, 20);
		contentPane.add(lblMotivoDaConsulta);
		
		lblDentistaResponsvel = new JLabel("DENTISTA RESPONS\u00C1VEL");
		lblDentistaResponsvel.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDentistaResponsvel.setBounds(40, 242, 189, 20);
		contentPane.add(lblDentistaResponsvel);
		
		txtDentista = new JTextField();
		txtDentista.setForeground(Color.DARK_GRAY);
		txtDentista.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtDentista.setColumns(10);
		txtDentista.setCaretColor(SystemColor.textInactiveText);
		txtDentista.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtDentista.setBounds(42, 263, 380, 30);
		contentPane.add(txtDentista);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setBounds(557, 128, 184, 45);
		contentPane.add(btnSalvar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(0, 102, 255));
		btnExcluir.setBounds(557, 189, 184, 45);
		contentPane.add(btnExcluir);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					nsch = new NewSchedulingView();
					sch = new SchedulingView();
					sch.setLocationRelativeTo(null);
					sch.setVisible(true);
					nsch.setVisible(false);
					dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(0, 102, 255));
		btnVoltar.setBounds(557, 250, 184, 45);
		contentPane.add(btnVoltar);
	}
}
