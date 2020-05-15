package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.odonto.controller.ClientRegisterController;
import br.com.odonto.model.CepModel;
import br.com.odonto.model.ClientRegisterModel;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ClientRegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtNameComplete;
	private JTextField txtPhone;
	private JTextField txtBirthday;
	private JTextField txtNeighborhood;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtStreet;
	private ClientRegisterView crv;
	private ClientRegisterController clientRegisterController;
	private ClientRegisterModel client;
	private SchedulingView sch;
	private int x,y;
	String cep;
	private JLabel lblResultado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientRegisterView frame = new ClientRegisterView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public ClientRegisterView() throws ParseException {
		setForeground(new Color(65, 105, 225));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 500);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setForeground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 30, 500);
		contentPane.add(panel);
		
		JLabel lblNome = new JLabel("Nome Completo");
		lblNome.setForeground(Color.BLACK);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(59, 118, 159, 20);
		contentPane.add(lblNome);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(UIManager.getColor("SplitPaneDivider.draggingColor"));
		txtCPF.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCPF.setBounds(61, 77, 380, 30);
		contentPane.add(txtCPF);
		
		txtNameComplete = new JTextField();
		txtNameComplete.setForeground(Color.DARK_GRAY);
		txtNameComplete.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNameComplete.setColumns(10);
		txtNameComplete.setCaretColor(SystemColor.textInactiveText);
		txtNameComplete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtNameComplete.setBounds(61, 139, 380, 30);
		contentPane.add(txtNameComplete);
		
		txtPhone = new JTextField();
		txtPhone.setForeground(Color.DARK_GRAY);
		txtPhone.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setCaretColor(SystemColor.textInactiveText);
		txtPhone.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtPhone.setBounds(61, 201, 380, 30);
		contentPane.add(txtPhone);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(60, 56, 43, 20);
		contentPane.add(lblCpf);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCelular.setBounds(59, 180, 85, 20);
		contentPane.add(lblCelular);
		
		txtBirthday = new JTextField();
		txtBirthday.setForeground(Color.DARK_GRAY);
		txtBirthday.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtBirthday.setColumns(10);
		txtBirthday.setCaretColor(SystemColor.textInactiveText);
		txtBirthday.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtBirthday.setBounds(61, 263, 380, 30);
		contentPane.add(txtBirthday);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setForeground(Color.BLACK);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(59, 242, 201, 20);
		contentPane.add(lblDataDeNascimento);
		
		JButton btnClose = new JButton("X");
		
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(898, 0, 45, 45);
		contentPane.add(btnClose);
		
		JButton btnMinimize = new JButton("-");
		
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(853, 0, 45, 45);
		contentPane.add(btnMinimize);
		
		JLabel lblSe = new JLabel("Sexo");
		lblSe.setForeground(Color.BLACK);
		lblSe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSe.setBounds(59, 304, 65, 20);
		contentPane.add(lblSe);
		
		JComboBox cbSex = new JComboBox();
		cbSex.setBorder(null);
		cbSex.setBackground(Color.WHITE);
		cbSex.setForeground(Color.BLACK);
		cbSex.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbSex.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cbSex.setBounds(62, 325, 379, 37);
		contentPane.add(cbSex);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setForeground(Color.BLACK);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCep.setBounds(533, 56, 43, 20);
		contentPane.add(lblCep);
		
		txtStreet = new JTextField();
		txtStreet.setForeground(Color.DARK_GRAY);
		txtStreet.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		txtStreet.setCaretColor(SystemColor.textInactiveText);
		txtStreet.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtStreet.setBounds(533, 139, 380, 30);
		contentPane.add(txtStreet);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setForeground(Color.BLACK);
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogradouro.setBounds(533, 118, 127, 20);
		contentPane.add(lblLogradouro);
		
		txtNeighborhood = new JTextField();
		txtNeighborhood.setForeground(Color.DARK_GRAY);
		txtNeighborhood.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNeighborhood.setColumns(10);
		txtNeighborhood.setCaretColor(SystemColor.textInactiveText);
		txtNeighborhood.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtNeighborhood.setBounds(533, 201, 380, 30);
		contentPane.add(txtNeighborhood);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(Color.BLACK);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBairro.setBounds(533, 180, 95, 20);
		contentPane.add(lblBairro);
		
		txtCity = new JTextField();
		txtCity.setForeground(Color.DARK_GRAY);
		txtCity.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setCaretColor(SystemColor.textInactiveText);
		txtCity.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCity.setBounds(533, 263, 380, 30);
		contentPane.add(txtCity);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(533, 242, 95, 20);
		contentPane.add(lblCidade);
		
		txtState = new JTextField();
		txtState.setForeground(Color.DARK_GRAY);
		txtState.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtState.setColumns(10);
		txtState.setCaretColor(SystemColor.textInactiveText);
		txtState.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtState.setBounds(533, 325, 380, 30);
		contentPane.add(txtState);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(533, 304, 95, 20);
		contentPane.add(lblEstado);
		
		JFormattedTextField txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtCep.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		txtCep.setToolTipText("");
		txtCep.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCep.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, UIManager.getColor("Button.light"), null));
		txtCep.setBounds(533, 79, 195, 30);
		

		contentPane.add(txtCep);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				clientRegisterController = new ClientRegisterController();
				String cpf = txtCPF.getText();
				String name = txtNameComplete.getText();
				String phone = txtPhone.getText();
				String birthday = txtBirthday.getText();
				String sex = String.valueOf(cbSex.getSelectedItem());
				String cep = txtCep.getText();
				String street = txtStreet.getText();
				String neighborhood = txtNeighborhood.getText();
				String city = txtCity.getText();
				String state = txtState.getText();
				try {
					success = clientRegisterController.saveClientData(cpf, name, phone, birthday, sex, cep, street, neighborhood, city, state);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {
					lblResultado.setText("Dados salvos com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
					txtNameComplete.setText(null);
					txtPhone.setText(null);
					txtBirthday.setText(null);
					cbSex.setSelectedIndex(0);
					txtCep.setText(null);
					txtStreet.setText(null);
					txtNeighborhood.setText(null);
					txtCity.setText(null);
					txtState.setText(null);
				}else {
					lblResultado.setText("Erro ao salvar os dados");
					lblResultado.setVisible(true);
				}
			}
		});
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setBounds(59, 391, 184, 40);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
				clientRegisterController = new ClientRegisterController();
				String cpf = txtCPF.getText();
				String name = txtNameComplete.getText();
				String phone = txtPhone.getText();
				String birthday = txtBirthday.getText();
				String sex = String.valueOf(cbSex.getSelectedItem());
				String cep = txtCep.getText();
				String street = txtStreet.getText();
				String neighborhood = txtNeighborhood.getText();
				String city = txtCity.getText();
				String state = txtState.getText();
				try {
					success = clientRegisterController.updateClientData(cpf, name, phone, birthday, sex, cep, street, neighborhood, city, state);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(success) {
					lblResultado.setText("Dados alterados com sucesso");
					lblResultado.setVisible(true);
					txtCPF.setText(null);
					txtNameComplete.setText(null);
					txtPhone.setText(null);
					txtBirthday.setText(null);
					cbSex.setSelectedIndex(0);
					txtCep.setText(null);
					txtStreet.setText(null);
					txtNeighborhood.setText(null);
					txtCity.setText(null);
					txtState.setText(null);
				}else {
					lblResultado.setText("Erro ao alterar os dados");
					lblResultado.setVisible(true);
				}
			}
		});
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(0, 102, 255));
		btnAlterar.setBounds(257, 391, 184, 40);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(0, 102, 255));
		btnExcluir.setBounds(59, 442, 184, 40);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientRegisterController = new ClientRegisterController();
				String cpf = txtCPF.getText();
				try {
					client = clientRegisterController.consultClientData(cpf);
					txtNameComplete.setText(client.getName());
					txtPhone.setText(client.getPhone());
					txtBirthday.setText(client.getBirthday());
					cbSex.setSelectedItem(client.getSex());
					txtCep.setText(client.getCep());
					txtStreet.setText(client.getStreet());
					txtNeighborhood.setText(client.getNeighborhood());
					txtCity.setText(client.getCity());
					txtState.setText(client.getState());
				} catch (Exception e2) {
					lblResultado.setText("Erro ao consultar os dados");
					lblResultado.setVisible(true);
					e2.printStackTrace();
				}
			}
		});
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(0, 102, 255));
		btnConsultar.setBounds(257, 442, 184, 40);
		contentPane.add(btnConsultar);
		
		JPanel draggWindow = new JPanel();
		draggWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		draggWindow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		draggWindow.setBackground(Color.WHITE);
		draggWindow.setBounds(0, 0, 855, 45);
		contentPane.add(draggWindow);
		draggWindow.setLayout(null);
		
		JLabel lblCadastrar = new JLabel("Sign Up");
		lblCadastrar.setBounds(0, 0, 855, 44);
		draggWindow.add(lblCadastrar);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setForeground(Color.LIGHT_GRAY);
		lblCadastrar.setFont(new Font("Verdana", Font.BOLD, 30));
		
		JButton btnFindCep = new JButton("Buscar Endere\u00E7o");
	
		btnFindCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindCep.setForeground(Color.WHITE);
		btnFindCep.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFindCep.setBorder(null);
		btnFindCep.setBackground(new Color(0, 102, 255));
		btnFindCep.setBounds(738, 69, 175, 44);
		contentPane.add(btnFindCep);
				
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crv = new ClientRegisterView();
					sch = new SchedulingView();
					sch.setLocationRelativeTo(null);
					sch.setVisible(true);
					crv.setVisible(false);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(0, 102, 255));
		btnVoltar.setBounds(633, 408, 184, 40);
		contentPane.add(btnVoltar);
		
		lblResultado = new JLabel("New label");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(533, 459, 380, 30);
		lblResultado.setVisible(false);
		contentPane.add(lblResultado);
		
		// MARK: METHODS
		
		// Método para Minimizar Janela de forma customizada
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		
		// Metodo para fechar Janela de forma customizada
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// Metodo para tornar janela arrastavel de forma customizada
		draggWindow.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		
		// Metodo que ao clicar no botao abaixo, retorna nos TextFields, os dados da API(Endereço)
		btnFindCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientRegisterController controller = new ClientRegisterController();
				 
				cep = txtCep.getText().replace("-", ""); // Pegar o CEP digitado pelo usuario
		try {
			if(!cep.isEmpty() && cep.length() == 8) {
				CepModel data = controller.getAdress(cep); // usamos data aqui tbm para manipular a API, como objeto
			if(data != null){
				txtStreet.setText(data.getLogradouro());  // É Setado cada um dos campos de endereço, com os dados da API, de forma separada
				txtNeighborhood.setText(data.getBairro());
				txtCity.setText(data.getLocalidade());
				txtState.setText(data.getUf());
				}
			}else {
				JOptionPane.showMessageDialog(null, "CEP não encontrado");
			}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Campo CEP está vazio!");
			}
			}});
	}
}
