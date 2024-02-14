package com.example.cc.servicio;

import java.util.List;

import com.example.cc.domain.Persona;

public interface IPersonaService {
	
	public List<Persona> listarP();
	
	public void guardar(Persona p);
	
	public void eliminar(Persona p);
	
	public Persona buscarP(Persona p);
	

}
