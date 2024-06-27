package com.example.demo.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import es.tiendazara.web.common.GeneroPrenda;
import es.tiendazara.web.common.TipoPrenda;
import es.tiendazara.web.controllers.PrendaController;
import es.tiendazara.web.entities.Prenda;
import es.tiendazara.web.services.prenda.PrendaService;

@WebMvcTest(PrendaController.class)
public class PrendaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrendaService prendaService;

    private List<Prenda> prendaList;

    @BeforeEach
    public void setUp() {
        prendaList = Arrays.asList(
            new Prenda(1, "M", "Rojo", GeneroPrenda.HOMBRE, TipoPrenda.CAMISA),
            new Prenda(2, "L", "Azul", GeneroPrenda.MUJER, TipoPrenda.PANTALON)
        );
    }

    @Test
    public void testPaginaDepartamentos() throws Exception {
        when(prendaService.listarTodasLasPrendas()).thenReturn(prendaList);

        mockMvc.perform(get("/prenda"))
            .andExpect(status().isOk())
            .andExpect(view().name("prenda"))
            .andExpect(model().attributeExists("prendas"))
            .andExpect(model().attribute("prendas", prendaList));
        
        verify(prendaService, times(1)).listarTodasLasPrendas();
    }

    @Test
    public void testPaginaDepartamento() throws Exception {
        Prenda prenda = new Prenda(1, "M", "Rojo", GeneroPrenda.HOMBRE, TipoPrenda.CAMISA);
        when(prendaService.get(1)).thenReturn(prenda);

        mockMvc.perform(get("/prenda/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("prenda"))
            .andExpect(model().attributeExists("prenda"))
            .andExpect(model().attribute("prenda", prenda));
        
        verify(prendaService, times(1)).get(1);
    }
}
