package cine;

public class pelicula {

    private String codigo;
    private String titulo;
    private String director;
    private int duracion;
    private String genero;
    private double valoracion;
    private boolean visto;

    public pelicula() {}

    public pelicula(String codigo, String titulo, String director, int duracion, String genero, double valoracion, boolean visto) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.valoracion = valoracion;
        this.visto = visto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public double getValoracion() {
        return valoracion;
    }

    public boolean getVisto() {
        return visto;
    }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    @Override
    public String toString() {
       /* return "pelicula{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", duracion=" + duracion +
                ", genero='" + genero + '\'' +
                ", valoracion=" + valoracion +
                ", visto=" + visto +
                '}'; */
       String texto = "codigo='" + codigo + '\'' +", titulo='" + titulo + '\'' + ", director='" + director + '\'' + ", duracion=" + duracion + ", genero='" + genero + '\'' + ", valoracion=" + valoracion;
        return texto += visto ? "VISTA" : "POR VER";
    }
}
