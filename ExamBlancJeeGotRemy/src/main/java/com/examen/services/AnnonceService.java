package com.examen.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.examen.models.Annonce;
import com.examen.utils.HibernateUtils;

public class AnnonceService {

	private SessionFactory sessionFactory;
	
	public AnnonceService() {
		this.sessionFactory = HibernateUtils.getSessionFactory();
	}
	
	public List<Annonce> getAll() {
		// TODO Auto-generated method stub
		List<Annonce> annonces = new ArrayList<>();

		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "FROM annonce";
		Query query = session.createQuery(hql);
		annonces = query.getResultList();
		session.close();
		
		return annonces;
	}

	public Annonce getById(Integer id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        Annonce annonce = (Annonce) session.get(Annonce.class, id);
        
        session.close();
        return annonce;
	}

	public void create(Annonce t) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(t);

        session.flush();
        session.close();
	}

}
