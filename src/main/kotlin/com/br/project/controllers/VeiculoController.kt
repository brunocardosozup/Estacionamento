package com.br.project.controllers

import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import com.br.project.services.VeiculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
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



//    @GetMapping("/{id}")
//   fun pegarporID(@PathVariable  id: Int){
//      if(veiculoRepository.existsById(id)){
//         veiculoService.findById(id)
//
//      } else{
//          println("ID NÃO ENCONTRADO, TENTE NOVAMENTE!!!")
//      }
//
//    }


@DeleteMapping("/{id}")
fun delete(@PathVariable id : Int){
    if(veiculoRepository.existsById(id)){
        veiculoService.deleteById(id)
    }
}


    /////////////////////////////////////////////////////////////////


}