package interfacegraphic.interfaceorganisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class InCreationEtape extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public InCreationEtape() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JCheckBox chckbxEtapeAvecSpciale = new JCheckBox("Etape avec sp\u00E9ciale");
		chckbxEtapeAvecSpciale.setBounds(84, 129, 170, 21);
		contentPane.add(chckbxEtapeAvecSpciale);
		
		JLabel lblTempsLimite = new JLabel("Temps limite : ");
		lblTempsLimite.setBounds(84, 63, 85, 13);
		contentPane.add(lblTempsLimite);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(123, 188, 85, 21);
		contentPane.add(btnConfirmer);
	}
}
