package Ejemplo2.modelo;

import java.util.Objects;

public class Mascota {
    private Integer id;
    private String NombreMascota;
    private String Raza;
    private static int ultimoId;

    public Mascota() {
        this.id = ++ultimoId;
    }

    public Mascota(String nombreMascota, String raza) {
        this();
        NombreMascota = nombreMascota;
        Raza = raza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        NombreMascota = nombreMascota;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        Raza = raza;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", NombreMascota='" + NombreMascota + '\'' +
                ", Raza='" + Raza + '\'' +
                '}';
    }
}
