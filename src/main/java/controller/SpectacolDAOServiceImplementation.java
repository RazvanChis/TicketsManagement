package controller;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.Spectacol;
import util.DBUtil;

public class SpectacolDAOServiceImplementation implements SpectacolDAOService {

	SessionFactory sessionFactory;

	public SpectacolDAOServiceImplementation() {
		this.sessionFactory = DBUtil.configureSessionFactory();
	}

	@Override
	public boolean addSpectacol(Spectacol spectacol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteSpectacol(int spectacolId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Spectacol> getAllSpectacol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSpectacol(Spectacol spectacol) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
