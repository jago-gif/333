package cl.nosotros;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        int password= 12345;
        int opcion;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        ArrayList<Producto>productosList= new ArrayList();
        ArrayList<Compra>comprasList = new ArrayList();

        productosList.add(new Producto(5000,"mouse",5));
        productosList.add(new Producto(10000,"Teclado",2));
        productosList.add(new Producto(15000,"webcam",1));
        productosList.add(new Producto(20000,"router",10));
        productosList.add(new Producto(200000,"celular",7));



        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenido a nuestra tienda ¿usted es administrador?");
        System.out.println("presione [1] para si o presione [2] si usted no es administrador");
            opcion = scan.nextInt();
            if (opcion==1){
                for (int i=0; i<3; i++){
                    System.out.println("por favor ingrese la clave de acceso");
                    opcion = scan.nextInt();
                    if (opcion == password){
                        System.out.println("Bienvenido administrador ¿que desea hacer?");
                        do {
                            System.out.println(opcion);
                            System.out.println("[1] para agregar producto ");
                            System.out.println("[2] para ver producto ");
                            System.out.println("[3] para Realizar una venta ");
                            System.out.println("[4] para ver ventas realizadas ");
                            System.out.println("[0] para salir del sistema ");
                            opcion = scan.nextInt();
                            if (opcion == 1){
                                productosList.add(new Producto(5000,"mouse",5));
                                System.out.println("Ingrese el nombre del producto");
                            }else if (opcion ==2){
                                for (i=0; i<productosList.size();i++){
                                    System.out.println("["+i+"]"+productosList.get(i));
                                }
                            }else if (opcion ==3){
                                int cantidad;
                                int valorProducto;
                                String nombreProducto;
                                System.out.println("Seleccione los productos que desea comprar");
                                int salir=0;
                                do {
                                    for (i=0; i<productosList.size();i++){
                                    System.out.println("["+i+"]"+productosList.get(i));
                                    }
                                    System.out.println("precione el numero del productor que" +
                                            "desea comprar o para salir presiones [999]");
                                    opcion = scan.nextInt();


                                    if (opcion==999){
                                        salir=999;
                                    }else if (opcion<productosList.size()){
                                        System.out.println("cuantos desea comprar");
                                        cantidad = scan.nextInt();
                                            int stock = productosList.get(opcion).getStock();
                                            if (stock<cantidad){
                                                System.out.println("no puede comprar mas de "
                                                        +productosList.get(opcion).getStock()+
                                                    " "+productosList.get(opcion).getNombreProducto());
                                            }else {
                                                valorProducto = productosList.get(opcion).getValorProducto();
                                                nombreProducto = productosList.get(opcion).getNombreProducto();
                                                comprasList.add(new Compra(valorProducto,nombreProducto,cantidad,
                                                        dateFormat.format(date)));
                                                productosList.get(opcion).setStock(productosList.get(opcion)
                                                        .getStock()-cantidad);
                                                System.out.println(productosList.get(opcion));
                                            }
                                    }else {
                                        System.out.println("Lo sentimos su seleccion esta fuera del rango de nuestros" +
                                                "productor");
                                    }
                                    }
                                    while (salir==999);
                            }else if (opcion ==4){

                                System.out.println("Ventas Realizadas");
                                for (int indice=0; indice<comprasList.size();indice++){
                                    int ventasTotales=0;
                                    int v = comprasList.get(indice).getValorProducto();
                                    System.out.print(comprasList.get(indice).getNombreProducto()+" vendido "+
                                            comprasList.get(indice).getTotal()+" valor total de "+v);
                                    System.out.println(v);
                                    v+=ventasTotales;
                                    System.out.println(ventasTotales);


                                }
                            }
                        }while (opcion!=999);
                    }else {
                        System.out.println("contraseña incorrecta");
                    }
                }

            }else{
                System.out.println("Bienvenido Usuario");
            }





    }



}
