package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.tiendazara.web.common.GeneroPrenda;
import es.tiendazara.web.common.TipoPrenda;
import es.tiendazara.web.entities.Prenda;
import es.tiendazara.web.reporitories.PrendaRepository;
import es.tiendazara.web.services.prenda.PrendaServiceImpl;

public class PrendaServiceImplTest {

    @Mock
    private PrendaRepository prendaRepository;

    @InjectMocks
    private PrendaServiceImpl prendaService;

    private List<Prenda> prendaList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        prendaList = Arrays.asList(
            new Prenda(1, "M", "Rojo", GeneroPrenda.HOMBRE, TipoPrenda.CAMISA),
            new Prenda(2, "L", "Azul", GeneroPrenda.MUJER, TipoPrenda.PANTALON)
        );
    }

    @Test
    public void testListarTodasLasPrendas() throws Exception {
        when(prendaRepository.findAll()).thenReturn(prendaList);

        List<Prenda> result = prendaService.listarTodasLasPrendas();
        
        assertThat(result).isEqualTo(prendaList);
        verify(prendaRepository, times(1)).findAll();
    }

    @Test
    public void testGetPrenda() throws Exception {
        Prenda prenda = new Prenda(1, "M", "Rojo", GeneroPrenda.HOMBRE, TipoPrenda.CAMISA);
        when(prendaRepository.findById(1)).thenReturn(java.util.Optional.of(prenda));

        Prenda result = prendaService.get(1);
        
        assertThat(result).isEqualTo(prenda);
        verify(prendaRepository, times(1)).findById(1);
    }
}
