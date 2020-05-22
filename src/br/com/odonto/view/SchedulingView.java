package br.com.odonto.view;

//AUTHOR: Gabriel dos Santos(21285136) e Felipe Pereira dos Santos(21192057)
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
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.odonto.controller.SchedulingController;
import br.com.odonto.model.SchedulingModel;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Cursor;

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
	private LoginView loginView;
	private SchedulingView sch;
	private JButton btnCadastroCliente;
	private JButton btnNovoAgendamento;
	private JTable tbScheduling;
	private SchedulingModel clientData;

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
		btnMinimize.setFocusable(false);
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
		btnClose.setFocusable(false);
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
		btnCadastroCliente.setFocusable(false);
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
		btnCadastroCliente.setBounds(595, 115, 184, 45);
		contentPane.add(btnCadastroCliente);
		
		btnNovoAgendamento = new JButton("Marcar Agendamento");
		btnNovoAgendamento.setFocusable(false);
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
		btnNovoAgendamento.setBounds(595, 171, 184, 45);
		contentPane.add(btnNovoAgendamento);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginView = new LoginView();
					sch = new SchedulingView();
					loginView.setLocationRelativeTo(null);
					loginView.setVisible(true);
					sch.setVisible(false);
					dispose();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(0, 102, 255));
		btnLogout.setBounds(595, 390, 184, 45);
		contentPane.add(btnLogout);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setForeground(new Color(128, 128, 128));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(120, 95, 45, 14);
		contentPane.add(lblNome);
		
		JLabel lblDentista = new JLabel("DENTISTA");
		lblDentista.setForeground(new Color(128, 128, 128));
		lblDentista.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDentista.setBounds(316, 95, 69, 14);
		contentPane.add(lblDentista);
		
		JLabel lblData = new JLabel("DATA");
		lblData.setForeground(new Color(128, 128, 128));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblData.setBounds(465, 95, 39, 14);
		contentPane.add(lblData);
		
		JLabel lblHorario = new JLabel("HORARIO");
		lblHorario.setForeground(new Color(128, 128, 128));
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorario.setBounds(514, 95, 74, 14);
		contentPane.add(lblHorario);
		
		tbScheduling = new JTable();
		
		tbScheduling.setSelectionForeground(new Color(255, 255, 255));
		tbScheduling.setSelectionBackground(SystemColor.textHighlight);
		tbScheduling.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tbScheduling.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(240, 248, 255), new Color(0, 0, 205), new Color(0, 0, 139)));
		tbScheduling.setGridColor(new Color(47, 79, 79));
		tbScheduling.setForeground(new Color(0, 0, 0));
		tbScheduling.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbScheduling.getColumnModel().getColumn(0).setResizable(false);
		tbScheduling.getColumnModel().getColumn(0).setPreferredWidth(264);
		tbScheduling.getColumnModel().getColumn(1).setResizable(false);
		tbScheduling.getColumnModel().getColumn(1).setPreferredWidth(209);
		tbScheduling.getColumnModel().getColumn(2).setResizable(false);
		tbScheduling.getColumnModel().getColumn(3).setResizable(false);
		tbScheduling.setBounds(32, 115, 550, 320);
		contentPane.add(tbScheduling);
		
		try {
			readTable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tbScheduling.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SchedulingModel model;
				String clientName = tbScheduling.getValueAt(tbScheduling.getSelectedRow(), 0).toString();
				String clientDentist = tbScheduling.getValueAt(tbScheduling.getSelectedRow(), 1).toString();
				String clientDate = tbScheduling.getValueAt(tbScheduling.getSelectedRow(), 2).toString();
				String clientHour = tbScheduling.getValueAt(tbScheduling.getSelectedRow(), 3).toString();
				
				try {
					model = readTable();
					sch = new SchedulingView();
					nsch = new NewSchedulingView();
					nsch.receiveData(model.getCpf(), clientName, clientDentist, clientDate, clientHour,  model.getDuration(), model.getReason());
					nsch.setLocationRelativeTo(null);
					nsch.setVisible(true);
					sch.setVisible(false);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
	}
	
	public SchedulingModel readTable() throws Exception {
		SchedulingController controller = new SchedulingController();
		DefaultTableModel model = (DefaultTableModel) tbScheduling.getModel();
		model.setNumRows(0);
		for(SchedulingModel client: controller.schedulingListController()) {
			model.addRow(new Object[] {
						client.getName(),
						client.getDentist(),
						client.getDate(),
						client.getSchedule()
				});
			 this.clientData = new SchedulingModel(client.getCpf(), client.getName(), client.getDentist(), client.getDuration(),
					client.getDate(), client.getSchedule(), client.getReason());
		}
		 return clientData;
	}
}
