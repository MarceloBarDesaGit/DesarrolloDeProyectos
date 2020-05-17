package negocio;

	import java.util.List;

	import dao.EquipoDao;
	import dao.PersonaDao;
	//--------
	import datos.Jugador;
	import datos.Equipo;	

	public class EquipoABM {

		// INSTANCIAS de la capa DAO
		private EquipoDao daoEquipo = new EquipoDao();
		private PersonaDao daoJugador = new PersonaDao();

		// AGREGAR
		//--------------------
//		public boolean agregarProducto(String codProducto, String descripProducto, float precioUniProd, LocalDate fechAlta) throws Exception {
//		if (traerProducto(codProducto) != null) throw new Exception(" El Producto con el código de producto: [" +codProducto + "]  ya existe en Lista");
//			int idProducto=1; 
//			if (!lstProductos.isEmpty()) {              // Sí NO esta Vacia
//				
//		idProducto = lstProductos.get(lstProductos.size() - 1).getIdProducto() + 1; 
//			}
//		return lstProductos.add(new Producto(idProducto, codProducto, descripProducto, precioUniProd, fechAlta));   
//	}
		
		public int agregarEquipo(Equipo e) {
			int salida = 0;
			Equipo eq = traerEquipo(e.getIdEquipo());
			if (eq == null) {
				salida = daoEquipo.agregar(new Equipo());
				// "El Equipo: " + e.getIdEquipo() + " se Agrego correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Equipo con el ID: " + e.getIdEquipo() + " YA existe."
			}
			return salida;
		}

		// MODIFICAR
		//--------------------
		public void modificarEquipo(Equipo e) {
			Equipo eq = daoEquipo.traerEquipo(e.getIdEquipo());
			if(eq != null) {
				daoEquipo.actualizar(e);
				// "El Equipo: " + e.getIdEquipo() + " se Actualizo correctamente."
			} else {
				// Depende de lo que pida, si tirar excepción 
				// "El Equipo con el ID: " + e.getIdEquipo() + " NO existe."
			}
			return;
			
		}

		// ELIMINAR (Fisica con Dependencia)
		// Equipo tiene dependencia con Jugador y Categoria
		// Sancion no se tocca, queda ahí hasta la desición del Organizador
		//----------------------------------
		public boolean eliminarEquipo(Equipo e) {
			boolean salida = false;
			Equipo eq = daoEquipo.traerEquipo(e.getIdEquipo());
			if(eq != null) {
				//Listas de Dependencias
				List<Jugador> listaJugadores = daoJugador.traerJugadorPorEquipo(e.getIdEquipo());
				List<Equipo> listaCategoria = daoEquipo.traerCategoriaPorEquipo(e.getIdEquipo());
				//----------
				if(listaJugadores.isEmpty() && listaCategoria.isEmpty()) {
					daoEquipo.eliminar(eq);
					salida = true;
					// "El Equipo" + e.getIdEquipo() + " ha sido Eliminado correctamente."
				}else {
					// "El Local" + e.getIdEquipo() + " NO ha sido Eliminado por tener sus dependencias."
				}
			}else {
				// "No existe el Local " + l + "a Eliminar"
			}
			return salida;
		}

		// Borrado Logico
		public boolean bajaEquipo(Equipo p) {
			boolean salida = false;
			Equipo prod = daoEquipo.traerEquipo(p.getIdEquipo());
			if(prod!=null) {                    // Si el Equipo traido existe
				//prod.setHabilitado(false);    // No se lo habilita a borrar
				daoEquipo.actualizar(prod);     // Se actualiza el estado a True 
				salida = true;
			}
			else {
				// Depende de lo que pida, si tirar excepción o dar mensaje de error.
			}
			return salida;
		}

	// TRAER
	//------------------
		public Equipo traerEquipo(int idEquipo) {
			return daoEquipo.traerEquipo(idEquipo);
		}

		public Equipo traerEquipo(String nombre) {
			return daoEquipo.traerEquipo(nombre);
		}

		// LISTADO general
		//-------------------
		public List<Equipo> traerEquipo() {
			return daoEquipo.traerEquipo();
		}


	//---------------------
	}// Fin EquipoABM


