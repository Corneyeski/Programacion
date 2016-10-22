package presupuesto;

/**
 * Created by Alan on 13/10/2016.
 */
public class Presupuesto {
    private Integer num;
    private String concepto;
    private Double precio_neto;
    private String estado;

    public Presupuesto(){}

    public Presupuesto(Integer num, String concepto, Double precio_neto) {
        this.num = num;
        this.concepto = concepto;
        this.precio_neto = precio_neto;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getPrecio_neto() {
        return precio_neto;
    }

    public void setPrecio_neto(Double precio_neto) {
        this.precio_neto = precio_neto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPresupuestoDescuento(Integer precio_neto){



        return precio_neto;
    }
    public Integer getPrecioIva(Integer getPresupuestoDescuento){

        Integer iva = getPresupuestoDescuento / 21;


        return getPresupuestoDescuento + 21;
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "num=" + num +
                ", concepto='" + concepto + '\'' +
                ", precio_neto=" + precio_neto +
                ", estado='" + estado + '\'' +
                '}';
    }
}
