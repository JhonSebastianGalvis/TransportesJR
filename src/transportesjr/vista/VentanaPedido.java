/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportesjr.vista;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import transportesjr.controlador.PedidoControlador;
import transportesjr.modelo.DetallePedido;
import transportesjr.modelo.Pedido;
import transportesjr.modelo.Producto;
import transportesjr.repositorio.DetallePedidoRepositorio;
import transportesjr.repositorio.PedidoRepositorio;

public class VentanaPedido extends javax.swing.JFrame {

    // =====================================================================
    // ATRIBUTOS DE CONTROL Y DATOS (Misma estructura de VentanaProductos)
    // =====================================================================
    private PedidoControlador controlador;
    private DefaultTableModel modelo;
    private List<DetallePedido> detallesEnTabla = new ArrayList<>();
    private List<Producto> catalogoProductos = new ArrayList<>();
    private int idPedidoSeleccionado = -1;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPedido.class.getName());

    // =====================================================================
    // CONSTRUCTOR: Recibe el controlador de Transportes JR
    // =====================================================================
    public VentanaPedido(PedidoControlador controlador) {
        initComponents();
        this.controlador = controlador;

        modelo = new DefaultTableModel(new String[]{"ID", "Descripción", "Cantidad", "Precio Unitario", "Subtotal"}, 0);
        tblDetallesPedido.setModel(modelo);
        tblDetallesPedido.setDefaultEditor(Object.class, null);

        cargarProductosDisponibles();
        cargarMetodosPago();
        cargarTabla(detallesEnTabla);
        setLocationRelativeTo(null);
    }

    // =====================================================================
    // MÉTODOS AYUDANTES: Muestran y gestionan los datos en la ventana
    // =====================================================================

    private void cargarProductosDisponibles() {
        catalogoProductos.clear();
        catalogoProductos.add(new Producto(101, "Cemento", "Disponible", 32000.0, 100));
        catalogoProductos.add(new Producto(102, "Varilla", "Disponible", 28500.0, 80));
        catalogoProductos.add(new Producto(103, "Arena", "Disponible", 45000.0, 50));
        catalogoProductos.add(new Producto(104, "Ladrillo", "Disponible", 1200.0, 500));
    }

    private void cargarMetodosPago() {
        cmbMetodoPago.removeAllItems();
        cmbMetodoPago.addItem("Efectivo");
        cmbMetodoPago.addItem("Tarjeta");
        txtFechaPedido.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
    }

    private void cargarTabla(List<DetallePedido> lista) {
        modelo.setRowCount(0);
        for (DetallePedido d : lista) {
            Producto p = buscarProductoPorId(d.getIdProducto());
            String descripcion = (p != null) ? p.getTipoProducto() : "Producto #" + d.getIdProducto();
            modelo.addRow(new Object[]{
                d.getIdProducto(),
                descripcion,
                d.getCantidad(),
                d.getPrecio(),
                d.calcularSubtotal()
            });
        }
    }

    private void mostrarResultado(String mensaje, boolean exitoso) {
        JOptionPane.showMessageDialog(this, mensaje);
        if (exitoso) {
            limpiar();
        }
    }

    private void limpiar() {
        idPedidoSeleccionado = -1;
        detallesEnTabla.clear();
        txtidProducto.setText("");
        txtCliente.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
        cmbMetodoPago.setSelectedIndex(0);
        txtFechaPedido.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        cargarTabla(detallesEnTabla);
        tblDetallesPedido.clearSelection();
    }

    private void mostrarSeleccionado() {
        int fila = tblDetallesPedido.getSelectedRow();
        if (fila == -1) {
            return;
        }
        DetallePedido d = detallesEnTabla.get(fila);
        Producto p = buscarProductoPorId(d.getIdProducto());
        if (p != null) {
            txtNombre.setText(p.getTipoProducto());
        }
        txtCantidad.setText(String.valueOf(d.getCantidad()));
    }

    private Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : catalogoProductos) {
            if (p.getTipoProducto().equalsIgnoreCase(nombre.trim())) {
                return p;
            }
        }
        return null;
    }

    private Producto buscarProductoPorId(int id) {
        for (Producto p : catalogoProductos) {
            if (p.getIdProducto() == id) {
                return p;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelCentral = new javax.swing.JPanel();
        lblIdPedido = new javax.swing.JLabel();
        txtidProducto = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblFechaPedido = new javax.swing.JLabel();
        txtFechaPedido = new javax.swing.JTextField();
        lblMetodoPago = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();
        panelAnadirProductos = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarProductos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetallesPedido = new javax.swing.JTable();
        panelFooter = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transportes JR - Pedido");

        panelHeader.setBackground(new java.awt.Color(14, 144, 210));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Transportes JR - Pedido");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelCentral.setBackground(new java.awt.Color(242, 244, 247));

        lblIdPedido.setText("ID del pedido:");
        lblCliente.setText("Cliente (ID):");
        lblFechaPedido.setText("Fecha del pedido:");
        lblMetodoPago.setText("Método de pago:");

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));

        panelAnadirProductos.setBackground(new java.awt.Color(242, 244, 247));
        panelAnadirProductos.setBorder(BorderFactory.createTitledBorder(null, "Añadir productos:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 13)));

        lblProducto.setText("Producto:");
        txtNombre.setToolTipText("Disponibles: Cemento, Varilla, Arena, Ladrillo");
        lblCantidad.setText("Cantidad:");

        btnAgregarProductos.setBackground(new java.awt.Color(76, 217, 10));
        btnAgregarProductos.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnAgregarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProductos.setText("Agregar Productos");
        btnAgregarProductos.addActionListener(this::btnAgregarProductosActionPerformed);

        javax.swing.GroupLayout panelAnadirProductosLayout = new javax.swing.GroupLayout(panelAnadirProductos);
        panelAnadirProductos.setLayout(panelAnadirProductosLayout);
        panelAnadirProductosLayout.setHorizontalGroup(
            panelAnadirProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnadirProductosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAnadirProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(btnAgregarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCantidad))
                .addContainerGap(18, Short.MAX_VALUE))
            );
        
            panelAnadirProductosLayout.setVerticalGroup(
            panelAnadirProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnadirProductosLayout.createSequentialGroup()
            .addGap(14, 14, 14)
            .addGroup(panelAnadirProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(lblProducto)
            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblCantidad)
            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(btnAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(16, Short.MAX_VALUE))
        );
            
        tblDetallesPedido.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] { "ID", "Descripción", "Cantidad", "Precio Unitario", "Subtotal" }
    ));
        
    tblDetallesPedido.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblDetallesPedidoMouseClicked(evt);
        }
    });
    
    jScrollPane1.setViewportView(tblDetallesPedido);
    javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
    panelCentral.setLayout(panelCentralLayout);
    panelCentralLayout.setHorizontalGroup(
    panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(panelCentralLayout.createSequentialGroup()
    .addGap(28, 28, 28)
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(jScrollPane1)
    .addGroup(panelCentralLayout.createSequentialGroup()
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(lblIdPedido)
    .addComponent(lblCliente)
    .addComponent(lblFechaPedido)
    .addComponent(lblMetodoPago))
    .addGap(26, 26, 26)
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
    .addComponent(txtidProducto)
    .addComponent(txtCliente)
    .addComponent(txtFechaPedido)
    .addComponent(cmbMetodoPago, 0, 195, Short.MAX_VALUE))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
    .addComponent(panelAnadirProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    .addGap(28, 28, 28))
    );
    panelCentralLayout.setVerticalGroup(
    panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(panelCentralLayout.createSequentialGroup()
    .addGap(18, 18, 18)
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(panelCentralLayout.createSequentialGroup()
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    .addComponent(lblIdPedido)
    .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGap(12, 12, 12)
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    .addComponent(lblCliente)
    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGap(12, 12, 12)
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    .addComponent(lblFechaPedido)
    .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGap(14, 14, 14)
    .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    .addComponent(lblMetodoPago)
    .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    .addComponent(panelAnadirProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGap(18, 18, 18)
    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap(20, Short.MAX_VALUE))
    );
    panelFooter.setBackground(new java.awt.Color(45, 52, 235));
    btnGuardar.setBackground(new java.awt.Color(76, 217, 10));
    btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 13));
    btnGuardar.setForeground(Color.WHITE);
    btnGuardar.setText("Guardar");
    btnGuardar.addActionListener(this::btnGuardarActionPerformed);
    btnActualizar.setBackground(new java.awt.Color(255, 152, 0));
    btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 13));
    btnActualizar.setForeground(Color.WHITE);
    btnActualizar.setText("Actualizar");
    btnActualizar.addActionListener(this::btnActualizarActionPerformed);
    btnEliminar.setBackground(new java.awt.Color(244, 28, 28));
    btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 13));
    btnEliminar.setForeground(Color.WHITE);
    btnEliminar.setText("Eliminar");
    btnEliminar.addActionListener(this::btnEliminarActionPerformed);
    btnLimpiar.setBackground(new java.awt.Color(158, 158, 158));
    btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 13));
    btnLimpiar.setForeground(Color.WHITE);
    btnLimpiar.setText("Limpiar");
    btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);
    javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
    panelFooter.setLayout(panelFooterLayout);
    panelFooterLayout.setHorizontalGroup(
    panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(panelFooterLayout.createSequentialGroup()
    .addGap(90, 90, 90)
    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(50, 50, 50)
    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(50, 50, 50)
    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(50, 50, 50)
    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelFooterLayout.setVerticalGroup(
    panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(panelFooterLayout.createSequentialGroup()
    .addGap(18, 18, 18)
    .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addContainerGap(18, Short.MAX_VALUE))
    );
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
    .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(0, 0, 0)
    .addComponent(panelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addGap(0, 0, 0)
    .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    pack();
    }// //GEN-END:initComponents
    // =====================================================================
    // EVENTOS DE BOTONES Y TABLA (Estructura ActionPerformed)
    // =====================================================================
    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
    try {
    int idPedido = Integer.parseInt(txtidProducto.getText().trim());
    String nombreProducto = txtNombre.getText().trim();
    int cantidad = Integer.parseInt(txtCantidad.getText().trim());
    if (cantidad <= 0) {
    mostrarResultado("La cantidad debe ser mayor a cero.", false);
    return;
    }
    Producto producto = buscarProductoPorNombre(nombreProducto);
    if (producto == null) {
    mostrarResultado("Producto no encontrado. Disponibles: Cemento, Varilla, Arena, Ladrillo.", false);
    return;
    }
    if (producto.getStockDisponible() < cantidad) {
    mostrarResultado("Stock insuficiente. Disponible: " + producto.getStockDisponible(), false);
    return;
    }
    DetallePedido detalle = new DetallePedido(idPedido, producto.getIdProducto(), cantidad, producto.getPrecioUnitario());
    detallesEnTabla.add(detalle);
    cargarTabla(detallesEnTabla);
    txtNombre.setText("");
    txtCantidad.setText("");
    } catch (NumberFormatException ex) {
    mostrarResultado("El ID del pedido y la cantidad deben ser valores numéricos.", false);
    }
    }//GEN-LAST:event_btnAgregarProductosActionPerformed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    try {
    if (detallesEnTabla.isEmpty()) {
    mostrarResultado("Agregue al menos un producto al pedido antes de guardar.", false);
    return;
    }
    int idPedido = Integer.parseInt(txtidProducto.getText().trim());
    int idCliente = Integer.parseInt(txtCliente.getText().trim());
    String metodoPago = cmbMetodoPago.getSelectedItem().toString();
    Pedido creado = controlador.crearPedido(idPedido, idCliente, 3001, metodoPago, "Dirección registrada");
    if (creado == null) {
    mostrarResultado("Ya existe un pedido registrado con el ID " + idPedido, false);
    return;
    }
    for (DetallePedido d : detallesEnTabla) {
    Producto p = buscarProductoPorId(d.getIdProducto());
    controlador.agregarProductoAPedido(idPedido, p, d.getCantidad());
    }
    double total = controlador.obtenerTotalPedido(idPedido);
    mostrarResultado("Pedido #" + idPedido + " guardado con éxito.\nTotal: $" + total, true);
    } catch (NumberFormatException ex) {
    mostrarResultado("El ID del pedido y el ID del cliente deben ser numéricos.", false);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    try {
    int idPedido = Integer.parseInt(txtidProducto.getText().trim());
    Pedido pedido = controlador.consultarPedido(idPedido);
    if (pedido == null) {
    mostrarResultado("No se encontró un pedido con el ID #" + idPedido, false);
    return;
    }
    String nuevoEstado = JOptionPane.showInputDialog(this,
    "Estado actual: " + pedido.getEstadoPedido() + "\nIngrese nuevo estado (Ej. Pagado, Enviado, Completado):");
    if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
    boolean actualizado = controlador.cambiarEstadoPedido(idPedido, nuevoEstado.trim());
    mostrarResultado(actualizado ? "Pedido actualizado a: " + nuevoEstado : "No se pudo actualizar.", actualizado);
    }
    } catch (NumberFormatException ex) {
    mostrarResultado("Ingrese un ID de pedido válido para actualizar.", false);
    }
    }//GEN-LAST:event_btnActualizarActionPerformed
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    try {
    int idPedido = Integer.parseInt(txtidProducto.getText().trim());
    Pedido pedido = controlador.consultarPedido(idPedido);
    if (pedido == null) {
    mostrarResultado("No existe el pedido #" + idPedido, false);
    return;
    }
    int respuesta = JOptionPane.showConfirmDialog(this,
    "¿Cancelar el pedido #" + idPedido + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (respuesta == JOptionPane.YES_OPTION) {
    controlador.cambiarEstadoPedido(idPedido, "Cancelado");
    mostrarResultado("Pedido #" + idPedido + " marcado como Cancelado.", true);
    }
    } catch (NumberFormatException ex) {
    mostrarResultado("Ingrese un ID de pedido válido.", false);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed
    private void tblDetallesPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetallesPedidoMouseClicked
    mostrarSeleccionado();
    }//GEN-LAST:event_tblDetallesPedidoMouseClicked
    // =====================================================================
    // MAIN PARA PROBAR LA VENTANA DE FORMA INDEPENDIENTE
    // =====================================================================
    public static void main(String args[]) {
    try {
    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    if ("Nimbus".equals(info.getName())) {
    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    break;
    }
    }
    } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
    logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
    java.awt.EventQueue.invokeLater(() -> {
    PedidoRepositorio pedidos = new PedidoRepositorio();
    DetallePedidoRepositorio detalles = new DetallePedidoRepositorio();
    PedidoControlador controlador = new PedidoControlador(pedidos, detalles);
    new VentanaPedido(controlador).setVisible(true);
    });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarProductos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbMetodoPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFechaPedido;
    private javax.swing.JLabel lblIdPedido;
    private javax.swing.JLabel lblMetodoPago;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelAnadirProductos;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTable tblDetallesPedido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFechaPedido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}