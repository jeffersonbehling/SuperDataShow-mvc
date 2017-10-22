package View.Projectors;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import Controller.ProjectorsController;
import Model.Projector;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class add extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnRegisters = new JMenu("Registers");
	private final JLabel lblIcon = new JLabel("");
	private final JLabel lblBrand = new JLabel("Brand");
	private final JTextField txtBrand = new JTextField();
	private final JLabel lblModel = new JLabel("Model");
	private final JTextField txtModel = new JTextField();
	private final JLabel lblAnsiLumens = new JLabel("Ansi Lumens");
	private final JTextField txtAnsiLumens = new JTextField();
	private final JLabel lblProjectorState = new JLabel("Projector State");
	private final JComboBox cbxProjectorState = new JComboBox();
	private final JLabel lblSerialNumber = new JLabel("Serial Number");
	private final JTextField txtSerialNumber = new JTextField();
	private final JLabel lblPurchaseDate = new JLabel("Purchase Date");
	private final JDateChooser txtPurchaseDate = new JDateChooser(new Date());
	private final JLabel lblDateLastLampChange = new JLabel("Date Last Lamp Change");
	private final JDateChooser txtDateLastLampChange = new JDateChooser();
	private final JLabel lblCopyright = new JLabel("Copyright \u00A9 Jefferson Vantuir - All rights reserved");
	private final JButton btnSave = new JButton("  Save");
	private final JLabel lblBrandRequired = new JLabel("*");
	private final JLabel lblModelRequired = new JLabel("*");
	private final JLabel lblSerialNumberRequired = new JLabel("*");
	private final JLabel lblRequiredFields = new JLabel("*");
	private final JLabel lblRequiredFields_1 = new JLabel("Required Fields");

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
	 */
	public add() {
		lblRequiredFields_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblRequiredFields.setForeground(Color.RED);
		lblRequiredFields.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSerialNumberRequired.setForeground(Color.RED);
		lblSerialNumberRequired.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblModelRequired.setForeground(Color.RED);
		lblModelRequired.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblBrandRequired.setForeground(Color.RED);
		lblBrandRequired.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSave.setIcon(new ImageIcon("E:\\Sistemas Git\\Java\\SuperDataShow-mvc\\resource\\img\\save.png"));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setForeground(Color.GRAY);
		lblCopyright.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblDateLastLampChange.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPurchaseDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSerialNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSerialNumber.setColumns(10);
		lblSerialNumber.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbxProjectorState.setModel(new DefaultComboBoxModel(new String[] {"Available", "Maintenance"}));
		cbxProjectorState.setSelectedIndex(0);
		cbxProjectorState.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblProjectorState.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAnsiLumens.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtAnsiLumens.setColumns(10);
		lblAnsiLumens.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtModel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtModel.setColumns(10);
		lblModel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtBrand.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtBrand.setColumns(10);
		lblBrand.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon("E:\\Sistemas Git\\Java\\SuperDataShow-mvc\\resource\\img\\projector.png"));
		
		initComponents();
		actions();
	}
	
	private void initComponents() {
		setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Sistemas Git\\Java\\SuperDataShow-mvc\\resource\\img\\company.png"));
		setResizable(false);
		setTitle("Add Projector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 90, 850, 600);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnRegisters);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtBrand, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBrand)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblBrandRequired))
								.addComponent(txtModel, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
								.addComponent(lblAnsiLumens)
								.addComponent(txtAnsiLumens, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
								.addComponent(lblProjectorState)
								.addComponent(cbxProjectorState, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblModel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblModelRequired, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRequiredFields, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblRequiredFields_1)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(59)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDateLastLampChange, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPurchaseDate, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPurchaseDate)
										.addComponent(lblDateLastLampChange)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnSave)
											.addComponent(txtSerialNumber, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(58)
									.addComponent(lblSerialNumber)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSerialNumberRequired, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCopyright, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 826, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblIcon)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBrand)
								.addComponent(lblBrandRequired))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblModel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModelRequired, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtModel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSerialNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSerialNumberRequired, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSerialNumber, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPurchaseDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPurchaseDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnsiLumens, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateLastLampChange, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtAnsiLumens, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblProjectorState, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbxProjectorState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtDateLastLampChange, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRequiredFields, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRequiredFields_1))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addGap(18)
					.addComponent(lblCopyright, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void actions() {
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtBrand.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Brand is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
					txtBrand.requestFocus();
				} else {
					if (txtModel.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Model is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
						txtModel.requestFocus();
					} else {
						if (txtSerialNumber.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Serial Number is Required", "Required Field", JOptionPane.ERROR_MESSAGE);
							txtSerialNumber.requestFocus();
						} else {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Projector projector = new Projector();
							ProjectorsController projectorsController = new ProjectorsController();
							
							projector.setBrand(txtBrand.getText().toString());
							projector.setModel(txtModel.getText().toString());
							
							if (!txtAnsiLumens.getText().equals("")) {
								projector.setAnsiLumens(Integer.parseInt(txtAnsiLumens.getText().toString()));	
							} else {
								projector.setAnsiLumens(0);
							}
							
							projector.setProjectorState(cbxProjectorState.getSelectedItem().toString());
							projector.setSerialNumber(txtSerialNumber.getText().toString());
							
							if (txtPurchaseDate.getDate() != null) {
								projector.setPurchaseDate(dateFormat.format(txtPurchaseDate.getDate()));
							} else {
								projector.setPurchaseDate(null);
							}
							
							if (txtDateLastLampChange.getDate() != null) {
								projector.setDateLastLampChange(dateFormat.format(txtDateLastLampChange.getDate()));
							} else {
								projector.setDateLastLampChange(null);
							}
							
							if (projectorsController.add(projector)) {
								JOptionPane.showMessageDialog(null, "Projector has been saved", "Successful Registration", JOptionPane.INFORMATION_MESSAGE);
								clearFields();
							} else {
								JOptionPane.showMessageDialog(null, "Projector was not saved. Please, try again", "Failed Registration", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
	}
	
	public void clearFields() {
		txtBrand.setText("");
		txtModel.setText("");
		txtAnsiLumens.setText("");
		cbxProjectorState.setSelectedIndex(0);
		txtSerialNumber.setText("");
		txtPurchaseDate.setDate(new Date());
		txtDateLastLampChange.setDate(null);
	}
}
