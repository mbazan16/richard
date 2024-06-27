package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.tiendazara.web.common.GeneroPrenda;
import es.tiendazara.web.common.TipoPrenda;
import es.tiendazara.web.entities.Prenda;
import es.tiendazara.web.reporitories.PrendaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) 
public class PrendaRepositoryTest {

    @Autowired
    private PrendaRepository prendaRepository;

    @Test
    public void testGuardarYEncontrarPrenda() {
        Prenda prenda = new Prenda();
        prenda.setTalla("M");
        prenda.setColor("Rojo");
        prenda.setGenero(GeneroPrenda.HOMBRE);
        prenda.setTipo(TipoPrenda.CAMISA);

        prendaRepository.save(prenda);

        List<Prenda> found = prendaRepository.findAll();
        assertThat(found).isNotEmpty();
        assertThat(found.get(0).getTalla()).isEqualTo("M");
    }
}
