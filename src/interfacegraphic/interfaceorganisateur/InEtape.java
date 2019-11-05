package interfacegraphic.interfaceorganisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.Course;
import gestioncourse.Edition;
import gestioncourse.Etape;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class InEtape extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTl;
	private JLabel lblNomcourse;
	private JLabel lblEdition;
	private JLabel labelNum;
	private JLabel lblAnnee;
	private JLabel lblTempsLimite;
	private JList<String> listEtape;
	/**
	 * Create the frame.
	 * @param ed 
	 */
	public InEtape(Edition ed, Course c) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTempsLimite = new JLabel("Temps limite : ");
		lblTempsLimite.setBounds(226, 60, 85, 13);
		contentPane.add(lblTempsLimite);
		
		textFieldTl = new JTextField();
		textFieldTl.setBounds(347, 57, 96, 19);
		contentPane.add(textFieldTl);
		textFieldTl.setColumns(10);
		
		listEtape = new JList<String>();
		//afficher les étapes lors qu'on choisi un édition
		listEtape.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(listEtape.getSelectedIndex()!=-1) {
					afficherEtapeSelected(ed.getEtape(listEtape.getSelectedIndex()));
				}
			}
		});
		
		
		listEtape.setBounds(31, 44, 146, 280);
		contentPane.add(listEtape);
		
		lblNomcourse = new JLabel("NomCourse");
		lblNomcourse.setBounds(31, 21, 70, 13);
		contentPane.add(lblNomcourse);
		
		lblEdition = new JLabel("Edition : ");
		lblEdition.setBounds(148, 21, 68, 13);
		contentPane.add(lblEdition);
		
		labelNum = new JLabel("No.");
		labelNum.setBounds(226, 21, 46, 13);
		contentPane.add(labelNum);
		
		lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(282, 21, 70, 13);
		contentPane.add(lblAnnee);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(55, 334, 85, 21);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(226, 100, 85, 21);
		contentPane.add(btnModifier);
		
		init(ed,c);
	}
	
	
	
	private void init(Edition e,Course c) {
		//titire du course
			lblNomcourse.setText(c.getNomCourse());
			labelNum.setText(String.valueOf(e.getNumEdition()));
			lblAnnee.setText(e.getAnnee());
		// initialiser la liste des course			
				DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
				for(Etape et : e.getListeEtape()) {
					dlm.addElement("Etape "+et.getNumEtape());		
				}
				listEtape.setModel(dlm);

	}

	private void afficherEtapeSelected(Etape et) {
		textFieldTl.setText(String.valueOf(et.getTempsLimiteEtape()));
	}

}
