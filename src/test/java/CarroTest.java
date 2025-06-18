import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import dao.AcessorioDao;
import dao.CarroDao;
import dao.IAcessorioDao;
import dao.ICarroDao;
import dao.IMarcaDao;
import dao.MarcaDao;
import domain.Acessorio;
import domain.Carro;
import domain.Marca;

public class CarroTest {
    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public CarroTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();

    }

    @Test
    public void cadastrar() {
        Marca marca = criarMarca("123");
        Acessorio acessorio = criarAcessorio("ac123");

        Carro carro = new Carro();
        carro.setNome("Uno");
        carro.setCodigo("uno123");
        carro.setMarca(marca);
        carro.setAcessorio(Arrays.asList(acessorio));
        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setNome("Gol");
        marca.setCodigo(codigo);
        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String codigo) {
        Acessorio acessorio = new Acessorio();
        acessorio.setNome("Acessório");
        acessorio.setCodigo(codigo);
        acessorio.setDescricao("universal");
        return acessorioDao.cadastrar(acessorio);
    }
}
