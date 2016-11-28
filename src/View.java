import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View {
	private Model model;
	private JPanel panelContainer;
	private JFrame frame;
	private CardLayout cl;
	
	public View(Model model){
		this.model = model;
		cl = new CardLayout();
		frame = new JFrame();
		panelContainer = new JPanel(cl); 
		
		
		
		panelContainer.add(getLoginPanel(), "Login");
		panelContainer.add(getCustomerPanel(), "Customer");
		panelContainer.add(getManagerPanel(), "Manager");
		panelContainer.add(getRoomAttendantPanel(), "RoomAttendant");
		panelContainer.add(getRegisterPanel(), "Register"); //700, 350
		panelContainer.add(getForgetPasswordPanel(), "ForgetPassword");
		
		cl.show(panelContainer, "Register");
		
		frame.add(panelContainer);
		frame.setResizable(false);
		frame.setSize(700, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private JPanel getForgetPasswordPanel(){
		final JPanel forgetPasswordPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		forgetPasswordPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel username = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		forgetPasswordPanel.add(username, gbc);
		
		JTextField usernameTextField = new JTextField(15);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		forgetPasswordPanel.add(usernameTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		JButton ok = new JButton("OK");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		forgetPasswordPanel.add(ok,gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		JButton goBack = new JButton("Back");
		gbc.gridx = 1;
		gbc.gridy = 2;
		forgetPasswordPanel.add(goBack,gbc);
		
		
		return forgetPasswordPanel;
	}
	
	private JPanel getRegisterPanel(){
		final JPanel registerPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		registerPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel username = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		registerPanel.add(username, gbc);
		
		JTextField usernameTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		registerPanel.add(usernameTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;

		JLabel passwordLabel = new JLabel("Password:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		registerPanel.add(passwordLabel, gbc);
		
		JPasswordField passwordField = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		registerPanel.add(passwordField, gbc);

		JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		registerPanel.add(confirmPasswordLabel, gbc);

		JPasswordField confirmPasswordField = new JPasswordField(15);
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		registerPanel.add(confirmPasswordField, gbc);
		
		JLabel firstName = new JLabel("First Name:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		registerPanel.add(firstName, gbc);
		
		JTextField firstNameTextField = new JTextField(15); 
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		registerPanel.add(firstNameTextField, gbc);
		
		JLabel lastName = new JLabel("Last Name:");
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		registerPanel.add(lastName, gbc);
		
		JTextField lastNameTextField = new JTextField(15);
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		registerPanel.add(lastNameTextField, gbc);
		
		JLabel gender = new JLabel("Gender:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		registerPanel.add(gender, gbc);
		
		String[] sex = {"M","F"};
		JComboBox genderSelector = new JComboBox(sex);
		genderSelector.setSelectedIndex(-1);
		gbc.gridx = 1;
		gbc.gridy = 3;
		registerPanel.add(genderSelector, gbc);
		
		JLabel age = new JLabel("Age:");
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		registerPanel.add(age, gbc);
		
		JTextField ageTextField = new JTextField(3);
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		registerPanel.add(ageTextField, gbc);
		
		JLabel securityQuestionLabel = new JLabel("Security Question:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 5;
		registerPanel.add(securityQuestionLabel, gbc);
		
		JTextField securityQuestionTextField = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		registerPanel.add(securityQuestionTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		JLabel answerLabel = new JLabel("Answer:");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 5;
		registerPanel.add(answerLabel, gbc);
		
		JTextField answerTextField = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		registerPanel.add(answerTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean validEntry = true;
				String errors = "<html>";
				
				String user_name = usernameTextField.getText();
				if(user_name.isEmpty()){
					usernameTextField.setText("");
					validEntry = false;
					errors += "Username cannot be empty<br>";
				}else if (user_name.length() > 12) {
					usernameTextField.setText("");
					validEntry = false;
					errors += "Username cannot exceed 12 characters<br>";
				}else if(model.checkUserExistence(user_name)){
					usernameTextField.setText("");
					validEntry = false;
					errors += "Username already exists<br>";
				}

				String pass_word = String.valueOf(passwordField.getPassword());
				String confirm_pass_word =  String.valueOf(confirmPasswordField.getPassword());
				if(pass_word.isEmpty()){
					passwordField.setText("");
					confirmPasswordField.setText("");
					validEntry = false;
					errors += "Password cannot be empty<br>";
				}else if(pass_word.length() > 20){
					passwordField.setText("");
					confirmPasswordField.setText("");
					validEntry = false;
					errors += "Password cannot exceed 20 characters<br>";
				}else if(!pass_word.equals(confirm_pass_word)){
					passwordField.setText("");
					confirmPasswordField.setText("");
					validEntry = false;
					errors += "Passwords do not match<br>";
				}
				
				String first_name = firstNameTextField.getText();
				if(first_name.isEmpty()){
					firstNameTextField.setText("");
					validEntry = false;
					errors += "First name cannont be empty<br>";
				}else if(first_name.length() > 15){
					firstNameTextField.setText("");
					validEntry = false;
					errors += "First name cannont exceed 15 characters<br>";
				}
				
				String last_name = lastNameTextField.getText();
				if(last_name.isEmpty()){
					lastNameTextField.setText("");
					validEntry = false;
					errors += "Last name cannont be empty<br>";
				}else if(last_name.length() > 15){
					lastNameTextField.setText("");
					validEntry = false;
					errors += "Last name cannont exceed 15 characters<br>";
				}
				
				String gen = "";
				if(genderSelector.getSelectedItem() == null){
					validEntry = false;
					errors += "Gender must be selected<br>";
				}else{
					gen = genderSelector.getSelectedItem().toString();
				}
				
				String temp_age = ageTextField.getText();
				int user_age = 0;
				if(!isInteger(temp_age)){
					ageTextField.setText("");
					validEntry = false;
					errors += "Age must be an integer<br>";
				}else if(temp_age.isEmpty()){
					ageTextField.setText("");
					validEntry = false;
					errors += "Age cannot be empty<br>";
				}else{
					user_age = Integer.parseInt(temp_age);
				}
				
				String securityQuestion = securityQuestionTextField.getText();
				if(last_name.isEmpty()){
					securityQuestionTextField.setText("");
					validEntry = false;
					errors += "Security question cannont be empty<br>";
				}else if(last_name.length() > 50){
					securityQuestionTextField.setText("");
					validEntry = false;
					errors += "Security question exceed 50 characters<br>";
				}
				
				String answer = answerTextField.getText();
				if(last_name.isEmpty()){
					answerTextField.setText("");
					validEntry = false;
					errors += "Answer cannont be empty<br>";
				}else if(last_name.length() > 30){
					answerTextField.setText("");
					validEntry = false;
					errors += "Answer exceed 30 characters";
				}
				
				if(validEntry){
					try {
						model.registerNewUser(user_name, pass_word, first_name, last_name, "Customer", user_age, gen, securityQuestion, answer);
						usernameTextField.setText("");
						passwordField.setText("");
						confirmPasswordField.setText("");
						firstNameTextField.setText("");
						lastNameTextField.setText("");
						ageTextField.setText("");
						genderSelector.setSelectedIndex(-1);
						securityQuestionTextField.setText("");
						answerTextField.setText("");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(new JFrame(), errors + "</html>", "Registration failed", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			
		});
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		registerPanel.add(registerButton,gbc);
		
		
		gbc.anchor = GridBagConstraints.EAST;
		JButton goBack = new JButton("Back");
		gbc.gridx = 4;
		gbc.gridy = 8;
		registerPanel.add(goBack,gbc);
		
		return registerPanel;
	}
	
	private JPanel getRoomAttendantPanel(){
		final JPanel roomAttendantPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		roomAttendantPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		
		JButton roomService = new JButton("Room Services");
		roomService.setFont(new Font(null, Font.BOLD, 20));
		roomService.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		roomAttendantPanel.add(roomService,gbc);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font(null, Font.BOLD, 20));
		logout.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 1;
		roomAttendantPanel.add(logout,gbc);
		
		return roomAttendantPanel;
	}
	
	private JPanel getManagerPanel(){
		final JPanel managerPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		managerPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		
		JButton manageReservation = new JButton("Manage Reservations");
		manageReservation.setFont(new Font(null, Font.BOLD, 20));
		manageReservation.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		managerPanel.add(manageReservation,gbc);
		
		JButton manageEmployee = new JButton("Manage Employees");
		manageEmployee.setFont(new Font(null, Font.BOLD, 20));
		manageEmployee.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 1;
		managerPanel.add(manageEmployee,gbc);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font(null, Font.BOLD, 20));
		logout.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 2;
		managerPanel.add(logout,gbc);
		
		return managerPanel;
	}
	
	private JPanel getCustomerPanel(){
		final JPanel customerPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		customerPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		
		JButton reservation = new JButton("Make A Reservation");
		reservation.setFont(new Font(null, Font.BOLD, 20));
		reservation.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		customerPanel.add(reservation,gbc);
		
		JButton cancelReservation = new JButton("Cancel Reservation");
		cancelReservation.setFont(new Font(null, Font.BOLD, 20));
		cancelReservation.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 1;
		customerPanel.add(cancelReservation,gbc);
		
		JButton roomService = new JButton("Request A Room Service");
		roomService.setFont(new Font(null, Font.BOLD, 20));
		roomService.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 2;
		customerPanel.add(roomService,gbc);
		
		JButton logout = new JButton("Logout");
		logout.setFont(new Font(null, Font.BOLD, 20));
		logout.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 3;
		customerPanel.add(logout,gbc);
		
		return customerPanel;	
	}
	
	private JPanel getLoginPanel(){
		final JPanel login = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		login.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font(null, Font.BOLD, 20));
		gbc.gridx = 0;
		gbc.gridy = 0;
		login.add(username, gbc);
		
		JTextField usernameTextField = new JTextField(15);
		usernameTextField.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 1;
		gbc.gridy = 0;
		login.add(usernameTextField, gbc);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font(null, Font.BOLD, 20));
		gbc.gridx = 0;
		gbc.gridy = 1;
		login.add(password,gbc);
		
		JPasswordField passwordField = new JPasswordField(15);
		passwordField.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 1;
		gbc.gridy = 1;
		login.add(passwordField, gbc);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font(null, Font.BOLD, 20));
		loginButton.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		login.add(loginButton,gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font(null, Font.BOLD, 15));
		registerButton.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 0;
		gbc.gridy = 3;
		login.add(registerButton,gbc);
		
		JButton forgetPasswordButton = new JButton("Forget Password");
		forgetPasswordButton.setFont(new Font(null, Font.BOLD, 15));
		forgetPasswordButton.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 1;
		gbc.gridy = 3;
		login.add(forgetPasswordButton,gbc);
		
		
		return login;
	}
	
	public boolean isInteger(String s) {  
	    for(char c : s.toCharArray()) {
	    	if (!Character.isDigit(c)) return false;
	    }
	    
	    return true;
	}  
}
