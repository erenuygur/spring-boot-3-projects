package com.erenuygur.cruddemo;

import com.erenuygur.cruddemo.dao.StudentDAO;
import com.erenuygur.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			updateStudent(studentDao);
		};
	}

	private void updateStudent(StudentDAO studentDao) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);

		// change email to eren123@javamail.co
		System.out.println("Updating student...");
		myStudent.setEmail("eren123@javamail.co");

		// update the student
		studentDao.update(myStudent);

		// display updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findByLastName("Uygur");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudent(StudentDAO studentDao) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Yasin", "Turen", "yasinturen@gma1l.com");
		Student tempStudent2 = new Student("Kagan", "Gunturk", "kagangunturk@outlo0k.com");
		Student tempStudent3 = new Student("Ahmet", "Çetinkaya", "ahmetcetnky@hotma1l.com");

		// save the students
		// save the student object
		System.out.println("Saving the students ...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDao) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Eren", "Uygur", "ernuygur@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDao.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "duffyduck@outlook.co");

		// save the student
		studentDAO.save(tempStudent);

		// display id of saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);


		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}
}
