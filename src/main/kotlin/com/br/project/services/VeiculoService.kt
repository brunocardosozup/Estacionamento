package com.br.project.services

import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.List
import javax.persistence.Column


//@Column(name="service")
@Service
class VeiculoService(var veiculorepository: VeiculoRepository) {

    fun getVeiculos(): MutableIterable<VeiculoModel> {
        return veiculorepository.findAll()
    }

    fun saveVeiculos(veiculoModel: VeiculoModel): VeiculoModel {
        return veiculorepository.save(veiculoModel)
    }

    fun findById(id: Int): VeiculoModel {
        return veiculorepository.findById(id).get()

    }


    fun deleteById(id: Int) {
        veiculorepository.deleteById(id)
    }


// atualizar
    fun alterById(id: Int, atualizar: VeiculoModel): VeiculoModel {
     var veiculoModel : VeiculoModel
        veiculoModel = veiculorepository.findById(id).get()

        if(veiculoModel != null){
            atualizar.id
            return veiculorepository.save(atualizar)
        }
        return veiculoModel
    }
    //


    fun count() : Long{
        return veiculorepository.count()
    }
}









