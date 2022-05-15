package ru.geekbrains;

import org.hibernate.Session;

import java.util.List;

public class StudentsDaoImpl implements StudentsDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public StudentsDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Students findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Students students = session.get(Students.class, id);
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public List<Students> findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Students> students = session
                    .createQuery("select s from Students s where s.name = :name", Students.class)
                    .setParameter("name", name)
                    .getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public List<Students> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Students> studentss = session.createQuery("select u from Students u").getResultList();
            session.getTransaction().commit();
            return studentss;
        }
    }

    @Override
    public void save(Students students) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(students);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateNameById(Long id, String newName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Students students = session.get(Students.class, id);
            students.setName(newName);
            session.getTransaction().commit();
        }
    }
}
