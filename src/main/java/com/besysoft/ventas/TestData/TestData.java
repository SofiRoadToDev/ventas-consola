
package com.besysoft.ventas.TestData;

import java.util.ArrayList;
import java.util.List;

import com.besysoft.ventas.exceptions.AlreadyStoredObjectException;
import com.besysoft.ventas.modelos.Categorias;
import com.besysoft.ventas.modelos.Producto;
import com.besysoft.ventas.modelos.Vendedor;
import com.besysoft.ventas.modelos.Venta;

public class TestData {
    
  private static List<Producto>productos=new ArrayList<>();
  private static  List<Vendedor>vendedores=new ArrayList<>();
  private static List<Venta>ventas=new ArrayList<>();






  public static void initData(){
      Producto p=new Producto();
      p.setCategoría(Categorias.LACTEOS);
      p.setCodigo("L1");
      p.setNombre("yogurt");
      p.setPrecio(250.00);

      Producto p2=new Producto();
      p2.setCategoría(Categorias.LACTEOS);
      p2.setCodigo("L2");
      p2.setNombre("queso");
      p2.setPrecio(600.00);

      Producto p3=new Producto();
      p.setCategoría(Categorias.ROPA);
      p.setCodigo("R1");
      p.setNombre("remera");
      p.setPrecio(5000.00);

      Producto p4=new Producto();
      p.setCategoría(Categorias.ROPA);
      p.setCodigo("R2");
      p.setNombre("pantalon");
      p.setPrecio(8000.00);

      productos.add(p);
      productos.add(p2);
      productos.add(p3);
      productos.add(p4);


      Vendedor v=new Vendedor();
      v.setCodigo("v1");
      v.setNombre("Juan");
      v.setSueldo(100000);

      Vendedor v2=new Vendedor();
      v.setCodigo("v2");
      v.setNombre("Mariana");
      v.setSueldo(150000);

      vendedores.add(v);
      vendedores.add(v2);
  }



  public static List<Producto>getProductos(){
      return productos;
  }

  public static void agregarProducto(Producto p) throws AlreadyStoredObjectException{
      if (productos.contains(p)) {
          throw new AlreadyStoredObjectException(String.format(" El producto %s ya existe",p.getNombre()));
      }else{
          System.out.println(productos.contains(p));
      productos.add(p);}
  }

  public static void agregarVenta(Venta venta){
      ventas.add(venta);
  }

  public static void agregarVendedor(Vendedor v){
      vendedores.add(v);
  }
    
}
