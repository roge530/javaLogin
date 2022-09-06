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

public class administrator extends JFrame {
	
	private void ErrorMsg() {
		JOptionPane.showMessageDialog(null, "No se puede conectar con la base de datos "
				+ "Rogelio Contreras González ES202103280");
	}
	
	public administrator() {
		setTitle("Administrador");
		setSize(500, 350);
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane panels = new JTabbedPane();
		JPanel panelUp = new JPanel();
		JPanel panelDown = new JPanel();
		JPanel panelMod = new JPanel();
		JPanel panelQuery = new JPanel();
		JPanel panelBottom = new JPanel();
		panelUp.setLayout(null);
		panelDown.setLayout(null);
		panelMod.setLayout(null);
		panelQuery.setLayout(null);
		JLabel numAccountLabel = new JLabel("Número de cuenta");
		JLabel numCardLabel = new JLabel("Número de cuenta");
		JLabel nameLabel = new JLabel("Nombre");
		JLabel lastNameLabel = new JLabel("Apellido");
		JTextField numAccount = new JTextField(16);
		JTextField numCard = new JTextField(16);
		JTextField name = new JTextField(10);
		JTextField lastName = new JTextField(10);
		numAccountLabel.setBounds(0, 0, 175, 25);
		numCardLabel.setBounds(0, 50, 175, 25);
		nameLabel.setBounds(0, 100, 175, 25);
		lastNameLabel.setBounds(0, 150, 175, 25);
		
		numAccount.setBounds(180, 0, 175, 25);
		numCard.setBounds(180, 50, 175, 25);
		name.setBounds(180, 100, 175, 25);
		lastName.setBounds(180, 150, 175, 25);
		
		panelUp.add(numAccountLabel);
		panelUp.add(numAccount);
		panelUp.add(numCardLabel);
		panelUp.add(numCard);
		panelUp.add(nameLabel);
		panelUp.add(name);
		panelUp.add(lastNameLabel);
		panelUp.add(lastName);
		panels.addTab("Altas", panelUp);
		
		JLabel numAccountLabel2 = new JLabel("Número de cuenta");
		JLabel numCardLabel2 = new JLabel("Número de tarjeta");
		JTextField numAccount2 = new JTextField(16);
		JTextField numCard2 = new JTextField(16);
		
		numAccountLabel2.setBounds(0, 0, 175, 25);
		numCardLabel2.setBounds(0, 50, 175, 25);
		numAccount2.setBounds(180, 0, 175, 25);
		numCard2.setBounds(180, 50, 175, 25);
		
		panelDown.add(numAccountLabel2);
		panelDown.add(numAccount2);
		panelDown.add(numCardLabel2);
		panelDown.add(numCard2);
		panels.addTab("Bajas", panelDown);
		
		JLabel numAccountLabel3 = new JLabel("Número de cuenta");
		JLabel numCardLabel3 = new JLabel("Número de tarjeta");
		JTextField numAccount3 = new JTextField(16);
		JTextField numCard3 = new JTextField(16);
		
		numAccountLabel3.setBounds(0, 0, 175, 25);
		numCardLabel3.setBounds(0, 50, 175, 25);
		numAccount3.setBounds(180, 0, 175, 25);
		numCard3.setBounds(180, 50, 175, 25);
		
		panelMod.add(numAccountLabel3);
		panelMod.add(numAccount3);
		panelMod.add(numCardLabel3);
		panelMod.add(numCard3);
		panels.addTab("Modificaciones", panelMod);
		
		JLabel numAccountLabel4 = new JLabel("Número de cuenta");
		JLabel numCardLabel4 = new JLabel("Número de tarjeta");
		JTextField numAccount4 = new JTextField(16);
		JTextField numCard4 = new JTextField(16);
		
		numAccountLabel4.setBounds(0, 0, 175, 25);
		numCardLabel4.setBounds(0, 50, 175, 25);
		numAccount4.setBounds(180, 0, 175, 25);
		numCard4.setBounds(180, 50, 175, 25);
		
		panelQuery.add(numAccountLabel4);
		panelQuery.add(numAccount4);
		panelQuery.add(numCardLabel4);
		panelQuery.add(numCard4);
		panels.addTab("Consultas", panelQuery);
		
		JButton save = new JButton("Guardar");
		JButton delete = new JButton("Eliminar");
		JButton edit = new JButton("Editar");
		panels.setBounds(50, 0, 400, 250);
		panelBottom.setBounds(50, 260, 400, 150);
		add(panels);
		panelBottom.add(save);
		panelBottom.add(delete);
		panelBottom.add(edit);
		add(panelBottom);

		save.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ErrorMsg();
		    }
		});
		
		delete.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ErrorMsg();
		    }
		});
		
		edit.addActionListener((ActionListener) new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ErrorMsg();
		    }
		});
		//add(panelBottom);
		setVisible(true);
	}
}
