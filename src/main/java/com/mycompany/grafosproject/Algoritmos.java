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
        //Se crea una cola (FIFO - Firts In, First Out)
        Queue <Integer> cola = new LinkedList<>();
        /*
        Se realiza un arreglo de booleanos que nos indica verdadero o falso para cada lugar del campus. Se le asigna el tamaño de la lista de nombres,
        y al crearlo de este modo todas sus casillas empiezan con automaticamente el valor de false
        */
        boolean[]  visitados = new boolean[grafo.getNombres().size()];
        visitados[inicio]=true; //Punto de partida
        cola.add(inicio);
        
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
    
    //Metodo DFS
    public void DFS (int inicio, Grafo grafo){
        /*El metodo publico solo se limita a crear el arreglo de visitados de forma unica, para que no se reinicie
        el arreglo cada vez que se hace el llamado recursivo. A su vez llama el metodo auxDFS.
        */
        boolean [] visitados = new boolean[grafo.getNombres().size()]; 
        auxDFS(inicio, grafo, visitados);
    }
    
    //Auxiliar para el metodo DFS, es private porque solo se utilizara dentro de la clase.
    //Al usar recursividad la pila del metodo DFS la va generando java con cada llamado recursivo.
    private void auxDFS (int vertice, Grafo grafo, boolean[] visitados){
        visitados[vertice]=true;
        System.out.println("ID: " + vertice + " ; "  + grafo.getNombres().get(vertice));
        ArrayList<Integer> vecinos= grafo.getListaAdyacencia().get(vertice);
        for (int vecino: vecinos){
                if(visitados[vecino] == false){
                    auxDFS(vecino, grafo, visitados);
            }
        }

    }
    
    //Metodo para encontrar la ruta más optima entre dos lugares
    public void buscarRuta(int origen, int destino, Grafo grafo) {
        if (origen == destino){
            System.out.println("El origen y el destino son los mismos, la ruta es solo ese lugar");
            return;
        }
        Queue<Integer> cola = new LinkedList<>();
        boolean[] visitados = new boolean[grafo.getNombres().size()];
        int[] predecesores = new int[grafo.getNombres().size()];
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
