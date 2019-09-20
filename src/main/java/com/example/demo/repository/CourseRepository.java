package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();
    static int[] arr = {1,2,3,4,5,6,7,8,9,10};

    // constructor
    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();
        Course two= Course.builder()
                .className("Java II")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
    }

    public List<Integer> findSum(Integer target) {
        int start = 0;
        int end = 9;
        List<Integer> ans = new ArrayList<>();
        while (start + 1 < end) {
            int total = arr[start] + arr[end];
            if (target == total) {
                ans.add(start);
                ans.add(end);
                return ans;
            } else if (target < total) {
                --end;
            } else {
                ++start;
            }
        }
        if (target == (arr[start] + arr[end])){
            ans.add(start);
            ans.add(end);
            return ans;
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }

    public List<Integer> findIndex(int[] ar, Integer target) {
        int start = 0;
        int end = ar.length - 1;
        List<Integer> ans = new ArrayList<>();
        while (start + 1 < end) {
            int total = ar[start] + ar[end];
            if (target == total) {
                ans.add(start);
                ans.add(end);
                return ans;
            } else if (target < total) {
                --end;
            } else {
                ++start;
            }
        }
        if (target == (ar[start] + ar[end])){
            ans.add(start);
            ans.add(end);
            return ans;
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }

    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        if(courseName.equals("Java_I")) {
            return courses;
        }

        return new ArrayList<Course>();
    }
}
