package com.example.mavenspring.Repository;

import com.example.mavenspring.model.Banco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagingAndSorting extends CrudRepository<Banco, Integer> {
    Page<Banco> findAll(Pageable pageable);
}