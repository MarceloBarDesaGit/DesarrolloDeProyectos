package negocio;

	import java.time.LocalDate;
import java.util.List;

	import dao.PartidoDao;
	import dao.CanchaHoraDao;
	import dao.PersonaDao;	
	//--------
	import datos.Partido;
	import datos.CanchaHora;	
	import datos.Arbitro;
	
	
	public class PartidoABM {

		// INSTANCIAS de la capa DAO
		private PartidoDao daoPartido = new PartidoDao();
		private CanchaHoraDao daoCanchaHora = new CanchaHoraDao();
		private PersonaDao daoPersonaArb = new PersonaDao();
		
		// AGREGAR
		//--------------------
		public int agregarPartido(Partido p) {
			int salida = 0;
			if (traerPartido(p.getIdPartido()) == null) {
				salida = daoPartido.agregar(new Partido());
				// "El Partido: " + e.getIdPartido() + " se Agrego correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Partido con el ID: " + e.getIdPartido() + " YA existe."
			}
			return salida;
		}

		// MODIFICAR
		//--------------------
		public void modificarPartido(Partido p) {
			if(daoPartido.traerPartido(p.getIdPartido()) != null) {
				daoPartido.actualizar(p);
				// "El Partido: " + e.getIdPartido() + " se Actualizo correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Partido con el ID: " + e.getIdPartido() + " NO existe."
			}
			return;
			
		}

		// ELIMINAR (Fisica con Dependencia)
		//----------------------------------
		public boolean eliminarPartido(Partido p) {
			boolean salida = false;
			Partido eq = daoPartido.traerPartido(p.getIdPartido());
			if(daoPartido.traerPartido(p.getIdPartido()) != null) {
				//Listas de Dependencias
				List<CanchaHora> listaCanchaHoras = daoCanchaHora.traerCanchaHoraPorPartido(p.getIdPartido());
				List<Arbitro> listaArbitros = daoPersonaArb.traerArbitroPorPartido(p.getIdPartido());
			
				//----------
				if(listaCanchaHoras.isEmpty()) {
					daoPartido.eliminar(eq);
					salida = true;
					// "El Partido" + e.getIdPartido() + " ha sido Eliminado correctamente."
				}else {
					// "El Local" + e.getIdPartido() + " NO ha sido Eliminado por tener sus dependencias."
				}
			}else {
				// "No existe el Local " + l + "a Eliminar"
			}
			return salida;
		}

	// TRAER
	//------------------
		public Partido traerPartido(int idPartido) {
			return daoPartido.traerPartido(idPartido);
		}

	// LISTADO general
	//-------------------
		public List<Partido> traerPartido() {
			return daoPartido.traerPartido();
		}
		public List<Partido> traerPartidos(int categoria) {
			return daoPartido.traerPartidos(categoria);
		}
		public List<Partido> traerPartido(LocalDate fechaPart) {
			return daoPartido.traerPartido(fechaPart);
		}	
		public List<Partido> traerPartido(LocalDate fechaDesde, LocalDate fechaHasta) {
			return daoPartido.traerPartido(fechaDesde, fechaHasta);
		}	
		public List<Partido> traerPartido(LocalDate fechaDesde, LocalDate fechaHasta, int categoria) {
			return daoPartido.traerPartido(fechaDesde, fechaHasta,categoria);
		}				
						

//---------------------
}// Fin PartidoABM



