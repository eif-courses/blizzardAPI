package controllers;

import com.teamtreehouse.course.CourseRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Marius on 2/7/2017.
 */

@RestController
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }




}