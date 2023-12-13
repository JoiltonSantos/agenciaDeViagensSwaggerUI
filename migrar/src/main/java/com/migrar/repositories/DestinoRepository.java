package com.migrar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.migrar.model.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>{

}
