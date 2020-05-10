package dao;

	import java.time.LocalDate;
	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	//--------
	import datos.Campeonato;

	public class CampeonatoDao {
		private static Session session;
		private Transaction tx;
		
		//---------------------
		// Conexión a BD y creación de la Session
		protected void iniciaOperacion() throws HibernateException {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
		}
		protected void manejaExcepcion(HibernateException he) throws HibernateException {
			tx.rollback();
			throw new HibernateException("ERROR en la capa de acceso a datos", he);
		}
		
//-------------------------------------------------------
//   Agregar-Eliminar-Modificar-Traer - List de Contacto
//-------------------------------------------------------
// AGREGAR
	public int agregar(Campeonato objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

// ACTUALIZAR
	public void actualizar(Campeonato objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

// ELIMINAR
	// Físico (sin Dependencia)
	public void eliminar(Campeonato objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// Borrado Logico
	public void Borrar(Campeonato objeto) throws HibernateException {
		try {
			iniciaOperacion();
			// --Control del nuevo Estado
			// para la tabla de Campeonato que me pide el estado.
			// Estafo = "A"
			// FechaCtrl=xx/xx/xx
			// FechaModf=xx/xx/xx
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

//---------------------------------------
//	TRAER (varios)
//---------------------------------------
// Campeonato
//			traerCampeonato(int idCampeonato)   uniqueResult()
//			traerCampeonato(String nombre)       uniqueResult()
	// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Campeonato traerCampeonato(int idCampeonato) throws HibernateException {
		Campeonato objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Campeonato
			objeto = (Campeonato) session.get(Campeonato.class, idCampeonato);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public Campeonato traerCampeonato(String nombre) throws HibernateException {
		Campeonato objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Campeonato
	        String query = "from Campeonato e where e.nombreCampeonato=" + nombre;			
			objeto = (Campeonato) session.createQuery(query)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	CAMPEONATO
//				List<Campeonato> traerCampeonato()	--> Listar TODAs las Personas
//				List<Campeonato> traerCampeonatos(int temporada)
//				List<Campeonato> traerCampeonato(LocalDate fechaAlta)	
//				List<Campeonato> traerCampeonato(LocalDate fechaDesde, LocalDate fechaHasta, int temporada)
//	 --> para Elimiinar con Dependencias
//              List<Campeonato> traerCampeonatoPorTorneo(int torneo)
// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Campeonato> traerCampeonato() throws HibernateException {
		List<Campeonato> lista = null;
		try {
			iniciaOperacion();
			String query = "from Campeonato e "
					+ "order by "
					+ "e.fechaCampeonato asc "
					+ "e.nombreCampeonato asc "
					+ "e.cgoTemporada asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Campeonato> traerCampeonatos(int temporada) throws HibernateException {
		List<Campeonato> lista = null;
		try {
			iniciaOperacion();
			String query = "from Campeonato e "
					+ "where e.cgoTemporada=" + temporada
					+ "order by "
					+ "e.fechaCampeonato "
					+ "e.nombreCampeonato asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Campeonato> traerCampeonato(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Campeonato> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Campeonato e "
					+ "where (e.fechaCampeonato >=" + fechaDesde + " and j.fechaCampeonato <=" + fechaHasta +")" 
					+ "order by "
					+ "e.fechaCampeonato asc "
					+ "e.nombreCampeonato asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Campeonato> traerCampeonato(LocalDate fechaDesde, LocalDate fechaHasta, int temporada)
			throws HibernateException {
		List<Campeonato> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Campeonato e "
					+ "where (e.fechaCampeonato >=" + fechaDesde + " and j.fechaCampeonato <=" + fechaHasta +")" 
					+ " and (e.cgoTemporada=" + temporada +")"
					+ " order by "
					+ "e.fechaCampeonato asc "
					+ "e.nombreCampeonato asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
		
// Para el Eliminar
//------------------------
	public List<Campeonato> traerCampeonatoPorTorneo(int torneo) throws HibernateException {
		List<Campeonato> campe = null;
		try {
			iniciaOperacion();
			String query = "from Campeonato ca where ca.cgoTorneo = " + torneo;
			campe = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return campe;
	}


//-----------------	
}//Fin CampeonatoDao

