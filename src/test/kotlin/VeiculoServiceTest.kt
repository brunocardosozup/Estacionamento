import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import com.br.project.services.VeiculoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito


import java.util.*

class VeiculoServiceTest {
    private val veiculoRepository: VeiculoRepository = Mockito.mock(VeiculoRepository::class.java)
    private val veiculoService = VeiculoService(veiculoRepository)

    @Test
    // ENCONTRAR VEICULO POR ID
    fun `should find veiculo by Id`() {
        val id = 1231231
        val veiculoModel = VeiculoModel(
                id = id,
                automovel = "Carro",
                cor = "branco",
                modelo = "RangerRover"


        )

        Mockito.`when`(veiculoRepository.findById(id)).thenReturn(Optional.of(veiculoModel))
        val resposta = veiculoService.findById(id)

        assertEquals(id, resposta.id)
        assertEquals("Carro", resposta.automovel)
        assertEquals("branco", resposta.cor)
        assertEquals("RangerRover", resposta.modelo)
    }


    @Test

    // SALVAR MEU VEICULO
    fun `save my veiculo`() {

        val id = 12
        val veiculoModel = VeiculoModel(
                id = id,
                automovel = "Moto",
                cor = "red",
                modelo = "Hornet"
        )


        Mockito.`when`(veiculoRepository.save(veiculoModel)).thenReturn(veiculoModel)

        val res = veiculoService.saveVeiculos(veiculoModel)

        assertEquals(id, res.id)
        assertEquals("Moto", res.automovel)
        assertEquals("red", res.cor)
        assertEquals("Hornet", res.modelo)

    }

    @Test

    fun `find all veiculos`() {

        val id = 1
        val veiculoModel = VeiculoModel(

                id = id,
                automovel = "motocicleta",
                cor = "yellow",
                modelo = "bis"
        )
        Mockito.`when`(veiculoRepository.findAll()).thenReturn(listOf(veiculoModel))

        val res = veiculoService.findAll()

        assertEquals(id, res[0].id)
        assertEquals("motocicleta", res[0].automovel)
        assertEquals("yellow", res[0].cor)
        assertEquals("bis", res[0].modelo)
    }

    @Test

    // DELETAR VEICULO POR ID
    fun `Delete veiculo for id`() {

        val id = 123
        val veiculoModel = VeiculoModel(
                id = id,
                automovel = "Bike",
                cor = "Blue",
                modelo = "Caisara"
        )

        Mockito.verify(veiculoRepository).delete(veiculoModel)


        val res = veiculoService.deleteById(id)

        assertEquals(id, veiculoModel.id)
        assertEquals("Bike", veiculoModel.automovel)
        assertEquals("Blue", veiculoModel.cor)
        assertEquals("Caisara", veiculoModel.modelo)


    }
}





//    // CONTAR VEICULOS DENTRO DO ESTACIONAMENTO
//    fun `count the veiculos on the alocadora`(){
//
//        val id = 16
//        val veiculoModel = VeiculoModel(
//                id = id,
//                automovel = "a",
//                cor = "b",
//                modelo = "c"
//        )
//
//        Mockito.`when`(veiculoRepository.count()).thenReturn(5)
//
//        val res = veiculoService.count()
//










//    @Test
//    fun `update my veiculo`(){
//
//        val id = 1
//        val veiculoModel = VeiculoModel(
//                id = id,
//                automovel = "caminhao",
//                cor = "white",
//                modelo = "volvo"
//        )
//
//        Mockito.`when`(veiculoRepository.save(veiculoModel)).thenReturn(veiculoModel)
//
//        val resposta = veiculoService.alterById(id, veiculoModel)
//
//        assertEquals(id, resposta.id)
//        assertEquals("caminhao", resposta.automovel)
//        assertEquals("white", resposta.cor)
//        assertEquals("volvo", resposta.modelo)
//    }


























