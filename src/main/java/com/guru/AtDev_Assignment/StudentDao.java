package com.guru.AtDev_Assignment;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    public Session getSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    public List<Students> getStudnetList() {
        Criteria criteria = getSession().createCriteria(Students.class);
        List<Students> list = criteria.list();
        return list;
    }

}
