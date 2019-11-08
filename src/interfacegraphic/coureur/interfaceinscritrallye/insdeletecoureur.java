package interfacegraphic.coureur.interfaceinscritrallye;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Addcoureur;
import data.Coureuroperation;
import data.vehicule;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insdeletecoureur extends JFrame {

	private JPanel contentPane;
	private JTextField textFielddeletecou;
	private JTextField textFielddeletevehi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insdeletecoureur frame = new insdeletecoureur();
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
	public insdeletecoureur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Delete Vos infos");
		lblNewLabel.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 29, 300, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Saisir IDCoureur");
		lblNewLabel_1.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 65, 122, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblSaisirId = new JLabel("Saisir IDVehicule");
		lblSaisirId.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblSaisirId.setBounds(24, 95, 122, 15);
		contentPane.add(lblSaisirId);

		textFielddeletecou = new JTextField();
		textFielddeletecou.setBounds(157, 63, 136, 21);
		contentPane.add(textFielddeletecou);
		textFielddeletecou.setColumns(10);

		textFielddeletevehi = new JTextField();
		textFielddeletevehi.setBounds(156, 93, 138, 21);
		contentPane.add(textFielddeletevehi);
		textFielddeletevehi.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idcou = textFielddeletecou.getText();
				String idv = textFielddeletevehi.getText();

				Addcoureur addc = new Addcoureur();
				addc.setIdcou(Integer.valueOf(idcou));
				vehicule v = new vehicule();
				v.setIdv(Integer.valueOf(idv));

				boolean res = Coureuroperation.getInstance().deletecoureurById(addc);
				if (res) {
					System.out.println("ok");
				} else {
					System.out.println("ko");
				}

				boolean res1 = Coureuroperation.getInstance().deletevehiculeById(v);
				if (res) {
					System.out.println("ok");
				} else {
					System.out.println("ko");
				}

			}
		});
		btnDelete.setFont(new Font("Arial MT", Font.PLAIN, 12));
		btnDelete.setBounds(115, 137, 93, 23);
		contentPane.add(btnDelete);
	}
}
