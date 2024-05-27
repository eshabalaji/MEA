//save the project as forgot.java
//this is a page created to reset the forgot password
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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
//rounded button code
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
//code for rounded textfield/textbox
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
//code for rounded password field
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
//function code
public class forgot extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private RoundedTextField name;
    private RoundedTextField email;
    private RoundedPasswordField password;
    private RoundedPasswordField confirmpassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    forgot frame = new forgot();
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
    public forgot() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 631, 726);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(forgot.class.getResource("/images/LOGO.png")));
        lblNewLabel.setBounds(195, 11, 179, 136);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("USER NAME");
        lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(84, 184, 164, 38);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("EMAIL");
        lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(84, 247, 164, 38);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("PASSWORD");
        lblNewLabel_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(84, 311, 164, 38);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("RE-ENTER");
        lblNewLabel_1_1_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(84, 382, 164, 38);
        contentPane.add(lblNewLabel_1_1_1_1);

        name = new RoundedTextField(20,50);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setBounds(273, 188, 251, 38);
        contentPane.add(name);
        name.setColumns(10);

        email = new RoundedTextField(20,50);
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setColumns(10);
        email.setBounds(273, 247, 251, 38);
        contentPane.add(email);

        RoundedButton btnNewButton = new RoundedButton("SUBMIT", 50);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = name.getText();
                String userEmail = email.getText();
                String newPassword = new String(password.getPassword());
                String confirmPassword = new String(confirmpassword.getPassword());

                if (username.isEmpty() || userEmail.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "All fields are mandatory.\nPlease fill in all the details.");
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(contentPane, "Passwords do not match.\nPlease try again.");
                } else {
                    if (checkUsernameExistence(username)&& checkEmailExistence(userEmail)) 
                    {                      
                        if (updatePassword(username, newPassword) && insertData(username, userEmail, newPassword)) {
                            JOptionPane.showMessageDialog(contentPane, "Password reset successful!");
                            // Add code to navigate to the login page or do something else.
                            login loginFrame = new login();
                            loginFrame.show();
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(contentPane, "Password reset failed. Please try again.");
                        }
                    }
                }
                
            }
        });

        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        btnNewButton.setBounds(223, 497, 164, 47);
        contentPane.add(btnNewButton);

        password = new RoundedPasswordField(20,50);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setBounds(275, 324, 249, 30);
        contentPane.add(password);

        confirmpassword = new RoundedPasswordField(20,50);
        confirmpassword.setHorizontalAlignment(SwingConstants.CENTER);
        confirmpassword.setBounds(273, 382, 249, 30);
        contentPane.add(confirmpassword);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(forgot.class.getResource("/images/login_page_bg2.png")));
        lblNewLabel_2.setBounds(0, 0, 617, 689);
        contentPane.add(lblNewLabel_2);
    }
//code for database connectivity
//replace the userdb,user and password with your data base table name,username and password
    private static boolean insertData(String username, String email, String password) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "INSERT INTO forgotpassword (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkUsernameExistence(String username) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "SELECT COUNT(*) FROM forgotpassword WHERE username=?";
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

    private static boolean checkEmailExistence(String email) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "SELECT COUNT(*) FROM forgotpassword WHERE email=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
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

    private static boolean updatePassword(String username, String newPassword) {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String user = "root";
        String password1 = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password1);
            String sql = "UPDATE signup SET password=? WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, username);
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            connection.close();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
