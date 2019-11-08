package interfacegraphic.coureur.interfaceinscritrallye;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import data.*;
import java.util.ArrayList;

public class insvoirConcurrents extends JFrame {

	private JPanel contentPane;
	private JList listconcurrent;

	public insvoirConcurrents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Liste de vos Concurrents");
		lblNewLabel.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblNewLabel.setBounds(29, 21, 144, 15);
		contentPane.add(lblNewLabel);

		listconcurrent = new JList();
		listconcurrent.setBounds(29, 40, 537, 156);
		contentPane.add(listconcurrent);
		// inilstconcurrents() ;
		ArrayList<Addcoureur> colist = Coureuroperation.getInstance().selectcourse();
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (Addcoureur addc : colist) {
			dlm.addElement("Num: " + addc.getIdcou() + "\t" + " Nom: " + addc.getNomcou() + "\t" + " Prenom: "
					+ addc.getPrenomcou() + "\t" + " Datenaissance: " + addc.getDatenaissance() + "\t"
					+ " groupe sang: " + addc.getSang() + "\t");
		}

		listconcurrent.setModel(dlm);

	}

	/*
	 * public void inilstconcurrents() { ArrayList<Addcoureur> colist =
	 * Coureuroperation.getInstance().selectcourse();
	 * 
	 * for (Addcoureur co : colist) { System.out.print(co.getIdcou() + "\t" +
	 * co.getNomcou() + "\t" + co.getPrenomcou() + "\t" + co.getDatenaissance()+
	 * "\t" + co.getSang()+ "\t" ); System.out.println(); } }
	 */

}
