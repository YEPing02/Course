package interfacegraphic;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donnee.Donnee;
import interfacegraphic.consultation.InConsultationCourse;
import interfacegraphic.coureur.InschosirCourse;
import interfacegraphic.organisateur.InCourse;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Accueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Accueil(Donnee d) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 255);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCreation = new JButton("Cr\u00E9ation");
		btnCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InCourse ic = new InCourse(d);
				ic.setVisible(true);
			}
		});
		btnCreation.setBounds(75, 130, 85, 21);
		contentPane.add(btnCreation);

		JButton btnConsultation = new JButton("Consultation");
		btnConsultation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InConsultationCourse icc = new InConsultationCourse(d);
				icc.setVisible(true);
			}
		});
		btnConsultation.setBounds(114, 55, 135, 21);
		contentPane.add(btnConsultation);

		/*
		 * Pour la partie de l'inscription, il faudra créer une base de donnée local
		 * afin de tester:
		 * 
		 * 1. Le nom de base de donnée est "databaseinscrit" (modifiable dans package data) par defaut.
		 * 2. le nom de utilisateur et le mot de passe sont institué séparément "root" et "" (vide).
		 * 3. le script de l'implémentation est "script_bd".
		 * 
		 * on peut faire l'inscrition dans les course qu'on crée dans l'interface
		 */
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InschosirCourse icc = new InschosirCourse(d);
				icc.setVisible(true);
			}
		});
		btnInscription.setBounds(202, 130, 85, 21);
		contentPane.add(btnInscription);
	}

}
