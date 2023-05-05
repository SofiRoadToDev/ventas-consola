
package com.besysoft.ventas.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    
    
    private LocalDate fecha;
    
    private Vendedor vendedor;
    
    private double comisionVendedor=0;
    
    List<DetalleVenta>productos=new ArrayList();
    
    public void calcularComision(){
    
        if(productos.size()>0 && productos.size()<3){
            
            productos.forEach(d -> {
                comisionVendedor+=d.getCantidad()*d.getProducto().getPrecio()*0.05;
            });
        }else if(productos.size()>2){
        
            productos.forEach(d->comisionVendedor+=d.getCantidad()*d.getProducto().getPrecio()*0.1);
        }
    }
    
}
