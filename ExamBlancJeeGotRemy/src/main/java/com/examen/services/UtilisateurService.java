package com.examen.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.examen.models.Utilisateur;

import com.examen.utils.HibernateUtils;

public class UtilisateurService {

	private SessionFactory sessionFactory;
	
	public UtilisateurService() {
		this.sessionFactory = HibernateUtils.getSessionFactory();
	}

	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		List<Utilisateur> utilisateurs = new ArrayList<>();
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "FROM utilisateur";
		Query query = session.createQuery(hql);
		utilisateurs = query.getResultList();
		session.close();
		
		return utilisateurs;
	}

	public Utilisateur getById(Integer id) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        Utilisateur utilisateur = (Utilisateur) session.get(Utilisateur.class, id);
        
        session.close();
        return utilisateur;
	}

	public Utilisateur getByNom_Prenom(String nom_prenom) {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "FROM utilisateur where nom = :nom and prenom = :prenom";
		String[] nomprenom = nom_prenom.split("_");
		Query query = session.createQuery(hql);
		query.setParameter("nom", nomprenom[0]);
		query.setParameter("prenom", nomprenom[1]);
		Utilisateur utilisateur = (Utilisateur) query.getSingleResult();
		session.close();
		
		return utilisateur;
	}
	
	public void create(Utilisateur t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(t);

        session.flush();
        session.close();
	}

}
