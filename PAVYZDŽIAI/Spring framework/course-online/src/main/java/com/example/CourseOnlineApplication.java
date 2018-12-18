package com.example;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CourseOnlineApplication {



	public static void main(String[] args) {
		SpringApplication.run(CourseOnlineApplication.class, args);
	}

	@Bean CommandLineRunner loadData(CourseRepository courseRepository){
		return args -> {
			String courses[] = {"Programavimas kalba Java", "Operacinės sistemos", "Struktūrinio programvimo praktika",
					"Web saugumas","Programavimas išmaniesiems įrenginiams I"};

			for (String item: courses) {
				courseRepository.save(new Course(""+item))	;
			}

		};
	}
}
