package com.besysoft.ventas.utils;

import com.besysoft.ventas.exceptions.ProductNotFoundException;
import com.besysoft.ventas.modelos.Producto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductFilters {



    public static List<Producto>filtrarPorCategoria(String categoria, List<Producto> lista)throws ProductNotFoundException{
        List<Producto>prods= lista.stream()
                .filter(p->p.getCategoría().toString().equals(categoria.toUpperCase()))
                .collect(Collectors.toList());
        if(prods.size()>0){
            return prods;
        }else{
            throw new ProductNotFoundException("No hay productos concidentes con esa categoria");
        }
    }

    public static Producto filtrarPorCodigo(String codigo, List<Producto> lista)throws ProductNotFoundException{

        List<Producto>pros=lista.stream().filter(p->p.getCodigo().equals(codigo.toUpperCase())).collect(Collectors.toList());
        if(pros.size()>0){
            return lista.stream().filter(p->p.getCodigo().equals(codigo.toUpperCase())).collect(Collectors.toList()).get(0);
        }else{
            throw new ProductNotFoundException("producto no encontrado");
        }
    }

    public static List<Producto>filtrarPorRangoPrecio(Double desde,Double hasta, List<Producto> lista){

        List<Producto>prods=lista.stream()
                .filter(p->p.getPrecio()>=desde && p.getPrecio()<=hasta)
                .collect(Collectors.toList());
        if(prods.size()>0){
            return prods;
        }else{
            throw new ProductNotFoundException("No hay productos en ese rango de precios");
        }

    }

    public static Producto filtrarPorNombre(String nombre, List<Producto> lista)throws ProductNotFoundException {
       List<Producto> pro=lista.stream().filter(p->p.getNombre().equals(nombre.toLowerCase())).collect(Collectors.toList());
            if(pro.size()>0){
                return pro.get(0);
            }else {
                throw new ProductNotFoundException("producto no encontrado");
            }
        }
    }

