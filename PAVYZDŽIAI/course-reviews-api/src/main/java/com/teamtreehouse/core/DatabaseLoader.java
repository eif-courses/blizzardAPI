package com.teamtreehouse.core;

import com.teamtreehouse.course.Course;
import com.teamtreehouse.course.CourseRepository;
import com.teamtreehouse.review.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by Marius on 2/6/2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner{

    private final CourseRepository courses;

    /**
     * @param courses
     */

    @Autowired
    public DatabaseLoader(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course = new Course("Java programavimas", "http://eif-courses.github.io/Programavimas-Java/");
        course.addReview(new Review(3, "Restful easy"));
        courses.save(course);

        String [] templates = {
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
                "%s for NeckBeards",
                "Under the hood: %s"
        };
        String [] buzzwords = {
                "Spring Rest Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "C++",
                "Python"
        };

        List<Course> courseList = new ArrayList<>();
        IntStream.range(0, 1000).
                forEach(i ->{
                    String template = templates[i % templates.length];
                    String buzzword = buzzwords[i % buzzwords.length];

                                                //"%s Basics", C++
                    // printf("%s Basics", "C++");
                    String title = String.format(template, buzzword);
                    Course c = new Course(title,"http://eif-courses.github.io/Programavimas-Java/");
                    c.addReview(new Review(i % 5, String.format("Moar %s please!!!", buzzword)));
                    courseList.add(c);
                });
        courses.save(courseList);
    }
}
