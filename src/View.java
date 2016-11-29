import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class View {
	private Model model;
	private JPanel panelContainer;
	private JFrame frame;
	private CardLayout cl;

	private JLabel securityQuestionPrompt;
	private JLabel showPassword;
	private String currentUser;
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	
	public View(Model model){
		this.model = model;
		cl = new CardLayout();
		frame = new JFrame("Hotel");
		panelContainer = new JPanel(cl); 
		
		
		//login panels
		panelContainer.add(getLoginPanel(), "Login"); //350, 200
		panelContainer.add(getRegisterPanel(), "Register"); //700, 350
		panelContainer.add(getForgetPasswordPanel(), "ForgetPassword");
		panelContainer.add(getSecurityAnswerPanel(), "SecurityAnswer");
		panelContainer.add(getPasswordPanel(), "Password");
		
		//room attendant panels
		panelContainer.add(getRoomAttendantPanel(), "RoomAttendant");
		
		//manager panels
		panelContainer.add(getManagerPanel(), "Manager"); //300, 200
		panelContainer.add(getMangeUserPanel(), "MangeUser"); 
		panelContainer.add(getAddEmployeePanel(), "AddEmployee"); 
		
		
		//Customer panels
		panelContainer.add(getCustomerPanel(), "Customer"); //350,250
		panelContainer.add(getReservationPanel(), "Reservation"); 
		
		cl.show(panelContainer, "Login");
		
		frame.add(panelContainer);
		frame.setResizable(false);
		frame.setSize(350, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private JPanel getAddEmployeePanel(){
		final JPanel addEmployeePanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		addEmployeePanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel accountType = new JLabel("Account type:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		addEmployeePanel.add(accountType, gbc);
		
		String[] selectAccountType = {"Manager","Room Attendant"};
		JComboBox accountTypeSelector = new JComboBox(selectAccountType);
		accountTypeSelector.setSelectedIndex(-1);
		gbc.gridx = 1;
		gbc.gridy = 0;
		addEmployeePanel.add(accountTypeSelector, gbc);
		
		
		JLabel username = new JLabel("Username:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		addEmployeePanel.add(username, gbc);
		
		JTextField usernameTextField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addEmployeePanel.add(usernameTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;

		JLabel passwordLabel = new JLabel("Password:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		addEmployeePanel.add(passwordLabel, gbc);
		
		JPasswordField passwordField = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		addEmployeePanel.add(passwordField, gbc);

		JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		addEmployeePanel.add(confirmPasswordLabel, gbc);

		JPasswordField confirmPasswordField = new JPasswordField(15);
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		addEmployeePanel.add(confirmPasswordField, gbc);
		
		JLabel firstName = new JLabel("First Name:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		addEmployeePanel.add(firstName, gbc);
		
		JTextField firstNameTextField = new JTextField(15); 
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		addEmployeePanel.add(firstNameTextField, gbc);
		
		JLabel lastName = new JLabel("Last Name:");
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		addEmployeePanel.add(lastName, gbc);
		
		JTextField lastNameTextField = new JTextField(15);
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		addEmployeePanel.add(lastNameTextField, gbc);
		
		JLabel gender = new JLabel("Gender:");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		addEmployeePanel.add(gender, gbc);
		
		String[] sex = {"M","F"};
		JComboBox genderSelector = new JComboBox(sex);
		genderSelector.setSelectedIndex(-1);
		gbc.gridx = 1;
		gbc.gridy = 4;
		addEmployeePanel.add(genderSelector, gbc);
		
		JLabel age = new JLabel("Age:");
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		addEmployeePanel.add(age, gbc);
		
		JTextField ageTextField = new JTextField(3);
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		addEmployeePanel.add(ageTextField, gbc);
		
		JLabel securityQuestionLabel = new JLabel("Security Question:");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 5;
		addEmployeePanel.add(securityQuestionLabel, gbc);
		
		JTextField securityQuestionTextField = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addEmployeePanel.add(securityQuestionTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		JLabel answerLabel = new JLabel("Answer:");
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 5;
		addEmployeePanel.add(answerLabel, gbc);
		
		JTextField answerTextField = new JTextField(20);
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addEmployeePanel.add(answerTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		JButton registerButton = new JButton("Add");
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean validEntry = true;
				String errors = "<html>";
				
				String accType = "";
				if(accountTypeSelector.getSelectedItem() == null){
					validEntry = false;
					errors += "Account type must be selected<br>";
				}else{
					accType = accountTypeSelector.getSelectedItem().toString();
				}
				
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
						model.setUser(user_name);
						model.registerNewUser(user_name, pass_word, first_name, last_name, accType, user_age, gen, securityQuestion, answer);
						accountTypeSelector.setSelectedIndex(-1);
						usernameTextField.setText("");
						passwordField.setText("");
						confirmPasswordField.setText("");
						firstNameTextField.setText("");
						lastNameTextField.setText("");
						ageTextField.setText("");
						genderSelector.setSelectedIndex(-1);
						securityQuestionTextField.setText("");
						answerTextField.setText("");
						switchToCustomerPanel();
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
		gbc.gridy = 9;
		gbc.gridwidth = 1;
		addEmployeePanel.add(registerButton,gbc);
		
		
		gbc.anchor = GridBagConstraints.EAST;
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc.gridx = 4;
		gbc.gridy = 9;
		addEmployeePanel.add(delete,gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		JButton goBack = new JButton("Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountTypeSelector.setSelectedIndex(-1);
				usernameTextField.setText("");
				passwordField.setText("");
				confirmPasswordField.setText("");
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				ageTextField.setText("");
				genderSelector.setSelectedIndex(-1);
				securityQuestionTextField.setText("");
				answerTextField.setText("");
				switchToManagerPanel();
			}	
		});
		gbc.gridx = 4;
		gbc.gridy = 10;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addEmployeePanel.add(goBack,gbc);
		
		return addEmployeePanel;
	}
	
	private JPanel getMangeUserPanel(){
		final JPanel mangeUserPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		mangeUserPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
		JList list = new JList();
		list.setCellRenderer(new MyListCellThing());
		ArrayList<User> users = model.getAllUsers();
		list.setListData(users.toArray());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(12);
		JScrollPane listScroller = new JScrollPane(list);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		mangeUserPanel.add(listScroller, gbc);
		
		JButton addEmployee = new JButton("Add An Employee");
		addEmployee.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				switchTonAddEmployeePanel();
			}
			
		});
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		mangeUserPanel.add(addEmployee, gbc);
		
		JButton delete = new JButton("Delete A User");
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		mangeUserPanel.add(delete, gbc);
		
		JButton goBack = new JButton("Back to main menu");
		goBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				switchToManagerPanel();
			}
			
		});
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		mangeUserPanel.add(goBack, gbc);
		
		return mangeUserPanel;
	}
	
//	private void refresh(JList list, String[] arrays){
//		list.setListData(arrays);
//	}
	
	private JPanel getReservationPanel(){
		final JPanel reservationPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		reservationPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;
		
		JLabel beginLabel = new JLabel("Check-in:");
		beginLabel.setFont(new Font(null, Font.BOLD, 12));
		gbc.gridx = 0;
		gbc.gridy = 0;
		reservationPanel.add(beginLabel, gbc);
		
		JLabel EndLabel = new JLabel("Check-out:");
		EndLabel.setFont(new Font(null, Font.BOLD, 12));
		gbc.gridx = 1;
		gbc.gridy = 0;
		reservationPanel.add(EndLabel, gbc);
		
		UtilDateModel model1 = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl beginPanel = new JDatePanelImpl(model1, p);
		JDatePickerImpl begin = new JDatePickerImpl(beginPanel, new DateLabelFormatter());
		gbc.gridx = 0;
		gbc.gridy = 1;
		reservationPanel.add(begin, gbc);
		
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl endPanel = new JDatePanelImpl(model2, p);
		JDatePickerImpl end = new JDatePickerImpl(endPanel, new DateLabelFormatter());
		gbc.gridx = 1;
		gbc.gridy = 1;
		reservationPanel.add(end, gbc);
		
		JButton searchForAvalible = new JButton("Search for availble room");
		searchForAvalible.setFont(new Font("Tahoma", Font.BOLD, 14));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		reservationPanel.add(searchForAvalible, gbc);
		
		JList list = new JList();
		list.setCellRenderer(new MyListCellThing());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(12);
		JScrollPane listScroller = new JScrollPane(list);
		gbc.gridx = 0;
		gbc.gridy = 3;
		reservationPanel.add(listScroller, gbc);
		
		
		searchForAvalible.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Date checkIn = (Date) begin.getModel().getValue();
				Date checkOut = (Date) end.getModel().getValue();
				if(checkIn == null || checkOut == null){
					JOptionPane.showMessageDialog(new JFrame(),
							"Please, select check-in date and check-out date.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else{ 
					String in = dateFormatter.format(checkIn);
					String out = dateFormatter.format(checkOut);
					
					GregorianCalendar inCal = converToGregorianCalendar(in);
					GregorianCalendar outCal = converToGregorianCalendar(out);
					if(inCal.before(Model.TODAY) || outCal.before(Model.TODAY)){
						JOptionPane.showMessageDialog(new JFrame(),
								"Please, select a date after today.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else if (inCal.equals(outCal)){
						JOptionPane.showMessageDialog(new JFrame(),
								"Check-in and check-out cannot be the same day.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else{
						ArrayList<Room> rooms = model.getAvailRooms(in, out);
						list.setListData(rooms.toArray());
					}
				}
			}
			
		});
		
		JButton reserveButton = new JButton("Reserve");
		reserveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Room room = (Room)list.getSelectedValue();
				if(room == null){
					JOptionPane.showMessageDialog(new JFrame(),
							"Please, select a room.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else{
					Date checkIn = (Date) begin.getModel().getValue();
					Date checkOut = (Date) end.getModel().getValue();
					String in = dateFormatter.format(checkIn);
					String out = dateFormatter.format(checkOut);
					long diff = checkOut.getTime() - checkIn.getTime();
					int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
					
					
					double totalCost = days * room.getCostPerNight();
					String message = "<html>Do you want to make the reservation?<br><br>";
					message += "Room type: " + room.getRoomType() + "<br>";
					message += "Number of days: " + days  + "<br>";
					message += "Totol cost: " + totalCost  + "</html>";
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(new JFrame(), message, "Confirmation", dialogButton, JOptionPane.QUESTION_MESSAGE);
					if(dialogResult == 0) {
						model.addReservation(room.getRoomId(), in, out, days, totalCost);
					} 
				}
			}
			
		});
		reserveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		reservationPanel.add(reserveButton, gbc);
		
		JButton goBack = new JButton("Back to main menu");
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				list.setListData(new String[0]);
				switchToCustomerPanel();
			}
			
		});
		goBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		reservationPanel.add(goBack, gbc);
		
		return reservationPanel;
	} 
	
	private GregorianCalendar converToGregorianCalendar(String input) {
		try {
			dateFormatter.setLenient(false);
			GregorianCalendar cal = new GregorianCalendar();
			Date d = dateFormatter.parse(input);
			cal.setTime(d);

			return cal;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private JPanel getPasswordPanel(){
		final JPanel passwordPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		passwordPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;

		JLabel passwordLabel = new JLabel("Password:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		passwordPanel.add(passwordLabel, gbc);
		gbc.anchor = GridBagConstraints.CENTER;

		showPassword = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = 1;
		passwordPanel.add(showPassword, gbc);

		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLoginPanel();
			}	
		});
		gbc.gridx = 0;
		gbc.gridy = 2;
		passwordPanel.add(ok,gbc);

		return passwordPanel;
	}

	private JPanel getSecurityAnswerPanel(){
		final JPanel securityAnswerPanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		securityAnswerPanel.setLayout(new GridBagLayout());
		gbc.insets = new Insets(5,5,5,5);
		gbc.anchor = GridBagConstraints.WEST;

		securityQuestionPrompt = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = 0;
		securityAnswerPanel.add(securityQuestionPrompt, gbc);

		JTextField answerTextField = new JTextField(15);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		securityAnswerPanel.add(answerTextField, gbc);
		gbc.fill = GridBagConstraints.NONE;

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isValid = true;
				String error = "";
				String answer = answerTextField.getText();
				if(answer.isEmpty()){
					answerTextField.setText("");
					isValid = false;
					error = "Security answer cannont be empty.";
				}else if(answer.length() > 30){
					answerTextField.setText("");
					isValid = false;
					error = "Security answer cannont exceed 30 characters."; 
				}else if(!model.checkUserSecurityAnwser(currentUser, answer)){
					answerTextField.setText("");
					isValid = false;
					error = "Incorrect answer."; 
				}
				
				if(isValid){
					String password = model.getPassword(currentUser);
					switchToShowPasswordPanel(password);
				}else{
					JOptionPane.showMessageDialog(new JFrame(), error, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		securityAnswerPanel.add(ok,gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		JButton goBack = new JButton("Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLoginPanel();
			}	
		});
		gbc.gridx = 1;
		gbc.gridy = 2;
		securityAnswerPanel.add(goBack,gbc);
		
		return securityAnswerPanel;	
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
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isValid = true;
				String error = "";
				String user_name = usernameTextField.getText();
				if(user_name.isEmpty()){
					usernameTextField.setText("");
					isValid = false;
					error = "Username cannont be empty.";
				}else if(user_name.length() > 12){
					usernameTextField.setText("");
					isValid = false;
					error = "Username cannont exceed 12 characters."; 
				}else if(!model.checkUserExistence(user_name)){
					usernameTextField.setText("");
					isValid = false;
					error = "Username does not exists in the system."; 
				}
				
				if(isValid){
					String securityQuestion = model.getSecurityQuestion(user_name);
					currentUser = user_name;
					switchToAnswerSecurityQuestionPanel(securityQuestion);
				}else{
					JOptionPane.showMessageDialog(new JFrame(), error, "Error", JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		forgetPasswordPanel.add(ok,gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		JButton goBack = new JButton("Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLoginPanel();
			}	
		});
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
						model.setUser(user_name);
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
						switchToCustomerPanel();
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
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameTextField.setText("");
				passwordField.setText("");
				confirmPasswordField.setText("");
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				ageTextField.setText("");
				genderSelector.setSelectedIndex(-1);
				securityQuestionTextField.setText("");
				answerTextField.setText("");
				switchToLoginPanel();
			}	
		});
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
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLoginPanel();
			}	
		});
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
		
		JButton manageEmployee = new JButton("Manage Users");
		manageEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToManageUsersPanel();
			}	
		});
		manageEmployee.setFont(new Font(null, Font.BOLD, 20));
		manageEmployee.setMargin(new Insets(5,5,5,5));
		gbc.gridy = 1;
		managerPanel.add(manageEmployee,gbc);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLoginPanel();
			}	
		});
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
		reservation.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				swichToMakeReservationPanel();
			}
			
		});
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
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchToLoginPanel();
			}	
		});
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
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String errors = "<html>";
				boolean validEntry = true;
				String user_name = usernameTextField.getText();
				if(user_name.isEmpty()){
					usernameTextField.setText("");
					validEntry = false;
					errors += "Username cannont be empty<br>";
				}else if(user_name.length() > 12){
					usernameTextField.setText("");
					validEntry = false;
					errors += "Username cannont be exceed 12 characters<br>";
				}else if(!model.checkUserExistence(user_name)){
					usernameTextField.setText("");
					validEntry = false;
					errors += "Username does not exists in the system<br>";
				}

				String pass_word = String.valueOf(passwordField.getPassword());
				if(pass_word.isEmpty()){
					passwordField.setText("");
					validEntry = false;
					errors += "Password cannont be empty<br>";
				}else if(pass_word.length() > 20){
					passwordField.setText("");
					validEntry = false;
					errors += "Password cannont be exceed 20 characters<br>";
				}else if(!model.checkUserPassword(user_name, pass_word)){
					passwordField.setText("");
					validEntry = false;
					errors += "Password is incorrect";
				}

				if(validEntry){
					try {
						usernameTextField.setText("");
						passwordField.setText("");
						model.setUser(user_name);
						String accountType = model.getAccountType(user_name);
						if(accountType.equals("Manager")){
							switchToManagerPanel();
						}else if(accountType.equals("Customer")){
							switchToCustomerPanel();
						}else{
							switchToRoomAttendantAPanel();
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(new JFrame(), errors + "</html>", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
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
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				usernameTextField.setText("");
				passwordField.setText("");
				switchToRegisterPanel();
				
			}
			
		});
		registerButton.setFont(new Font(null, Font.BOLD, 15));
		registerButton.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 0;
		gbc.gridy = 3;
		login.add(registerButton,gbc);
		
		JButton forgetPasswordButton = new JButton("Forget Password");
		forgetPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usernameTextField.setText("");
				passwordField.setText("");
				switchToForgetPassordPanel();
			}
		});
		forgetPasswordButton.setFont(new Font(null, Font.BOLD, 15));
		forgetPasswordButton.setMargin(new Insets(5,5,5,5));
		gbc.gridx = 1;
		gbc.gridy = 3;
		login.add(forgetPasswordButton,gbc);
		
		return login;
	}
	
	public void switchTonAddEmployeePanel(){
		frame.setSize(700,450);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "AddEmployee");
	}
	
	public void switchToManageUsersPanel(){
		frame.setSize(450,450);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "MangeUser");
	}
	
	public void swichToMakeReservationPanel(){
		frame.setSize(500,450);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "Reservation");
	}
	
	public void switchToShowPasswordPanel(String password){
		frame.setSize(500,150);
		frame.setLocationRelativeTo(null);
		showPassword.setText(password);
		cl.show(panelContainer, "Password");
	}


	public void switchToAnswerSecurityQuestionPanel(String securityQuestion){
		frame.setSize(500,150);
		frame.setLocationRelativeTo(null);
		securityQuestionPrompt.setText(securityQuestion);
		cl.show(panelContainer, "SecurityAnswer");
	}
	
	public void switchToForgetPassordPanel(){
		frame.setSize(250,150);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "ForgetPassword");
	}
	
	public void switchToRoomAttendantAPanel(){
		frame.setSize(250,150);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "RoomAttendant");
	}
	
	public void switchToManagerPanel(){
		frame.setSize(300,200);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "Manager");
	}
	
	public void switchToRegisterPanel(){
		frame.setSize(700,350);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "Register");
	}

	public void switchToCustomerPanel(){
		frame.setSize(350,250);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "Customer");
	}
	
	public void switchToLoginPanel(){
		frame.setSize(350,200);
		frame.setLocationRelativeTo(null);
		cl.show(panelContainer, "Login");
	}
	
	public boolean isInteger(String s) {  
	    for(char c : s.toCharArray()) {
	    	if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}  
}
