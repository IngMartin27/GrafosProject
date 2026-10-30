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
        Grafo grafo1 = new Grafo();
        
        //Agregar lugares
        grafo1.agregarLugar("Entrada Principal");
        grafo1.agregarLugar("Biblioteca");
        grafo1.agregarLugar("Bloque A");
        grafo1.agregarLugar("Cafeteria");
        grafo1.agregarLugar("Laboratorio de Sistemas");
        grafo1.agregarLugar("Auditorio");
        grafo1.agregarLugar("Zona Deportiva");
        grafo1.agregarLugar("Parqueadero");
        grafo1.agregarLugar("Bodega");
        
        
        //Agregar conexiones
        grafo1.agregarConexion(0, 1);
        grafo1.agregarConexion(0, 2);
        grafo1.agregarConexion(0, 3);
        grafo1.agregarConexion(0, 7);
        grafo1.agregarConexion(1, 2);
        grafo1.agregarConexion(1, 3);
        grafo1.agregarConexion(2, 4);
        grafo1.agregarConexion(3, 5);
        grafo1.agregarConexion(4, 5);
        grafo1.agregarConexion(5, 6);
        
        grafo1.listaLugares();
        grafo1.mostrarConexiones(0);
        grafo1.mostrarConexiones(8);
    }
}
