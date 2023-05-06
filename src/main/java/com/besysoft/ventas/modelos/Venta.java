
package com.besysoft.ventas.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    
    
    private LocalDate fecha;
    
    private Vendedor vendedor;
    
    private double comisionVendedor=0;

    private double importe=0;
    
    List<DetalleVenta>productos=new ArrayList();
    
    public void calcularImporteYComision(){
        //Revisar que el detalle puede tener mas de un producto sin cambiar el tamaño del arreglo
       productos.forEach(d -> {
            this.importe+=d.getCantidad()*d.getProducto().getPrecio();
        });
        if(productos.size()>0 && productos.size()<=2){
            this.comisionVendedor=importe*0.05;

        }else if(productos.size()>2){
           comisionVendedor=importe*0.1;
        }
       // System.out.println("importe: "+importe+" comision: "+comisionVendedor);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getComisionVendedor() {
        return comisionVendedor;
    }

    public void setComisionVendedor(double comisionVendedor) {
        this.comisionVendedor = comisionVendedor;
    }

    public List<DetalleVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<DetalleVenta> productos) {
        this.productos = productos;
    }

    @Override
    public String toString()  {
        return "Venta{" +
                "\nfecha= " + fecha +
                ", \nvendedor= " + vendedor +
                ", \ncomisionVendedor= " + comisionVendedor +
                ", \nimporte= " + importe +
                ", \ncantidad de productos= " + productos.size() +
                '}';
    }
}
