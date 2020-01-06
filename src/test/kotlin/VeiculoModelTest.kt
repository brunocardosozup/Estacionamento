import com.br.project.models.VeiculoModel
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert.assertEquals
import org.springframework.test.context.junit4.SpringRunner

class VeiculoModelTest {
    private lateinit var modelTest : VeiculoModel


    @BeforeEach
fun testModel(){
        modelTest = VeiculoModel(modelTest.id, modelTest.automovel, modelTest.cor, modelTest.modelo)
           }

    @Test
  fun getID() {
val getId =    modelTest.id


    }
}



