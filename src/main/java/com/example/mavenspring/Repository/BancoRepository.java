package com.example.mavenspring.Repository;

import com.example.mavenspring.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//AQUI NO EXTENDS NOS PASSAMOS PRIMEIRO A ENTIDADE Q QUEREMOS DEPOIS A CHAVE PRIMARIA

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {
}
