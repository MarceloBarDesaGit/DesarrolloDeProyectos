package negocio;

	import java.time.LocalDate;
import java.util.List;

	import dao.TorneoDao;
	import dao.CampeonatoDao;
//--------
	import datos.Torneo;	
	import datos.Campeonato;
	
	public class TorneoABM {
		// INSTANCIAS de la capa DAO
		private TorneoDao daoTorneo = new TorneoDao();
		private CampeonatoDao daoCampeonato = new CampeonatoDao();
		

		// AGREGAR
		//--------------------
		public int agregarTorneo(Torneo t) {
			int salida = 0;
//			Equipo to = traerTorneo(t.getIdTorneo());
//			if (to == null) {
			if (traerTorneo(t.getIdTorneo()) == null) {		
				salida = daoTorneo.agregar(new Torneo());
				// "El Torneo: " + e.getIdTorneo() + " se Agrego correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Torneo con el ID: " + e.getIdTorneo() + " YA existe."
			}
			return salida;
		}
	
		// MODIFICAR
		//--------------------
		public void modificarTorneo(Torneo t) {
//			Torneo eq = daoTorneo.traerTorneo(t.getIdTorneo());
//			if(eq != null) {
			if (daoTorneo.traerTorneo(t.getIdTorneo()) != null) {
				daoTorneo.actualizar(t);
				// "El Torneo: " + e.getIdTorneo() + " se Actualizo correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Torneo con el ID: " + e.getIdTorneo() + " NO existe."
			}
			return;
			
		}

		// ELIMINAR (Fisica con Dependencia)
		//----------------------------------
		// Tambien puede ser como void y campos int etc
		//		public void eliminarTorneo(int idCTorneo ) {
		//			Torneo torneo = daoTorneo.traerTorneo(idCTorneo);
		//			if(torneo != null) {
		//				daoTorneo.eliminar(torneo);
		//			}	
		//		}
		public boolean eliminarTorneo(Torneo t) {
			boolean salida = false;
//			Torneo to = daoTorneo.traerTorneo(t.getIdTorneo());
//			if(to != null) {
			if(daoTorneo.traerTorneo(t.getIdTorneo()) != null) {
				//Listas de Dependencias
				List<Campeonato> listaCampeonatos = daoCampeonato .traerCampeonatoPorTorneo(t.getIdTorneo());
				//----------
				if(listaCampeonatos.isEmpty()) {
					daoTorneo.eliminar(t);
					salida = true;
					// "El Torneo" + e.getIdTorneo() + " ha sido Eliminado correctamente."
				}else {
					// "El Local" + e.getIdTorneo() + " NO ha sido Eliminado por tener sus dependencias."
				}
			}else {
				// "No existe el Local " + l + "a Eliminar"
			}
			return salida;
		}

	// TRAER
	//------------------
		public Torneo traerTorneo(int idTorneo) {
			return daoTorneo.traerTorneo(idTorneo);
		}

//		public Torneo traerTorneo(String nombre) {
//			return daoTorneo.traerTorneo(nombre);
//		}

	// LISTADO general
	//-------------------
//		List<Torneo> traerTorneo()	--> Listar TODAs las Personas
//		List<Torneo> traerTorneos(String sponsor)
//		List<Torneo> traerTorneo(LocalDate fechaAlta)	
//		List<Torneo> traerTorneo(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor)
// -------------------------------------------------------------

		public List<Torneo> traerTorneo() {
			return daoTorneo.traerTorneo();
		}
		
		public List<Torneo> traerTorneo(String sponsor) {
			return (List<Torneo>) daoTorneo.traerTorneo(sponsor);
		}
			
		public List<Torneo> traerTorneo(LocalDate fechaDesde, LocalDate fechaHasta) {
			return daoTorneo.traerTorneo(fechaDesde, fechaHasta);
		}
		public List<Torneo> traerTorneo(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor) {
			return daoTorneo.traerTorneo(fechaDesde, fechaHasta, sponsor);
		}


//---------------------
}// Fin TorneoABM

//	public boolean agregarProducto(String codProducto, String descripProducto, float precioUniProd, LocalDate fechAlta) throws Exception {
//		if (traerProducto(codProducto) != null) throw new Exception(" El Producto con el código de producto: [" +codProducto + "]  ya existe en Lista");
//			int idProducto=1; 
//			if (!lstProductos.isEmpty()) {              // Sí NO esta Vacia
//				idProducto = lstProductos.get(lstProductos.size() - 1).getIdProducto() + 1; 
//			}
//		return lstProductos.add(new Producto(idProducto, codProducto, descripProducto, precioUniProd, fechAlta));   
//	}


