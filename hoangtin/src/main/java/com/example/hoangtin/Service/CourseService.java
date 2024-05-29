package com.example.hoangtin.Service;

import com.example.hoangtin.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> listCourse = new ArrayList<>();

    public void add(Course newCourse) {
        listCourse.add(newCourse);
    }

    public List<Course> GetAll() {
        return listCourse;
    }
}
