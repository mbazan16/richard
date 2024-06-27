package es.tiendazara.web.services.prenda;

import java.util.List;

import es.tiendazara.web.common.exception.ServicioException;
import es.tiendazara.web.entities.Prenda;

public interface PrendaService{
	List<Prenda> listAll()throws ServicioException;

	Prenda get(Integer id)throws ServicioException;

	void nueva(Prenda prenda)throws ServicioException;

	void modificar(Prenda prenda)throws ServicioException;

	void eliminar(Integer id)throws ServicioException;
	

}
