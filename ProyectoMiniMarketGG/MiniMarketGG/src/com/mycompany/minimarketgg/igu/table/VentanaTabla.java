package com.mycompany.minimarketgg.igu.table;

import java.awt.BorderLayout;
import java.util.Date;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.mycompany.minimarketgg.igu.pedidos.prodped.ProductoPed;
import com.mycompany.minimarketgg.logica.Categoria;
import com.mycompany.minimarketgg.logica.CategoriaDao;
import com.mycompany.minimarketgg.logica.Pedido;
import com.mycompany.minimarketgg.logica.PedidoDao;
import com.mycompany.minimarketgg.logica.Producto;
import com.mycompany.minimarketgg.logica.ProductoDao;
import com.mycompany.minimarketgg.logica.ProductoPedido;
import com.mycompany.minimarketgg.logica.ProductoPedidoDao;
import com.mycompany.minimarketgg.logica.Proveedor;
import com.mycompany.minimarketgg.logica.ProveedorDao;
import com.mycompany.minimarketgg.util.GestionCeldas;
import com.mycompany.minimarketgg.util.GestionEncabezadoTabla;
import com.mycompany.minimarketgg.util.IndicesUtil;
import com.mycompany.minimarketgg.util.ModeloTabla;

/*
    Existiran diferentes tipos de tabla para abordar en todo el proyecto, cada tabla tiene un indice indicado por n_tabla:
    
    1 = Tabla de Productos / inventario
    2 = Tabla de Proveedores / btnProveedores
    3 = Tabla de Categorias / btnCategorias
    4 = Tabla de Pedidos / btnPedidos

*/

//Para crear una categoria, crear obtenerMatrizDatosX(), luego crear case en crearTabla(), y finalmente crear case en configurarComparadoresPorTipoTabla()

public class VentanaTabla extends JPanel implements MouseListener {

    private JPanel contentPane;
    private JScrollPane scrollPaneTabla;
    private JTable tablaP;
    private int id_pedido = -1;
    ModeloTabla modelo;

    public VentanaTabla(int n_tabla, int id_pedido) {
        this.id_pedido = id_pedido;
        iniciarComponentes();
        construirTabla(n_tabla);
        configurarTamañoVentana(n_tabla);
    }

    public VentanaTabla(int n_tabla, ArrayList<Producto> productos) {
        iniciarComponentes();
        construirTablaConProductos(productos);
        configurarTamañoVentana(n_tabla);
    }

    private void configurarTamañoVentana(int n_tabla) {
        switch (n_tabla) {
            case 1:
                setSize(1121, 670);
                break;
            case 2:
                setSize(880, 490);
                break;
            case 3:
                setSize(600, 490);
                break;
            case 4:
                setSize(800, 490);
                break;
            case 5:
                setSize(800, 490);
                break;
            default:
                setSize(800, 600);
                break;
        }
    }
        
