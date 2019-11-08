package interfacegraphic.organisateur.f1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.Course;
import gestioncourse.CourseF1;
import gestioncourse.Edition;
import gestioncourse.EditionF1;
import interfacegraphic.organisateur.f1.InEtapeF1;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;

public class InEditionF1 extends JFrame {

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
	public InEditionF1(CourseF1 cf) {
		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(cf);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 515, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTypecourse = new JLabel("Typecourse");
		lblTypecourse.setBounds(57, 10, 91, 33);
		contentPane.add(lblTypecourse);

		lblNomcourse = new JLabel("NomCourse");
		lblNomcourse.setBounds(170, 20, 91, 13);
		contentPane.add(lblNomcourse);

		JLabel lblAnnee = new JLabel("Annee : ");
		lblAnnee.setBounds(300, 138, 46, 13);
		contentPane.add(lblAnnee);

		textFieldA = new JTextField();
		textFieldA.setBounds(378, 135, 96, 19);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);

		textFieldDd = new JTextField();
		textFieldDd.setBounds(378, 63, 96, 19);
		contentPane.add(textFieldDd);
		textFieldDd.setColumns(10);

		textFieldDf = new JTextField();
		textFieldDf.setBounds(378, 106, 96, 19);
		JLabel lblDateDbut = new JLabel("Date d\u00E9but : ");
		lblDateDbut.setBounds(300, 66, 85, 13);
		contentPane.add(lblDateDbut);

		JLabel lblDateFin = new JLabel("Date fin : ");
		lblDateFin.setBounds(300, 102, 46, 13);
		contentPane.add(lblDateFin);
		contentPane.add(textFieldDf);
		textFieldDf.setColumns(10);

		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.setEnabled(false);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InEtapeF1 ie = new InEtapeF1(cf.getEdition(listEdition.getSelectedIndex()), cf);
				ie.setVisible(true);
			}
		});

		btnContinuer.setBounds(176, 348, 85, 21);
		contentPane.add(btnContinuer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listEdition.getSelectedIndex() != -1) {
					cf.getEdition(listEdition.getSelectedIndex()).setAnnee(textFieldA.getText());
					cf.getEdition(listEdition.getSelectedIndex()).setDateDeb(textFieldDd.getText());
					cf.getEdition(listEdition.getSelectedIndex()).setDateFin(textFieldDf.getText());
					init(cf);
				}
			}
		});
		btnModifier.setBounds(346, 199, 85, 21);
		contentPane.add(btnModifier);

		listEdition = new JList<String>();

		// afficher info quand choisir
		listEdition.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (listEdition.getSelectedIndex() != -1) {
					btnContinuer.setEnabled(true);
					btnModifier.setEnabled(true);
					afficherEditionSelected(cf.getEdition(listEdition.getSelectedIndex()));
				} else {
					btnContinuer.setEnabled(false);
					btnModifier.setEnabled(false);
				}
			}

		});

		listEdition.setBounds(67, 53, 194, 286);
		contentPane.add(listEdition);

		JButton btnAjouter = new JButton("Ajouter");

		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCreationEditionF1 iced = new InCreationEditionF1(cf);
				iced.setVisible(true);
			}
		});
		btnAjouter.setBounds(77, 348, 85, 21);
		contentPane.add(btnAjouter);

		JLabel label = new JLabel(":");
		label.setBounds(135, 20, 13, 13);
		contentPane.add(label);
		init(cf);
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

	private void afficherEditionSelected(EditionF1 ed) {
		textFieldDd.setText(ed.getDateDeb());
		textFieldDf.setText(ed.getDateFin());
		textFieldA.setText(ed.getAnnee());
	}

}
