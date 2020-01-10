package com.br.project.repositories

import com.br.project.models.VeiculoModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VeiculoRepository : CrudRepository<VeiculoModel, Int> {
    fun findAll(veiculoModel: VeiculoModel): MutableIterable<VeiculoModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}