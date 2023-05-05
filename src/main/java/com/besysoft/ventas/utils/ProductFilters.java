package com.besysoft.ventas.utils;

import com.besysoft.ventas.modelos.Producto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilters {



    public static List<Producto>filtrarPorCategoria(String categoria, List<Producto> lista){
        return lista.stream()
                .filter(p->p.getCategoría().equals(categoria.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Producto>filtrarPorCodigo(String codigo, List<Producto> lista){
        return lista.stream()
                .filter(p->p.getCodigo().equals(codigo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Producto>filtrarPorRangoPrecio(Double desde,Double hasta, List<Producto> lista){
        return lista.stream()
                .filter(p->p.getPrecio()>=desde && p.getPrecio()<=hasta)
                .collect(Collectors.toList());
    }

    public static List<Producto>filtrarPorNombre(String nombre, List<Producto> lista){
        return lista.stream()
                .filter(p->p.getNombre().equals(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
}
