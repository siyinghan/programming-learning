package com.siying;

import com.siying.ba02.Student;
import com.siying.ba02.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest02 {
    @Test
    public void test01() {
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);

        School school = new School();
        school.setName("动力节点");
        school.setAddress("北京");

        student.setSchool(school);
        System.out.println("student: " + student);
    }

    @Test
    public void test02() {
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取Student对象
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println("Student对象：" + myStudent);
    }
}

