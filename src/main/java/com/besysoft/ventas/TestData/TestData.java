
package com.besysoft.ventas.TestData;

import java.util.ArrayList;
import java.util.List;
import com.besysoft.ventas.modelos.Producto;
import com.besysoft.ventas.modelos.Vendedor;
import com.besysoft.ventas.modelos.Venta;

public class TestData {
    
  private static List<Producto>productos=new ArrayList<>();
  private static  List<Vendedor>vendedores=new ArrayList<>();
  private static List<Venta>ventas=new ArrayList<>();



  public static List<Producto>getProductos(){
      return productos;
  }

  public static void agregarProducto(Producto p){
      productos.add(p);
  }

  public static void agregarVenta(Venta venta){
      ventas.add(venta);
  }

  public static void agregarVendedor(Vendedor v){
      vendedores.add(v);
  }
    
}
