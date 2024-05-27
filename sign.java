//code for signup page with database connection
//replace package name with your packge name
//create a jframe wih the name as sign.java

package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

class RoundedButton extends JButton {

    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setContentAreaFilled(false);
    }

    //@Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        super.paintComponent(g);
    }

    //@Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}

class RoundedTextField extends JTextField {

    private int radius;

    public RoundedTextField(int columns, int radius) {
        super(columns);
        this.radius = radius;
        setOpaque(false);
        setBorder(null);
    }

    //@Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        super.paintComponent(g);
    }

    //@Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}

class RoundedPasswordField extends JPasswordField {

    private int radius;

    public RoundedPasswordField(int columns, int radius) {
        super(columns);
        this.radius = radius;
        setOpaque(false);
        setBorder(null);
    }

    //@Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        super.paintComponent(g);
    }

    //@Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}

public class sign extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundedTextField nameText;
	private RoundedTextField userText;
	private RoundedTextField emailText;
	private RoundedPasswordField passwordText;
	private RoundedPasswordField confirmText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign frame = new sign();
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
	public sign() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(sign.class.getResource("/images/LOGO.png")));
		lblNewLabel_1.setBounds(190, 0, 200, 147);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("email");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(74, 268, 144, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("name");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(77, 182, 108, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("username");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(74, 219, 144, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPassword.setBounds(74, 320, 144, 41);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("confirm password");
		lblConfirmPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(74, 379, 176, 41);
		contentPane.add(lblConfirmPassword);
		
		nameText = new RoundedTextField(20,50);
		nameText.setHorizontalAlignment(SwingConstants.CENTER);
		nameText.setBounds(320, 182, 191, 30);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		userText = new RoundedTextField(20,50);
		userText.setHorizontalAlignment(SwingConstants.CENTER);
		userText.setColumns(10);
		userText.setBounds(320, 233, 191, 30);
		contentPane.add(userText);
		
		emailText = new RoundedTextField(20,50);
		emailText.setHorizontalAlignment(SwingConstants.CENTER);
		emailText.setColumns(10);
		emailText.setBounds(320, 282, 191, 30);
		contentPane.add(emailText);
		
		passwordText = new RoundedPasswordField(20,50);
		passwordText.setHorizontalAlignment(SwingConstants.CENTER);
		passwordText.setBounds(320, 334, 191, 27);
		contentPane.add(passwordText);
		
		confirmText = new RoundedPasswordField(20,50);
		confirmText.setHorizontalAlignment(SwingConstants.CENTER);
		confirmText.setBounds(320, 387, 191, 26);
		contentPane.add(confirmText);
		
		RoundedButton btnNewButton = new RoundedButton("submit",50);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   String username = nameText.getText();
				   String User=userText.getText();
	                String userEmail = emailText.getText();  // Use a different variable name to avoid conflicts
	                String newPassword = new String(passwordText.getPassword());
	                String confirmPassword = new String(confirmText.getPassword());

	                if (username.isEmpty() ||User.isEmpty()|| userEmail.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
	                    JOptionPane.showMessageDialog(contentPane, "All fields are mandatory. Please fill in all the details.");
	                } else if (!newPassword.equals(confirmPassword)) {
	                    JOptionPane.showMessageDialog(contentPane, "Passwords do not match. Please try again.");
	                } else if (checkUsernameExistence(username) || checkUsernameExistence(userEmail)) {
	                        JOptionPane.showMessageDialog(contentPane, "user alread exist!");}
	                else if (!userEmail.contains("@gmail.com") &&!userEmail.contains("@ymail.com") && !userEmail.contains("@hotmail.com") &&
	                	    !userEmail.contains("@bnmit.in")) {
	                	    JOptionPane.showMessageDialog(contentPane, "Invalid Email Id");
	                	}
	                   else{
	                	   if (insertData(username, User, userEmail, newPassword)) {
	                           JOptionPane.showMessageDialog(contentPane, "Signup Successful!\nYour are all set to play");
	                           login loginFrame = new login();
	                           loginFrame.show();
	                           dispose();
	                           
	                       } else {
	                           JOptionPane.showMessageDialog(contentPane, "Signup failed. Please try again.");
	                       }
	                        
	                    }
	                
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(223, 481, 149, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(sign.class.getResource("/images/login_page_bg2.png")));
		lblNewLabel_4.setBounds(0, 0, 611, 563);
		contentPane.add(lblNewLabel_4);
	}
	

	// Existing UI component declarations
    private static RoundedTextField nameText1;
    private static RoundedTextField userText1;
    private static RoundedTextField emailText1;
    private static RoundedPasswordField passwordText1;
    private static RoundedPasswordField confirmText1;

    // Insert data into the database
    private static boolean insertData(String name, String username, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "INSERT INTO signup (name, username, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, email);
            statement.setString(4, password);
            int rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if the username already exists
    private static boolean checkUsernameExistence(String username) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "SELECT COUNT(*) FROM signup WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            resultSet.close();
            statement.close();
            connection.close();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
