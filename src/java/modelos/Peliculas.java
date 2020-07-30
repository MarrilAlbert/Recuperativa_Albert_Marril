
package modelos;

public class Peliculas {

    public Peliculas() {
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Peliculas(long codigo, String nombre, int duracion, String idioma, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;
        this.idioma = idioma;
        this.categoria = categoria;
    }

 
    private long codigo;
    private String nombre;
    private int duracion;
    private String idioma;
    private Categoria categoria;

  
}

  