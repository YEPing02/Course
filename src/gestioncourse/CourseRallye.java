package gestioncourse;

public class CourseRallye extends Course {
	public CourseRallye(int numCourse, String nomRallye) {
		super(numCourse, nomRallye);
	}

	public EditionRallye getEdition(int i) {
		return (EditionRallye) listeEdition.get(i);
	}

}
