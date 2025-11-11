package com.smartattendance.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.smartattendance.model.Student;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sf;

    @Override
    public void save(Student s) {
        sf.getCurrentSession().save(s);
    }

    @Override
    public List<Student> findAll() {
        CriteriaQuery<Student> cq = sf.getCurrentSession().getCriteriaBuilder().createQuery(Student.class);
        cq.from(Student.class);
        return sf.getCurrentSession().createQuery(cq).getResultList();
    }
}
