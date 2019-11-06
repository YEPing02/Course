package interfacegraphic.interfaceorganisateur.Rallye;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import donnee.Donnee;
import gestioncourse.Course;
import gestioncourse.Edition;
import interfacegraphic.interfaceorganisateur.F1.InEtapeF1;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;

public class InEditionRallye extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldDd;
	private JTextField textFieldDf;
	private JList<String> listEdition;
	private JLabel lblTypecourse;
	private JLabel lblNomcourse;

	/**
	 * Create the frame.
	 */
	public InEditionRallye(Course cr) {

		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(cr);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 590, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTypecourse = new JLabel("Typecourse");
		lblTypecourse.setBounds(188, 10, 91, 33);
		contentPane.add(lblTypecourse);

		lblNomcourse = new JLabel("NomCourse");
		lblNomcourse.setBounds(325, 20, 91, 13);
		contentPane.add(lblNomcourse);

		JLabel lblAnnee = new JLabel("Annee : ");
		lblAnnee.setBounds(350, 138, 46, 13);
		contentPane.add(lblAnnee);

		textFieldA = new JTextField();
		textFieldA.setBounds(406, 135, 96, 19);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);

		JLabel lblDateDbut = new JLabel("Date d\u00E9but : ");
		lblDateDbut.setBounds(338, 66, 46, 13);
		contentPane.add(lblDateDbut);

		JLabel lblDateFin = new JLabel("Date fin : ");
		lblDateFin.setBounds(338, 102, 46, 13);
		contentPane.add(lblDateFin);

		textFieldDd = new JTextField();
		textFieldDd.setBounds(406, 63, 96, 19);
		contentPane.add(textFieldDd);
		textFieldDd.setColumns(10);

		textFieldDf = new JTextField();
		textFieldDf.setBounds(406, 99, 96, 19);
		contentPane.add(textFieldDf);
		textFieldDf.setColumns(10);

		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.setEnabled(false);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InEtapeRallye ie = new InEtapeRallye(cr.getEdition(listEdition.getSelectedIndex()), cr);
				ie.setVisible(true);
			}
		});

		btnContinuer.setBounds(362, 348, 85, 21);
		contentPane.add(btnContinuer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listEdition.getSelectedIndex() != -1) {
					cr.getEdition(listEdition.getSelectedIndex()).setAnnee(textFieldA.getText());
					cr.getEdition(listEdition.getSelectedIndex()).setDateDeb(textFieldDd.getText());
					cr.getEdition(listEdition.getSelectedIndex()).setDateFin(textFieldDf.getText());
					init(cr);
				}
			}
		});
		btnModifier.setBounds(389, 199, 85, 21);
		contentPane.add(btnModifier);

		listEdition = new JList<String>();

		// afficher info quand choisir
		listEdition.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (listEdition.getSelectedIndex() != -1) {
					btnContinuer.setEnabled(true);
					btnModifier.setEnabled(true);
					afficherEditionSelected(cr.getEdition(listEdition.getSelectedIndex()));
				} else {
					btnContinuer.setEnabled(false);
					btnModifier.setEnabled(false);
				}
			}

		});

		listEdition.setBounds(57, 66, 157, 286);
		contentPane.add(listEdition);

		JButton btnAjouter = new JButton("Ajouter");

		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCreationEditionRallye iced = new InCreationEditionRallye(cr);
				iced.setVisible(true);
			}
		});
		btnAjouter.setBounds(87, 362, 85, 21);
		contentPane.add(btnAjouter);

		JLabel label = new JLabel(":");
		label.setBounds(279, 20, 13, 13);
		contentPane.add(label);
		init(cr);
	}

	private void init(Course c) {

		// titire du course
		lblNomcourse.setText(c.getNomCourse());
		lblTypecourse.setText(c.getClass().getSimpleName());
		// initialiser la liste des course
		DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
		for (Edition ed : c.getListeEdition()) {
			dlm.addElement("Edition " + ed.getNumEdition() + " " + ed.getAnnee());
		}
		listEdition.setModel(dlm);

	}

	private void afficherEditionSelected(Edition ed) {
		textFieldDd.setText(ed.getDateDeb());
		textFieldDf.setText(ed.getDateFin());
		textFieldA.setText(ed.getAnnee());
	}

}
