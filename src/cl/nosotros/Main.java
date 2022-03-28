package cl.nosotros;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int password= 12345;


        productosList.add(new Producto(5000,"mouse",5));
        productosList.add(new Producto(10000,"Teclado",2));
        productosList.add(new Producto(15000,"webcam",1));
        productosList.add(new Producto(20000,"router",10));
        productosList.add(new Producto(200000,"celular",7));
        comprasList.add(new Compra(5000,"mouse",2,"28/02/2022"));




        System.out.println("Bienvenido a nuestra tienda ¿usted es administrador?");
        System.out.println("Si es administrador ingrese su clave sino ingrese cualquier numero");
        if (login()==password){
            int opMenuAdmin;
            do{
                opMenuAdmin = menuAdmin();
                switch (opMenuAdmin){
                    case OPCION_MENU_CREAR_PRODUCTOS:
                        System.out.println("crear producto");
                        crearProducto();
                    break;
                    case OPCION_MENU_VER_PRODUCTOS:
                        System.out.println("ver productos");
                        verProductos();
                        break;
                    case OPCION_MENU_AGREGAR_VENTA:
                        System.out.println("agregar venta");
                        crearVenta();
                        break;
                    case OPCION_MENU_VER_VENTAS:
                        System.out.println("ver ventas");
                        verVentas();
                        break;
                    case OPCION_MENU_SALIR:
                        System.out.println("salir");
                }

            }while (opMenuAdmin !=OPCION_MENU_SALIR);
        }else{

        }

    }
    private static int login(){
        Scanner scan = new Scanner(System.in);
        int logear = scan.nextInt();
        return logear;
    }
    public static ArrayList<Producto> productosList= new ArrayList();
    public static ArrayList<Compra>comprasList = new ArrayList();


    private  static int menuAdmin(){
        System.out.println("[1] para agregar producto ");
        System.out.println("[2] para ver producto ");
        System.out.println("[3] para Realizar una venta ");
        System.out.println("[4] para ver ventas realizadas ");
        System.out.println("[0] para salir del sistema ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
    private static void verProductos(){
        for (int i=0; i<productosList.size();i++){
            System.out.println("["+i+"]"+productosList.get(i));
        }return;
    }
    private static void crearProducto(){
        Scanner scan = new Scanner(System.in);
        System.out.println("ingrese el nombre del producto");
        String nombreProducto = scan.nextLine();
        System.out.println("ingrese el valor del producto");
        int valorProducto = scan.nextInt();
        System.out.println("ingrese el Stock del producto");
        int stock = scan.nextInt();
        productosList.add(new Producto(valorProducto,nombreProducto,stock));
        return;
    }
    private static void crearVenta(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Scanner scan = new Scanner(System.in);
        verProductos();
        System.out.println("seleccione el producto que desea comprar");
        int vender = scan.nextInt();
        if (vender<productosList.size()){
            System.out.println("cuantos desea comprar");
            int cantidad = scan.nextInt();
            if (cantidad<productosList.get(vender).getStock()){
                System.out.println(cantidad);
                int VenderValorProducto = productosList.get(vender).getValorProducto();
                String VenderNombreProducto = productosList.get(vender).getNombreProducto();
                comprasList.add(new Compra(VenderValorProducto,VenderNombreProducto,cantidad,dateFormat.format(date)));
                productosList.get(vender).setStock(productosList.get(vender)
                        .getStock()-cantidad);
            }else {
                System.out.println("No tenemos Stock suficiente pra procesar su compra");
            }
        }else {
            System.out.println("Solo puede seleccionar un producto existente");
        }
        return;
    }
    private static void verVentas(){
        int sumarVentas=0;
        for (int i=0; i<comprasList.size();i++){
            System.out.println("[Venta ]"+comprasList.get(i).getNombreProducto()+" $"+comprasList.get(i).getValorProducto()
            +" c/u cantidad vendida "+comprasList.get(i).getTotal()+" Fecha "+comprasList.get(i).getFecha());
            sumarVentas += comprasList.get(i).getTotal()*comprasList.get(i).getValorProducto();
        }
        System.out.println("El total de ventas del día es de $"+sumarVentas);
        return;
    }

    public static final int OPCION_MENU_CREAR_PRODUCTOS   = 1;
    public static final int OPCION_MENU_VER_PRODUCTOS     = 2;
    public static final int OPCION_MENU_AGREGAR_VENTA = 3;
    public static final int OPCION_MENU_VER_VENTAS   = 4;
    public static final int OPCION_MENU_SALIR   = 5;
}
