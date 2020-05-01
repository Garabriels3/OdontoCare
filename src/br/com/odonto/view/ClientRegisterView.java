package br.com.odonto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.odonto.controller.ClientRegisterController;
import br.com.odonto.model.CepModel;

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
	private LoginView lv;
	String cep;
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
		setBounds(100, 100, 939, 489);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(65, 105, 225), null, new Color(123, 104, 238), new Color(65, 105, 225)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 255));
		panel.setForeground(new Color(0, 102, 255));
		panel.setBounds(0, 0, 30, 489);
		contentPane.add(panel);
		
		JLabel lblNome = new JLabel("NOME COMPLETO");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNome.setBounds(48, 87, 159, 20);
		contentPane.add(lblNome);
		
		txtCPF = new JTextField();
		txtCPF.setForeground(Color.DARK_GRAY);
		txtCPF.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCPF.setColumns(10);
		txtCPF.setCaretColor(SystemColor.textInactiveText);
		txtCPF.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtCPF.setBounds(50, 46, 380, 30);
		contentPane.add(txtCPF);
		
		txtNameComplete = new JTextField();
		txtNameComplete.setForeground(Color.DARK_GRAY);
		txtNameComplete.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNameComplete.setColumns(10);
		txtNameComplete.setCaretColor(SystemColor.textInactiveText);
		txtNameComplete.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtNameComplete.setBounds(50, 112, 380, 30);
		contentPane.add(txtNameComplete);
		
		txtPhone = new JTextField();
		txtPhone.setForeground(Color.DARK_GRAY);
		txtPhone.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setCaretColor(SystemColor.textInactiveText);
		txtPhone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtPhone.setBounds(50, 175, 380, 30);
		contentPane.add(txtPhone);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCpf.setBounds(49, 25, 43, 20);
		contentPane.add(lblCpf);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCelular.setBounds(48, 153, 85, 20);
		contentPane.add(lblCelular);
		
		txtBirthday = new JTextField();
		txtBirthday.setForeground(Color.DARK_GRAY);
		txtBirthday.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtBirthday.setColumns(10);
		txtBirthday.setCaretColor(SystemColor.textInactiveText);
		txtBirthday.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtBirthday.setBounds(50, 241, 380, 30);
		contentPane.add(txtBirthday);
		
		JLabel lblDataDeNascimento = new JLabel("DATA DE NASCIMENTO");
		lblDataDeNascimento.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblDataDeNascimento.setBounds(48, 216, 201, 20);
		contentPane.add(lblDataDeNascimento);
		
		JButton btnClose = new JButton("X");
		
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(0, 102, 255));
		btnClose.setBounds(894, 0, 45, 45);
		contentPane.add(btnClose);
		
		JButton btnMinimize = new JButton("-");
		
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Verdana", Font.PLAIN, 24));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(0, 102, 255));
		btnMinimize.setBounds(849, 0, 45, 45);
		contentPane.add(btnMinimize);
		
		JLabel lblSe = new JLabel("SEXO");
		lblSe.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblSe.setBounds(48, 282, 65, 20);
		contentPane.add(lblSe);
		
		JComboBox cbSex = new JComboBox();
		cbSex.setBackground(new Color(220, 220, 220));
		cbSex.setForeground(new Color(0, 0, 0));
		cbSex.setFont(new Font("Verdana", Font.PLAIN, 14));
		cbSex.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cbSex.setBounds(51, 306, 379, 37);
		contentPane.add(cbSex);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCep.setBounds(522, 39, 43, 20);
		contentPane.add(lblCep);
		
		txtStreet = new JTextField();
		txtStreet.setForeground(Color.DARK_GRAY);
		txtStreet.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		txtStreet.setCaretColor(SystemColor.textInactiveText);
		txtStreet.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtStreet.setBounds(522, 148, 380, 30);
		contentPane.add(txtStreet);
		
		JLabel lblLogradouro = new JLabel("LOGRADOURO");
		lblLogradouro.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblLogradouro.setBounds(522, 117, 127, 20);
		contentPane.add(lblLogradouro);
		
		txtNeighborhood = new JTextField();
		txtNeighborhood.setForeground(Color.DARK_GRAY);
		txtNeighborhood.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNeighborhood.setColumns(10);
		txtNeighborhood.setCaretColor(SystemColor.textInactiveText);
		txtNeighborhood.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtNeighborhood.setBounds(522, 230, 380, 30);
		contentPane.add(txtNeighborhood);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBairro.setBounds(522, 199, 95, 20);
		contentPane.add(lblBairro);
		
		txtCity = new JTextField();
		txtCity.setForeground(Color.DARK_GRAY);
		txtCity.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setCaretColor(SystemColor.textInactiveText);
		txtCity.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtCity.setBounds(522, 293, 380, 30);
		contentPane.add(txtCity);
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCidade.setBounds(522, 271, 95, 20);
		contentPane.add(lblCidade);
		
		txtState = new JTextField();
		txtState.setForeground(Color.DARK_GRAY);
		txtState.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtState.setColumns(10);
		txtState.setCaretColor(SystemColor.textInactiveText);
		txtState.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, new Color(227, 227, 227), null));
		txtState.setBounds(522, 359, 380, 30);
		contentPane.add(txtState);
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEstado.setBounds(522, 334, 95, 20);
		contentPane.add(lblEstado);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(new Color(0, 102, 255));
		btnSalvar.setBounds(48, 365, 184, 40);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(new Color(0, 102, 255));
		btnAlterar.setBounds(246, 365, 184, 40);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Consultar");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(0, 102, 255));
		btnExcluir.setBounds(48, 416, 184, 40);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Excluir");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnConsultar.setBorder(null);
		btnConsultar.setBackground(new Color(0, 102, 255));
		btnConsultar.setBounds(246, 416, 184, 40);
		contentPane.add(btnConsultar);
		
		JPanel draggWindow = new JPanel();
		draggWindow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		draggWindow.setBackground(Color.WHITE);
		draggWindow.setBounds(29, 4, 810, 20);
		contentPane.add(draggWindow);
		
		JButton btnFindCep = new JButton("Buscar Endere\u00E7o");
	
		btnFindCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindCep.setForeground(Color.WHITE);
		btnFindCep.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnFindCep.setBorder(null);
		btnFindCep.setBackground(new Color(0, 102, 255));
		btnFindCep.setBounds(727, 63, 175, 44);
		contentPane.add(btnFindCep);
		
		JFormattedTextField txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtCep.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		txtCep.setToolTipText("");
		txtCep.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCep.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, SystemColor.controlHighlight, null));
		txtCep.setBounds(522, 70, 195, 30);
		

		contentPane.add(txtCep);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crv = new ClientRegisterView();
					lv = new LoginView();
					lv.setLocationRelativeTo(null);
					lv.setVisible(true);
					crv.setVisible(false);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(new Color(0, 102, 255));
		btnVoltar.setBounds(645, 416, 184, 40);
		contentPane.add(btnVoltar);
		
		// MARK: METHODS
		
		// M�todo para Minimizar Janela de forma customizada
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
				Point cordinate = e.getLocationOnScreen();
				setLocation(cordinate);
			}
		});
		
		// Metodo que ao clicar no botao abaixo, retorna nos TextFields, os dados da API(Endere�o)
		btnFindCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientRegisterController controller = new ClientRegisterController();
				 
				cep = txtCep.getText().replace("-", ""); // Pegar o CEP digitado pelo usuario
		try {
			if(!cep.isEmpty() && cep.length() == 8) {
				CepModel data = controller.getAdress(cep); // usamos data aqui tbm para manipular a API, como objeto
			if(data != null){
				txtStreet.setText(data.getLogradouro());  // � Setado cada um dos campos de endere�o, com os dados da API, de forma separada
				txtNeighborhood.setText(data.getBairro());
				txtCity.setText(data.getLocalidade());
				txtState.setText(data.getUf());
				}
			}else {
				JOptionPane.showMessageDialog(null, "CEP n�o encontrado");
			}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Campo CEP est� vazio!");
			}
			}});
	}
}
