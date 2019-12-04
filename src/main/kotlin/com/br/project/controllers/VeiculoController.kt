package com.br.project.controllers

import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import com.br.project.services.VeiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*



@RestController
open class VeiculoController(var veiculoService: VeiculoService) {


  @Autowired
    lateinit var veiculoRepository: VeiculoRepository



    @GetMapping("/find", consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
   private fun findAllCars() = veiculoService.getVeiculos().toList()



    @PostMapping("/criar")
    private fun create(@RequestBody veiculoModel: VeiculoModel) : VeiculoModel{
        veiculoService.saveVeiculos(veiculoModel)
        return veiculoModel
    }



    @GetMapping("/{id}")

   fun pegarporID(@PathVariable  id: Int) : ResponseEntity<VeiculoModel>{
        try {
            return ResponseEntity.ok().body(veiculoService.findById(id))
        }catch (e : Exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }



@DeleteMapping("/{id}")
fun delete(@PathVariable id : Int){
    if(veiculoRepository.existsById(id)){
        veiculoService.deleteById(id)
    }
}


    @PutMapping("/{id}")
    fun alterToId(@PathVariable id : Int, @RequestBody veiculoModel: VeiculoModel): VeiculoModel {
if(veiculoRepository.existsById(id)){
    var veiculo = VeiculoModel(id, veiculoModel.automovel, veiculoModel.cor, veiculoModel.modelo)
    return veiculoRepository.save(veiculo)
}
        return veiculoModel
    }


    @GetMapping("qtd")
    fun qtd() = veiculoService.count()
}