package negocio;

import java.util.List;

import dao.PeriodoDao;
import dao.CampeonatoDao;
//--------
import datos.Periodo;
import datos.Campeonato;

public class PeriodoABM {
	// INSTANCIAS de la capa DAO
	private PeriodoDao daoPeriodo = new PeriodoDao();
	private CampeonatoDao daoCampeonato = new CampeonatoDao();

// AGREGAR
// --------------------
	public int agregarPeriodo(Periodo p) {
		int salida = 0;
		if (traerPeriodo(p.getIdPeriodo()) == null) {
			salida = daoPeriodo.agregar(new Periodo());
			// "El Periodo: " + p.getDetallePeriodo() + " se Agrego correctamente."
		} else {
			// Depende de lo que pida, si tirar excepción
			// "El Periodo: " + p.getDetallePeriodo() + " YA existe."
		}
		return salida;
	}

// MODIFICAR
// --------------------
	public void modificarPeriodo(Periodo p) {
		if (daoPeriodo.traerPeriodo(p.getIdPeriodo()) != null) {
			daoPeriodo.actualizar(p);
			// "El Periodo: " + p.getDetallePeriodo() + " se Actualizo correctamente."
		} else {
			// Depende de lo que pida, si tirar excepción
			// "El Periodo: " + p.getDetallePeriodo() + " NO existe."
		}
		return;

	}

// ELIMINAR (Fisica con Dependencia)
// ----------------------------------
// Tambien puede ser como void y campos int etc
	// public void eliminarPeriodo(int idCPeriodo ) {
		// Periodo Periodo = daoPeriodo.traerPeriodo(idCPeriodo);
		// if(Periodo != null) {
			// daoPeriodo.eliminar(Periodo);
		// }
	// }
	
	public boolean eliminarPeriodo(Periodo c) {
		boolean salida = false;
		if (daoPeriodo.traerPeriodo(c.getIdPeriodo()) != null) {
			// Listas de Dependencias
			// Reutilizo el traer de campeonato con periodos
			List<Periodo> listaPeriodos = daoPeriodo .traerPeriodoPorCampeonato(c.getIdPeriodo());
			// ----------
			if (listaPeriodos.isEmpty()) {
				daoPeriodo.eliminar(c);
				salida = true;
				// "La Periodo: " + c.getDescripPeriodo() + " ha sido Eliminado
				// correctamente."
			} else {
				// "La Periodo: " + c.getDescripPeriodo() + " NO ha sido Eliminado por tener
				// sus
				// dependencias."
			}
		} else {
			// "No existe La Periodo: " + c.getDescripPeriodo() + "a Eliminar"
		}
		return salida;
	}

	// TRAER
	// ------------------
	public Periodo traerPeriodo(int idPeriodo) {
		return daoPeriodo.traerPeriodo(idPeriodo);
	}

// LISTADO general
// -------------------
//			List<Periodo> traerPeriodo()	--> Listar TODAs
// -------------------------------------------------------------

	public List<Periodo> traerPeriodo() {
		return daoPeriodo.traerPeriodo();
	}

//---------------------
}// Fin periodoABM
