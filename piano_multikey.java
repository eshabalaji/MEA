//save the jframe project as piano_multikey.java
//replace the package name with your package name
package project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


//code to create multiplekeys and adding their tunes and functionality
public class piano_multikey extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JRadioButton rbtn;
    private JComboBox<String> comboBox;
    private JRadioButton frame1_2;
    private JRadioButton frame3_4;
    private JRadioButton frame5_6;
    private JRadioButton frame7_8;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    piano_multikey frame = new piano_multikey();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	 piano_multikey frame = new piano_multikey();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public piano_multikey() {
    	setTitle("MELODIA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1328, 698);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(piano_multikey.class.getResource("/images/LOGO.png")));
        lblNewLabel_4.setBounds(1118, 0, 165, 157);
        contentPane.add(lblNewLabel_4);
        
        JLayeredPane panel = new JLayeredPane();
        panel.setBorder(UIManager.getBorder("FileChooser.listViewBorder"));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(942, 366, 200, 205);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JRadioButton frame1_2 = new JRadioButton("Octave 1 - 2");
        frame1_2.setSelected(true);
        buttonGroup.add(frame1_2);
        frame1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame1_2.isSelected()==true)
        		{
					frame3_4.setSelected(false);
					frame5_6.setSelected(false);
					frame7_8.setSelected(false);					
        			
        		}
        	}
        });
        frame1_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame1_2.setBackground(new Color(0, 0, 0));
        frame1_2.setForeground(new Color(255, 255, 255));
        frame1_2.setBounds(6, 7, 172, 35);
        panel.add(frame1_2);
        
        JRadioButton frame3_4 = new JRadioButton("Octave 3 - 4");
        buttonGroup.add(frame3_4);
        frame3_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame3_4.isSelected()==true)
        		{
					frame1_2.setSelected(false);
					frame5_6.setSelected(false);
					frame7_8.setSelected(false);					
        			
        		}
        	}
        });
        frame3_4.setForeground(new Color(255, 255, 255));
        frame3_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame3_4.setBackground(new Color(0, 0, 0));
        frame3_4.setBounds(6, 60, 172, 35);
        panel.add(frame3_4);
        
        JRadioButton frame5_6 = new JRadioButton("Octave 5 - 6");
        buttonGroup.add(frame5_6);
        frame5_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame5_6.isSelected())
        		{
					frame1_2.setSelected(false);
					frame3_4.setSelected(false);
					frame7_8.setSelected(false);					
        			
        		}
        	}
        });
        frame5_6.setForeground(new Color(255, 255, 255));
        frame5_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame5_6.setBackground(new Color(0, 0, 0));
        frame5_6.setBounds(6, 112, 172, 35);
        panel.add(frame5_6);
        
        JRadioButton frame7_8 = new JRadioButton("Octave 7 - 8");
        buttonGroup.add(frame7_8);
        frame7_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame7_8.isSelected()==true)
        		{
					frame1_2.setSelected(false);
					frame3_4.setSelected(false);
					frame5_6.setSelected(false);					
        			
        		}
        	}
        });
        frame7_8.setForeground(new Color(255, 255, 255));
        frame7_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame7_8.setBackground(new Color(0, 0, 0));
        frame7_8.setBounds(6, 163, 172, 35);
        panel.add(frame7_8);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(66, 342, 866, 271);
        contentPane.add(layeredPane);

        // Add items to the JComboBox
        comboBox = new JComboBox<>();
        comboBox.setBounds(842, 296, 150, 30);
        comboBox.addItem("Happy Birthday");
        comboBox.addItem("Drag me down");
        comboBox.addItem("Option 3");
        layeredPane.add(comboBox);
        JButton c1 = new JButton("");
        c1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        c1.setForeground(new Color(255, 255, 255));
        c1.setBackground(new Color(0, 0, 0));
        c1.setBounds(36, 39, 45, 135);
        c1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            	if(frame1_2.isSelected()) {
                try {
	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\Sharp notes\\Sharp notes\\C1# (online-audio-converter (mp3cut.net).wav"));
	Clip clip = AudioSystem.getClip();
	clip.open(audioInputStream);
	clip.start();
}
catch(Exception ex)
{
	ex.printStackTrace();
}
                if (rbtn.isSelected()) {
                    String currentText = textField.getText();
                    textField.setText(currentText + "C1#");
                }
            }
            
        	if(frame3_4.isSelected()) {
                try {
	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C3# (online-audio-converter (mp3cut.net).wav"));
	Clip clip = AudioSystem.getClip();
	clip.open(audioInputStream);
	clip.start();
}
catch(Exception ex)
{
	ex.printStackTrace();
}
                if (rbtn.isSelected()) {
                    String currentText = textField.getText();
                    textField.setText(currentText + "C3#");
                }
            }
         	if(frame5_6.isSelected()) {
                try {
	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C5# (online-audio-converter (mp3cut.net).wav"));
	Clip clip = AudioSystem.getClip();
	clip.open(audioInputStream);
	clip.start();
}
catch(Exception ex)
{
	ex.printStackTrace();
}
                if (rbtn.isSelected()) {
                    String currentText = textField.getText();
                    textField.setText(currentText + "C5#");
                }
            }
        	
         	if(frame7_8.isSelected()) {
                try {
	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C7# (online-audio-converter (mp3cut.net).wav"));
	Clip clip = AudioSystem.getClip();
	clip.open(audioInputStream);
	clip.start();
}
catch(Exception ex)
{
	ex.printStackTrace();
}
                if (rbtn.isSelected()) {
                    String currentText = textField.getText();
                    textField.setText(currentText + "C7#");
                }
            }
            }
              
        });
        
        JButton a2 = new JButton("");
        a2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A2# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A2#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A4# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A4#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A6# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A6#");
                    }
                }
    
        	}
        });
        a2.setBackground(Color.BLACK);
        a2.setBounds(718, 39, 45, 135);
        layeredPane.add(a2);
        
        JButton f2 = new JButton("");
        f2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F2# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F2#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F4# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F4#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F6# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F6#");
                    }
                }
        
        	}
        });
        f2.setBackground(Color.BLACK);
        f2.setBounds(592, 39, 45, 135);
        layeredPane.add(f2);
        
        JButton g2 = new JButton("");
        g2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G2# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G2#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G4# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G4#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G6# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G6#");
                    }
                }
       
        	}
        });
        g2.setBackground(Color.BLACK);
        g2.setBounds(652, 39, 45, 135);
        layeredPane.add(g2);
        
        JButton d2 = new JButton("");
        d2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D2# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "D2#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D4# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "D4#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D6# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "D6#");
                    }
                }
       
        		
        	}
        });
        d2.setBackground(Color.BLACK);
        d2.setBounds(494, 39, 45, 135);
        layeredPane.add(d2);
        
        JButton c2 = new JButton("");
        c2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
             	if(frame1_2.isSelected()) {
                    try {
    	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C2# (online-audio-converter (mp3cut.net).wav"));
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioInputStream);
    	clip.start();
    }
    catch(Exception ex)
    {
    	ex.printStackTrace();
    }
                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "C2#");
                    }
                }
             	if(frame3_4.isSelected()) {
                    try {
    	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C4# (online-audio-converter (mp3cut.net).wav"));
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioInputStream);
    	clip.start();
    }
    catch(Exception ex)
    {
    	ex.printStackTrace();
    }
                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "C4#");
                    }
                }
             	if(frame5_6.isSelected()) {
                    try {
    	AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C6# (online-audio-converter (mp3cut.net).wav"));
    	Clip clip = AudioSystem.getClip();
    	clip.open(audioInputStream);
    	clip.start();
    }
    catch(Exception ex)
    {
    	ex.printStackTrace();
    }
                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "C6#");
                    }
                }

        	}
        });
        c2.setBackground(Color.BLACK);
        c2.setBounds(429, 39, 45, 135);
        layeredPane.add(c2);
        
        JButton f1 = new JButton("");
        f1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F1# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F1#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F3# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F3#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F5# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F5#");
                    }
                }
        		if(frame7_8.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F7# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "F7#");
                    }
                }
        	}
        });
        f1.setBackground(Color.BLACK);
        f1.setBounds(199, 39, 45, 135);
        layeredPane.add(f1);
        
        JButton g1 = new JButton("");
        g1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G1# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G1#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G3# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G3#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G5# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G5#");
                    }
                }
        		if(frame7_8.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G7# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G7#");
                    }
                }
        	}
        });
        g1.setBackground(Color.BLACK);
        g1.setBounds(259, 39, 45, 135);
        layeredPane.add(g1);
        
        JButton G1 = new JButton("");
        G1.setForeground(new Color(0, 0, 0));
        G1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G1");
                    }
                }
          		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G3");
                    }
                }
          		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G5 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G5");
                    }
                }
          		if(frame7_8.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G7 (online-audio-converter.com).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "G7");
                    }
                }
        	}
        });
        G1.setVerticalAlignment(SwingConstants.BOTTOM);
        G1.setBackground(Color.WHITE);
        G1.setBounds(225, 39, 60, 210);
        layeredPane.add(G1);
        
        JButton a1 = new JButton("");
        a1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(frame1_2.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A1# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A1#");
                    }
                }
        		if(frame3_4.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A3# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A3#");
                    }
                }
        		if(frame5_6.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A5# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A5#");
                    }
                }
        		if(frame7_8.isSelected()) {
                	try {
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A7# (online-audio-converter (mp3cut.net).wav"));
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    if (rbtn.isSelected()) {
                        String currentText = textField.getText();
                        textField.setText(currentText + "A7#");
                    }
                }
        	}
        });
        a1.setBackground(Color.BLACK);
        a1.setBounds(325, 39, 45, 135);
        layeredPane.add(a1);
        layeredPane.add(c1, new Integer(1));
        
                JButton d1 = new JButton("");
                d1.setBackground(new Color(0, 0, 0));
                d1.setBounds(101, 39, 45, 135);
                d1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(frame1_2.isSelected()) {
                    	try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\Sharp notes\\Sharp notes\\D1# (online-audio-converter (mp3cut.net).wav"));
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        if (rbtn.isSelected()) {
                            String currentText = textField.getText();
                            textField.setText(currentText + "D1#");
                        }
                    }
                        if(frame3_4.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D3# (online-audio-converter (mp3cut.net).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "D3#");
                            }
                        }
                        if(frame5_6.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D5# (online-audio-converter (mp3cut.net).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "D5#");
                            }
                        }
                        if(frame7_8.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D7# (online-audio-converter (mp3cut.net).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "D7#");
                            }
                        }
                    }
                });
                layeredPane.add(d1, new Integer(1));
                
                JButton C1 = new JButton("");
                C1.setForeground(new Color(0, 0, 0));
                C1.setVerticalAlignment(SwingConstants.BOTTOM);
                C1.setVerticalTextPosition(SwingConstants.TOP);
                C1.setBackground(new Color(255, 255, 255));
                C1.setBounds(0, 39, 60, 210);
                C1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	if(frame1_2.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "C1");
                            }
                        }
                    	if(frame3_4.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "C3");
                            }
                        }
                    	if(frame5_6.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C5 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "C5");
                            }
                        }
                    	if(frame7_8.isSelected()) {
                        	try {
                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C7 Piano Note (online-audio-converter.com).wav"));
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioInputStream);
                                clip.start();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                            if (rbtn.isSelected()) {
                                String currentText = textField.getText();
                                textField.setText(currentText + "C7");
                            }
                        }
                    }
                });
                layeredPane.add(C1, new Integer(0));
                        
                                JButton D1 = new JButton("");
                                D1.setForeground(new Color(0, 0, 0));
                                D1.setVerticalAlignment(SwingConstants.BOTTOM);
                                D1.setBackground(new Color(255, 255, 255));
                                D1.setBounds(58, 39, 59, 210);
                                D1.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                                               	
                                    	if(frame1_2.isSelected()) {
                                        	try {
                                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                                                Clip clip = AudioSystem.getClip();
                                                clip.open(audioInputStream);
                                                clip.start();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }

                                            if (rbtn.isSelected()) {
                                                String currentText = textField.getText();
                                                textField.setText(currentText + "D1");
                                            }
                                        }
                                     	if(frame3_4.isSelected()) {
                                        	try {
                                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                Clip clip = AudioSystem.getClip();
                                                clip.open(audioInputStream);
                                                clip.start();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }

                                            if (rbtn.isSelected()) {
                                                String currentText = textField.getText();
                                                textField.setText(currentText + "D3");
                                            }
                                        }
                                     	if(frame5_6.isSelected()) {
                                        	try {
                                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D5 Piano Note (128 kbps) (online-audio-converter.com).wav"));
                                                Clip clip = AudioSystem.getClip();
                                                clip.open(audioInputStream);
                                                clip.start();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }

                                            if (rbtn.isSelected()) {
                                                String currentText = textField.getText();
                                                textField.setText(currentText + "D5");
                                            }
                                        }
                                     	if(frame7_8.isSelected()) {
                                        	try {
                                                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D7 (online-audio-converter (online-audio-converter.com).wav"));
                                                Clip clip = AudioSystem.getClip();
                                                clip.open(audioInputStream);
                                                clip.start();
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }

                                            if (rbtn.isSelected()) {
                                                String currentText = textField.getText();
                                                textField.setText(currentText + "D7");
                                            }
                                        }
                                    }
                                });
                                layeredPane.add(D1, new Integer(0));
                                
                                        JButton E1 = new JButton("");
                                        E1.setForeground(new Color(0, 0, 0));
                                        E1.setVerticalAlignment(SwingConstants.BOTTOM);
                                        E1.setBackground(new Color(255, 255, 255));
                                        E1.setBounds(115, 39, 57, 210);
                                        E1.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                             	if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E1");
                                                    }
                                                }
                                            	if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E3");
                                                    }
                                                }
                                            	if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E5 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E5");
                                                    }
                                                }
                                            	if(frame7_8.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E7 (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E7");
                                                    }
                                                }
                                             	
                                            }
                                        });
                                        layeredPane.add(E1, new Integer(0));
                                        
                                        JButton A1 = new JButton("");
                                        A1.setForeground(new Color(0, 0, 0));
                                        A1.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                          		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A1");
                                                    }
                                                }
                                          		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A3");
                                                    }
                                                }
                                          		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A5 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A5");
                                                    }
                                                }
                                          		if(frame7_8.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A7 (online-audio-converter (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A7");
                                                    }
                                                }
                                        	}
                                        });
                                        A1.setVerticalAlignment(SwingConstants.BOTTOM);
                                        A1.setBackground(Color.WHITE);
                                        A1.setBounds(282, 39, 59, 210);
                                        layeredPane.add(A1);
                                        
                                        JButton B1 = new JButton("");
                                        B1.setForeground(new Color(0, 0, 0));
                                        B1.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B1");
                                                    }
                                                }
                                        		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B3");
                                                    }
                                                }
                                        		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B5 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B5");
                                                    }
                                                }
                                        		if(frame7_8.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B7 (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B7");
                                                    }
                                                }
                                        	}
                                        });
                                        B1.setVerticalAlignment(SwingConstants.BOTTOM);
                                        B1.setBackground(Color.WHITE);
                                        B1.setBounds(338, 39, 57, 210);
                                        layeredPane.add(B1);
                                        
                                        JButton F1 = new JButton("");
                                        F1.setForeground(new Color(0, 0, 0));
                                        F1.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F1 Piano Note (128 kbps) (online-audio-converter (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F1");
                                                    }
                                                }
                                        		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F3 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F3");
                                                    }
                                                }
                                        		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F5 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F5");
                                                    }
                                                }
                                        		if(frame7_8.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F7 (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F7");
                                                    }
                                                }
                                        		
                                        	}
                                        });
                                        F1.setVerticalAlignment(SwingConstants.BOTTOM);
                                        F1.setBackground(Color.WHITE);
                                        F1.setBounds(170, 39, 57, 210);
                                        layeredPane.add(F1);
                                        

