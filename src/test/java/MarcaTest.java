import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

import dao.IMarcaDao;
import domain.Marca;

public class MarcaTest {

    private IMarcaDao marcaDao;

    public MarcaTest() {
        marcaDao = new dao.MarcaDao();
    }

    @Test
    public void cadastrar() {
        Marca marca = new Marca();
        marca.setNome("Fiat");
        marca.setCodigo("FIA123");
        marca = marcaDao.cadastrar(marca);

        assertNotNull(marca);
        assertNotNull(marca.getId());
    }
}
