package com.example.crud_app;

import com.example.crud_app.dao.StudentDAO;
import com.example.crud_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			 //updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);



		};

	}




	private void readStudent(StudentDAO studentDAO) {

		//creaaza un obiect de tip student
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Mircea", "Popescu", "mircea@pixelacademy.md");

		//salveaza studentul in baza de date
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//afiseaza id-ul studentului salvat
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated Id: " + theId);

		//recupereaza studentul pe baza id-ului (PK)
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findbyId(theId);

		//afiseaza detaliile studentului
		System.out.println("Found the student: " + myStudent);


	}

	private void createStudent(StudentDAO studentDAO) {

		//cream un obiect

		System.out.println("Creating new student object...");
		Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");

		//salvam obiectul Student in baza de date folosind DAO
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		// afisam Id-ul studentului salvat
		System.out.println("Saved student. Generated id:" + newStudent.getId());

	}


	private void createMultipleStudents(StudentDAO studentDAO) {
		//cream mai multi studenti
		System.out.println("Creating 3 students objects...");
		Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
		Student newStudent2 = new Student("Iulian", "Vataman", "iulic@pixelacademy.md");
		Student newStudent3 = new Student("Maria", "Mirabela", "mira@pixelacademy.md");

		//salvam obiectele student in baza de date
		System.out.println("Saving the student...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//obtine lista de studenti
		List<Student> theStudents = studentDAO.findAll();

		//afiseaza lista de stundeti
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// returneaza lista de studenti
		List<Student> theStudent = studentDAO.findByLastName("Popescu");

		//afiseaza lista de studenti
		for (Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}



    private void updateStudent(StudentDAO studentDAO){

		//gaseste student in baza de date folosind id-ul(cheia primara)

		int studentId = 7;
		System.out.println("Getting student with id: " + studentId);
		Student newStudent = studentDAO.findbyId(studentId);

		//modifica prenumele studentlui in "Ion"
		System.out.println("Updating student ...");
		newStudent.setFirstName("Goe");

		//salveaza modificarile in baza de date
		studentDAO.update(newStudent);

		//afiseaza detaliile studentului actualizat
		System.out.println("Updated student: " + newStudent);
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students.");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRowsDeleted);


	}

}









