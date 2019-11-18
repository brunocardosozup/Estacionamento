package com.br.project.controllers

import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import com.br.project.services.VeiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping
class VeiculoController(var veiculoService: VeiculoService) {


  @Autowired
    lateinit var veiculoRepository: VeiculoRepository


    @GetMapping("/find")
    fun findAllCars() = veiculoService.getVeiculos().toList()

    @PostMapping("/criar")
    fun create(@RequestBody veiculoModel: VeiculoModel) : VeiculoModel{
        veiculoService.saveVeiculos(veiculoModel)
        return veiculoModel
    }



    @GetMapping("/{id}")
   fun pegarporID(@PathVariable ("id") id: Long) {

    }


@DeleteMapping("/{id}")
fun delete(@PathVariable id : Long){
    if(veiculoRepository.existsById(id)){
        veiculoService.deleteById(id)
    }
}
    /////////////////////////////////////////////////////////////////


}