package interfacegraphic.organisateur.rallye;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.Course;
import gestioncourse.CourseRallye;
import gestioncourse.Edition;
import gestioncourse.EditionRallye;
import gestioncourse.Etape;
import gestioncourse.EtapeRallye;
import interfacegraphic.organisateur.f1.InEtapeF1;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class InEtapeRallye extends JFrame {
	private JPanel contentPane;
	private JLabel lblNomcourse;
	private JLabel lblEdition;
	private JLabel labelNum;
	private JLabel lblAnnee;
	private JList<String> listEtapeRallye;
	private JButton btnContinuer;

	/**
	 * Create the frame.
	 * 
	 * @param ed
	 */
	public InEtapeRallye(EditionRallye ed, CourseRallye c) {
		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(ed, c);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listEtapeRallye = new JList<String>();
		// afficher les étapes lors qu'on choisi un édition
		listEtapeRallye.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listEtapeRallye.getSelectedIndex() != -1) {
					btnContinuer.setEnabled(true);
				} else {
					btnContinuer.setEnabled(false);
				}
			}
		});

		listEtapeRallye.setBounds(96, 44, 160, 280);
		contentPane.add(listEtapeRallye);

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

		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCreationEtapeRallye icet = new InCreationEtapeRallye(ed, c);
				icet.setVisible(true);
			}
		});

		btnAjouter.setBounds(81, 334, 85, 21);

		contentPane.add(btnAjouter);

		btnContinuer = new JButton("Continuer");
		btnContinuer.setEnabled(false);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtapeRallye etr = ed.getEtape(listEtapeRallye.getSelectedIndex());
				InSpeciale is = new InSpeciale(etr, ed, c);
				is.setVisible(true);
			}
		});
		btnContinuer.setBounds(195, 334, 85, 21);
		contentPane.add(btnContinuer);

		init(ed, c);
	}

	private void init(EditionRallye e, CourseRallye c) {

		// titire du course
		lblNomcourse.setText(c.getNomCourse());
		labelNum.setText(String.valueOf(e.getNumEdition()));
		lblAnnee.setText(e.getAnnee());
		// initialiser la liste des course
		DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
		for (EtapeRallye et : e.getLstEtape()) {
			dlm.addElement("Etape " + et.getNumEtape());
		}
		listEtapeRallye.setModel(dlm);

	}

}
