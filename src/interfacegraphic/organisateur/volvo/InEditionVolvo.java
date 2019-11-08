package interfacegraphic.organisateur.volvo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gestioncourse.Course;
import gestioncourse.CourseVolvo;
import gestioncourse.Edition;
import gestioncourse.EditionVolvo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;

public class InEditionVolvo extends JFrame {

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
	public InEditionVolvo(CourseVolvo cv) {

		// quand on retoune sur le frame(depuis frame de ajout), acualise la liste
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(cv);
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTypecourse = new JLabel("Typecourse");
		lblTypecourse.setBounds(46, 10, 91, 33);
		contentPane.add(lblTypecourse);

		lblNomcourse = new JLabel("NomCourse");
		lblNomcourse.setBounds(147, 20, 91, 13);
		contentPane.add(lblNomcourse);

		JLabel lblAnnee = new JLabel("Annee : ");
		lblAnnee.setBounds(275, 138, 46, 13);
		contentPane.add(lblAnnee);

		textFieldA = new JTextField();
		textFieldA.setBounds(342, 135, 96, 19);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);

		textFieldDd = new JTextField();
		textFieldDd.setBounds(342, 63, 96, 19);
		contentPane.add(textFieldDd);
		textFieldDd.setColumns(10);

		textFieldDf = new JTextField();
		textFieldDf.setBounds(342, 99, 96, 19);
		JLabel lblDateDbut = new JLabel("Date d\u00E9but : ");
		lblDateDbut.setBounds(275, 66, 91, 13);
		contentPane.add(lblDateDbut);

		JLabel lblDateFin = new JLabel("Date fin : ");
		lblDateFin.setBounds(275, 102, 85, 13);
		contentPane.add(lblDateFin);
		contentPane.add(textFieldDf);
		textFieldDf.setColumns(10);

		JButton btnContinuer = new JButton("Continuer");
		btnContinuer.setEnabled(false);
		btnContinuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditionVolvo etv = (EditionVolvo) cv.getEdition(listEdition.getSelectedIndex());
				InEtapeVolvo ie = new InEtapeVolvo(etv, cv);
				ie.setVisible(true);
			}
		});

		btnContinuer.setBounds(147, 362, 85, 21);
		contentPane.add(btnContinuer);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setEnabled(false);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listEdition.getSelectedIndex() != -1) {
					cv.getEdition(listEdition.getSelectedIndex()).setAnnee(textFieldA.getText());
					cv.getEdition(listEdition.getSelectedIndex()).setDateDeb(textFieldDd.getText());
					cv.getEdition(listEdition.getSelectedIndex()).setDateFin(textFieldDf.getText());
					init(cv);
				}
			}
		});
		btnModifier.setBounds(320, 258, 85, 21);
		contentPane.add(btnModifier);

		listEdition = new JList<String>();

		// afficher info quand choisir
		listEdition.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {

				if (listEdition.getSelectedIndex() != -1) {
					btnContinuer.setEnabled(true);
					btnModifier.setEnabled(true);
					EditionVolvo etv = (EditionVolvo) cv.getEdition(listEdition.getSelectedIndex());
					afficherEditionSelected(etv);
				} else {
					btnContinuer.setEnabled(false);
					btnModifier.setEnabled(false);
				}
			}

		});

		listEdition.setBounds(46, 65, 202, 286);
		contentPane.add(listEdition);

		JButton btnAjouter = new JButton("Ajouter");

		// ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCreationEditionVolvo iced = new InCreationEditionVolvo(cv);
				iced.setVisible(true);
			}
		});
		btnAjouter.setBounds(46, 362, 85, 21);
		contentPane.add(btnAjouter);

		JLabel label = new JLabel(":");
		label.setBounds(124, 20, 13, 13);
		contentPane.add(label);
		init(cv);
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

	private void afficherEditionSelected(EditionVolvo ed) {
		textFieldDd.setText(ed.getDateDeb());
		textFieldDf.setText(ed.getDateFin());
		textFieldA.setText(ed.getAnnee());
	}

}
