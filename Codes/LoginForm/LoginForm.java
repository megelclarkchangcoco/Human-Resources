package LoginFormCodes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import EmployeeFrame.EmployeeFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginForm extends JFrame {

	private ImageIcon clipboard = new ImageIcon(new ImageIcon("C:\\\\Users\\\\MOMSIE BETSKIE\\\\eclipse-workspace\\\\FinalHumanResources\\\\assets\\\\loginframeicon\\\\clipboard-user (1).png").getImage().getScaledInstance(77, 67, Image.SCALE_DEFAULT));
	private ImageIcon earth = new ImageIcon(new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\FinalHumanResources\\assets\\loginframeicon\\logologin.png").getImage().getScaledInstance(424, 149, Image.SCALE_DEFAULT));
	private ImageIcon logo = new ImageIcon(new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\FinalHumanResources\\assets\\loginframeicon\\metrologo.png").getImage().getScaledInstance(424, 170, Image.SCALE_DEFAULT));
	private ImageIcon x = new ImageIcon(new ImageIcon("C:\\\\Users\\\\MOMSIE BETSKIE\\\\eclipse-workspace\\\\FinalHumanResources\\\\assets\\\\loginframeicon\\\\circle-xmark.png").getImage().getScaledInstance(28, 19, Image.SCALE_DEFAULT));

	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel usernamepanel;
    private JPanel passwordpanel;
    private JPanel cardPanel;
    private JPanel signbtnpanel;
    private CardLayout cardLayout;
    private JTextField usernametextField;
    private JPasswordField passwordField;
    private RoundedTextField usernameTextField;
    private RoundedPasswordField passwordField_1;
    private RoundedJPanel signbtnpanel_1;

    
     
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { 
            public void run() {
                try {
                    LoginForm frame = new LoginForm();
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
    public LoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 771, 506);
        setLocationRelativeTo(null);
    	setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(424, 0, 347, 506);
        contentPane.add(cardPanel); 

        JPanel adminLoginPanel = new JPanel();
        adminLoginPanel.setForeground(new Color(0, 0, 0));
        adminLoginPanel.setBackground(new Color(41, 75, 144));
        cardPanel.add(adminLoginPanel, "Employee");
        adminLoginPanel.setLayout(null);

        JButton Employeebtn = new JButton("Employee");
        Employeebtn.setForeground(new Color(255, 255, 255));
        Employeebtn.setFont(new Font("Open Sans", Font.BOLD, 14));
        Employeebtn.setBounds(78, 133, 112, 23);
        Employeebtn.setOpaque(false);
        Employeebtn.setContentAreaFilled(false);
        Employeebtn.setBorderPainted(false);
        Employeebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Admin");
            }
        });
        adminLoginPanel.add(Employeebtn);

        JButton Adminbtn = new JButton("Admin");
        Adminbtn.setForeground(new Color(255, 255, 255));
        Adminbtn.setBackground(new Color(255, 255, 255));
        Adminbtn.setFont(new Font("Open Sans", Font.BOLD, 14));
        Adminbtn.setBounds(177, 133, 89, 23);
        Adminbtn.setOpaque(false);
        Adminbtn.setContentAreaFilled(false);
        Adminbtn.setBorderPainted(false);
        Adminbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Employee");
            }
        });
        adminLoginPanel.add(Adminbtn);
        
         usernamepanel = new RoundedJPanel();
         usernamepanel.setForeground(new Color(0, 0, 0));
         usernamepanel.setOpaque(true);
        usernamepanel.setBackground(new Color(41, 75, 144));
        usernamepanel.setBounds(35, 180, 275, 41);
        adminLoginPanel.add(usernamepanel);
        usernamepanel.setLayout(null);
        
        usernametextField = new RoundedTextField();
        usernametextField.setFont(new Font("Open Sans", Font.PLAIN, 14));
        usernametextField.setText("Username");
        usernametextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (usernametextField.getText().equals("")) {
					usernametextField.setForeground(new Color(96, 96, 96));
					usernametextField.setText("Username");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (usernametextField.getText().equals("Username")) {
					usernametextField.setForeground(Color.BLACK);
					usernametextField.setText("");
				}
			}
		});
        usernametextField.setForeground(new Color(0, 0, 0));
        usernametextField.setOpaque(false);
        usernametextField.setBounds(0, 0, 275, 41);
        usernamepanel.add(usernametextField);
        usernametextField.setColumns(10);
        
        passwordpanel = new RoundedJPanel();
        passwordpanel.setOpaque(false);
        passwordpanel.setBackground(new Color(120, 182, 50));
        passwordpanel.setBounds(35, 243, 275, 41);
        adminLoginPanel.add(passwordpanel);
        passwordpanel.setLayout(null);
        
        passwordField = new RoundedPasswordField();
        passwordField.setText("Password");
        passwordField.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().equals("")) {
					passwordField.setForeground(new Color(96, 96, 96));
					passwordField.setText("Password");
					passwordField.setEchoChar((char) 0);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Password")) {
					passwordField.setEchoChar('●');
					passwordField.setForeground(Color.BLACK);
					passwordField.setText("");
				}
			}

		});
        passwordField.setForeground(new Color(0, 0, 0));
        passwordField.setOpaque(false);
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setBounds(0, 0, 275, 41);
        passwordpanel.add(passwordField);
        
        signbtnpanel = new RoundedJPanel();
        signbtnpanel.setBackground(new Color(41, 75, 144));
        signbtnpanel.addMouseListener(new PanelButtonMouseAdapter(signbtnpanel) {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginForm lf = new LoginForm();
                EmployeeFrame ef = new EmployeeFrame();
                String enteredUsername = usernametextField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                // check if user username and password is correct
                if (!enteredUsername.isEmpty() && enteredPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Fail password!");
                }
                else if (enteredUsername.isEmpty() && !enteredPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Fail password!");
                } else if (authenticateAdmin(enteredUsername, enteredPassword)) {
                    JOptionPane.showMessageDialog(contentPane, "Login Successfully!");
                    ef.setVisible(true);
                    lf.dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Fail Login!, Invalid Account!");
                }
            }
        });

        signbtnpanel.setForeground(new Color(255, 255, 255));
        signbtnpanel.setOpaque(false);
        signbtnpanel.setBounds(111, 295, 129, 41);
        adminLoginPanel.add(signbtnpanel);
        signbtnpanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblNewLabel.setBounds(46, 11, 55, 19);
        signbtnpanel.add(lblNewLabel);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(177, 154, 89, 2);
        adminLoginPanel.add(separator_2);
        
        JSeparator separator_3 = new JSeparator();
        separator_3.setBounds(35, 120, 275, 2);
        adminLoginPanel.add(separator_3);
        
        JSeparator separator_4 = new JSeparator();
        separator_4.setBounds(35, 357, 275, 2);
        adminLoginPanel.add(separator_4);
        
        JPanel exitpanel1 = new JPanel();
        exitpanel1.addMouseListener(new PanelButtonMouseAdapter(exitpanel1) {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(contentPane, "You Want Exit?");
                dispose();
            }

        });

        exitpanel1.setBounds(299, 0, 48, 41);
        exitpanel1.setOpaque(false);      
        adminLoginPanel.add(exitpanel1);
        exitpanel1.setLayout(null);
        
        JLabel exitlbl1 = new JLabel("");
        exitlbl1.setBounds(10, 11, 28, 19);
        exitlbl1.setIcon(x);
        exitpanel1.add(exitlbl1);

        JPanel employeeLoginPanel = new JPanel();
        employeeLoginPanel.setBackground(new Color(41, 75, 144));
        cardPanel.add(employeeLoginPanel, "Admin");
        employeeLoginPanel.setLayout(null);

        JButton Employeebtn_1 = new JButton("Employee");
        Employeebtn_1.setBackground(new Color(255, 255, 255));
        Employeebtn_1.setForeground(new Color(255, 255, 255));
        Employeebtn_1.setFont(new Font("Open Sans", Font.BOLD, 14));
        Employeebtn_1.setBounds(78, 133, 116, 23);
        Employeebtn_1.setOpaque(false);
        Employeebtn_1.setContentAreaFilled(false);
        Employeebtn_1.setBorderPainted(false);
        Employeebtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Admin");
            }
        });
        employeeLoginPanel.add(Employeebtn_1);

        JButton Adminbtn_1 = new JButton("Admin");
        Adminbtn_1.setFont(new Font("Open Sans", Font.BOLD, 14));
        Adminbtn_1.setForeground(new Color(255, 255, 255));
        Adminbtn_1.setBackground(new Color(255, 255, 255));
        Adminbtn_1.setBounds(177, 133, 89, 23);
        Adminbtn_1.setOpaque(false);
        Adminbtn_1.setContentAreaFilled(false);
        Adminbtn_1.setBorderPainted(false);
        Adminbtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Employee");
            }
        });
        employeeLoginPanel.add(Adminbtn_1);
        
        RoundedJPanel passwordfieldPanel_1 = new RoundedJPanel();
        passwordfieldPanel_1.setLayout(null);
        passwordfieldPanel_1.setOpaque(false);
        passwordfieldPanel_1.setBackground(new Color(120, 182, 50));
        passwordfieldPanel_1.setBounds(33, 243, 275, 41);
        employeeLoginPanel.add(passwordfieldPanel_1);
        
         passwordField_1 = new RoundedPasswordField();
         passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
         passwordField_1.setText("Password");
         passwordField_1.addFocusListener(new FocusAdapter(){
 			@Override
 			public void focusLost(FocusEvent e) {
 				if (passwordField_1.getText().equals("")) {
 					passwordField_1.setForeground(new Color(96, 96, 96));
 					passwordField_1.setText("Password");
 					passwordField_1.setEchoChar((char) 0);
 				}
 			}

 			@Override
 			public void focusGained(FocusEvent e) {
 				if (passwordField_1.getText().equals("Password")) {
 					passwordField_1.setEchoChar('●');
 					passwordField_1.setForeground(Color.BLACK);
 					passwordField_1.setText("");
 				}
 			}

 		});
         passwordField_1.setBounds(0, 0, 275, 41);
         passwordField_1.setOpaque(false);
         passwordField_1.setForeground(new Color(0, 0, 0));
         passwordField_1.setBackground(Color.WHITE);
         passwordfieldPanel_1.add(passwordField_1);
        
        RoundedJPanel usernametextfieldPanel_1 = new RoundedJPanel();
        usernametextfieldPanel_1.setLayout(null);
        usernametextfieldPanel_1.setOpaque(false);
        usernametextfieldPanel_1.setBackground(new Color(120, 182, 50));
        usernametextfieldPanel_1.setBounds(33, 180, 275, 41);
        employeeLoginPanel.add(usernametextfieldPanel_1);
        
        JPanel panel_2_2 = new JPanel();
        panel_2_2.setForeground(Color.WHITE);
        panel_2_2.setBounds(-47, -66, 346, 10);
        usernametextfieldPanel_1.add(panel_2_2);
        
        JLabel profilelbl_1 = new JLabel("");
        profilelbl_1.setBounds(90, -131, 77, 67);
        usernametextfieldPanel_1.add(profilelbl_1);
        
        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setForeground(Color.WHITE);
        panel_2_1_1.setBounds(-44, 212, 346, 10);
        usernametextfieldPanel_1.add(panel_2_1_1);
        
         signbtnpanel_1 = new RoundedJPanel();
        signbtnpanel_1.setBackground(new Color(41, 75, 144));
        signbtnpanel_1.addMouseListener(new PanelButtonMouseAdapter(signbtnpanel_1) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		EmployeeFrame ef = new EmployeeFrame();
        		LoginForm lf = new LoginForm();
        		
        		String enteredUsername = usernameTextField.getText();
        		String enteredPassword = new String(passwordField_1.getPassword()); 

        		// check if admin username and password correct
        		if (!authenticateUser(enteredUsername, enteredPassword)) {
        		    JOptionPane.showMessageDialog(contentPane, "Fail password!");
        		} else if (!authenticateUser(enteredUsername, enteredPassword)) {
        		    JOptionPane.showMessageDialog(contentPane, "Username or password cannot be empty!");
        		} else if (authenticateUser(enteredUsername, enteredPassword)) {
        		    JOptionPane.showMessageDialog(contentPane, "Login Successfully!");      		    
        		    ef.setVisible(true);
        		    lf.dispose();
        		} else {
        		    JOptionPane.showMessageDialog(contentPane, "Fail Login!, Invalid Account!");
        		}
        		
        		
        		
        	}
        });
        signbtnpanel_1.setLayout(null);
        signbtnpanel_1.setOpaque(false);
        signbtnpanel_1.setForeground(Color.WHITE);
        signbtnpanel_1.setBounds(111, 295, 129, 41);
        employeeLoginPanel.add(signbtnpanel_1);
        
        JLabel lblNewLabel_1 = new JLabel("Login");
        lblNewLabel_1.setBackground(new Color(147, 149, 151));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 14));
        lblNewLabel_1.setBounds(46, 11, 55, 19);
        signbtnpanel_1.add(lblNewLabel_1);
        
        JLabel profilelbl_2 = new JLabel("");
        profilelbl_2.setIcon(clipboard);
        profilelbl_2.setBounds(136, 55, 77, 67);
        employeeLoginPanel.add(profilelbl_2);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(33, 120, 275, 2);
        employeeLoginPanel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(33, 357, 275, 2);
        employeeLoginPanel.add(separator_1);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(100, 154, 77, 2);
        employeeLoginPanel.add(separator_1_1);
        
         usernameTextField = new RoundedTextField();
        usernameTextField.setFont(new Font("Open Sans", Font.PLAIN, 14));
        usernameTextField.setBounds(0, 0, 275, 41); // Consider defining constants for these values
        usernameTextField.setOpaque(false);
        usernameTextField.setForeground(new Color(0, 0, 0));
        usernameTextField.setColumns(10);
        usernameTextField.setText("Username"); // Set initial placeholder text

        usernameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (usernameTextField.getText().isEmpty()) {
                    usernameTextField.setForeground(new Color(96, 96, 96));
                    usernameTextField.setText("Username");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (usernameTextField.getText().equals("Username")) {
                    usernameTextField.setForeground(Color.BLACK);
                    usernameTextField.setText("");
                }
            }
        });

        usernametextfieldPanel_1.add(usernameTextField);

         
        JPanel exitpanel2 = new JPanel();
        exitpanel2.addMouseListener(new PanelButtonMouseAdapter(exitpanel2) {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                JOptionPane.showMessageDialog(contentPane, "You Want Exit?");
                dispose();
            }
        });
        exitpanel2.setBounds(299, 0, 48, 41);
        employeeLoginPanel.add(exitpanel2);
        exitpanel2.setOpaque(false);
        exitpanel2.setLayout(null);

         
         JLabel exitlbl2 = new JLabel("");
         exitlbl2.setBounds(10, 11, 28, 19);
         exitlbl2.setIcon(x);
         exitpanel2.add(exitlbl2);
        
        JPanel designpanel = new JPanel();
        designpanel.setBackground(new Color(255, 255, 255));
        designpanel.setBounds(0, -2, 425, 504);
        contentPane.add(designpanel);
        designpanel.setLayout(null);
        
        JLabel earthlbl = new JLabel("");
        earthlbl.setIcon(earth);
        earthlbl.setBounds(2, 359, 424, 149);
        designpanel.add(earthlbl);
        
        JLabel logolbls = new JLabel("");
        logolbls.setIcon(logo);
        logolbls.setBounds(2, 133, 424, 170);
        designpanel.add(logolbls);
    }
    
    // Function to authenticate user by querying the database
    private boolean authenticateUser(String username, String password) {
        try {
            String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=casethreedatabase;integratedSecurity=true;encrypt=false;";
            Connection conn = DriverManager.getConnection(url);

            // Use a prepared statement to avoid SQL injection
            String query = "SELECT * FROM Employee WHERE e_username = ? AND e_password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet resultSet = pstmt.executeQuery();

                // If resultSet.next() returns true, it means a matching user was found
                return resultSet.next();
            } 
        } catch (SQLException e) {
            e.printStackTrace();	
            return false;
        }
    }
    
    
    //=========================== to do ============================================
    /// Function to authenticate Admin by querying the database
    private boolean authenticateAdmin(String username, String password) {
    	try {
    		String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=casethreedatabase;integratedSecurity=true;encrypt=false;";
    		Connection conn = DriverManager.getConnection(url);
    		// update
    		String query = "SELECT * FROM HR WHERE hr_username = ? AND hr_password = ?";
    		try(PreparedStatement pstmt = conn.prepareStatement(query)){
    			pstmt.setString(1, username);
    			pstmt.setString(2, password);
    			
    			ResultSet resultSet = pstmt.executeQuery();
    			
    			// if resultSet.next() return true, it means a matching admin was found
    			return resultSet.next();
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    		return false;
    	}
    }
    

    private class PanelButtonMouseAdapter extends MouseAdapter{
		  JPanel panel;
				
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
				
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(15, 147, 149));
		}
				
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(41, 75, 144));
		}
				
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(15, 147, 149));
		}
				
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(15, 147, 149));
		}
	}
    
    
}