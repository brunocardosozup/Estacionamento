package com.br.project.models

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

import javax.validation.constraints.NotBlank


@Entity
data class VeiculoModel (


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val placa: Int,

    @NotBlank(message = "Campo automovel obrigatório")
    val automovel: String,

    @NotBlank(message = "Campo cor obrigatório")
     val cor: String,

    @NotBlank(message = "Campo modelo obrigatório")
    val modelo: String




)


