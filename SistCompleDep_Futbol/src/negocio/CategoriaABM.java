package negocio;

import java.util.List;

import dao.CategoriaDao;
import dao.EquipoDao;
import dao.ZonaDao;
//--------
import datos.Categoria;	
import datos.Equipo;
import datos.Zona;
	
public class CategoriaABM {
	// INSTANCIAS de la capa DAO
	private CategoriaDao daoCategoria = new CategoriaDao();
	private ZonaDao daoZona = new ZonaDao();
	private EquipoDao daoEquipo = new EquipoDao();

// AGREGAR
// --------------------
	public int agregarCategoria(Categoria c) {
		int salida = 0;
//			Equipo to = traerCategoria(t.getIdCategoria());
//			if (to == null) {
		if (traerCategoria(c.getIdCategoria()) == null) {
			salida = daoCategoria.agregar(new Categoria());
			 //"La Categoria: " + c.getDescripCategoria() + " se Agrego correctamente."
		} else {
			// Depende de lo que pida, si tirar excepción
			// "La Categoria: " + c.getDescripCategoria() + " YA existe."
		}
		return salida;
	}

// MODIFICAR
// --------------------
	public void modificarCategoria(Categoria c) {
		if (daoCategoria.traerCategoria(c.getIdCategoria()) != null) {
			daoCategoria.actualizar(c);
			// "La Categoria: " + c.getDescripCategoria() + " se Actualizo correctamente."
		} else {
			// Depende de lo que pida, si tirar excepción
			// "La Categoria: " + c.getDescripCategoria() + " NO existe."
		}
		return;

	}

// ELIMINAR (Fisica con Dependencia)
// ----------------------------------
// Tambien puede ser como void y campos int etc
	// public void eliminarCategoria(int idCCategoria ) {
		// Categoria Categoria = daoCategoria.traerCategoria(idCCategoria);
		// if(Categoria != null) {
			// daoCategoria.eliminar(Categoria);
		// }
	// }
	public boolean eliminarCategoria(Categoria c) {
		boolean salida = false;
		if (daoCategoria.traerCategoria(c.getIdCategoria()) != null) {
			// Listas de Dependencias
			List<Zona> listaZonas = daoZona.traerZonaPorCategoria(c.getIdCategoria());
			// reutlizo el metodo traer
			List<Equipo> listaEquipos = daoEquipo.traerCategoriaPorEquipo(c.getIdCategoria());
			// ----------
			if (listaZonas.isEmpty() && listaEquipos.isEmpty()) {
				daoCategoria.eliminar(c);
				salida = true;
				// "La Categoria: " + c.getDescripCategoria() + " ha sido Eliminado correctamente."
			} else {
				// "La Categoria: " + c.getDescripCategoria() + " NO ha sido Eliminado por tener sus
				// dependencias."
			}
		} else {
			// "No existe La Categoria: " + c.getDescripCategoria() + "a Eliminar"
		}
		return salida;
	}

	// TRAER
	// ------------------
	public Categoria traerCategoria(int idCategoria) {
		return daoCategoria.traerCategoria(idCategoria);
	}

	public Categoria traerCategoria(String Categ) {
		return daoCategoria.traerCategoria(Categ);
	}

	// LISTADO general
	// -------------------
//		List<Categoria> traerCategoria()	--> Listar TODAs
// -------------------------------------------------------------

	public List<Categoria> traerCategoria() {
		return daoCategoria.traerCategoria();
	}


//---------------------
}// Fin CategoriaABM




