//package view;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JSplitPane;
//import java.awt.BorderLayout;
//import javax.swing.JInternalFrame;
//import javax.swing.JPanel;
//import java.awt.GridLayout;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import javax.swing.BoxLayout;
//import javax.swing.SpringLayout;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import java.awt.Font;
//import javax.swing.JSeparator;
//import java.awt.Color;
//import javax.swing.JTextField;
//import javax.swing.JFormattedTextField;
//import javax.swing.JButton;
//import java.awt.SystemColor;
//
//public class view_login {
//
//	private JFrame frmLogin;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					view_login window = new view_login();
//					window.frmLogin.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public view_login() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frmLogin = new JFrame();
//		frmLogin.getContentPane().setBackground(SystemColor.activeCaption);
//		frmLogin.setTitle("Login");
//		frmLogin.setResizable(false);
//		frmLogin.setBounds(100, 100, 593, 401);
//		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(SystemColor.activeCaption);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(SystemColor.activeCaption);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("Cadastrar");
//		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		
//		JPanel panel_2_1 = new JPanel();
//		SpringLayout sl_panel_2_1 = new SpringLayout();
//		panel_2_1.setLayout(sl_panel_2_1);
//		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
//		gl_panel_1.setHorizontalGroup(
//			gl_panel_1.createParallelGroup(Alignment.TRAILING)
//				.addGroup(gl_panel_1.createSequentialGroup()
//					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
//					.addGap(2))
//				.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
//		);
//		gl_panel_1.setVerticalGroup(
//			gl_panel_1.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_panel_1.createSequentialGroup()
//					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
//					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
//		);
//		
//		JLabel lblNewLabel_2_1 = new JLabel("CPF");
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2_1, 31, SpringLayout.NORTH, panel_2_1);
//		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		panel_2_1.add(lblNewLabel_2_1);
//		
//		textField_2 = new JTextField();
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, lblNewLabel_2_1, -6, SpringLayout.WEST, textField_2);
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, textField_2, -99, SpringLayout.EAST, panel_2_1);
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, textField_2, 30, SpringLayout.NORTH, panel_2_1);
//		sl_panel_2_1.putConstraint(SpringLayout.WEST, textField_2, 91, SpringLayout.WEST, panel_2_1);
//		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		textField_2.setColumns(10);
//		panel_2_1.add(textField_2);
//		
//		JLabel lblNewLabel_3 = new JLabel("Senha");
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 7, SpringLayout.SOUTH, lblNewLabel_2_1);
//		sl_panel_2_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 47, SpringLayout.WEST, panel_2_1);
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_2_1);
//		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		panel_2_1.add(lblNewLabel_3);
//		
//		textField_3 = new JTextField();
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, textField_3, 3, SpringLayout.SOUTH, textField_2);
//		sl_panel_2_1.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblNewLabel_3);
//		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		textField_3.setColumns(10);
//		panel_2_1.add(textField_3);
//		
//		JLabel lblNewLabel_3_1 = new JLabel("Conf. senha");
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3_1, 11, SpringLayout.SOUTH, lblNewLabel_3);
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, lblNewLabel_3_1, 0, SpringLayout.EAST, lblNewLabel_2_1);
//		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		panel_2_1.add(lblNewLabel_3_1);
//		
//		textField_4 = new JTextField();
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, textField_4, 6, SpringLayout.SOUTH, textField_3);
//		sl_panel_2_1.putConstraint(SpringLayout.WEST, textField_4, 6, SpringLayout.EAST, lblNewLabel_3_1);
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, textField_4, -99, SpringLayout.EAST, panel_2_1);
//		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		textField_4.setColumns(10);
//		panel_2_1.add(textField_4);
//		
//		JButton btnNewButton_1 = new JButton("Entrar");
//		sl_panel_2_1.putConstraint(SpringLayout.WEST, btnNewButton_1, 91, SpringLayout.WEST, panel_2_1);
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, btnNewButton_1, -91, SpringLayout.EAST, panel_2_1);
//		panel_2_1.add(btnNewButton_1);
//		
//		JLabel lblNewLabel_4_1 = new JLabel("Feedback");
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4_1, 4, SpringLayout.SOUTH, textField_4);
//		sl_panel_2_1.putConstraint(SpringLayout.NORTH, btnNewButton_1, 5, SpringLayout.SOUTH, lblNewLabel_4_1);
//		sl_panel_2_1.putConstraint(SpringLayout.EAST, lblNewLabel_4_1, -120, SpringLayout.EAST, panel_2_1);
//		panel_2_1.add(lblNewLabel_4_1);
//		panel_1.setLayout(gl_panel_1);
//		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
//		groupLayout.setHorizontalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addGroup(groupLayout.createSequentialGroup()
//					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//					.addGap(2))
//		);
//		groupLayout.setVerticalGroup(
//			groupLayout.createParallelGroup(Alignment.LEADING)
//				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 362, Short.MAX_VALUE)
//				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
//		);
//		
//		JLabel lblNewLabel_1 = new JLabel("Login");
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		
//		JPanel panel_2 = new JPanel();
//		GroupLayout gl_panel = new GroupLayout(panel);
//		gl_panel.setHorizontalGroup(
//			gl_panel.createParallelGroup(Alignment.TRAILING)
//				.addGroup(gl_panel.createSequentialGroup()
//					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
//						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
//						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
//					.addGap(2))
//		);
//		gl_panel.setVerticalGroup(
//			gl_panel.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_panel.createSequentialGroup()
//					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
//		);
//		SpringLayout sl_panel_2 = new SpringLayout();
//		panel_2.setLayout(sl_panel_2);
//		
//		JLabel lblNewLabel = new JLabel("Senha");
//		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel, 62, SpringLayout.NORTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel, 37, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel, -203, SpringLayout.EAST, panel_2);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		panel_2.add(lblNewLabel);
//		
//		textField = new JTextField();
//		sl_panel_2.putConstraint(SpringLayout.WEST, textField, 90, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.SOUTH, textField, -240, SpringLayout.SOUTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, textField, -90, SpringLayout.EAST, panel_2);
//		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		panel_2.add(textField);
//		textField.setColumns(10);
//		
//		JLabel lblNewLabel_2 = new JLabel("CPF");
//		sl_panel_2.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 35, SpringLayout.NORTH, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, lblNewLabel_2, -204, SpringLayout.EAST, panel_2);
//		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		panel_2.add(lblNewLabel_2);
//		
//		textField_1 = new JTextField();
//		sl_panel_2.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textField);
//		sl_panel_2.putConstraint(SpringLayout.WEST, textField_1, 90, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, textField_1, -90, SpringLayout.EAST, panel_2);
//		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		textField_1.setColumns(10);
//		panel_2.add(textField_1);
//		
//		JButton btnNewButton = new JButton("Entrar");
//		sl_panel_2.putConstraint(SpringLayout.NORTH, btnNewButton, 44, SpringLayout.SOUTH, textField_1);
//		sl_panel_2.putConstraint(SpringLayout.WEST, btnNewButton, 90, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.EAST, btnNewButton, -90, SpringLayout.EAST, panel_2);
//		panel_2.add(btnNewButton);
//		
//		JLabel lblNewLabel_4 = new JLabel("Feedback");
//		sl_panel_2.putConstraint(SpringLayout.WEST, lblNewLabel_4, 120, SpringLayout.WEST, panel_2);
//		sl_panel_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -6, SpringLayout.NORTH, btnNewButton);
//		panel_2.add(lblNewLabel_4);
//		panel.setLayout(gl_panel);
//		frmLogin.getContentPane().setLayout(groupLayout);
//	}
//}
