package negocio;

	import java.time.LocalDate;
	import java.util.List;

	import dao.CampeonatoDao;
	import dao.PeriodoDao;
	import dao.TemporadaDao;
	import dao.ZonaDao;
//--------
	import datos.Campeonato;	
	import datos.Temporada;
	import datos.Zona;	
	import datos.Periodo;
	
	public class CampeonatoABM {
		// INSTANCIAS de la capa DAO para ABM y Eliminar Dependencias
		private CampeonatoDao daoCampeonato = new CampeonatoDao();
		private TemporadaDao daoTemporada = new TemporadaDao();		
		private ZonaDao daoZona = new ZonaDao();
		private PeriodoDao daoPeriodo = new PeriodoDao();		
		
		// AGREGAR
		//--------------------
		public int agregarCampeonato(Campeonato c) {
			int salida = 0;
			if (traerCampeonato(c.getIdCampeonato()) == null) {		
				salida = daoCampeonato.agregar(new Campeonato());
				// "El Campeonato: " + c.getIdCampeonato() + " se Agrego correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Campeonato con el ID: " + c.getIdCampeonato() + " YA existe."
			}
			return salida;
		}
	
		// MODIFICAR
		//--------------------
		public void modificarCampeonato(Campeonato c) {
			if (daoCampeonato.traerCampeonato(c.getIdCampeonato()) != null) {
				daoCampeonato.actualizar(c);
				// "El Campeonato: " + c.getIdCampeonato() + " se Actualizo correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Campeonato con el ID: " + c.getIdCampeonato() + " NO existe."
			}
			return;
			
		}

		// ELIMINAR (Fisica con Dependencia)
		//----------------------------------
		// Tambien puede ser como void y campos int etc
		//		public void eliminarCampeonato(int idCCampeonato ) {
		//			Campeonato Campeonato = daoCampeonato.traerCampeonato(idCCampeonato);
		//			if(Campeonato != null) {
		//				daoCampeonato.eliminar(Campeonato);
		//			}	
		//		}
		public boolean eliminarCampeonato(Campeonato c) {
			boolean salida = false;
			if(daoCampeonato.traerCampeonato(c.getIdCampeonato()) != null) {
			  //Listas de Dependencias
				List<Temporada> listaTemporadas = daoTemporada .traerTemporadaPorCampeonato(c.getIdCampeonato());
				List<Zona> listaZonas = daoZona .traerZonaPorCampeonato(c.getIdCampeonato());
				List<Periodo> listaPeriodos = daoPeriodo .traerPeriodoPorCampeonato(c.getIdCampeonato());
			  
			  //----------
				if(listaTemporadas.isEmpty() && listaZonas.isEmpty() && listaPeriodos.isEmpty()) {
					daoCampeonato.eliminar(c);
					salida = true;
					// "El Campeonato" + e.getIdCampeonato() + " ha sido Eliminado correctamente."
				}else {
					// "El Local" + e.getIdCampeonato() + " NO ha sido Eliminado por tener sus dependencias."
				}
			}else {
				// "No existe el Local " + l + "a Eliminar"
			}
			return salida;
		}

	// TRAER
	//------------------
		public Campeonato traerCampeonato(int idCampeonato) {
			return daoCampeonato.traerCampeonato(idCampeonato);
		}

//		public Campeonato traerCampeonato(String nombre) {
//			return daoCampeonato.traerCampeonato(nombre);
//		}

	// LISTADO general
	//-------------------
//		List<Campeonato> traerCampeonato()	--> Listar TODAs las Personas
//		List<Campeonato> traerCampeonatos(String sponsor)
//		List<Campeonato> traerCampeonato(LocalDate fechaAlta)	
//		List<Campeonato> traerCampeonato(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor)
// -------------------------------------------------------------

		public List<Campeonato> traerCampeonato() {
			return daoCampeonato.traerCampeonato();
		}
		
		public List<Campeonato> traerCampeonato(String sponsor) {
			return (List<Campeonato>) daoCampeonato.traerCampeonato(sponsor);
		}
			
		public List<Campeonato> traerCampeonato(LocalDate fechaDesde, LocalDate fechaHasta) {
			return daoCampeonato.traerCampeonato(fechaDesde, fechaHasta);
		}
		public List<Campeonato> traerCampeonato(LocalDate fechaDesde, LocalDate fechaHasta, int temporada) {
			return daoCampeonato.traerCampeonato(fechaDesde, fechaHasta, temporada);
		}


//---------------------
}// Fin CampeooonatoABM
