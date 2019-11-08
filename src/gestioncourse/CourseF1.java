package gestioncourse;

public class CourseF1 extends Course {

	public CourseF1(int numCourse, String nomCourse) {
		super(numCourse, nomCourse);
		// TODO Auto-generated constructor stub
	}

	public EditionF1 getEdition(int i) {
		return (EditionF1) (listeEdition.get(i));
	}

}
