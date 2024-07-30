import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class tienda_de_jhonatan {
    private Scanner nyx = new Scanner(System.in);
    private String[] libreria = {"cuadernos:$5.00", "lapiceros:$1.00"
            , "lapiz:$1.00", "borrador:$1.00", "tajador:$1.00", "corrector:$3.00"
            ,"colores largos Artesco:$14.70","Resaltador Stabilo:$44.00"
            ,"Plumon indeleble:$19.20","pegamento faber castell:$8.20"
            ,"lapiceros faber castell:$9.20","lapiceros pilot frexion:$13.00"
            ,"tijera :$9.30","juego de escuadras:$4.00"};

    private double[] precioLibreria = {5.00, 1.00, 1.00, 1.00, 1.00, 3.00
            ,14.70,44.00,19.20,8.20,9.20,13.00,9.30,4.00};

    private String[] bebidas = {"agua san luis:$1.50", "agua cielo:$1.00", "yogur:$3.00", "jugo:$3.00"};

    private double[] precioBebidas = {1.50, 1.00, 3.00, 3.00};

    private String[] antogitos = {"salteñas:$2.00", "humitas:$3.00", "pie de piña:$3.00", "pie de manzana:$2.00"
            , "atadito de chocolate:$2.00"
            , "atadito de manjar:$2.00", "budin de leche:$2.00"
            , "budin de chocolate:$2.00"};

    private double[] precioPostres = {2.00, 3.00, 3.00, 2.00, 2.00, 2.00, 2.00, 2.00};

    private String[] helado = {"pesiduri:$15.00", "bote de sublime:$21.00"
            , "trika de vainilla:$1.50", "zoorpresa:$2.50","sin parar:$5.00"
            ,"kit kat:$5.00","sin parar lucuma:$5.00","duo sublime:3.50"
            ,"turbo max:$1.20","BB chicha morada:$1.00","alaska camu camu:$2.50"
            ,"alaska fresa:$3.00","alaska maracuya:$3.00","crea frutas:$1.20"
            ,"copa k_bana:$3.00","frio rico maracuya:$5.50"
            ,"frio rico vainilla:$5.50","cacao de junin :$5.50"};

    private double[] precioHelado = {15.00, 21.00, 1.50, 2.50,5.00
            ,5.00,5.00,3.50,1.20,1.00,2.50,3.00,3.00,1.20,3.00,5.50,5.50,5.50};

    private int[] carritoLibreria = new int[libreria.length];
    private int[] carritoBebidas = new int[bebidas.length];
    private int[] carritoPostres = new int[antogitos.length];
    private int[] carritoHelado = new int[helado.length];

    private String nombre;
    private String metodoPago;
    private String numeroDeYape;
    private String nombreTitular;

    public static void main(String[] args) {
        tienda_de_jhonatan nyx = new tienda_de_jhonatan();
        nyx.iniciar();
    }

    public void iniciar() {
        iniciarSesion();
        menuPrincipal();
    }

    private void iniciarSesion() {
        String[] credenciales = {"j", "a", "123"};
        System.out.println("******* Bazar *******");
        System.out.println("Ingrese su usuario:");
        String usuario = nyx.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = nyx.nextLine();

        if (usuario.equals(credenciales[1]) && contraseña.equals(credenciales[2])) {
            System.out.println("Bienvenido " + credenciales[0]);
            metodoPago();
        } else {
            System.out.println("Usuario/Contraseña no válidos");
            iniciarSesion();
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
            case 2 :
                comprarBebidas();
                break;
            case 3 :
                comprarantogitos();
                break;
            case 4 :
                comprarHelado();
            break;
            case 5 :
                libroDeReclamos();
                break;
            default :{
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
            case 1 :
                seleccionarycomprar(productos, precios, carrito);
                    break;
            case 2 :
                     calcularPago(carrito, precios, productos);
                break;
            case 3 :
                     menuPrincipal();
            break;
        }
    }

    private void metodoPago() {
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Yape");
        System.out.println("2. Efectivo");

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
        } else {
            System.out.println("Opción no válida. Intente de nuevo.");
            metodoPago();
        }
    }

    private boolean validarPagoYape() {
        return numeroDeYape != null && numeroDeYape.length() == 9
                && nombreTitular != null && !nombreTitular.isEmpty();
    }

    private void calcularPago(int[] carrito, double[] precios, String[] items) {
        double subtotal = 0;
        for (int i = 0; i < carrito.length; i++) {
            subtotal += carrito[i] * precios[i];
        }
        double igv = subtotal * 0.18;
        double totalPagar = subtotal + igv;

        System.out.println("---- BOLETA DE VENTA ---------");
        System.out.println("Nombre del Cliente: " + nombre);
        System.out.println("Fecha: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format(new Date()));
        System.out.println("Productos Comprados:");
        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i] > 0) {
                System.out.println(items[i] + " x " + carrito[i] + " = " + (carrito[i] * precios[i]));
            }
        }
        System.out.println("SUBTOTAL: " + subtotal);
        System.out.println("IGV: " + igv);
        System.out.println("TOTAL: " + totalPagar);
        System.out.println("Método de Pago: " + metodoPago);

        if (metodoPago.equals("yape") && validarPagoYape()) {
            System.out.println("Pago realizado con éxito con Yape.");
            exportarBoleta(subtotal, igv, totalPagar, metodoPago, items, carrito, 0);
        } else if (metodoPago.equals("Efectivo")) {
            System.out.println("Ingrese la cantidad de efectivo recibido:");
            double efectivoRecibido = nyx.nextDouble();
            double cambio = efectivoRecibido - totalPagar;
            System.out.println("Cambio: " + cambio);
            exportarBoleta(subtotal, igv, totalPagar, metodoPago, items, carrito, cambio);
        } else {
            System.out.println("Error en el pago con Yape. Intente nuevamente.");
        }
    }

    private void exportarBoleta(double subtotal, double igv, double totalPagar, String metodoPago, String[] items, int[] carrito, double cambio) {
        try {
            File archivo = new File("D:\\boleta.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("---- BOLETA DE VENTA ---------\n");
            escritor.write("Nombre del Cliente: " + nombre + "\n");
            escritor.write("Fecha: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) + "\n");
            escritor.write("Productos Comprados:\n");
            for (int i = 0; i < carrito.length; i++) {
                if (carrito[i] > 0) {
                    escritor.write(items[i] + " x " + carrito[i] + " = " + (carrito[i] * precioBebidas[i]) + "\n");
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

    private void libroDeReclamos() {
        Scanner reclamo = new Scanner(System.in);
        String[] lineas = new String[1000];
        int contadorLineas = 0;

        System.out.println("Libro de Reclamos");
        while (true) {
            System.out.println("Opciones:");
            System.out.println("1 - Agregar sugerencias para mejorar la atención");
            System.out.println("2 - Mostrar contenido");
            System.out.println("3 - Guardar y salir");
            System.out.print("Elige una opción: ");

            int opcion = reclamo.nextInt();
            reclamo.nextLine();

            if (opcion == 1) {
                System.out.print("Ingrese su queja o sugerencia para mejorar el servicio: ");
                String linea = reclamo.nextLine();
                if (contadorLineas < lineas.length) {
                    lineas[contadorLineas] = linea;
                    contadorLineas++;
                } else {
                    System.out.println("Se ha alcanzado el límite de líneas.");
                }
            } else if (opcion == 2) {
                System.out.println("Contenido:");
                for (int i = 0; i < contadorLineas; i++) {
                    System.out.println(lineas[i]);
                }
            } else if (opcion == 3) {
                menuPrincipal();
                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        try {
            File archivo = new File("D:\\libro_de_reclamos.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.write("---- Libro de Reclamos ---------\n");
            for (int i = 0; i < contadorLineas; i++) {
                escritor.write("Reclamo: " + lineas[i] + "\n");
            }
            escritor.close();

        } catch (IOException e) {
            System.out.println("Error al exportar las quejas.");
            e.printStackTrace();
        }

    }


}
