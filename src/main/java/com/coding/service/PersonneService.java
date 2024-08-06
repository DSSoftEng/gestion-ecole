package com.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.coding.dao2.PersonneDao;
import com.coding.entity.Personne;

@Service
public class PersonneService implements IpersersonneService {
	
	@Autowired
	PersonneDao dao;
	
	
	public Personne ajouter(Personne p)
	{
		Personne p2= dao.save(p);
		return p2;
	}
	
	public Personne selecOne(int id)
	{
		return dao.findById(id).get();
	}
	
	public List<Personne> selectAll()
	{
		return dao.findAll();
	}
	
	public void supprimer(int id)
	{
		dao.deleteById(id);
	}
	
	public void modifier(Personne p)
	{
		dao.save(p);
	}

}
