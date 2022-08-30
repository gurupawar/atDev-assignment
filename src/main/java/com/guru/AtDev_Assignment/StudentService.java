package com.guru.AtDev_Assignment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    String message = null;

    // ! Fetch All Student data
    public List<Students> getAllStudents() {
        return studentDao.getStudnetList();
    }

    // ! Add new Student to Database
    public String addNewStudent(Students newStud) {
        Session session = studentDao.getSession();
        session.beginTransaction();

        Students s = new Students();

        s.setStud_id(newStud.stud_id);
        s.setStud_name(newStud.stud_name);
        s.setStud_age(newStud.stud_age);
        s.setStud_class(newStud.stud_class);

        session.save(s);
        session.getTransaction().commit();
        message = "new student added";
        return message;
    }

    // ! Update student information in database
    public String updateStudent(Students stud) {
        Session session = studentDao.getSession();
        Criteria criteria = session.createCriteria(Students.class);
        List<Students> list = criteria.list();
        session.beginTransaction();

        list.forEach(s -> {
            if (s.getStud_id().equals(stud.stud_id)) {
                s.setStud_name(stud.stud_name);
                s.setStud_age(stud.stud_age);
                s.setStud_class(stud.stud_class);
            }
        });

        session.getTransaction().commit();
        message = "student data updated";
        return message;
    }

    // ! Delete student by id
    public String deleteStudById(String id) {
        Session session = studentDao.getSession();
        session.beginTransaction();

        Students stud = session.get(Students.class, id);

        if (stud != null) {
            session.delete(stud);
        }
        session.getTransaction().commit();
        message = "student data deleted successfully.";
        return message;
    }

}
