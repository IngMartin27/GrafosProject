/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafosproject;
import java.util.Scanner;
/**
 *
 * @author marti
 */
public class GrafosProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Grafo campus = new Grafo();
        Algoritmos algoritmos = new Algoritmos ();
        //Agregar lugares
        campus.agregarLugar("Entrada Principal");
        campus.agregarLugar("Biblioteca");
        campus.agregarLugar("Bloque A");
        campus.agregarLugar("Cafeteria");
        campus.agregarLugar("Laboratorio de Sistemas");
        campus.agregarLugar("Auditorio");
        campus.agregarLugar("Zona Deportiva");
        campus.agregarLugar("Parqueadero");
        campus.agregarLugar("Bodega");
        
        
        //Agregar conexiones
        campus.agregarConexion(0, 1);
        campus.agregarConexion(0, 2);
        campus.agregarConexion(0, 3);
        campus.agregarConexion(0, 7);
        campus.agregarConexion(1, 2);
        campus.agregarConexion(1, 3);
        campus.agregarConexion(2, 4);
        campus.agregarConexion(3, 5);
        campus.agregarConexion(4, 5);
        campus.agregarConexion(5, 6);
        
        //Menu interactivo
        System.out.println(" --- Bienvenido al menu para navegar en el Campus Universitario --- ");
        int opcion=0;
        do{
            System.out.println("Elige una opcion entre las siguientes: ");
            System.out.println("1 - Listar los lugares del Campus Universitario. "
                    + "\n2 - Ver conexiones de un sitio del Campus Universitario. "
                    + "\n3 - Hacer un recorrido BFS. "
                    + "\n4 - Hacer un recorrido DFS. "
                    + "\n5 - Calcular la ruta mas corta para llegar a un lugar del campus. "
                    + "\n6 - Salir del menu.");
            System.out.print("Elige una opcion: ");
            try{
                opcion = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                opcion=-1; //Fuerza a entrar al default del switch            
        }
            
            switch(opcion){
                case 1:
                    System.out.println("Mostrando Lugares: ");
                    campus.listaLugares();
                    System.out.println();
                    break;
                    
                case 2:
                    System.out.println("Mostrando conexiones: ");
                    System.out.println("Ingresa el ID del sitio al cual deseas ver las conexiones: ");
                    try{
                        int ID = Integer.parseInt(input.nextLine());
                        campus.mostrarConexiones(ID);
                    }catch(NumberFormatException e){
                        System.out.println("El ID debe ser un numero entero.");
                    }
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.println("Ejecutando recorrido BFS: ");
                    System.out.println("Ingresa el ID del punto de partida con el que quieres hacer el recorrido BFS: ");
                    try{
                        int inicio = Integer.parseInt(input.nextLine());
                        algoritmos.BFS(inicio,campus);
                    }catch(NumberFormatException e){
                        System.out.println("El ID debe ser un numero entero.");
                    }
                    System.out.println();
                    break;
                    
                case 4:
                    System.out.println("Ejecutando recorrido DFS: ");
                    System.out.println("Ingresa el ID del punto de partida con el que quieres hacer el recorrido DFS: ");
                    try{
                        int begin = Integer.parseInt(input.nextLine());
                        algoritmos.DFS(begin, campus);
                    }catch(NumberFormatException e){
                        System.out.println("El ID debe ser un numero entero.");
                    }
                    System.out.println();
                    break;
                
                case 5:
                    System.out.println("Ejecutando la ruta mas corta para llegar a un lugar: ");
                    System.out.println("Ingesa el ID del punto de partida: ");
                    try{
                        int init = Integer.parseInt(input.nextLine());
                        System.out.println("Ingresa el ID del lugar al cual deseas llegar en el campus: ");
                        int end = Integer.parseInt(input.nextLine());
                        algoritmos.buscarRuta(init, end, campus);
                    }catch(NumberFormatException e){
                        System.out.println("El ID debe ser un numero entero.");
                    }
                    System.out.println();
                    break;
                    
                case 6:
                    System.out.println("Saliendo del programa, hasta la proxima estudiante !!! :D");
                    break;
                
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
                    System.out.println();
                    break;
            }
            
        } while(opcion!=6);
    }
}
