package com.besysoft.ventas.negocio;

import com.besysoft.ventas.TestData.TestData;
import com.besysoft.ventas.exceptions.AlreadyStoredObjectException;
import com.besysoft.ventas.exceptions.ProductNotFoundException;
import com.besysoft.ventas.modelos.*;
import com.besysoft.ventas.utils.ProductFilters;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenusLogicMethods {

    public static int salida=-1;
    public static Scanner sc= new Scanner(System.in);
    public static void mainMenu(){
        Scanner sc=new Scanner(System.in);
        int mainMenuOption=-1;
        System.out.println("Que desea hacer? "
                + "\n 1. Agregar producto "
                + "\n 2. Agregar Vendedor"
                + " \n 3. Agregar Venta "
                + "\n 4.Buscar Producto "
                + "\n 5.ver ventas"
                +"\n 6.salir");

        mainMenuOption=sc.nextInt();

        switch(mainMenuOption){
            case 1:
                addProducto();
                break;
            case 2:
                addVendedor();
                break;
            case 3:
                agregarVenta();
                break;
            case 4:
                buscarProducto();
                break;
            case 5:
                consultarVentas();
                break;
            case 6:
                salida=0;
                break;
            default:
                System.out.println("Ingrese una opción válida");
        }
    }




    public static void consultarVentas(){
        TestData.getVentas().forEach(v-> System.out.println(v.toString()+"\n"));
        System.out.println(" volver atras y/n?");
        if(sc.nextLine().toLowerCase().equals("y")){
            mainMenu();
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
        for(int i = 0; i< Categorias.values().length; i++){
            System.out.println(String.format("%s. %S",i,Categorias.values()[i]));
        }
        int cat=sc.nextInt();
        p.setCategoria(Categorias.values()[cat]);
        sc.nextLine();

        System.out.println("Desea guardar el producto? y/n");

        if(sc.nextLine().toLowerCase().equals("y")){
            try{
                TestData.agregarProducto(p);
                System.out.println("producto guardado");

            }catch(AlreadyStoredObjectException e){
                System.out.println(e);
            }

        }else{
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
        sc.nextLine();
        try{
            switch(option){
                case 1:
                    System.out.println("Ingrese el codigo del producto");
                    String codigo=sc.nextLine();
                    System.out.println(ProductFilters.filtrarPorCodigo(codigo,TestData.getProductos()));
                    innerFilterMenu(sc);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del prroducto");
                    String nombre=sc.nextLine();
                    System.out.println(ProductFilters.filtrarPorNombre(nombre,TestData.getProductos()).toString());
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
                    sc.nextLine();
                    System.out.println("Ingrese hasta que precio buscar");
                    double hasta=sc.nextDouble();
                    sc.nextLine();
                    ProductFilters.filtrarPorRangoPrecio(desde,hasta,TestData.getProductos()).forEach(p-> System.out.println(p.getNombre()));
                    innerFilterMenu(sc);
                    break;

                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida");
                    break;
            }}catch(ProductNotFoundException e){
            System.out.println(e);
        }

    }

    public static void innerFilterMenu(Scanner sc){

        System.out.println("Desea buscar productos con otro filtro? y/n");
        String op=sc.nextLine().toLowerCase();
        if(op.equals("y")){
            buscarProducto();
        }else{
            mainMenu();
        }


    }

    public static void agregarProductosAVenta(List<DetalleVenta> dv, Scanner sc){
        int stop=-1;

        while(stop!=0){

            System.out.println("Elija un producto ");
            for (int i=0;i<TestData.getProductos().size();i++){
                System.out.println(i+". "+TestData.getProductos().get(i).getNombre()+ " c/u $"+TestData.getProductos().get(i).getPrecio());
            }
            int op=sc.nextInt();
            sc.nextLine();

            System.out.println("Elija la cantidad a comprar");
            int cantidad=sc.nextInt();
            sc.nextLine();

            dv.add(new DetalleVenta(TestData.getProductos().get(op),cantidad));

            System.out.println("desea agregar mas productos? y/n");
            stop=sc.nextLine().toLowerCase().equals("y")?-1:0;
        }


    }

    public static void agregarVenta(){
        Venta venta=new Venta();
        List<DetalleVenta> dv=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        agregarProductosAVenta(dv,sc);
        System.out.println("Confirma los productos agregados? y/n");
        dv.forEach(d-> System.out.println(d.getProducto()+" cant: "+d.getCantidad()+" total: $"+d.getProducto().getPrecio()*d.getCantidad()));
        if(sc.nextLine().toLowerCase().equals("y")){
            venta.setProductos(dv);
        }else{
            dv.clear();
            agregarProductosAVenta(dv,sc);
        }

        System.out.println("Elija el vendedor que realizo la venta");
        for (int i=0;i<TestData.getVendedores().size();i++){
            System.out.println(i+". "+TestData.getVendedores().get(i).getNombre());
        }
        int selectedV=sc.nextInt();
        sc.nextLine();
        Vendedor v=TestData.getVendedores().get(selectedV);
        venta.setVendedor(v);
        venta.setFecha(LocalDateTime.now());
        venta.calcularImporteYComision();
        System.out.println("comision : "+venta.getComisionVendedor());

        System.out.println("Desea confirmar la venta y/n?");
        if(sc.nextLine().toLowerCase().equals("y")){
            TestData.agregarVenta(venta);
            System.out.println(TestData.getVentas().size());
        }else{
            mainMenu();
        }
    }


}
