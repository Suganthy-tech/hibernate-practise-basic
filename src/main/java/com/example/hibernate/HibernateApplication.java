package com.example.hibernate;

import com.example.hibernate.dao.StudentDAO;
import com.example.hibernate.entity.Student;
import org.hibernate.boot.model.source.internal.hbm.CompositeIdentifierSingularAttributeSourceManyToOneImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}
@Bean
	public CommandLineRunner commandLineRunner(StudentDAO sd){
		return runner->{
			updateItem(sd);
		//	removeItem(sd);
			//findAllStudent(sd);
			fetchCondiotionallyhere(sd);
//			createMultipleStudent(sd);
		};
}

	private void fetchCondiotionallyhere(StudentDAO sd ) {
		List<Student> l=sd.fetchCondiotionally("agarwal");
		for(Student a:l){
			System.out.println(a);
		}

	}

	private void updateItem(StudentDAO sd) {
		System.out.println(sd.updateDB(1,"samuel"));
		System.out.println("updation completed");
	}

	private void removeItem(StudentDAO sd) {
		sd.remove(1);
		System.out.println("Removed Item");
	}

	private void findAllStudent(StudentDAO sd) {

		List<Student> l=sd.fetchAll();
		for(Student s:l){
			System.out.println(s);
		}

	}


	private void createMultipleStudent(StudentDAO sd) {
		Student stud1=new Student("Paul","samuel","IT");
		Student stud2=new Student("Joe","samuel","BCOM");
		Student stud3=new Student("Paul","dow","IT");


		sd.save(stud1);
		sd.save(stud2);
		sd.save(stud3);
		System.out.println(stud1.getId());
		System.out.println(stud2.getId());
		System.out.println(stud3.getId());
		System.out.println(sd.fetch(stud3.getId()));
	}
}
