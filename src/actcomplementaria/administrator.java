package actcomplementaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

//https://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples

public class administrator extends JFrame {
	
	private void ErrorMsg() {
		JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos "
				+ "Rogelio Contreras González ES202103280");
	}
	
        private static void createAndShowGUI(Connection conn) {
        try {
            String usuarios = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(usuarios);
             //Create and set up the window.
            JFrame frame = new JFrame("SimpleTableDemo");

            //Create and set up the content pane.
            SimpleTable newContentPane = new SimpleTable(result);
            newContentPane.setOpaque(true); 
            frame.setContentPane(newContentPane);

            //Display the window.
            frame.pack();
            frame.setVisible(true);
        } 
        catch (SQLException ex) {
            System.out.println("Fallo para conectarse al servidor");
            System.out.println(ex.getMessage());
        }
    }
        
	public administrator(Connection conn) {
		setTitle("Administrador");
		setSize(500, 350);
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
		JTabbedPane panels = new JTabbedPane();
		JPanel panelUp = new JPanel();
		JPanel panelDown = new JPanel();
		panelUp.setLayout(null);

		JLabel nameLabel = new JLabel("Nombre");
                JLabel middleNameLabel = new JLabel("Apellido Paterno");
		JLabel lastNameLabel = new JLabel("Apellido Materno");
		JTextField middleName = new JTextField(16);
		JTextField name = new JTextField(10);
		JTextField lastName = new JTextField(10);
                
		nameLabel.setBounds(0, 10, 175, 25);
		middleNameLabel.setBounds(0, 60, 175, 25);
		lastNameLabel.setBounds(0, 110, 175, 25);
		
		name.setBounds(180, 10, 175, 25);
		middleName.setBounds(180, 60, 175, 25);
		lastName.setBounds(180, 110, 175, 25);
		
                panelUp.add(middleNameLabel);
		panelUp.add(middleName);
		panelUp.add(nameLabel);
		panelUp.add(name);
		panelUp.add(lastNameLabel);
		panelUp.add(lastName);
                
                JButton save = new JButton("Guardar");
                save.setBounds(180, 160, 175, 25);
                panelUp.add(save);
		panels.addTab("Altas", panelUp);
		
		JLabel clvUsuarioLabel = new JLabel("Clave de usuario");
		JTextField clvUsuario = new JTextField(16);
		JButton delete = new JButton("Eliminar");
                
		clvUsuarioLabel.setBounds(0, 10, 175, 25);
		clvUsuario.setBounds(180, 10, 175, 25);
		delete.setBounds(180, 60, 175, 25);
		panelDown.add(clvUsuarioLabel);
		panelDown.add(clvUsuario);
		panelDown.add(delete);
                
		panels.addTab("Bajas", panelDown);
	
		panels.setBounds(50, 0, 400, 250);
                
                JPanel panelBottom = new JPanel();
                panelBottom.setBounds(50, 260, 400, 150);
                JButton ver = new JButton("Ver usuarios");
                panelBottom.add(ver);
		add(panels);
                add(panelBottom);
                
                
		save.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String createEntry = "INSERT INTO users (nombre, aPaterno, aMaterno) VALUES (?,?,?)";
                        try {
                            PreparedStatement stmt = conn.prepareStatement(createEntry);
                            stmt.setString(1, name.getText());
                            stmt.setString(2, middleName.getText());
                            stmt.setString(3, lastName.getText());
                            int rowsInserted = stmt.executeUpdate();
                            if (rowsInserted > 0) {
                                JOptionPane.showMessageDialog(null, "Usuario creado");
                                name.setText("");
                                middleName.setText("");
                                lastName.setText("");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(administrator.class.getName()).log(Level.SEVERE, null, ex);
                        }
		    }
		});
		
		delete.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		       String deleteEntry = "DELETE FROM users WHERE clv_usuario=?"; 
                       PreparedStatement stmt;
                        try {
                            stmt = conn.prepareStatement(deleteEntry);
                            stmt.setString(1, clvUsuario.getText());
                            int rowsDeleted = stmt.executeUpdate();
                            if (rowsDeleted > 0) {
                                JOptionPane.showMessageDialog(null, "Usuario borrado");
                                clvUsuario.setText("");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(administrator.class.getName()).log(Level.SEVERE, null, ex);
                        }                
		    }
		});
                
                ver.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		      createAndShowGUI(conn);         
		    }
		});
		setVisible(true);
	}
}
