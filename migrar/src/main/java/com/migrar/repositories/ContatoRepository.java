package com.migrar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migrar.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
