package crud.co.com.clientecrud.util;

public class ItemLista {

    private int idImage;
    private String id;
    private String nombre;
    private String apellido;

    public ItemLista(int idImage, String id, String nombre, String apellido) {
        this.idImage = idImage;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
