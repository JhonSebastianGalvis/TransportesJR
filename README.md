Transportes JR - Sistema para la gestión empresarial y logística

Creado por: 
Jhon Sebastian Galvis (Grupo 328)
Facultad de ingenieria
Tecnologia en sistemas de información

Supervisado por:
Gustavo Adolfo Oviedo Bayan (Bases de datos I)
Mauricio Alberto Ledesma Villegas (Programación I)

Requerimientos basicos:
Lenguaje: Java (JDK 8 o superior)
IDE: Apache Netbeans

Para ejecutarlo correctamente:
1. Clona o descarga el repositorio y ábrelo en Apache NetBeans (u otro IDE compatible con Java).
2. Ejecuta TransportesJR.java para correr la simulación general del negocio.
3. Ejecuta las clases dentro del paquete transportesjr.pruebas (PruebaPedidoRepositorio, PruebaDetallePedidoRepositorio y PruebaPedidoControlador)
   para verificar las operaciones CRUD en la consola.

Estructura del proyecto:

TransportesJR/
└── src/
    ├── transportesjr/                                      # Clase principal (Main)
    │   └── TransportesJR.java
    ├── transportesjr/controlador/                          # Lógica del negocio y coordinación entre capas
    │   └── PedidoControlador.java
    ├── transportesjr/modelo/                               # Entidades del dominio y reglas básicas
    │   ├── Cliente.java
    │   ├── Conductor.java
    │   ├── DetallePedido.java
    │   ├── Entrega.java
    │   ├── Factura.java
    │   ├── Gasto.java
    │   ├── Pedido.java
    │   ├── Producto.java
    │   ├── Trayecto.java
    │   └── Vehiculo.java
    ├── transportesjr/pruebas/                             # Pruebas unitarias y de integración por consola
    │   ├── PruebaDetallePedidoRepositorio.java
    │   ├── PruebaPedidoControlador.java
    │   └── PruebaPedidoRepositorio.java
    ├── transportesjr/repositorio/                         # Capa de acceso a datos y operaciones CRUD
    │   ├── DetallePedidoRepositorio.java
    │   └── PedidoRepositorio.java
    ├── transportesjr/util/                                # Clases de utilidad y soporte transversal
    │   └── Seguridad.java
    └── transportesjr/vista/                               # Interfaz gráfica de usuario (GUI)
        ├── VentanaPedido.java
        └── VentanaPedidoOld.java
