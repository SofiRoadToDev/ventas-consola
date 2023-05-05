
package com.besysoft.ventas.modelos;

public class Producto {
    
    private String codigo;
    
    private String nombre;
    
    private Categorias categoría;
    
    private double precio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categorias getCategoría() {
        return categoría;
    }

    public void setCategoría(Categorias categoría) {
        this.categoría = categoría;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    @Override
    public boolean equals(Object p) {
        if(this==p)return true;
        if(p==null|| this.getClass() != p.getClass())return false;
        Producto pro= (Producto) p;
        return this.nombre.equals(((Producto) p).nombre);
    }
}
