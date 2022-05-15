package com.example.mavenspring.controllers;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BancoController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
