package View.Clients;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuItem;
import Model.Client;
import Model.PhysicalPerson;
import Model.JuridicalPerson;
import Controller.StatesController;
import Controller.CitiesController;
import Controller.ClientsController;
import Controller.JuridicalPersonsController;
import Controller.PhysicalPersonsController;

public class add extends JFrame {

	private JPanel contentPane;
	private final JLabel lblImagem = new JLabel("");
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnRegisters = new JMenu("Registers");
	private final JLabel lblClientType = new JLabel("Client Type");
	private final JComboBox cbxClientType = new JComboBox();
	private final JLabel lblName = new JLabel("Name");
	private final JTextField txtName = new JTextField();
	private final JLabel lblCpfCnpj = new JLabel("CPF");
	private JTextField txtCpf;
	private final JLabel lblRg = new JLabel("RG");
	private JTextField txtRg;
	private JTextField txtCnpj;
	private final JLabel lblState = new JLabel("State");
	private final JComboBox cbxState = new JComboBox();
	private final JLabel lblCity = new JLabel("City");
	private final JComboBox cbxCity = new JComboBox();
	private final JLabel lblStreet = new JLabel("Street");
	private final JTextField txtStreet = new JTextField();
	private final JLabel lblEmail = new JLabel("E-mail");
	private final JTextField txtEmail = new JTextField();
	private final JLabel lblTelephone = new JLabel("Telephone");
	private final JTextField txtTelephone = new JTextField();
	private final JLabel lblBirthday = new JLabel("Birthday");
	private final JDateChooser txtBirthday = new JDateChooser();
	private JButton btnSave = new JButton("  Save");
	private JLabel lblCpfCnpjRequired = new JLabel("*");
	private JLabel lblRgRequired = new JLabel("*");
	private JLabel lblNameRequired = new JLabel("*");
	private final JLabel label = new JLabel("Copyright \u00A9 Jefferson Vantuir - All rights reserved");
	private final JLabel lblRequired = new JLabel("*");
	private final JLabel lblRequiredFields = new JLabel("Required Fields");
	
