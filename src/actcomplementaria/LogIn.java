package actcomplementaria;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogIn extends JFrame{
	private static JTextField user;
	private static JPasswordField password;
	private void ValidateData(Connection conn) throws SQLException {
		String who = user.getText();
		String auth = String.valueOf(password.getPassword());
                
                String adminData = "SELECT * FROM admin";
                
                Statement stmt = conn.createStatement();
                ResultSet result = stmt.executeQuery(adminData);
                if (result.next()) {
                    String user = result.getString(1);
                    String pass = result.getString(2);
                   if (!(who.equals(user)) || !(auth.equals(pass))) {
			 JOptionPane.showMessageDialog(null, "Datos incorrectos");
			 return;
                    }
                    JOptionPane.showMessageDialog(null, "Bienvenido");
                    administrator admin = new administrator(conn);
                    this.dispose(); 
                }
	}
	
	public LogIn(String title, int[] bounds, Connection conn) {
		setTitle(title);
		if (!(bounds.length == 4)) {
			bounds = new int[]{10, 10, 200, 200};
		}
		this.setSize(bounds[2], bounds[3]);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, ((bounds[2]/10)*9), ((bounds[3]/4)*3));
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel userLabel = new JLabel("Usuario");
		user = new JTextField(15);
		JLabel passwordLabel = new JLabel("Contraseña");
		password = new JPasswordField(15);
		JButton validate = new JButton("Iniciar sesión");
		validate.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
                        try {
                            ValidateData(conn);
                        } catch (SQLException ex) {
                            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                        }
		    }
		});
		this.add(panel);
		panel.add(userLabel);
		panel.add(user);
		panel.add(passwordLabel);
		panel.add(password);
		panel.add(validate);
		setVisible(true);
	}
}
