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
}
