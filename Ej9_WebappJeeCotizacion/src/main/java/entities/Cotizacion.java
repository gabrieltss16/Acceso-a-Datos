package entities;

public class Cotizacion {

	private String ciclo;
	private String evalua;
	private Double actual = 0.0;
	private Double anterior = 0.0;

	public Cotizacion() {

	}

	public Cotizacion(String ciclo, Double anterior) {
		this.ciclo = ciclo;
		this.anterior = anterior;

	}

	public Cotizacion(String ciclo, Double anterior, Double actual) {
		this.ciclo = ciclo;
		this.actual = actual;
		this.anterior = anterior;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getEvalua() {
		return evalua;
	}

	public void setEvalua() {
		String evalua = "";
		if (this.actual != 0.0) {
			if (this.anterior < this.actual) {
				evalua = "Mayor";
			} else if (this.anterior > this.actual) {
				evalua = "Menor";
			} else {
				evalua = "Igual";
			}
		} else {
			evalua = "NO COTIZA";
		}
		this.evalua = evalua;
	}

	public Double getActual() {
		return actual;
	}

	public void setActual(Double actual) {
		this.actual = actual;
	}

	public Double getAnterior() {
		return anterior;
	}

	public void setAnterior(Double anterior) {
		this.anterior = anterior;
	}

}
