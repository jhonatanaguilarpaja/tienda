import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class sao {
    private Scanner nyx = new Scanner(System.in);
    private Random random = new Random();

    private String[] libreria = {"cuadernos:$5.90", "lapiceros:$1.18"
            , "lapiz:$1.18", "borrador:$1.18", "tajador:$1.18", "corrector:$3.54",
            "colores largos Artesco:$17.35", "Resaltador Stabilo:$51.92"
            , "Plumon indeleble:$22.66", "pegamento faber castell:$9.68",
            "lapiceros faber castell:$10.86", "lapiceros pilot frexion:$15.34"
            , "tijera :$10.97", "juego de escuadras:$4.72"};

    private double[] precioLibreria = {5.90, 1.18, 1.18, 1.18, 1.18, 3.54,
            17.35, 51.92, 22.66, 9.68, 10.86, 15.34, 10.97, 4.72};

    private String[] bebidas = {"agua san luis:$1.77", "agua cielo:$1.18"
            , "yogur:$3.54", "jugo:$3.54"};

    private double[] precioBebidas = {1.77, 1.18, 3.54, 3.54};

    private String[] antogitos = {"salteñas:$2.36", "humitas:$3.54", "pie de piña:$3.54"
            , "pie de manzana:$2.36",
            "atadito de chocolate:$2.36", "atadito de manjar:$2.36"
            , "budin de leche:$2.36", "budin de chocolate:$2.36"};

    private double[] precioPostres = {2.36, 3.54, 3.54, 2.36, 2.36, 2.36, 2.36, 2.36};

    private String[] helado = {"pesiduri:$17.70", "bote de sublime:$24.78"
            , "trika de vainilla:$1.77", "zoorpresa:$2.95", "sin parar:$5.90",
            "kit kat:$5.90", "sin parar lucuma:$5.90", "duo sublime:$4.13"
            , "turbo max:$1.42", "BB chicha morada:$1.18",
            "alaska camu camu:$2.95", "alaska fresa:$3.54", "alaska maracuya:$3.54"
            , "crea frutas:$1.42", "copa k_bana:$3.54",
            "frio rico maracuya:$6.49", "frio rico vainilla:$6.49"
            , "cacao de junin :$6.49"};

    private double[] precioHelado = {17.70, 24.78, 1.77, 2.95, 5.90, 5.90, 5.90, 4.13, 1.42, 1.18,
            2.95, 3.54, 3.54, 1.42, 3.54, 6.49, 6.49, 6.49};

    private int[] carritoLibreria = new int[libreria.length];
    private int[] carritoBebidas = new int[bebidas.length];
    private int[] carritoPostres = new int[antogitos.length];
    private int[] carritoHelado = new int[helado.length];

    private String nombre;
    private String metodoPago;
    private String numeroDeYape;
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvv;

    public static void main(String[] args) {
        sao nyx = new sao();
        nyx.iniciar();
    }

    public void iniciar() {
        cunentaoiniciarSesion();
        menuPrincipal();
    }



    private void cunentaoiniciarSesion() {
        String opcion;
        System.out.println("BIENVENIDO A TIENDA DE JHONATAN");
        System.out.println("1:_INICIAR SESION");
        System.out.println("2:_REGISTRARSE");
        opcion =  nyx.nextLine();
        switch (opcion) {

            case "1":
            String[] credenciales = {"JHONATAN", "j", "123"};
            System.out.println("******* TIENDA DE JHONATAN *******");
                System.out.println("----------BIENVENIDO---------");
            System.out.println("Ingrese su usuario:");
            String usuario = nyx.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contraseña = nyx.nextLine();

            if (usuario.equals(credenciales[1]) && contraseña.equals(credenciales[2])) {
                System.out.println("Bienvenido " + credenciales[0]);
                metodoPago();
            } else {
                System.out.println("Usuario/Contraseña no válidos");
                cunentaoiniciarSesion();
            }break;

            case "2":
                String nombre;
                String correo, correo_in, contra, contraseña_in;
                System.out.println("BIENVENIDO A TIENDA DE JHONATAN");
                System.out.println("------CREAR CUENTA------");
                System.out.println("Ingrese su nombre completo");
                nombre = nyx.nextLine();
                System.out.println("Ingrese su correo");
                correo = nyx.nextLine();
                System.out.println("Ingrese su contraseña");
                contra = nyx.nextLine();
                System.out.println("-----INICIAR SESION-----");
                System.out.println("Ingrese su correo");
                correo_in = nyx.nextLine();
                System.out.println("Ingrese su contraseña");
                contraseña_in = nyx.nextLine();
                if (correo_in.equals(correo) && contraseña_in.equals(contra)) {
                    System.out.println("BIENVENIDO"+nombre);
                    this.metodoPago();
                } else {
                    System.out.println("Credenciales incorrectas. Inténtalo nuevamente.");
                }break;
        }


    }



    public void menuPrincipal() {
        System.out.println("--------- BIENVENIDO  -----------");
        System.out.println("Seleccione una de las siguientes opciones:");
        System.out.println("1. Libreria");
        System.out.println("2. Bebidas");
        System.out.println("3. Postres");
        System.out.println("4. Helado");
        System.out.println("5. Libro de Reclamos");

        int opcion = nyx.nextInt();
        nyx.nextLine();

        switch (opcion) {
            case 1:
                comprarLibreria();
                break;
            case 2:
                comprarBebidas();
                break;
            case 3:
                comprarantogitos();
                break;
            case 4:
                comprarHelado();
                break;
            case 5:
                libro_de_reclamos();
                break;
            default: {
                System.out.println("Opción no válida. Intente de nuevo.");
                menuPrincipal();
            }
        }
    }

    private void comprarLibreria() {
        System.out.println("****** Libreria *******");
        seleccionarycomprar(libreria, precioLibreria, carritoLibreria);
    }

    private void comprarBebidas() {
        System.out.println("****** Bebidas *******");
        seleccionarycomprar(bebidas, precioBebidas, carritoBebidas);
    }

    private void comprarantogitos() {
        System.out.println("**** Postres *****");
        seleccionarycomprar(antogitos, precioPostres, carritoPostres);
    }

    private void comprarHelado() {
        System.out.println("****** Helados *******");
        seleccionarycomprar(helado, precioHelado, carritoHelado);
    }

    private void seleccionarycomprar(String[] productos, double[] precios, int[] carrito) {
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Opción " + (i + 1) + ": " + productos[i]);
        }

        int opcion = nyx.nextInt();
        nyx.nextLine();

        if (opcion < 1 || opcion > productos.length) {
            System.out.println("Opción no válida. Intente de nuevo.");
            seleccionarycomprar(productos, precios, carrito);
            return;
        }

        System.out.println("¿Cuántos comprará? Ingrese la cantidad:");
        int cantidad = nyx.nextInt();
        carrito[opcion - 1] += cantidad;

        System.out.println("Ud ha pedido " + carrito[opcion - 1] + " de " + productos[opcion - 1]);
        System.out.println("¿Desea elegir otro producto? 1. SI / 2. NO / 3. Menú Principal");

        opcion = nyx.nextInt();
        nyx.nextLine();

        switch (opcion) {
            case 1:
                seleccionarycomprar(productos, precios, carrito);
                break;
            case 2:
                calcularPago(carrito, precios, productos);
                break;
            case 3:
                menuPrincipal();
                break;
        }
    }

    private void metodoPago() {
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Yape");
        System.out.println("2. Efectivo");
        System.out.println("3. Tarjeta");

        int opcion = nyx.nextInt();
        nyx.nextLine();

        if (opcion == 1) {
            metodoPago = "yape";
            System.out.println("Ingrese el número de Yape:");
            numeroDeYape = nyx.nextLine();
            System.out.println("Ingrese el nombre del titular de Yape:");
            nombreTitular = nyx.nextLine();
        } else if (opcion == 2) {
            metodoPago = "Efectivo";
        } else if (opcion == 3) {
            metodoPago = "Tarjeta Visa";
            System.out.println("Ingrese el número de su tarjeta Visa:");
            numeroTarjeta = nyx.nextLine();
            System.out.println("Ingrese el nombre del titular de la tarjeta:");
            nombreTitular = nyx.nextLine();
            System.out.println("Ingrese la fecha de expiración (MM/AA):");
            fechaExpiracion = nyx.nextLine();
            System.out.println("Ingrese el CVV:");
            cvv = nyx.nextLine();
        } else {
            System.out.println("Opción no válida. Intente de nuevo.");
            metodoPago();
        }
    }

    private boolean validarPagoYape() {
        return numeroDeYape != null && numeroDeYape.length() == 9
                && nombreTitular != null && !nombreTitular.isEmpty();
    }

    private boolean validarPagoVisa() {
        return numeroTarjeta != null && numeroTarjeta.length() == 16 &&
                nombreTitular != null && !nombreTitular.isEmpty() &&
                fechaExpiracion != null && fechaExpiracion.matches("\\d{2}/\\d{2}") &&
                cvv != null && cvv.length() == 3;
    }

    private void calcularPago(int[] carrito, double[] precios, String[] producto) {
        double subtotal = 0;
        double igv = 0;

        System.out.println("---- BOLETA DE VENTA ---------");
        System.out.println("Nombre del Cliente: " + nombre);
        System.out.println("Fecha: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format(new Date()));
        System.out.println("Productos Comprados:");

        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i] > 0) {
                double precioSinIGV = precios[i] / 1.18;
                double igvPorProducto = carrito[i] * (precios[i] - precioSinIGV);
                subtotal += carrito[i] * precioSinIGV;
                igv += igvPorProducto;
                System.out.println(producto[i] + " * " + carrito[i] + " = " + (carrito[i] * precios[i]));
            }
        }

        double totalPagar = subtotal + igv;

        System.out.println("SUBTOTAL: " + subtotal);
        System.out.println("IGV: " + igv);
        System.out.println("TOTAL: " + totalPagar);
        System.out.println("Método de Pago: " + metodoPago);

        if (metodoPago.equals("yape") && validarPagoYape()) {
            System.out.println("Pago realizado con éxito con Yape.");
            exportarBoleta(subtotal, igv, totalPagar, metodoPago, producto, carrito, 0);
        } else if (metodoPago.equals("Efectivo")) {
            System.out.println("Ingrese la cantidad de efectivo recibido:");
            double efectivoRecibido = nyx.nextDouble();
            double cambio = efectivoRecibido - totalPagar;
            System.out.println("Cambio: " + cambio);
            exportarBoleta(subtotal, igv, totalPagar, metodoPago, producto, carrito, cambio);
        } else if (metodoPago.equals("Tarjeta Visa") && validarPagoVisa()) {
            System.out.println("Pago realizado con éxito con la tarjeta Visa.");
            exportarBoleta(subtotal, igv, totalPagar, metodoPago, producto, carrito, subtotal);
        } else {
            System.out.println("Error en el pago . Intente nuevamente.");
        }
    }

    private void exportarBoleta(double subtotal, double igv, double totalPagar
            , String metodoPago, String[] items, int[] carrito, double cambio) {
        try {
            File archivo = new File("D:\\boleta.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("---- BOLETA DE VENTA ---------\n");
            escritor.write("Nombre del Cliente: " + nombre + "\n");
            escritor.write("Fecha: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "\n");
            escritor.write("Productos Comprados:\n");
            for (int i = 0; i < carrito.length; i++) {
                if (carrito[i] > 0) {
                    double precioSinIGV = precioHelado[i] / 1.18;
                    double igvPorProducto = carrito[i] * (precioBebidas[i] - precioSinIGV);
                    escritor.write(items[i] + " x " + carrito[i] + " = " + (carrito[i] * precioBebidas[i]));
                }
            }
            escritor.write("SUBTOTAL: " + subtotal + "\n");
            escritor.write("IGV: " + igv + "\n");
            escritor.write("TOTAL: " + totalPagar + "\n");
            escritor.write("Método de Pago: " + metodoPago + "\n");
            if (metodoPago.equals("Efectivo")) {
                escritor.write("Cambio: " + cambio + "\n");
            }
            escritor.write("Gracias por su preferencia.");
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al exportar la boleta.");
            e.printStackTrace();
        }
    }


    private void libro_de_reclamos() {
        Scanner reclamo = new Scanner(System.in);
        String[] lineas = new String[1000];
        int contadorlineas = 0;

        System.out.println("libro de reclamos ");
        while (true) {
            System.out.println("Opciones:");
            System.out.println("1 - agregar sugerencias para mejorar la atencion ");
            System.out.println("2 - Mostrar contenido");
            System.out.println("3 - Guardar y salir");
            System.out.print("Elige una opción: ");

            int option = reclamo.nextInt();
            reclamo.nextLine();

            if (option == 1) {
                System.out.print("Ingrese su queja o suguerencia para mejorar el servicio: ");
                String line = reclamo.nextLine();
                if (contadorlineas < lineas.length) {
                    lineas[contadorlineas] = line;
                    contadorlineas++;
                } else {
                    System.out.println("Se ha alcanzado el límite de líneas.");
                }
            } else if (option == 2) {
                System.out.println("Contenido:");
                for (int i = 0; i < contadorlineas; i++) {
                    System.out.println(lineas[i]);
                }
            } else if (option == 3) {
                menuPrincipal();
                break;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        try {
            File archivo = new File("D:\\libro de reclamos.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("----reclamos ---------\n");
            for (int i = 0; i < contadorlineas; i++) {
                escritor.write("reclamo:" + lineas[i] + "\n");
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al exportar la queja.");
            e.printStackTrace();
        }



    }


}
