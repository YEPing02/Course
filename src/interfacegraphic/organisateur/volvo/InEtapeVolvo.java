package interfacegraphic.organisateur.volvo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.Course;
import gestioncourse.CourseF1;
import gestioncourse.CourseVolvo;
import gestioncourse.Edition;
import gestioncourse.EditionF1;
import gestioncourse.EditionVolvo;
import gestioncourse.Etape;
import gestioncourse.EtapeF1;
import gestioncourse.EtapeVolvo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class InEtapeVolvo extends JFrame {
	private JPanel contentPane;
	private JLabel lblNomcourse;
	private JLabel lblEdition;
	private JLabel labelNum;
	private JLabel lblAnnee;
	private JLabel lblTempsLimiteH;
	private JList<String> listEtape;
	private JTextField textFieldTlH;
	private JTextField textFieldTlM;
	private JTextField textFieldTlS;
	private JButton btnModifier;

	/**
	 * Create the frame.
	 * 
	 * @param edv
	 */
	public InEtapeVolvo(EditionVolvo edv, CourseVolvo cv) {
		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(edv, cv);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 479, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTempsLimiteH = new JLabel("Temps limite : ");
		lblTempsLimiteH.setBounds(201, 60, 85, 13);
		contentPane.add(lblTempsLimiteH);

		listEtape = new JList<String>();
		// afficher les étapes lors qu'on choisi un édition
		listEtape.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listEtape.getSelectedIndex() != -1) {
					btnModifier.setEnabled(true);
					EtapeVolvo etv = (EtapeVolvo) edv.getEtapeT(listEtape.getSelectedIndex());
					afficherEtapeSelected(etv);
				} else {
					btnModifier.setEnabled(false);
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

		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCreationEtapeVolvo icet = new InCreationEtapeVolvo(edv, cv);
				icet.setVisible(true);
			}
		});

		btnAjouter.setBounds(55, 334, 85, 21);

		contentPane.add(btnAjouter);

		btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listEtape.getSelectedIndex() != -1) {
					int h = Integer.valueOf(textFieldTlH.getText());
					int m = Integer.valueOf(textFieldTlM.getText());
					;
					float s = Float.valueOf(textFieldTlH.getText());
					edv.getEtapeT(listEtape.getSelectedIndex()).setTempsLimite(h, m, s);
					init(edv, cv);
				}

			}
		});

		btnModifier.setBounds(245, 191, 85, 21);
		contentPane.add(btnModifier);

		textFieldTlH = new JTextField();
		textFieldTlH.setBounds(282, 57, 27, 19);
		contentPane.add(textFieldTlH);
		textFieldTlH.setColumns(10);

		JLabel lblH = new JLabel("H");
		lblH.setBounds(313, 60, 17, 13);
		contentPane.add(lblH);

		textFieldTlM = new JTextField();
		textFieldTlM.setBounds(325, 57, 27, 19);
		contentPane.add(textFieldTlM);
		textFieldTlM.setColumns(10);

		textFieldTlS = new JTextField();
		textFieldTlS.setColumns(10);
		textFieldTlS.setBounds(372, 57, 36, 19);
		contentPane.add(textFieldTlS);

		JLabel labelM = new JLabel("'");
		labelM.setBounds(362, 60, 46, 13);
		contentPane.add(labelM);

		init(edv, cv);
	}

	private void init(EditionVolvo e, CourseVolvo c) {
		// titire du course
		lblNomcourse.setText(c.getNomCourse());
		labelNum.setText(String.valueOf(e.getNumEdition()));
		lblAnnee.setText(e.getAnnee());
		// initialiser la liste des course
		DefaultListModel<String> dlm = new DefaultListModel<String>();// modèle qui va être affiché dans la liste
		for (Etape et : e.getLstEtape()) {
			dlm.addElement("Etape " + et.getNumEtapeT());
		}
		listEtape.setModel(dlm);

	}

	private void afficherEtapeSelected(EtapeVolvo et) {
		textFieldTlH.setText(String.valueOf(et.getHeure()));
		textFieldTlM.setText(String.valueOf(et.getMinute()));
		textFieldTlS.setText(String.valueOf(et.getSeconde()));
	}
}
