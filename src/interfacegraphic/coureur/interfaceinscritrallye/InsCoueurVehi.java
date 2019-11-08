package interfacegraphic.coureur.interfaceinscritrallye;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import data.*;

import javax.swing.*;

public class InsCoueurVehi extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldidcou;
	private JTextField textFieldnom;
	private JTextField textFieldprenom;
	private JTextField textFielddatenai;
	private JTextField textFieldgroupesang;
	private JTextField textFieldidv;
	private JTextField textFieldmodele;
	private JTextField textFieldimm;
	private Connection conn;

	public InsCoueurVehi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblcoureur = new JLabel("Completer la formulaire ");
		lblcoureur.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblcoureur.setBounds(84, 13, 148, 15);
		contentPane.add(lblcoureur);

		JLabel lblNewLabel = new JLabel("Coureur");
		lblNewLabel.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNewLabel.setBounds(41, 38, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNom.setBounds(41, 87, 38, 17);
		contentPane.add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblPrenom.setBounds(41, 114, 54, 15);
		contentPane.add(lblPrenom);

		JLabel lblDatenaissa = new JLabel("Datenaissance");
		lblDatenaissa.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblDatenaissa.setBounds(41, 139, 93, 15);
		contentPane.add(lblDatenaissa);

		JLabel lblGroupesang = new JLabel("GroupeSang");
		lblGroupesang.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblGroupesang.setBounds(41, 166, 82, 15);
		contentPane.add(lblGroupesang);

		textFieldnom = new JTextField();
		textFieldnom.setBounds(137, 86, 166, 21);
		contentPane.add(textFieldnom);
		textFieldnom.setColumns(10);

		textFieldprenom = new JTextField();
		textFieldprenom.setBounds(137, 111, 166, 21);
		contentPane.add(textFieldprenom);
		textFieldprenom.setColumns(10);

		textFielddatenai = new JTextField();
		textFielddatenai.setBounds(137, 138, 166, 21);
		contentPane.add(textFielddatenai);
		textFielddatenai.setColumns(10);

		textFieldgroupesang = new JTextField();
		textFieldgroupesang.setBounds(137, 163, 166, 21);
		contentPane.add(textFieldgroupesang);
		textFieldgroupesang.setColumns(10);

		JLabel lblVhicule = new JLabel("V\u00E9hicule ");
		lblVhicule.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblVhicule.setBounds(41, 194, 54, 15);
		contentPane.add(lblVhicule);

		JLabel lblNewLabel_1 = new JLabel("IDv\u00E9hicule ");
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(41, 219, 60, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblModele = new JLabel("Modele");
		lblModele.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblModele.setBounds(41, 244, 48, 15);
		contentPane.add(lblModele);

		JLabel lblImm = new JLabel("Imm");
		lblImm.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblImm.setBounds(41, 269, 38, 15);
		contentPane.add(lblImm);

		textFieldimm = new JTextField();
		textFieldimm.setBounds(137, 266, 166, 21);
		contentPane.add(textFieldimm);
		textFieldimm.setColumns(10);

		textFieldmodele = new JTextField();
		textFieldmodele.setBounds(137, 241, 166, 21);
		contentPane.add(textFieldmodele);
		textFieldmodele.setColumns(10);

		textFieldidv = new JTextField();
		textFieldidv.setBounds(137, 216, 166, 21);
		contentPane.add(textFieldidv);
		textFieldidv.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("IDcoureur");
		lblNewLabel_2.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(41, 63, 54, 15);
		contentPane.add(lblNewLabel_2);

		textFieldidcou = new JTextField();
		textFieldidcou.setBounds(138, 60, 165, 21);
		contentPane.add(textFieldidcou);
		textFieldidcou.setColumns(10);

		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.setFont(new Font("Arial MT", Font.PLAIN, 12));
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String idcou = textFieldidcou.getText();
				String nom = textFieldnom.getText();
				String prenom = textFieldprenom.getText();
				String datenaissance = textFielddatenai.getText();
				String groupesang = textFieldgroupesang.getText();
				String idv = textFieldidv.getText();
				String modele = textFieldmodele.getText();
				String imm = textFieldimm.getText();

				Addcoureur addc = new Addcoureur();
				addc.setIdcou(Integer.valueOf(idcou));
				addc.setNomcou(nom);
				addc.setPrenomcou(prenom);
				addc.setDatenaissance(datenaissance);
				addc.setSang(groupesang);

				vehicule v = new vehicule();
				v.setIdv(Integer.valueOf(idv));
				v.setModele(modele);
				v.setImm(imm);

				boolean res = Coureuroperation.getInstance().getInstance().saveCoureur(addc);
				if (res == true) {
					System.out.println("ok");
				} else {
					System.out.println("ko");
				}

				boolean res1 = Coureuroperation.getInstance().getInstance().savevehicule(v);
				if (res1 == true) {
					System.out.println("ok");
				} else {
					System.out.println("ko");
				}

				/*
				 * String sql = "insert into datebaseinscrit.coureur values (?,?,?,?,?);";
				 * String idcou = textFieldidcou.getText(); String nom = textFieldnom.getText();
				 * String prenom = textFieldprenom.getText(); String datenaissance =
				 * textFielddatenai.getText(); String groupesang =textFieldgroupesang.getText();
				 * PreparedStatement ps; try { ps = conn.prepareStatement(sql); ps.setInt(1,
				 * Integer.valueOf(idcou)); ps.setString(2, nom); ps.setString(3, prenom);
				 * ps.setDate(4, Date.valueOf(datenaissance)); ps.setString(5, groupesang); }
				 * catch (SQLException e1) { e1.printStackTrace(); }
				 */

			}
		});
		btnSinscrire.setBounds(97, 297, 93, 23);
		contentPane.add(btnSinscrire);
	}

	public void connectToDB() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		final String URL = "jdbc:mysql://localhost:3306/databaseinscrit";
		conn = DriverManager.getConnection(URL, "root", "taylor1213");
	}

}
