package com.example.cc.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.cc.domain.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Integer>{

}