	private void iniciarComponentes() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout());
                add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPaneTabla = new JScrollPane();
		contentPane.add(scrollPaneTabla);
		
		tablaP = new JTable();
		tablaP.setBackground(Color.WHITE);
		tablaP.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
                
		//tablaSeguimiento.addKeyListener(this);
		tablaP.setOpaque(false);
                tablaP.addMouseListener(this);
		scrollPaneTabla.setViewportView(tablaP);
	}
        
	/**
	 * Metodo que permite construir la tabla de personas
	 * se crean primero las columnas y luego se asigna la información
	 */
        
	private void construirTabla(int n_tabla) {
        ArrayList<String> titulosList = new ArrayList<>();
        Object[][] data;
        
        switch (n_tabla) {
            case 1: // Tabla de Productos
                ProductoDao prddao = new ProductoDao();
                CategoriaDao prdcatDao = new CategoriaDao();
                ProveedorDao prdprovDao = new ProveedorDao();
                ArrayList<Producto> listaProductos = prddao.obtenerProductos();
                titulosList.addAll(Arrays.asList("ItemID", "Nombre", "Categoría", "Proveedor", "Precio", "Stock", "Descripción"));
                data = obtenerMatrizDatosProductos(listaProductos, prdcatDao, prdprovDao);
                construirTablaAvanzada(n_tabla, titulosList.toArray(new String[0]), data);
                break;

            case 2: // Tabla de Proveedor
                ProveedorDao provDao = new ProveedorDao();
                ArrayList<Proveedor> listaProveedores = provDao.obtenerProveedores();
                titulosList.addAll(Arrays.asList("ID Proveedor", "Nombre", "Teléfono", "Correo"));
                data = obtenerMatrizDatosProveedores(listaProveedores);
                construirTablaAvanzada(n_tabla, titulosList.toArray(new String[0]), data);
                break;

            case 3: // Tabla de Categoria
                CategoriaDao categoriaDao = new CategoriaDao();
                ArrayList<Categoria> listaCategorias = categoriaDao.obtenerCategorias();
                titulosList.addAll(Arrays.asList("ID Categoria", "Nombre", "Descripción"));
                data = obtenerMatrizDatosCategorias(listaCategorias);
                construirTablaAvanzada(n_tabla, titulosList.toArray(new String[0]), data);
                break;

            case 4: // Tabla de Pedido
                PedidoDao pedDao = new PedidoDao();
                ProveedorDao proavDao = new ProveedorDao();
                ArrayList<Pedido> listaPedidos = pedDao.obtenerPedidos();
                titulosList.addAll(Arrays.asList("ID Pedido", "Fecha de Pedido", "Proveedor", "Total Pedido", "Orden"));
                data = obtenerMatrizDatosPedidos(listaPedidos, proavDao);
                construirTablaAvanzada(n_tabla, titulosList.toArray(new String[0]), data);
                if (tablaP.getColumnCount() > IndicesUtil.pedidoIndices.get("INFORMATION")) {
                    tablaP.getColumnModel().getColumn(IndicesUtil.pedidoIndices.get("INFORMATION")).setCellRenderer(new GestionCeldas("icono"));
                }
                break;

            case 5: // Tabla de Producto Pedido
                ProductoPedidoDao productoPedidoDao = new ProductoPedidoDao();
                ProductoDao productodao = new ProductoDao();
                ArrayList<ProductoPedido> listaProductoPedido = productoPedidoDao.obtenerProductosPedido(this.id_pedido);
                titulosList.addAll(Arrays.asList("Nombre Producto", "ID Pedido", "Cantidad", "Precio Unitario", "Precio Total"));
                data = obtenerMatrizDatosProductoPedido(listaProductoPedido, productodao);
                construirTablaAvanzada(n_tabla, titulosList.toArray(new String[0]), data);
                break;
            
            default:
                throw new IllegalArgumentException("Tipo de tabla no soportado!!");
            }
        }
        
        private void abrirVentanaProductoPedido(int idPedido) {
            ProductoPed ventanaProductoPedido = new ProductoPed(idPedido);
            ventanaProductoPedido.setVisible(true);
            ventanaProductoPedido.setLocationRelativeTo(null);  // Centra la ventana
        }

        private Object[][] obtenerMatrizDatosProductos(ArrayList<Producto> listaProductos, CategoriaDao categoriaDao, ProveedorDao proveedorDao) {
            Object[][] informacion = new Object[listaProductos.size()][7]; // Asumiendo 7 campos como antes
                for (int i = 0; i < listaProductos.size(); i++) {
                    Producto producto = listaProductos.get(i);
                    Categoria categoria = categoriaDao.obtenerCategoriaPorId(producto.getIdCategoria());
                    Proveedor proveedor = proveedorDao.obtenerProveedorPorId(producto.getIdProveedor());
                    informacion[i][IndicesUtil.productoIndices.get("ITEMID")] = producto.getIdProducto(); // ID del producto
                    informacion[i][IndicesUtil.productoIndices.get("NOMBRE")] = producto.getNombre(); // Nombre del producto
                    informacion[i][IndicesUtil.productoIndices.get("CATEGORIA")] = categoria != null ? categoria.getNombre() : "No especificada"; // Nombre de la categoría
                    informacion[i][IndicesUtil.productoIndices.get("PROVEEDOR")] = proveedor != null ? proveedor.getNombre() : "No especificado"; // Nombre del proveedor
                    informacion[i][IndicesUtil.productoIndices.get("PRECIO")] = String.format("%.2f", producto.getPrecio()); // Precio formateado
                    informacion[i][IndicesUtil.productoIndices.get("STOCK")] = producto.getStock(); // Stock
                    informacion[i][IndicesUtil.productoIndices.get("DESCRIPCION")] = producto.getDescripcion(); // Descripción
                }
            return informacion;
        }
        
        private Object[][] obtenerMatrizDatosProveedores(ArrayList<Proveedor> listaProveedores) {
            Object[][] informacion = new Object[listaProveedores.size()][IndicesUtil.proveedorIndices.size()];
                for (int i = 0; i < listaProveedores.size(); i++) {
                    Proveedor p = listaProveedores.get(i);
                    informacion[i][IndicesUtil.proveedorIndices.get("ID_PROVEEDOR")] = p.getId();
                    informacion[i][IndicesUtil.proveedorIndices.get("NOMBRE")] = p.getNombre();
                    informacion[i][IndicesUtil.proveedorIndices.get("TELEFONO")] = p.getTelefono();
                    informacion[i][IndicesUtil.proveedorIndices.get("CORREO")] = p.getCorreo();
                }
            return informacion;
        }
        
        private Object[][] obtenerMatrizDatosCategorias(ArrayList<Categoria> listaCategorias) {
            Object[][] informacion = new Object[listaCategorias.size()][IndicesUtil.categoriaIndices.size()];
                for (int i = 0; i < listaCategorias.size(); i++) {
                    Categoria cat = listaCategorias.get(i);
                    informacion[i][IndicesUtil.categoriaIndices.get("ID_CATEGORIA")] = cat.getId();
                    informacion[i][IndicesUtil.categoriaIndices.get("NOMBRE")] = cat.getNombre();
                    informacion[i][IndicesUtil.categoriaIndices.get("DESCRIPCION")] = cat.getDescripcion();
                }
            return informacion;
        }
        
        private Object[][] obtenerMatrizDatosPedidos(ArrayList<Pedido> listaPedidos, ProveedorDao proveedorDao) {
            Object[][] informacion = new Object[listaPedidos.size()][IndicesUtil.pedidoIndices.size()];
                for (int i = 0; i < listaPedidos.size(); i++) {
                    Pedido ped = listaPedidos.get(i);
                    Proveedor proveedor = proveedorDao.obtenerProveedorPorId(ped.getIdProveedor());
                    String nombreProveedor = (proveedor != null) ? proveedor.getNombre() : "Proveedor desconocido"; // Maneja proveedores no encontrados
                    informacion[i][IndicesUtil.pedidoIndices.get("PEDIDOID")] = ped.getId();
                    informacion[i][IndicesUtil.pedidoIndices.get("FECHA_PEDIDO")] = ped.getFechaPedido();
                    informacion[i][IndicesUtil.pedidoIndices.get("PROVEEDOR")] = nombreProveedor;
                    informacion[i][IndicesUtil.pedidoIndices.get("TOTAL_PED")] = ped.getTotalPedido();
                    informacion[i][IndicesUtil.pedidoIndices.get("INFORMATION")] = "INFO";
                }
            return informacion;
        }
        
        private Object[][] obtenerMatrizDatosProductoPedido(ArrayList<ProductoPedido> listaProductoPedido, ProductoDao productoDao) {
            Object[][] informacion = new Object[listaProductoPedido.size()][IndicesUtil.prodpedIndices.size()];
                for (int i = 0; i < listaProductoPedido.size(); i++) {
                    ProductoPedido pp = listaProductoPedido.get(i);
                    Producto producto = productoDao.obtenerProductoPorId(pp.getIdProducto());
                    String nombreProducto = (producto != null) ? producto.getNombre() : "Producto desconocido"; // Maneja productos no encontrados
                    informacion[i][IndicesUtil.prodpedIndices.get("PRODUCTO")] = nombreProducto; // Mostrar nombre del producto
                    informacion[i][IndicesUtil.prodpedIndices.get("PEDIDOID")] = pp.getIdPedido();
                    informacion[i][IndicesUtil.prodpedIndices.get("CANTIDAD")] = pp.getCantidad();
                    informacion[i][IndicesUtil.prodpedIndices.get("PRECIO_UNI")] = pp.getPrecioPorUnidadProveedor();
                    informacion[i][IndicesUtil.prodpedIndices.get("TOTAL_PROD")] = pp.getPrecioTotal();
                }
            return informacion;
        }
        
        private void construirTablaConProductos(ArrayList<Producto> productos) {
        ArrayList<String> titulosList = new ArrayList<>(Arrays.asList("ItemID", "Nombre", "Categoría", "Proveedor", "Precio", "Stock", "Descripción"));
        CategoriaDao categoriaDao = new CategoriaDao();
        ProveedorDao proveedorDao = new ProveedorDao();
        Object[][] data = obtenerMatrizDatosProductos(productos, categoriaDao, proveedorDao);
        construirTablaAvanzada(1, titulosList.toArray(new String[0]), data);
    }
	/**
	 * Con los titulos y la información a mostrar se crea el modelo para 
	 * poder personalizar la tabla, asignando tamaño de celdas tanto en ancho como en alto
	 * así como los tipos de datos que va a poder soportar.
	 * @param titulos
	 * @param data
	 */
	private void construirTablaAvanzada(int tipoTabla, String[] titulos, Object[][] data) {
            modelo = new ModeloTabla(data, titulos);
            tablaP.setModel(modelo);
            tablaP.setRowHeight(30);
            tablaP.setGridColor(new java.awt.Color(0, 0, 0));

            // Configurar el TableRowSorter y los comparadores
            TableRowSorter<ModeloTabla> sorter = new TableRowSorter<>(modelo);
            tablaP.setRowSorter(sorter);
            configurarComparadoresPorTipoTabla(sorter, tipoTabla);

            // Configurar renderizadores y otros aspectos visuales
            for (int i = 0; i < titulos.length; i++) {
                if (titulos[i].equals("Stock")) {
                    tablaP.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
                } else {
                    tablaP.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
                }
            }

            // Configurar el encabezado de la tabla
            JTableHeader jtableHeader = tablaP.getTableHeader();
            jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
            tablaP.setTableHeader(jtableHeader);
            tablaP.getTableHeader().setReorderingAllowed(false);

            // Asigna la tabla al scrollPane
            scrollPaneTabla.setViewportView(tablaP);
        }

        private void configurarComparadoresPorTipoTabla(TableRowSorter<ModeloTabla> sorter, int tipoTabla) {
            switch (tipoTabla) {
                case 1: // Tabla de Productos
                    sorter.setComparator(IndicesUtil.productoIndices.get("ITEMID"), (o1, o2) -> {
                        int id1 = Integer.parseInt(o1.toString());
                        int id2 = Integer.parseInt(o2.toString());
                        return Integer.compare(id1, id2);
                    });
                    sorter.setComparator(IndicesUtil.productoIndices.get("NOMBRE"), Comparator.naturalOrder()); // Orden alfabético por Nombre
                    sorter.setComparator(IndicesUtil.productoIndices.get("CATEGORIA"), Comparator.naturalOrder()); // Orden alfabético por Categoría
                    sorter.setComparator(IndicesUtil.productoIndices.get("PROVEEDOR"), Comparator.naturalOrder()); // Orden alfabético por Proveedor
                    sorter.setComparator(IndicesUtil.productoIndices.get("PRECIO"), Comparator.comparingDouble(Double::parseDouble)); // Orden numérico por Precio
                    sorter.setComparator(IndicesUtil.productoIndices.get("STOCK"), (a1, a2) -> {
                        int stock1 = Integer.parseInt(a1.toString());
                        int stock2 = Integer.parseInt(a2.toString());
                        return Integer.compare(stock1, stock2);
                    });
                    sorter.setComparator(IndicesUtil.productoIndices.get("DESCRIPCION"), Comparator.naturalOrder()); // Orden alfabético por Descripción
                    break;
                    
                case 2:
                    sorter.setComparator(IndicesUtil.proveedorIndices.get("ID_PROVEEDOR"), (o1, o2) -> {
                        int id1 = Integer.parseInt(o1.toString());
                        int id2 = Integer.parseInt(o2.toString());
                        return Integer.compare(id1, id2);
                    });
                    sorter.setComparator(IndicesUtil.proveedorIndices.get("NOMBRE"), Comparator.naturalOrder()); // Orden alfabético por Nombre
                    sorter.setComparator(IndicesUtil.proveedorIndices.get("TELEFONO"), (o1, o2) -> {
                        return o1.toString().compareTo(o2.toString());
                    });
                    sorter.setComparator(IndicesUtil.proveedorIndices.get("CORREO"), Comparator.naturalOrder()); // Orden alfabético por Correo
                    break;
                
                case 3:
                    sorter.setComparator(IndicesUtil.categoriaIndices.get("ID_CATEGORIA"), (o1, o2) -> {
                        int id1 = Integer.parseInt(o1.toString());
                        int id2 = Integer.parseInt(o2.toString());
                        return Integer.compare(id1, id2);
                    });
                    sorter.setComparator(1, Comparator.naturalOrder()); // Comparador para Nombre
                    sorter.setComparator(2, Comparator.naturalOrder()); // Comparador para Descripción
                    break;
                    
                case 4:
                    sorter.setComparator(IndicesUtil.pedidoIndices.get("PEDIDOID"), (o1, o2) -> {
                        int id1 = Integer.parseInt(o1.toString());
                        int id2 = Integer.parseInt(o2.toString());
                        return Integer.compare(id1, id2);
                    });
                    sorter.setComparator(IndicesUtil.pedidoIndices.get("FECHA_PEDIDO"), Comparator.comparing(Date::parse));
                    sorter.setComparator(IndicesUtil.pedidoIndices.get("PROVEEDOR"), Comparator.naturalOrder()); // Orden alfabético por Proveedor
                    sorter.setComparator(IndicesUtil.pedidoIndices.get("TOTAL_PED"), Comparator.comparingDouble(Double::parseDouble));
                    sorter.setSortable(IndicesUtil.pedidoIndices.get("INFORMATION"), false);  // Deshabilita la ordenación para el icono
                    break;
                    
                case 5:
                    sorter.setComparator(IndicesUtil.prodpedIndices.get("PRODUCTO"), Comparator.naturalOrder());
                    sorter.setComparator(IndicesUtil.prodpedIndices.get("CANTIDAD"), (o1, o2) -> {
                        int id1 = Integer.parseInt(o1.toString());
                        int id2 = Integer.parseInt(o2.toString());
                        return Integer.compare(id1, id2);
                    });
                    sorter.setComparator(IndicesUtil.prodpedIndices.get("PRECIO_UNI"), Comparator.comparingDouble(value -> (Double) value));
                    sorter.setComparator(IndicesUtil.prodpedIndices.get("TOTAL_PROD"), Comparator.comparingDouble(value -> (Double) value));
                    break;
                    
        default:
            throw new IllegalArgumentException("Tipo de tabla no soportado!!");
    }
}
        
	@Override
	public void mouseClicked(MouseEvent e) {
            int column = tablaP.getColumnModel().getColumnIndexAtX(e.getX()); // Índice de columna donde se hizo clic
            int row = e.getY() / tablaP.getRowHeight(); // Índice de fila donde se hizo clic
            if (row < tablaP.getRowCount() && row >= 0 && column < tablaP.getColumnCount() && column >= 0) {
                Object value = tablaP.getValueAt(row, column);
                if ("INFO".equals(value)) {
                    int idPedido = Integer.parseInt(tablaP.getValueAt(row, IndicesUtil.pedidoIndices.get("PEDIDOID")).toString());
                    abrirVentanaProductoPedido(idPedido);
                }
            }
        }
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}