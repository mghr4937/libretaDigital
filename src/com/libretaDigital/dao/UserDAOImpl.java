package com.libretaDigital.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.libretaDigital.model.User;
import com.libretaDigital.util.HibernateUtil;

public class UserDAOImpl implements UserDAO{

		
	public boolean buscarUsuario(User usuario) {
		 boolean existe=false;
	        Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            String queryString = "from User where nombre = :nombre and clave = :clave";
	            Query query = session.createQuery(queryString);
	            query.setString("nombre", usuario.getNombre());
	            query.setString("clave", usuario.getClave());
	            existe = !(((User) query.uniqueResult())==(null));
	            //Aqui verificamos si la query me trae algun resultado, si no es asi el usuario no existe.
	        } catch (RuntimeException e) {
	            existe = false;
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	        return existe;
	}
}
