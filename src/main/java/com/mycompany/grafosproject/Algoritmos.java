/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafosproject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author marti
 */
public class Algoritmos {
    
    
    //Metodo BFS
    public void BFS (int inicio, Grafo grafo){
        
        //Validación
        if(inicio<0 || inicio>=grafo.getNumeroLugares()){
            System.out.println("El lugar con ID: " + inicio + " no existe.");
            return;
        }
        
        //Se crea una cola (FIFO - Firts In, First Out)
        Queue <Integer> cola = new LinkedList<>();
        /*
        Se realiza un arreglo de booleanos que nos indica verdadero o falso para cada lugar del campus. Se le asigna el tamaño de la lista de nombres,
        y al crearlo de este modo todas sus casillas empiezan con automaticamente el valor de false
        */
        boolean[]  visitados = new boolean[grafo.getNumeroLugares()];
        visitados[inicio]=true; //Punto de partida
        cola.add(inicio);
        System.out.println("Recorrido BFS desde " + grafo.getNombres().get(inicio) + ":");
        
        while (!cola.isEmpty()){
            int actual = cola.poll(); //El elemento sale de la cola y queda guardado en actual
            System.out.println("ID: " + actual + " ; "  + grafo.getNombres().get(actual));
            ArrayList<Integer> vecinos = grafo.getListaAdyacencia().get(actual);
            for (int vecino: vecinos){
                if(visitados[vecino] == false){
                    visitados[vecino]=true;
                    cola.add(vecino);
                }
            }       
        }
    }
    
//    //Metodo DFS (Implementado por Jorge Bernal)
    public void DFS(int inicio, Grafo grafo){

        //Validación: el id debe existir
        if (inicio < 0 || inicio >= grafo.getNumeroLugares()){
            System.out.println("El lugar con ID " + inicio + " no existe");
            return;
        }

        //Registro de visitados: todo empieza en false
        boolean[] visitados = new boolean[grafo.getNumeroLugares()];

        System.out.println("Recorrido DFS desde " + grafo.getNombres().get(inicio) + ":");
        auxDFS(grafo, inicio, visitados);
    }

    // Metodo privado que se llama a sí mismo (recursividad)
    private  void auxDFS(Grafo grafo, int actual, boolean[] visitados){

        //1. Marcar el lugar actual como visitado
        visitados[actual] = true;

        //2. Registrarlo (mostrarlo)
        System.out.println("ID: " + actual + " ; "  + grafo.getNombres().get(actual));

        //3. Llamarse con cada vecino que no se haya visitado
        for (int vecino : grafo.getListaAdyacencia().get(actual)){
            if (!visitados[vecino]){
                auxDFS(grafo, vecino, visitados);
            }
        }
    }
    
    //Metodo para encontrar la ruta más optima entre dos lugares
    public void buscarRuta(int origen, int destino, Grafo grafo) {
        
        if(origen<0 || origen >= grafo.getNumeroLugares()) {
            System.out.println("El lugar con ID: " + origen + " no existe.");
            return;
        }
        
        if (destino<0 || destino >= grafo.getNumeroLugares()){
            System.out.println("El lugar con ID: " + destino + " no existe.");
            return;
        }
        
        if (origen == destino){
            System.out.println("El origen y el destino son los mismos, la ruta es solo ese lugar");
            return;
        }
                
        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitados = new boolean[grafo.getNumeroLugares()];
        int[] predecesores = new int[grafo.getNumeroLugares()];
        for (int predecesor = 0; predecesor < predecesores.length; predecesor++) {
            predecesores[predecesor] = -1;
        }
        visitados[origen] = true;
        cola.add(origen);
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            ArrayList<Integer> vecinos = grafo.getListaAdyacencia().get(actual);
            for (int vecino : vecinos) {
                if (visitados[vecino] == false) {
                    visitados[vecino] = true;
                    predecesores[vecino] = actual;
                    cola.add(vecino);
                }
            }

        }
        
        //Validación por si la ruta no es alcanzable
        if(predecesores[destino] == -1){
            System.out.println("El destino no tiene una ruta alcanzable");
            return;
        }
        
        //Ordenar el orden más corto para llegar al destino
        int temp = destino;
        ArrayList<Integer> ruta = new ArrayList<>();
        while (temp != -1) {
            ruta.add(0, temp);
            temp = predecesores[temp];
        }
        
        //Imprimir
        System.out.println("La mejor ruta para llegar a " + grafo.getNombres().get(destino) + " es: ");
        for (int i =0; i<ruta.size();i ++){
            int lugar=ruta.get(i);
            System.out.print(grafo.getNombres().get(lugar));
            if (i < ruta.size()-1){
                System.out.print(" -> ");
            }
                
        }
        System.out.println();
    }
}
