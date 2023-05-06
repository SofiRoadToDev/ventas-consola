
package com.besysoft.ventas.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    
    
    private LocalDateTime fecha;
    
    private Vendedor vendedor;
    
    private double comisionVendedor=0;

    private double importe=0;
    
    List<DetalleVenta>productos=new ArrayList();
    
    public void calcularImporteYComision(){
       int cantidadProductos=productos.stream().map(d->d.getCantidad()).reduce(0,(a,b)->a+b);
        System.out.println("Cantidad productos: "+cantidadProductos);
       productos.forEach(d -> {
            this.importe+=d.getCantidad()*d.getProducto().getPrecio();
        });

        if(cantidadProductos>0 && cantidadProductos<=2){
            this.comisionVendedor=importe*0.05;

        }else if(cantidadProductos>2){
           comisionVendedor=importe*0.1;
        }
       // System.out.println("importe: "+importe+" comision: "+comisionVendedor);
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
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
                "\nfecha= " + DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(fecha).toString() +
                ", \nvendedor= " + vendedor.getNombre() +
                ", \ncomisionVendedor= " + comisionVendedor +
                ", \nimporte= " + importe +
                ", \ncantidad de productos= " + productos.size() +
                '}';
    }
}
