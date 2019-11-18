package com.br.project.services

import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import org.springframework.stereotype.Service
import java.util.List



@Service
class VeiculoService(var veiculorepository: VeiculoRepository) {

    fun getVeiculos(): MutableIterable<VeiculoModel> {
        return veiculorepository.findAll()
    }

    fun saveVeiculos(veiculoModel: VeiculoModel): VeiculoModel {
        return veiculorepository.save(veiculoModel)
    }

    fun findById(id: Long): VeiculoModel {
        return veiculorepository.findById(id).get()
    }


    fun deleteById(id: Long){
        veiculorepository.deleteById(id)
    }

}







