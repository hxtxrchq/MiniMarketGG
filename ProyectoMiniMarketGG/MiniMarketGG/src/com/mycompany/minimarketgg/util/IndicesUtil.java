package com.mycompany.minimarketgg.util;

import java.util.HashMap;
import java.util.Map;

public class IndicesUtil {
    public static final Map<String, Integer> productoIndices = new HashMap<>();
    public static final Map<String, Integer> proveedorIndices = new HashMap<>();
    public static final Map<String, Integer> categoriaIndices = new HashMap<>();
    public static final Map<String, Integer> pedidoIndices = new HashMap<>();
    public static final Map<String, Integer> prodpedIndices = new HashMap<>();
    // Si existen más tablas, agregar nuevos mapas para Indices.

    static {
        // Configuración para la tabla de productos
        productoIndices.put("ITEMID", 0);        // > id prod
        productoIndices.put("NOMBRE", 1);        // > nombre prod
        productoIndices.put("CATEGORIA", 2);     // > id catg
        productoIndices.put("PROVEEDOR", 3);     // > id prov
        productoIndices.put("PRECIO", 4);        // > prc prod
        productoIndices.put("STOCK", 5);         // > stck prod
        productoIndices.put("DESCRIPCION", 6);   // > dscrp prod

        // Configuración para la tabla de proveedores
        proveedorIndices.put("ID_PROVEEDOR", 0); // > id prov
        proveedorIndices.put("NOMBRE", 1);       // > nombre prov
        proveedorIndices.put("TELEFONO", 2);     // > tlf prov
        proveedorIndices.put("CORREO", 3);       // > correo prov
        
        // Configuración para la tabla de categorias
        categoriaIndices.put("ID_CATEGORIA", 0); // > id cat
        categoriaIndices.put("NOMBRE", 1);       // > nombre cat
        categoriaIndices.put("DESCRIPCION", 2);  // > dscrp cat
        
        // Configuración para la tabla de pedidos
        pedidoIndices.put("PEDIDOID", 0);        // > id ped
        pedidoIndices.put("FECHA_PEDIDO", 1);    // > date ped
        pedidoIndices.put("PROVEEDOR", 2);       // > id prov
        pedidoIndices.put("TOTAL_PED", 3);       // > total ped
        pedidoIndices.put("INFORMATION", 4);     // > info icon ped
        
        // Configuración para la tabla de productos-pedidos (tabla secundaria)
        prodpedIndices.put("PRODUCTO", 0);       // > nombre prod
        prodpedIndices.put("PEDIDOID", 1);       // > id ped
        prodpedIndices.put("CANTIDAD", 2);       // > cant prodped
        prodpedIndices.put("PRECIO_UNI", 3);     // > prc prodped
        prodpedIndices.put("TOTAL_PROD", 4);     // > total prodped
    }
}