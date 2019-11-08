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
import gestioncourse.Speciale;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class InSpeciale extends JFrame {
	private JPanel contentPane;
	private JLabel lblNomcourse;
	private JLabel lblEdition;
	private JLabel labelNum;
	private JLabel lblAnnee;
	private JLabel lblTempsLimiteH;
	private JList<String> listSpeciale;
	private JTextField textFieldTlH;
	private JTextField textFieldTlM;
	private JTextField textFieldTlS;
	private JButton btnModifier;
	private JLabel lblVille;
	private JLabel lblPays;
	private JLabel lblLblv;
	private JLabel lblLblp;
	private JPanel panelF1;
	private JLabel lblEtape;
	private JLabel lblNumetape;

	/**
	 * Create the frame.
	 * 
	 * @param ed
	 */
	public InSpeciale(EtapeRallye et, EditionRallye ed, CourseRallye c) {
		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(et, ed, c);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTempsLimiteH = new JLabel("Temps limite : ");
		lblTempsLimiteH.setBounds(201, 60, 85, 13);
		contentPane.add(lblTempsLimiteH);

		listSpeciale = new JList<String>();
		// afficher les étapes lors qu'on choisi un édition
		listSpeciale.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listSpeciale.getSelectedIndex() != -1) {
					btnModifier.setEnabled(true);
					afficherSpecialeSelected(et.getSpeciale(listSpeciale.getSelectedIndex()));
				} else {
					btnModifier.setEnabled(false);
				}
			}
		});

		listSpeciale.setBounds(31, 44, 146, 280);
		contentPane.add(listSpeciale);

		lblNomcourse = new JLabel("NomCourse");
		lblNomcourse.setBounds(31, 21, 70, 13);
		contentPane.add(lblNomcourse);

		lblEdition = new JLabel("Edition : ");
		lblEdition.setBounds(128, 21, 68, 13);
		contentPane.add(lblEdition);

		labelNum = new JLabel("No.");
		labelNum.setBounds(178, 21, 46, 13);
		contentPane.add(labelNum);

		lblAnnee = new JLabel("Annee");
		lblAnnee.setBounds(206, 21, 70, 13);
		contentPane.add(lblAnnee);

		JButton btnAjouter = new JButton("Ajouter");

		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCreationSpeciale ics = new InCreationSpeciale(et, ed, c);
				ics.setVisible(true);
			}
		});

		btnAjouter.setBounds(55, 334, 85, 21);

		contentPane.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listSpeciale.getSelectedIndex() != -1) {
					int h = Integer.valueOf(textFieldTlH.getText());
					int m = Integer.valueOf(textFieldTlM.getText());
					;
					float s = Float.valueOf(textFieldTlH.getText());
					et.getSpeciale(listSpeciale.getSelectedIndex()).enregistrerTempsLimite(h, m, s);
					init(et, ed, c);
				}

			}
		});

		btnModifier.setBounds(224, 198, 85, 21);
		contentPane.add(btnModifier);

		textFieldTlH = new JTextField();
		textFieldTlH.setBounds(282, 57, 27, 19);
		contentPane.add(textFieldTlH);
		textFieldTlH.setColumns(10);

		JLabel lblH = new JLabel("H");
		lblH.setBounds(313, 60, 17, 13);
		contentPane.add(lblH);

		textFieldTlM = new JTextField();
		textFieldTlM.setBounds(340, 57, 27, 19);
		contentPane.add(textFieldTlM);
		textFieldTlM.setColumns(10);

		textFieldTlS = new JTextField();
		textFieldTlS.setColumns(10);
		textFieldTlS.setBounds(387, 57, 36, 19);
		contentPane.add(textFieldTlS);

		JLabel labelM = new JLabel("'");
		labelM.setBounds(377, 60, 46, 13);
		contentPane.add(labelM);

		panelF1 = new JPanel();
		panelF1.setBounds(203, 101, 220, 71);
		contentPane.add(panelF1);
		panelF1.setLayout(null);

		lblPays = new JLabel("Pays : ");
		lblPays.setBounds(9, 5, 31, 13);
		panelF1.add(lblPays);

		lblLblp = new JLabel("lblP");
		lblLblp.setBounds(45, 5, 16, 13);
		panelF1.add(lblLblp);

		lblVille = new JLabel("Ville : ");
		lblVille.setBounds(9, 36, 30, 13);
		panelF1.add(lblVille);

		lblLblv = new JLabel("lblV");
		lblLblv.setBounds(45, 36, 17, 13);
		panelF1.add(lblLblv);

		lblEtape = new JLabel("Etape : ");
		lblEtape.setBounds(300, 21, 46, 13);
		contentPane.add(lblEtape);

		lblNumetape = new JLabel("NumEtape");
		lblNumetape.setBounds(377, 21, 46, 13);
		contentPane.add(lblNumetape);

		init(et, ed, c);
	}

	private void init(EtapeRallye et, Edition e, Course c) {

		// titire du course
		lblNomcourse.setText(c.getNomCourse());
		labelNum.setText(String.valueOf(e.getNumEdition()));
		lblAnnee.setText(e.getAnnee());
		System.out.println(et.getHeure());
		lblNumetape.setText(String.valueOf(et.getNumEtape()));
		// initialiser la liste des course
		EtapeRallye er = (EtapeRallye) et;
		DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
		for (Speciale s : er.getListeSpeciale()) {
			dlm.addElement("Speciale " + s.getNumSpeciale());
		}
		listSpeciale.setModel(dlm);

	}

	private void afficherSpecialeSelected(Speciale et) {
		textFieldTlH.setText(String.valueOf(et.getHeure()));
		textFieldTlM.setText(String.valueOf(et.getMinute()));
		textFieldTlS.setText(String.valueOf(et.getSeconde()));
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JPanel getPanelF1() {
		return panelF1;
	}
}
