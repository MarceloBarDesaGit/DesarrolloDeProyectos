package datos;

public class Reglamento {
private int idReglamento;
private int nroArticulo;
private char incisoArticulo;
private String detalleArticulo;
private int cantFechasExpulsado;
private int cantX;

public Reglamento() {}

public Reglamento(int idReglamento, int nroArticulo, char incisoArticulo, String detalleArticulo,
		int cantFechasExpulsado, int cantX) {
	super();
	this.idReglamento = idReglamento;
	this.nroArticulo = nroArticulo;
	this.incisoArticulo = incisoArticulo;
	this.detalleArticulo = detalleArticulo;
	this.cantFechasExpulsado = cantFechasExpulsado;
	this.cantX = cantX;
}
public int getIdReglamento() {
	return idReglamento;
}
public void setIdReglamento(int idReglamento) {
	this.idReglamento = idReglamento;
}
public int getNroArticulo() {
	return nroArticulo;
}
public void setNroArticulo(int nroArticulo) {
	this.nroArticulo = nroArticulo;
}
public char getIncisoArticulo() {
	return incisoArticulo;
}
public void setIncisoArticulo(char incisoArticulo) {
	this.incisoArticulo = incisoArticulo;
}
public String getDetalleArticulo() {
	return detalleArticulo;
}
public void setDetalleArticulo(String detalleArticulo) {
	this.detalleArticulo = detalleArticulo;
}
public int getCantFechasExpulsado() {
	return cantFechasExpulsado;
}
public void setCantFechasExpulsado(int cantFechasExpulsado) {
	this.cantFechasExpulsado = cantFechasExpulsado;
}
public int getCantX() {
	return cantX;
}
public void setCantX(int cantX) {
	this.cantX = cantX;
}

@Override
public String toString() {
	return "Reglamento [idReglamento=" + idReglamento + ", nroArticulo=" + nroArticulo + ", incisoArticulo="
			+ incisoArticulo + ", detalleArticulo=" + detalleArticulo + ", cantFechasExpulsado=" + cantFechasExpulsado
			+ ", cantX=" + cantX + "]";
}


}
