package com.example.mavenspring.Repository;
import com.example.mavenspring.model.agencia_bancaria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends PagingAndSortingRepository<agencia_bancaria, Integer> {
    @Query(value = "SELECT * FROM agencia_bancaria WHERE agencia_bancaria.nome_agencia ilike ?1 or agencia_bancaria.agencia ilike ?1",
            countQuery = "select count(*) from agencia_bancaria WHERE agencia_bancaria.nome_agencia ilike ?1 or agencia_bancaria.agencia ilike ?1",
            nativeQuery = true)
    Page<agencia_bancaria> findbyFilter(String filter, Pageable pageable);
}