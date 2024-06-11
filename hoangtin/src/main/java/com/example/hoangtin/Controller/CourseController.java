package com.example.hoangtin.Controller;

import com.example.hoangtin.Model.Course;
import com.example.hoangtin.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")

    public class CourseController {

        @Autowired
        private CourseService courseService;

        @GetMapping("/create")
        public String create(Model model) {
            model.addAttribute("course", new Course());
            return "create"; // Đây là tên của template trong thư mục templates
        }

        @PostMapping("/create")
        public String create(Course newCourse) {
            courseService.add(newCourse);
            return "redirect:/home";
        }
    @GetMapping("/edit/{index}")
    public String edit(@PathVariable int index, Model model) {
        Course course = courseService.GetAll().get(index);
        model.addAttribute("course", course);
        return "edit";
    }



}

