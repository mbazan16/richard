package es.tiendazara.web.services.prenda;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tiendazara.web.common.exception.ErrorCodeException;
import es.tiendazara.web.common.exception.ServicioException;
import es.tiendazara.web.entities.Prenda;
import es.tiendazara.web.reporitories.PrendaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrendaServiceImpl implements PrendaService {
	
	@Autowired
	PrendaRepository repositorio;


	@Override
	public List<Prenda> listarTodasLasPrendas() throws ServicioException {
		log.info("[listarTodasLasPrendas]");
		List<Prenda> prendas = new ArrayList<Prenda>();
		try {
			prendas = repositorio.findAll();
			
		}catch(Exception e) {
			log.error("Error general",e);
			throw new ServicioException(ErrorCodeException.ERROR_GENERAL);
		}
		return prendas;
	}

	@Override
	public Prenda get(Integer id) throws ServicioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void nueva(Prenda prenda) throws ServicioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Prenda prenda) throws ServicioException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) throws ServicioException {
		// TODO Auto-generated method stub
		
	}

}
