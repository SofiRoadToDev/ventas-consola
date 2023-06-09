
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
      p.setCategoria(Categorias.LACTEOS);
      p.setCodigo("L1");
      p.setNombre("yogurt");
      p.setPrecio(250.00);

      Producto p2=new Producto();
      p2.setCategoria(Categorias.LACTEOS);
      p2.setCodigo("L2");
      p2.setNombre("queso");
      p2.setPrecio(600.00);

      Producto p3=new Producto();
      p3.setCategoria(Categorias.ROPA);
      p3.setCodigo("R1");
      p3.setNombre("remera");
      p3.setPrecio(5000.00);

      Producto p4=new Producto();
      p4.setCategoria(Categorias.ROPA);
      p4.setCodigo("R2");
      p4.setNombre("pantalon");
      p4.setPrecio(8000.00);

      productos.add(p);
      productos.add(p2);
      productos.add(p3);
      productos.add(p4);


      Vendedor v=new Vendedor();
      v.setCodigo("v1");
      v.setNombre("Juan");
      v.setSueldo(100000);

      Vendedor v2=new Vendedor();
      v2.setCodigo("v2");
      v2.setNombre("Mariana");
      v2.setSueldo(150000);

      vendedores.add(v);
      vendedores.add(v2);
  }



  public static List<Producto>getProductos(){
      return productos;
  }

  public static void agregarProducto(Producto p) throws AlreadyStoredObjectException{
      if (productos.contains(p)) {
          System.out.println(String.format("resultado de contains %s",productos.contains(p)));
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

  public static List<Vendedor>getVendedores(){
      return vendedores;
  }

  public static List<Venta> getVentas(){
      return ventas;
    }
    
}
