package interfacegraphic.coureur;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import donnee.Donnee;
import gestioncourse.Course;
import gestioncourse.CourseRallye;
import interfacegraphic.coureur.interfaceinscritrallye.Inseditionrallye;

import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

import java.awt.Font;

public class InschosirCourse extends JFrame {

	private JPanel contentPane;
	private JList<String> listCourse;
	private JTextField coursechoisit;

	public InschosirCourse(Donnee d) {

		// actulaier la liste de nom de course
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				init(d.getLstCourse());
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVeuillezSlectionnerLe = new JLabel(
				"Veuillez s\u00E9lectionner le concours que vous souhaitez inscrire.");
		lblVeuillezSlectionnerLe.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblVeuillezSlectionnerLe.setBounds(42, 25, 336, 15);
		contentPane.add(lblVeuillezSlectionnerLe);

		listCourse = new JList();
		listCourse.setBounds(42, 61, 336, 111);
		contentPane.add(listCourse);
		init(d.getLstCourse()); // afficher la liste de course

		JButton btnChosir = new JButton("Chosir");
		btnChosir.setBounds(42, 207, 93, 23);
		contentPane.add(btnChosir);
		btnChosir.setEnabled(false);
		btnChosir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (d.getCourse(listCourse.getSelectedIndex()).getClass().getSimpleName()) {
				case "CourseRallye":
					System.out.println(1);

					CourseRallye cr = (CourseRallye) d.getCourse(listCourse.getSelectedIndex());
					Inseditionrallye ieR = new Inseditionrallye(cr);

					ieR.setVisible(true);
					break;
				case "CourseF1":
					System.out.println(2);
					// InEditionF1 ieF = new
					// InEditionF1(d.getCourse(listCourse.getSelectedIndex()));
					// ieF.setVisible(true);
					break;
				}

			}
		});

		listCourse.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (listCourse.getSelectedIndex() != -1) {

					btnChosir.setEnabled(true);
					afficherCourseSelected(d.getCourse(listCourse.getSelectedIndex()));
				} else {
					btnChosir.setEnabled(false);

				}
			}
		});

		JLabel lblToutesLesEditions = new JLabel("Liste des Courses");
		lblToutesLesEditions.setBounds(42, 45, 111, 15);
		contentPane.add(lblToutesLesEditions);

		coursechoisit = new JTextField();
		coursechoisit.setBounds(143, 179, 178, 21);
		contentPane.add(coursechoisit);
		coursechoisit.setColumns(10);

		JLabel lblLaCourseChosit = new JLabel("La course choisit");
		lblLaCourseChosit.setFont(new Font("Arial MT", Font.PLAIN, 12));
		lblLaCourseChosit.setBounds(42, 182, 141, 15);
		contentPane.add(lblLaCourseChosit);

	}

	public void init(ArrayList<Course> lstC) {
		// initialiser la liste des course
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (Course c : lstC) {
			dlm.addElement(c.getNomCourse());
		}
		listCourse.setModel(dlm);

	}

	private void afficherCourseSelected(Course c) {
		coursechoisit.setText(c.getNomCourse());
		// lblTypeaffi.setText(c.getClass().getSimpleName());
	}

}
