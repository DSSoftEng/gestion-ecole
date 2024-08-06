package com.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding.entity.Personne;
import com.coding.service.IpersersonneService;


//@Controller
//@ResponseBody
@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000")
public class PersonneController {
	
	@Autowired
	IpersersonneService persoService;
	
	@GetMapping("/personnes")
	//@RequestMapping(value = "/personnes",method = HttpMethod.GET)
	public List<Personne> selectAll()
	{
		List<Personne> liste=persoService.selectAll();
		return liste;
	}
	
	
	@GetMapping("/personnes/{id}")
	public Personne selectById(@PathVariable("id") int id)
	{
		Personne p= persoService.selecOne(id);
		return p;
	}
	
	@PostMapping("/personnes")
	public Personne ajouter(@RequestBody Personne p)
	{
		Personne p2= persoService.ajouter(p);
		return p2;
	}
	
	@DeleteMapping("/personnes/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		persoService.supprimer(id);
	}
	
	@PutMapping("/personnes/{id}")
	public void modifier(@PathVariable("id") int id,@RequestBody Personne p)
	{
		Personne p2= persoService.selecOne(id);
		if(p2!=null)
		{
			persoService.modifier(p);
		}
	}
	
	
	
	

}
