package com.example.crud_app;

import com.example.crud_app.dao.StudentDAO;
import com.example.crud_app.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
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
}









