//code to create a login page
//save the jframe name as login.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//gui designing and functioning of the login page
public class login extends JFrame {
    private RoundedTextField username_2;
    private RoundedPasswordField password_1;

    public login() {
        setTitle("Login Page");
        setSize(569, 724);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\balaj\\OneDrive\\Desktop\\prj\\login_page_bg.png");
        Image img = backgroundImage.getImage().getScaledInstance(480, 372, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon(img);

        JPanel panel = new JPanel();

        JLabel usernameLabel = new JLabel("USER ID");
        usernameLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        usernameLabel.setBounds(89, 221, 96, 45);
        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        passwordLabel.setBounds(89, 304, 148, 40);

        username_2 = new RoundedTextField(20, 50);
        username_2.setHorizontalAlignment(SwingConstants.CENTER);
        username_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        username_2.setBounds(247, 221, 231, 45);
        username_2.setBackground(new Color(255, 255, 255));

        password_1 = new RoundedPasswordField(20, 50);
        password_1.setHorizontalAlignment(SwingConstants.CENTER);
        password_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        password_1.setBounds(247, 299, 231, 45);
        password_1.setEchoChar('\u2022');
        password_1.setBackground(new Color(255, 255, 255));

        RoundedButton loginButton = new RoundedButton("Login", 50);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        loginButton.setBackground(new Color(0, 0, 0));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBounds(204, 414, 137, 35);
        loginButton.addActionListener(new ActionListener() {
            //@Override
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
                String username = username_2.getText();
                String password = new String(password_1.getPassword());

                if (validateLogin(username, password)) {
                    //JOptionPane.showMessageDialog(login.this, "Login successful!");
                	piano_multikey loginFrame = new piano_multikey();
                	loginFrame.show();
                	dispose();
                }
                else {
                    JOptionPane.showMessageDialog(login.this, "Account Doesn't Exist.\nCreate one.");
                }
            }
        });
        panel.setLayout(null);

        panel.add(usernameLabel);
        panel.add(username_2);
        panel.add(passwordLabel);
        panel.add(password_1);
        panel.add(loginButton);

        getContentPane().add(panel);

        RoundedButton btnNewButton = new RoundedButton("Reset", 50);
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username_2.setText("");
                password_1.setText("");
            }
        });
        btnNewButton.setBounds(204, 478, 137, 35);
        panel.add(btnNewButton);

        RoundedButton btnNewButton_1 = new RoundedButton("Sign Up", 50);
        btnNewButton_1.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
            	sign signupFrame = new sign();
            	signupFrame.show();
            	dispose(); 
            }
        });
        setVisible(true);
        
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.setBounds(204, 538, 137, 35);
        panel.add(btnNewButton_1);

        RoundedButton btnNewButton_1_1 = new RoundedButton("Forgot Password", 50);
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
        		forgot forg=new forgot();
        		forg.show();
        		dispose();
        		
        	}
        });
        btnNewButton_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1_1.setForeground(Color.WHITE);
        btnNewButton_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnNewButton_1_1.setBackground(Color.BLACK);
        btnNewButton_1_1.setBounds(164, 593, 236, 35);
        panel.add(btnNewButton_1_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/images/LOGO.png")));
        lblNewLabel.setBounds(179, 29, 192, 140);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/images/login_page_bg2.png")));
        lblNewLabel_1.setBounds(10, 11, 545, 676);
        panel.add(lblNewLabel_1);

        setVisible(true);
    }
//code for database connectivity
//replace userdb,user,dbpassword with your database table name,username and password
    private boolean validateLogin(String username, String password) {
        try {
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/userdb";
            String user = "root";
            String dbPassword = "";

            // Establish database connection
            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            // Validate login credentials
            String query = "SELECT * FROM signup WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean isValid = resultSet.next();

            // Close resources
            preparedStatement.close();
            connection.close();

            return isValid;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
      //      @Override
            public void run() {
                new login();
            }
        });
    }
}
