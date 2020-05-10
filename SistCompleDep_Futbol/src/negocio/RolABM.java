package negocio;

import java.util.List;

import dao.PermisoAccesoDao;
import dao.RolDao;
//-------
import datos.PermisoAcceso;
import datos.Rol;

public class RolABM {
	// Instancia de las tablas  a usar por cada capa DAO
	private RolDao daoRol = new RolDao();                           // para el ABM
	private PermisoAccesoDao daoPermisoAc = new PermisoAccesoDao(); // para el Eliminar
	
	// AGREGAR
	//--------------------
	public int agregarlRol(Rol r) {
		int salida = 0;
		Rol ro = traerRol(r.getIdRol());
		if (ro == null) {
			salida = daoRol.agregar(new Rol());
			// "El Rol: " + r.getIdRol() + " se Agrego correctamente."
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Rol con el ID: " + r.getIdRol() + " YA existe."
		}
		return salida;
	}
// ------------------------------------------------
//tambien lo hace de esta forma (que le cambio ?) 
//	public boolean actualizarRol(Rol rol) {
//--------------
//	public boolean actualizarRol(Rol r) {
//		boolean salida = false;		
//		Rol ro = daoRol.traerRol(r.getIdRol());
//		if (ro != null) {
//			daoRol.actualizar(r);
//			salida = true;
//			// "El Rol" + r + " ha sido Eliminado correctamente."
//			} else {
//			// Depende de lo que pida, si tirar excepción 
//			// "El Rol: " + rol + " No existe."		
//		}
//		return salida;
//	}
	
	// MODIFICAR
	//--------------------	
	public void modificarRol(Rol rol) {
		Rol ro = daoRol.traerRol(rol.getIdRol());
		if (ro != null) {
			daoRol.actualizar(rol);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Rol: " + rol + " No existe."		
		}
		return;
	}

	// ELIMINAR (Fisica con Dependencia)
	// ------------------------------------------------
	public boolean eliminarRol(Rol r) {
		boolean salida = false;
		Rol ro = daoRol.traerRol(r.getIdRol());
		if (ro != null) {
			//Listas de Dependencias
			List<PermisoAcceso> listaPermisoAc = daoPermisoAc.traerPermisosPorRol(r.getIdRol());
			//-------
			// Si la Lista de PermisosAcceso esta Vacia, 
			// 		se puede ELIMNAR el ROL sin problema.
			if (listaPermisoAc.isEmpty()) {
				daoRol.eliminar(ro);
				salida = true;
				// "El Rol" + r + " ha sido Eliminado correctamente."
			} else {
				// "El Rol" + r + " NO ha sido Eliminado por tener sus dependencias."
			}
		} else {
			// "No existe el Rol " + r + " a Eliminar"
		}
		return salida;
	}

// TRAER
//--------------	
	public Rol traerRol(int idRol) {
		return daoRol.traerRol(idRol);
	}

	public Rol traerRol(String nombre) {
		return daoRol.traerRol(nombre) ;
	}

//LISTADOS Generales
// ----------------------------
	public List<Rol> traerRol() {
		return daoRol.traerRol();
	}
	
	List<Rol> traerRols(int permiso) {
		return daoRol.traerRols(permiso);
	}	

// ---------------
}// Fin RolABM
