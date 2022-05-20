package org.bozdng.anotherdemo;

import org.bozdng.anotherdemo.model.Address;
import org.bozdng.anotherdemo.model.Gender;
import org.bozdng.anotherdemo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class AnotherDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnotherDemoApplication.class, args);
	}

	@Bean CommandLineRunner runner(
			StudentRepository repository,
			MongoTemplate mongoTemplate
	) {
		return args -> {
			var student = new Student(
					"John", "Smith",
					"cansimit@örnek.com",
					Gender.MALE,
					new Address("GB", "London", "27017"),
					List.of("Time-Lordship"),
					BigDecimal.ONE,
					LocalDateTime.now()
			);

//			var query = new Query();
//			query.addCriteria(Criteria.where("email").is("cansimit@örnek.com"));
//			List<Student> students = mongoTemplate.find(query, Student.class);
//
//			if(students.size() > 1) {
//				throw new RuntimeException("OH FUCK",
//						new IllegalStateException("Email is registered more than once."));
//			}
//
//			if(students.isEmpty()) {
//				System.out.println("Inserting... " + student);
//				repository.insert(student);
//			} else {
//				System.out.println("Already exists: " + student);
//			}

			repository.findStudentByEmail("cansimit@örnek.com")
					.ifPresentOrElse(it -> {
						System.out.println("Already exists: " + it);
					}, () -> {
						System.out.println("Inserting... " + student);
						repository.insert(student);
					});
		};
	}

}
