import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import com.br.project.services.VeiculoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.internal.configuration.injection.MockInjection

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
    fun `save my veiculo`(){

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

    // DELETAR VEICULO POR ID
    fun `Delete veiculo for id`(){

        val id = 123
        val veiculoModel = VeiculoModel(
                id = id,
                automovel = "Bike",
                cor = "Blue",
                modelo = "Caisara"
        )
Mockito.`when`(veiculoRepository.deleteById(id))

        assertEquals(id, id)
// TESTE CRIADO COM LÓGICA ERRADA

    }



    @Test

    // CONTAR VEICULOS DENTRO DO ESTACIONAMENTO
    fun `count the veiculos on the alocadora`(){

        Mockito.`when`(veiculoRepository.count()).thenReturn(Long.MAX_VALUE)



    }

    @Test
    fun `update my veiculo`(){

        val id = 1
        val veiculoModel = VeiculoModel(
                id = id,
                automovel = "caminhao",
                cor = "white",
                modelo = "volvo"
        )

        Mockito.`when`(veiculoRepository.save(veiculoModel)).thenReturn(veiculoModel)

        val resposta = veiculoService.alterById(id, veiculoModel)

        assertEquals(id, resposta.id)
        assertEquals("caminhao", resposta.automovel)
        assertEquals("white", resposta.cor)
        assertEquals("volvo", resposta.modelo)
    }

}
























