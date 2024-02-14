package com.example.cc.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cc.dao.IPersonaDao;
import com.example.cc.domain.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarP() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona p) {
		personaDao.save(p);
	}

	@Override
	@Transactional
	public void eliminar(Persona p) {
		personaDao.delete(p);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona buscarP(Persona p) {
		return personaDao.findById(p.getId()).orElse(null);
	}

	
}
