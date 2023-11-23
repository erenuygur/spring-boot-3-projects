package com.erenuygur.cruddemo;

import com.erenuygur.cruddemo.dao.StudentDAO;
import com.erenuygur.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			createMultipleStudent(studentDao);
		};
	}

	private void createMultipleStudent(StudentDAO studentDao) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Yasin", "Turen", "yasinturen@gmail.com");
		Student tempStudent2 = new Student("Kagan", "Gunturk", "kagangunturk@outlook.com");
		Student tempStudent3 = new Student("Ahmet", "Çetinkaya", "ahmetcetnky@hotmail.com");

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
}