	private StatesController statesController = new StatesController();
	private CitiesController citiesController = new CitiesController();
	private ClientsController clientsController = new ClientsController();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public add() {
		lblRequiredFields.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblRequired.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblRequired.setForeground(Color.RED);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.GRAY);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("resource//img//company.png"));
		lblBirthday.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTelephone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTelephone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTelephone.setColumns(10);
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		lblStreet.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtStreet.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtStreet.setColumns(10);
		cbxCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		cbxState.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblState.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblCpfCnpj.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtName.setColumns(10);
		
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			MaskFormatter maskRg = new MaskFormatter("##########");
			MaskFormatter maskCnpj = new MaskFormatter("##.###.###/####-##");
			txtCpf = new JFormattedTextField(maskCpf);
			txtRg = new JFormattedTextField(maskRg);
			txtCnpj = new JFormattedTextField(maskCnpj);
			txtCnpj.setVisible(false);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		cbxClientType.setModel(new DefaultComboBoxModel(new String[] {"Physical Person", "Juridical Person"}));
		cbxClientType.setSelectedIndex(0);
		cbxClientType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblClientType.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblImagem.setIcon(new ImageIcon("resource//img//users.png"));
		
		initComponents();
		actions();
		fillComboboxStates();
		
	}
	
	private void initComponents() {
		setTitle("Add Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 90, 850, 600);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnRegisters);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSave.setIcon(new ImageIcon("resource//img//save.png"));
		
		
		lblNameRequired.setForeground(Color.RED);
		lblNameRequired.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		lblCpfCnpjRequired.setForeground(Color.RED);
		lblCpfCnpjRequired.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				
		lblRgRequired.setForeground(Color.RED);
		lblRgRequired.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(344)
					.addComponent(lblImagem)
					.addContainerGap(490, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 824, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRequired)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRequiredFields)
							.addGap(796))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStreet)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblName)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNameRequired))
										.addComponent(cbxClientType, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblClientType)
										.addComponent(txtName, 340, 340, 340)
										.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(txtCpf, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblCpfCnpj)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblCpfCnpjRequired, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblRg)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblRgRequired, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE))
													.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(cbxState, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblState))
												.addGap(18)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblCity)
													.addComponent(cbxCity, 0, 0, Short.MAX_VALUE))))
										.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
									.addGap(25)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEmail)
										.addComponent(lblTelephone)
										.addComponent(lblBirthday)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtBirthday, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtTelephone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
									.addGap(76)))
							.addGap(76))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblImagem)
					.addGap(22)
					.addComponent(lblClientType)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbxClientType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(lblEmail)
						.addComponent(lblNameRequired))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblCpfCnpj)
									.addComponent(lblRg))
								.addComponent(lblCpfCnpjRequired, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRgRequired, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblState)
								.addComponent(lblCity))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(cbxState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblStreet))
								.addComponent(cbxCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTelephone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBirthday)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRequired)
						.addComponent(lblRequiredFields)
						.addComponent(btnSave))
					.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
		);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblRg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actions() {
		cbxClientType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbxClientType.getSelectedIndex() == 0) {
					lblImagem.setIcon(new ImageIcon("resource//img//users.png"));
					lblCpfCnpj.setText("CPF");
					txtCnpj.setVisible(false);
					txtCpf.setVisible(true);
					lblRg.setVisible(true);
					txtRg.setVisible(true);
					lblRgRequired.setVisible(true);
					lblBirthday.setVisible(true);
					txtBirthday.setVisible(true);
				} else {
					lblImagem.setIcon(new ImageIcon("resource//img//manufacturer.png"));
					lblCpfCnpj.setText("CNPJ");
					txtCpf.setVisible(false);
					txtCnpj.setVisible(true);
					lblRgRequired.setVisible(false);
					lblRg.setVisible(false);
					txtRg.setVisible(false);
					txtRg.setVisible(false);
					lblBirthday.setVisible(false);
					txtBirthday.setVisible(false);
				}
			}
		});
		
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String domain = new String(txtEmail.getText().substring(txtEmail.getText().lastIndexOf
						('@') + 1, txtEmail.getText().length()));
				
				if (txtEmail.getText().length() > 0 && (!txtEmail.getText().contains("@") || !domain.contains("."))) {
					JOptionPane.showMessageDialog(null, "Invalid email", "Invalid datas", JOptionPane.ERROR_MESSAGE);
					txtEmail.setForeground(Color.RED);
					txtEmail.requestFocus();
				} else {
					txtEmail.setForeground(Color.BLACK);
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = "";
				String rg = "";
				String birthday = null;
				String cnpj = "";
				
				Client client = new Client();
				
				if (txtName.getText().length() == 0) {
					txtName.requestFocus();
					JOptionPane.showMessageDialog(null, "Name is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
				} else {
					if (cbxCity.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null, "Select a City, please", "Field Required", JOptionPane.WARNING_MESSAGE);
						cbxCity.requestFocus();
					} else {
						if (cbxClientType.getSelectedIndex() == 0) {
							cpf = txtCpf.getText().replace(" ", "");
							
							if (cpf.length() != 14) {
								txtCpf.requestFocus();
								JOptionPane.showMessageDialog(null, "CPF is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
							} else {
								cpf = txtCpf.getText().replace(".", "");
								cpf = cpf.replace("-", "");
								rg = txtRg.getText().replace(" ", "");
								
								PhysicalPersonsController physicalPersonsController = new PhysicalPersonsController();
								
								if (physicalPersonsController.cpfIsAlreadyInUse(cpf)) {
									JOptionPane.showMessageDialog(null, "CPF is Already", "CPF is Already", JOptionPane.ERROR_MESSAGE);
									txtCpf.requestFocus();
								} else {
									if (rg.length() != 10) {
										txtRg.requestFocus();
										JOptionPane.showMessageDialog(null, "RG is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
									} else {
										if (physicalPersonsController.rgIsAlreadyInUse(txtRg.getText().toString())) {
											JOptionPane.showMessageDialog(null, "RG is Already", "RG is Already", JOptionPane.ERROR_MESSAGE);
											txtRg.requestFocus();
										} else {
											if (txtBirthday.getDate() != null) {
												SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
												birthday = dateFormat.format(txtBirthday.getDate());
											}
											
											PhysicalPerson physicalPerson = new PhysicalPerson();
											
											String cityName = cbxCity.getSelectedItem().toString();
											int stateId = statesController.getStateIdByName(cbxState.getSelectedItem().toString());
											int cityId = citiesController.getCityIdByName(cityName, stateId);
											
											client.setName(txtName.getText());
											client.setEmail(txtEmail.getText());
											client.setTelephone(txtTelephone.getText());
											client.setStreet(txtStreet.getText());
											client.setCityId(cityId);
											
											physicalPerson.setCpf(cpf);
											physicalPerson.setRg(rg);
											physicalPerson.setBirthday(birthday);
											
											physicalPerson.setId(clientsController.add(client));
											
											if (physicalPersonsController.add(physicalPerson)) {
												JOptionPane.showMessageDialog(null, "Client has been saved", "Successful Registration", JOptionPane.INFORMATION_MESSAGE);
												clearFields();
											} else {
												JOptionPane.showMessageDialog(null, "Client was not saved. Please, try again", "Failed Registration", JOptionPane.ERROR_MESSAGE);
											}
										}
									}
								}
							}
						} else {
							cnpj = txtCnpj.getText().replace(" ", "");
							
							if (cnpj.length() != 18) {
								JOptionPane.showMessageDialog(null, "CNPJ is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
							} else {
								cnpj = cnpj.replace(".", "");
								cnpj = cnpj.replace("/", "");
								cnpj = cnpj.replace("-", "");
							}
														
							JuridicalPersonsController juridicalPersonsController = new JuridicalPersonsController();
							
							if (juridicalPersonsController.cnpjIsAlreadyInUse(cnpj)) {
								JOptionPane.showMessageDialog(null, "CNPJ is Already", "CNPJ is Already", JOptionPane.ERROR_MESSAGE);
								txtCnpj.requestFocus();
							} else {
								JuridicalPerson juridicalPerson = new JuridicalPerson();
								
								String cityName = cbxCity.getSelectedItem().toString();
								int stateId = statesController.getStateIdByName(cbxState.getSelectedItem().toString());
								
								int cityId = citiesController.getCityIdByName(cityName, stateId);
								
								client.setName(txtName.getText());
								client.setEmail(txtEmail.getText());
								client.setTelephone(txtTelephone.getText());
								client.setStreet(txtStreet.getText());
								client.setCityId(cityId);
								
								juridicalPerson.setCnpj(cnpj);
								
								juridicalPerson.setId(clientsController.add(client));
								
								if (juridicalPersonsController.add(juridicalPerson)) {
									JOptionPane.showMessageDialog(null, "Client has been saved", "Successful Registration", JOptionPane.INFORMATION_MESSAGE);
									clearFields();
								} else {
									JOptionPane.showMessageDialog(null, "Client was not saved. Please, try again", "Failed Registration", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}
				}
			}
		});
		
		cbxState.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillComboboxCities();
			}
		});
		
	}
	
	private void fillComboboxStates() {
		ResultSet rs = statesController.states();
		
		try {
			if (rs != null) {
				cbxState.setModel(new DefaultComboBoxModel(new String[] {}));
				int index = 0;
				while (rs.next()) {
					cbxState.insertItemAt(rs.getString("name"), index);
					index++;
				}
			}
			
			cbxState.setSelectedIndex(0);
			
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void fillComboboxCities() {
		int stateId = statesController.getStateIdByName(cbxState.getSelectedItem().toString());
		ResultSet rs = citiesController.cities(stateId);
		
		try {
			if (rs != null) {
				cbxCity.setModel(new DefaultComboBoxModel(new String[] {}));
				int index = 0;
				while (rs.next()) {
					cbxCity.insertItemAt(rs.getString("name"), index);
					index++;
				}
			}
			
			cbxCity.setSelectedIndex(0);
						
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	private void clearFields() {
		cbxClientType.setSelectedIndex(0);
		txtName.setText("");
		txtEmail.setText("");
		txtCnpj.setText("");
		txtCpf.setText("");
		txtRg.setText("");
		txtBirthday.setDate(null);
		txtStreet.setText("");
		txtTelephone.setText("");
		cbxState.setSelectedIndex(0);
		cbxCity.setSelectedIndex(0);
	}
}
