package br.com.odonto.view;

//AUTHOR: Gabriel dos Santos(21285136) e Felipe Pereira

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.odonto.controller.SchedulingController;
import br.com.odonto.model.SchedulingModel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewSchedulingView extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnMinimize;
	private JButton btnClose;
	private JPanel draggWindow;
	private JLabel lblNovoAgendamento;
	private JLabel lblNomeCompleto;
	private JTextField txtName;
	private JLabel lblData;
	private JTextField txtConsultationDate;
	private JLabel lblDuraoDaConsulta;
	private JTextField txtConsultationDuration;
	private JTextField txtConsultationSchedule;
	private JLabel lblHorario;
	private JTextField txtConsultationReason;
	private JLabel lblMotivoDaConsulta;
	private JLabel lblDentistaResponsvel;
	private JButton btnVoltar;
	private NewSchedulingView nsch;
	private SchedulingView sch;
	private SchedulingController schedulingController = new SchedulingController();
	private SchedulingModel schedulingModel;
	private int x,y;
	private JComboBox cbDentists;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnSalvar;
	private JLabel lblCpf;
	private JTextField txtCPF;
	private JButton btnBuscarCliente;
	private JLabel lblResultado;
	private String clientCPF;
	private String clientName;
	private String clientDentist;
	private String clientDate;
	private String clientHours;
	private String clientReason;
	private String clientDuration;

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
		setBounds(100, 100, 758, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(4, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 102, 255));
		panel.setBackground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 30, 457);
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
		btnMinimize.setBounds(668, 0, 45, 45);
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
		btnClose.setBounds(713, 0, 45, 45);
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
		draggWindow.setBounds(0, 0, 669, 45);
		contentPane.add(draggWindow);
		
		lblNovoAgendamento = new JLabel("Novo Agendamento");
		lblNovoAgendamento.setBounds(30, 0, 639, 45);
		draggWindow.add(lblNovoAgendamento);
		lblNovoAgendamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAgendamento.setForeground(Color.LIGHT_GRAY);
		lblNovoAgendamento.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNovoAgendamento.setBackground(Color.WHITE);
		
		lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCompleto.setBounds(41, 135, 132, 20);
		contentPane.add(lblNomeCompleto);
		
		txtName = new JTextField();
		txtName.setForeground(Color.DARK_GRAY);
		txtName.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setCaretColor(SystemColor.textInactiveText);
		txtName.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtName.setBounds(42, 156, 380, 30);
		contentPane.add(txtName);
		
		lblData = new JLabel("Data");
		lblData.setForeground(Color.BLACK);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(322, 197, 41, 20);
		contentPane.add(lblData);
		
		txtConsultationDate = new JTextField();
		txtConsultationDate.setForeground(Color.DARK_GRAY);
		txtConsultationDate.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtConsultationDate.setColumns(10);
		txtConsultationDate.setCaretColor(SystemColor.textInactiveText);
		txtConsultationDate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtConsultationDate.setBounds(324, 218, 98, 30);
		contentPane.add(txtConsultationDate);
		
		lblDuraoDaConsulta = new JLabel("Dura\u00E7\u00E3o da Consulta");
		lblDuraoDaConsulta.setForeground(Color.BLACK);
		lblDuraoDaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDuraoDaConsulta.setBounds(40, 197, 188, 20);
		contentPane.add(lblDuraoDaConsulta);
		
		txtConsultationDuration = new JTextField();
		txtConsultationDuration.setForeground(Color.DARK_GRAY);
		txtConsultationDuration.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtConsultationDuration.setColumns(10);
		txtConsultationDuration.setCaretColor(SystemColor.textInactiveText);
		txtConsultationDuration.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtConsultationDuration.setBounds(42, 218, 144, 30);
		contentPane.add(txtConsultationDuration);
		
		txtConsultationSchedule = new JTextField();
		txtConsultationSchedule.setForeground(Color.DARK_GRAY);
		txtConsultationSchedule.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtConsultationSchedule.setColumns(10);
		txtConsultationSchedule.setCaretColor(SystemColor.textInactiveText);
		txtConsultationSchedule.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtConsultationSchedule.setBounds(497, 218, 98, 30);
		contentPane.add(txtConsultationSchedule);
		
		lblHorario = new JLabel("Hor\u00E1rio");
		lblHorario.setForeground(Color.BLACK);
		lblHorario.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHorario.setBounds(495, 197, 71, 20);
		contentPane.add(lblHorario);
		
		txtConsultationReason = new JTextField();
		txtConsultationReason.setForeground(Color.DARK_GRAY);
		txtConsultationReason.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtConsultationReason.setColumns(10);
		txtConsultationReason.setCaretColor(SystemColor.textInactiveText);
		txtConsultationReason.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtConsultationReason.setBounds(495, 280, 240, 30);
		contentPane.add(txtConsultationReason);
		
		lblMotivoDaConsulta = new JLabel("Motivo da Consulta");
		lblMotivoDaConsulta.setForeground(Color.BLACK);
		lblMotivoDaConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotivoDaConsulta.setBounds(495, 254, 175, 20);
		contentPane.add(lblMotivoDaConsulta);
		
		lblDentistaResponsvel = new JLabel("Dentista Respons\u00E1vel");
		lblDentistaResponsvel.setForeground(Color.BLACK);
		lblDentistaResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDentistaResponsvel.setBounds(40, 259, 189, 20);
		contentPane.add(lblDentistaResponsvel);

		lblResultado = new JLabel("New label");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblResultado.setForeground(new Color(204, 0, 0));
		lblResultado.setBounds(432, 405, 326, 27);
		lblResultado.setVisible(false);
		contentPane.add(lblResultado);
		
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
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(0, 102, 255));
		btnVoltar.setBounds(509, 358, 184, 40);
		contentPane.add(btnVoltar);
		
		cbDentists = new JComboBox();
		cbDentists.setModel(new DefaultComboBoxModel(new String[] {"Selecione um Dentista", "Juliana Almeida", "Theodoro Neves"}));
		cbDentists.setBorder(null);
		cbDentists.setBackground(Color.WHITE);
		cbDentists.setBounds(40, 280, 376, 30);
		contentPane.add(cbDentists);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				String cpf = txtCPF.getText();
				String date = txtConsultationDate.getText();
				try {
					success = schedulingController.excludeConsultation(cpf, date);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {
					lblResultado.setText("Consulta excluida com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
					txtName.setText(null);
					txtConsultationDuration.setText(null);
					txtConsultationSchedule.setText(null);
					txtConsultationDate.setText(null);
					cbDentists.setSelectedIndex(0);
					txtConsultationReason.setText(null);
				}else {
					lblResultado.setText("Erro ao excluir a consulta");
					lblResultado.setVisible(true);
				}
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(0, 102, 255));
		btnExcluir.setBounds(40, 392, 184, 40);
		contentPane.add(btnExcluir);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedulingModel = null;
				String cpf = txtCPF.getText();
				String date = txtConsultationDate.getText();
				try {
					schedulingModel = schedulingController.querySchedulingData(cpf, date);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(schedulingModel != null) {
					txtConsultationDuration.setText(schedulingModel.getDuration());
					txtConsultationSchedule.setText(schedulingModel.getSchedule());
					txtConsultationReason.setText(schedulingModel.getReason());
					cbDentists.setSelectedItem(schedulingModel.getDentist());
					
				}else {
					lblResultado.setText("Erro aos consultar o agendamento");
					lblResultado.setVisible(true);
				}
			}
		});
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(0, 102, 255));
		btnConsultar.setBounds(238, 392, 184, 40);
		contentPane.add(btnConsultar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				String cpf = txtCPF.getText();
				String duration = txtConsultationDuration.getText();
				String schedule = txtConsultationSchedule.getText();
				String date = txtConsultationDate.getText();
				String dentist = String.valueOf(cbDentists.getSelectedItem());
				String reason = txtConsultationReason.getText();
				try {
					success = schedulingController.updateConsultationData(cpf, duration, schedule, date, dentist, reason);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {
					lblResultado.setText("Agendamento atualizado com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
					txtName.setText(null);
					txtConsultationDuration.setText(null);
					txtConsultationSchedule.setText(null);
					txtConsultationDate.setText(null);
					cbDentists.setSelectedIndex(0);
					txtConsultationReason.setText(null);
				}else {
					lblResultado.setText("Erro ao atualizar agendamento");
					lblResultado.setVisible(true);
				}
			}
		});
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(0, 102, 255));
		btnAlterar.setBounds(238, 341, 184, 40);
		contentPane.add(btnAlterar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				String cpf = txtCPF.getText();
				String duration = txtConsultationDuration.getText();
				String schedule = txtConsultationSchedule.getText();
				String date = txtConsultationDate.getText();
				String dentist = String.valueOf(cbDentists.getSelectedItem());
				String reason = txtConsultationReason.getText();
				try {
					success = schedulingController.saveConsultationData(cpf, duration, schedule, date, dentist, reason);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {
					lblResultado.setText("Agendamento realizado com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
					txtName.setText(null);
					txtConsultationDuration.setText(null);
					txtConsultationSchedule.setText(null);
					txtConsultationDate.setText(null);
					cbDentists.setSelectedIndex(0);
					txtConsultationReason.setText(null);
				}else {
					lblResultado.setText("Erro ao fazer o agendamento");
					lblResultado.setVisible(true);
				}
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setBounds(40, 341, 184, 40);
		contentPane.add(btnSalvar);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(40, 66, 41, 20);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(Color.DARK_GRAY);
		txtCPF.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCPF.setBounds(42, 87, 379, 30);
		contentPane.add(txtCPF);
		
		btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = null , cpf = txtCPF.getText();
				try {
					name = schedulingController.queryClientName(cpf);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(name != null) {
					txtName.setText(name);
				}else {
					lblResultado.setText("Cliente não encontrado");
					lblResultado.setVisible(true);
				}
			}
		});
		btnBuscarCliente.setForeground(Color.WHITE);
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarCliente.setBorder(null);
		btnBuscarCliente.setBackground(new Color(0, 102, 255));
		btnBuscarCliente.setBounds(434, 80, 175, 44);
		contentPane.add(btnBuscarCliente);
		
	}
	
	public void receiveData(String CPF, String name, String dentist, String date, String hour, String duration, String reason) {
		this.clientCPF = CPF;
		this.clientName = name;
		this.clientDentist = dentist;
		this.clientDate = date;
		this.clientHours = hour;
		this.clientDuration = duration;
		this.clientReason = reason;
		txtCPF.setText(clientCPF);
		txtName.setText(clientName);
		txtConsultationDate.setText(clientDate);
		txtConsultationDuration.setText(clientDuration);
		txtConsultationSchedule.setText(clientHours);
		txtConsultationReason.setText(clientReason);
		cbDentists.setSelectedItem(clientDentist);
		System.out.println(CPF + name + dentist);

	}
}