JButton C2 = new JButton("");
C2.setForeground(new Color(0, 0, 0));
C2.setVerticalAlignment(SwingConstants.BOTTOM);
C2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    	if(frame1_2.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C2 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "C2");
            }
        }
    	if(frame3_4.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C4 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "C4");
            }
        }
    	if(frame5_6.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C6 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "C6");
            }
        }
    	if(frame7_8.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\C8 Piano Note (mp3cut.net).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "C8");
            }
        }
    }
});
C2.setBackground(Color.WHITE);
C2.setBounds(393, 39, 60, 210);
layeredPane.add(C2);
                                        
JButton D2 = new JButton("");
D2.setForeground(new Color(0, 0, 0));
D2.setVerticalAlignment(SwingConstants.BOTTOM);
D2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     	if(frame1_2.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D2 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "D2");
            }
        }
     	if(frame3_4.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D4 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "D4");
            }
        }
     	if(frame5_6.isSelected()) {
        	try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\D6 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (rbtn.isSelected()) {
                String currentText = textField.getText();
                textField.setText(currentText + "D6");
            }
        }
    }
});
D2.setBackground(Color.WHITE);
D2.setBounds(451, 39, 59, 210);
layeredPane.add(D2);
                                        
                                        JButton E2 = new JButton("");
                                        E2.setForeground(new Color(0, 0, 0));
                                        E2.setVerticalAlignment(SwingConstants.BOTTOM);
                                        E2.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		
                                        		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E2 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E2");
                                                    }
                                                }
                                        		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E4 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E4");
                                                    }
                                                }
                                        		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\E6 Piano Note (128 kbps) (Snap2s (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "E6");
                                                    }
                                                }
                                        	}
                                        });
                                        E2.setBackground(Color.WHITE);
                                        E2.setBounds(507, 39, 57, 210);
                                        layeredPane.add(E2);
                                        
                                        JButton F2 = new JButton("");
                                        F2.setForeground(new Color(0, 0, 0));
                                        F2.setVerticalAlignment(SwingConstants.BOTTOM);
                                        F2.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		
                                        		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F2 Piano Note (128 kbps) (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F2");
                                                    }
                                                }
                                        		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F4 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F4");
                                                    }
                                                }
                                        		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\F6 Piano Note (128 kbps) (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "F6");
                                                    }
                                                }
                                        	}
                                        });
                                        F2.setBackground(Color.WHITE);
                                        F2.setBounds(562, 39, 57, 210);
                                        layeredPane.add(F2);
                                        
                                        JButton G2 = new JButton("");
                                        G2.setForeground(new Color(0, 0, 0));
                                        G2.setVerticalAlignment(SwingConstants.BOTTOM);
                                        G2.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                       		
                                          		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G2 Piano Note (128 kbps) (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "G2");
                                                    }
                                                }
                                          		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G4 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "G4");
                                                    }
                                                }
                                          		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\G6 Piano Note (128 kbps) (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "G6");
                                                    }
                                                }
                                        	}
                                        });
                                        G2.setBackground(Color.WHITE);
                                        G2.setBounds(617, 39, 60, 210);
                                        layeredPane.add(G2);
                                        
                                        JButton A2 = new JButton("");
                                        A2.setForeground(new Color(0, 0, 0));
                                        A2.setVerticalAlignment(SwingConstants.BOTTOM);
                                        A2.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		
                                        		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A2 Piano Note (128 kbps) (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A2");
                                                    }
                                                }
                                        		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A4 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A4");
                                                    }
                                                }
                                        		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\A6 Piano Note (128 kbps) (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "A6");
                                                    }
                                                }
                                        	}
                                        });
                                        A2.setBackground(Color.WHITE);
                                        A2.setBounds(675, 39, 59, 210);
                                        layeredPane.add(A2);
                                        
                                        JButton B2 = new JButton("");
                                        B2.setForeground(new Color(0, 0, 0));
                                        B2.setVerticalAlignment(SwingConstants.BOTTOM);
                                        B2.addActionListener(new ActionListener() {
                                        	public void actionPerformed(ActionEvent e) {
                                        		
                                        		if(frame1_2.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B2 Piano Note (128 kbps) (Snap2s (mp3cut.net).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B2");
                                                    }
                                                }
                                        		if(frame3_4.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B4 Piano Note (128 kbps) (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B4");
                                                    }
                                                }
                                        		if(frame5_6.isSelected()) {
                                                	try {
                                                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\balaj\\OneDrive\\Desktop\\java project\\final notes\\B6 Piano Note (128 kbps) (online-audio-converter.com).wav"));
                                                        Clip clip = AudioSystem.getClip();
                                                        clip.open(audioInputStream);
                                                        clip.start();
                                                    } catch (Exception ex) {
                                                        ex.printStackTrace();
                                                    }

                                                    if (rbtn.isSelected()) {
                                                        String currentText = textField.getText();
                                                        textField.setText(currentText + "B6");
                                                    }
                                                }
                                              }
                                        });
                                        B2.setBackground(Color.WHITE);
                                        B2.setBounds(730, 39, 55, 210);
                                        layeredPane.add(B2);
                                        //layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{C1, D1, E1, comboBox, F1, G1, A1, B1, C2, a2, D2, E2, f2, G2, A2, B2, g2, d2, c2, f1, g1, a1, c1, d1, F2}));
        // ... Other components ...

        JPanel panel1 = new JPanel();
        panel1.setBounds(940, 0, 214, 659);
        contentPane.add(panel1);
        panel1.setLayout(null);
        
        JRadioButton set = new JRadioButton("Set Button Name");
        set.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        set.setBackground(new Color(0, 0, 0));
        set.setForeground(new Color(255, 255, 255));
        set.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		if(set.isSelected())
        		{
        			if(frame1_2.isSelected())
        			{
        				C1.setText("C1");
        				D1.setText("D1");
        				E1.setText("E1");
        				F1.setText("F1");
        				G1.setText("G1");
        				A1.setText("A1");
        				B1.setText("B1");
        				C2.setText("C2");
        				D2.setText("D2");
        				E2.setText("E2");
        				F2.setText("F2");
        				G2.setText("G2");
        				A2.setText("A2");
        				B2.setText("B2");
        				//set.setSelected(false);
        			}
        			else if(frame3_4.isSelected())
        			{
        				C1.setText("C3");
        				D1.setText("D3");
        				E1.setText("E3");
        				F1.setText("F3");
        				G1.setText("G3");
        				A1.setText("A3");
        				B1.setText("B3");
        				C2.setText("C4");
        				D2.setText("D4");
        				E2.setText("E4");
        				F2.setText("F4");
        				G2.setText("G4");
        				A2.setText("A4");
        				B2.setText("B4");
        				//set.setSelected(false);
        			}
        			else if(frame5_6.isSelected())
        			{
        				C1.setText("C5");
        				D1.setText("D5");
        				E1.setText("E5");
        				F1.setText("F5");
        				G1.setText("G5");
        				A1.setText("A5");
        				B1.setText("B5");
        				C2.setText("C6");
        				D2.setText("D6");
        				E2.setText("E6");
        				F2.setText("F6");
        				G2.setText("G6");
        				A2.setText("A6");
        				B2.setText("B6");
        			}
        			else if(frame7_8.isSelected())
        			{
        				C1.setText("C7");
        				D1.setText("D7");
        				E1.setText("E7");
        				F1.setText("F7");
        				G1.setText("G7");
        				A1.setText("A7");
        				B1.setText("B7");
        				C2.setText("C8");
        				D2.setText("");
        				E2.setText("");
        				F2.setText("");
        				G2.setText("");
        				A2.setText("");
        				B2.setText("");
        				//set.setSelected(false);
        			}
        		}
        		
        		if(!set.isSelected())
        		{
        			C1.setText("");
    				D1.setText("");
    				E1.setText("");
    				F1.setText("");
    				G1.setText("");
    				A1.setText("");
    				B1.setText("");
    				C2.setText("");
    				D2.setText("");
    				E2.setText("");
    				F2.setText("");
    				G2.setText("");
    				A2.setText("");
    				B2.setText("");
        		}
        		
        	}
        });
        set.setBounds(0, 290, 208, 39);
        panel1.add(set);

        JButton LOGOUT1 = new JButton("LOGOUT");
        LOGOUT1.setBackground(new Color(0, 0, 0));
        LOGOUT1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        LOGOUT1.setForeground(new Color(255, 255, 255));
        LOGOUT1.setBounds(0, 39, 204, 34);
        panel1.add(LOGOUT1);

        JButton CLEAR1 = new JButton("CLEAR");
        CLEAR1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        CLEAR1.setForeground(new Color(255, 255, 255));
        CLEAR1.setBackground(new Color(0, 0, 0));
        CLEAR1.setBounds(0, 84, 204, 34);
        panel1.add(CLEAR1);

        // ... Other components ...

        // Add items to the JComboBox in panel1
        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        comboBox_1.setForeground(new Color(255, 255, 255));
        comboBox_1.setBackground(new Color(0, 0, 0));
        comboBox_1.setBounds(0, 239, 204, 34);
        comboBox_1.addItem("HAPPY BIRTHDAY");
        comboBox_1.addItem("JINGLE BELL");
        comboBox_1.addItem("MISSION IMPOSSIBLE");
        panel1.add(comboBox_1);
        
                // ... (Other component declarations)
        
                JButton btnNewButton = new JButton("SET MUSIC");
                btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                btnNewButton.setBackground(new Color(0, 0, 0));
                btnNewButton.setForeground(new Color(255, 255, 255));
                btnNewButton.setBounds(0, 188, 204, 34);
                panel1.add(btnNewButton);
                
                
                // ... (Other button declarations)

                rbtn = new JRadioButton("TYPE TEXT");
                rbtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
                rbtn.setForeground(new Color(255, 255, 255));
                rbtn.setBounds(0, 136, 204, 34);
                panel1.add(rbtn);
                rbtn.setBackground(new Color(0, 0, 0));
                rbtn.setSelected(true);
                
                JLabel lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setIcon(new ImageIcon(piano_multikey.class.getResource("/images/woodbg_strip1.png")));
                lblNewLabel_2.setBounds(0, 0, 256, 659);
                panel1.add(lblNewLabel_2);
                
                JToggleButton toggleButton = new JToggleButton("New toggle button");
                toggleButton.setBounds(0, 336, 123, 23);
                panel1.add(toggleButton);
                rbtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (rbtn.isSelected()) {
                            textField.setText("");
                        }
                    }
                });
            
                btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedSong = (String) comboBox_1.getSelectedItem();
                        
                        if ("JINGLE BELL".equals(selectedSong)) {
                            textField.setText("E E E E E E E G C D E");
                        } else if ("HAPPY BIRTHDAY".equals(selectedSong)) {
                            textField.setText("G G A G C B G G A G D C G G G E C B A F F E C D C");
                        }
                        rbtn.setSelected(false);
                    }
                });

        CLEAR1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        LOGOUT1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        textField = new JTextField();
        textField.setSelectionEnd(10);
        textField.setBorder(UIManager.getBorder("TextField.border"));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textField.setBounds(38, 21, 877, 278);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(piano_multikey.class.getResource("/images/woodbg3.png")));
        lblNewLabel.setBounds(0, -31, 1154, 709);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(962, 27, 165, 291);
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon(piano_multikey.class.getResource("/images/keyboard bg3.png")));
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(piano_multikey.class.getResource("/images/border.png")));
        lblNewLabel_3.setBounds(1152, 136, 131, 525);
        contentPane.add(lblNewLabel_3);   
    }

    private void playAudio(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
