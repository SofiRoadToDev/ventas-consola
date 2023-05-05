
package com.besysoft.ventas;

import java.util.Arrays;
import java.util.Scanner;

import com.besysoft.ventas.TestData.TestData;
import com.besysoft.ventas.exceptions.AlreadyStoredObjectException;
import com.besysoft.ventas.modelos.Categorias;
import com.besysoft.ventas.modelos.Producto;
import com.besysoft.ventas.modelos.Vendedor;
import com.besysoft.ventas.utils.ProductFilters;


public class Ventas {
    
    static Scanner sc= new Scanner(System.in);
    static int salida=-1;

    public static void main(String[] args) {

        TestData.initData();
        
            do{
                mainMenu();
            }while(salida!=0);
            sc.close();
          
    }
    
    
    
    public static void mainMenu(){
        Scanner sc=new Scanner(System.in);
        int mainMenuOption=-1;
          System.out.println("Que desea hacer? "
                  + "\n 1. Agregar producto "
                  + "\n 2. Agregar Vendedor"
                  + " \n 3. Agregar Venta "
                  + "\n 4.Buscar Producto "
                  + "\n 5.Salir");
          
       mainMenuOption=sc.nextInt();
        
        switch(mainMenuOption){
            case 1:
                addProducto();
                break;
            case 5:
                sc.close();
                salida=0;
               
        }
    }
    
    
    public static void addProducto(){
        Producto p=new Producto();
        Scanner sc=new Scanner(System.in);

        System.out.println("Ingrese el codigo del producto: ");   
        p.setCodigo(sc.nextLine().toLowerCase());
        
        System.out.println("Ingrese el nombre del producto: ");        
        p.setNombre(sc.nextLine().toLowerCase());
        
        System.out.println("Ingrese el precio del producto: ");
        p.setPrecio(sc.nextDouble());
        sc.nextLine();
        
        System.out.println("Ingrese la categoria del producto: ");
       for(int i=0;i<Categorias.values().length;i++){
           System.out.println(String.format("%s. %S",i,Categorias.values()[i]));
       }
        int cat=sc.nextInt();
        p.setCategoría(Categorias.values()[cat]);
        
        System.out.println("Desea guardar el producto? y/n");

        if(sc.nextLine().toLowerCase().equals("y")){
            try{
                TestData.agregarProducto(p);
                System.out.println("producto guardado");

            }catch(AlreadyStoredObjectException e){
                System.out.println(e);
            }

        }else{
            sc.close();
            mainMenu();
        }
        
    }

    public static void elegirCategoria(){

    }

    public static void addVendedor(){
        Vendedor v=new Vendedor();
        Scanner sc=new Scanner(System.in);

        System.out.println("Ingrese el codigo del vendedor: ");
        v.setCodigo(sc.nextLine().toLowerCase());

        System.out.println("Ingrese el nombre del vendedor: ");
        v.setNombre(sc.nextLine());

        System.out.println("Ingrese el sueldo base del vendedor: ");
        v.setSueldo(sc.nextDouble());
        sc.nextLine();

        System.out.println("Desea guardar el vendedor? y/n");
        if(sc.nextLine().toLowerCase().equals("y")){
            TestData.agregarVendedor(v);
            System.out.println("vendedor guardado");
        }else{
            mainMenu();
        }

    }

    public static void buscarProducto(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Desea buscar un producto por:" +
                "\n 1.codigo " +
                "\n 2.nombre " +
                "\n 3.Categoria " +
                "\n 4.rango de precios " +
                "\n 5.Menu Principal");

        int option=sc.nextInt();
        switch(option){
            case 1:
                System.out.println("Ingrese el codigo del producto");
                String codigo=sc.nextLine();
                ProductFilters.filtrarPorCodigo(codigo,TestData.getProductos()).forEach(p-> System.out.println(p.getNombre()));
                innerFilterMenu(sc);
                break;
            case 2:
                System.out.println("Ingrese el nombre del prroducto");
                String nombre=sc.nextLine();
                ProductFilters.filtrarPorNombre(nombre,TestData.getProductos()).forEach(p-> System.out.println(p.getNombre()));
                innerFilterMenu(sc);
                break;
            case 3:
                System.out.println("Ingrese el nombre de la categoria");
                String categoria=sc.nextLine();
                ProductFilters.filtrarPorCategoria(categoria,TestData.getProductos()).forEach(p-> System.out.println(p.getNombre()));
                innerFilterMenu(sc);
                break;
            case 4:
                System.out.println("Ingrese desde que monto buscar");
                double desde=sc.nextDouble();
                System.out.println("Ingrese hasta que precio buscar");
                double hasta=sc.nextDouble();
                ProductFilters.filtrarPorRangoPrecio(desde,hasta,TestData.getProductos()).forEach(p-> System.out.println(p.getNombre()));
                innerFilterMenu(sc);
                break;
            case 5:
                sc.close();
                mainMenu();
                break;
        }

    }

    public static void innerFilterMenu(Scanner sc){

        System.out.println("Desea buscar productos con otro filtro? y/n");
        String op=sc.nextLine().toLowerCase();
        if(op.equals("y")){
            sc.close();
            buscarProducto();
        }else{
            sc.close();
            mainMenu();
        }


    }



}
