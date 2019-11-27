package com.br.project.models

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.persistence.*

import javax.validation.constraints.NotBlank


@Entity
data class VeiculoModel (


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    var id : Int,

    @NotBlank(message = "Campo automovel obrigatório")
    var automovel : String,

    @NotBlank(message = "Campo cor obrigatório")
     var cor: String,

    @NotBlank(message = "Campo modelo obrigatório")
    var modelo: String




)


