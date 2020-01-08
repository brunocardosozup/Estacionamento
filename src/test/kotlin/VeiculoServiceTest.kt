import com.br.project.models.VeiculoModel
import com.br.project.repositories.VeiculoRepository
import com.br.project.services.VeiculoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito

import java.util.*

class VeiculoServiceTest {
    private val veiculoRepository: VeiculoRepository = Mockito.mock(VeiculoRepository::class.java)
    private val veiculoService = VeiculoService(veiculoRepository)

    @Test
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
//
//    @Test
//    fun `find all veicule`() {
//        val id = 123
//        val veiculoModel = VeiculoModel(
//                id = id,
//                automovel = "Moto",
//                cor = "Red",
//                modelo = "Hornet"
//        )
//BDDMockito.given(veiculoRepository.findAll()).thenReturn(Optional.of(veiculoModel))
//
//    }
}


















