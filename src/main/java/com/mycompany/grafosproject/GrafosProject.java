/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafosproject;

/**
 *
 * @author marti
 */
public class GrafosProject {

    public static void main(String[] args) {
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
        
        campus.listaLugares();
        campus.mostrarConexiones(0);
        campus.mostrarConexiones(8);
        
        System.out.println("Metodo BFS");
        algoritmos.BFS(0, campus);
        System.out.println("Metodo DFS");
        algoritmos.DFS(0, campus);
    }
}
