/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grafosproject;
import java.util.ArrayList;
/**
 *
 * @author marti
 */
public class Grafo {
    //Atributos
    private ArrayList<String> nombres;
    private ArrayList<ArrayList<Integer>> listaAdyacencia;

    
    //Constructor
    public Grafo() {
             this.nombres=new ArrayList<String>();
this.listaAdyacencia=new ArrayList<ArrayList<Integer>>();

    }
    
    //Metodos
    
    //Metodo agregarLugar
    public void agregarLugar(String nombre){
        
        nombres.add(nombre);
        listaAdyacencia.add(new ArrayList<Integer>());
                    
    }
    
    //Metodo agregarConexion
    
    public void agregarConexion(int origen, int destino){
        //La lista de adyacencia ya tiene el espacio creado cuando se añade el nombre
        listaAdyacencia.get(origen).add(destino);
        listaAdyacencia.get(destino).add(origen);
    }
    
    //Metodo que muestra el identificador y el nombre de todos los lugares.
    public void listaLugares(){
        int i = 0;
        for (String nombre: nombres){          
            System.out.println("ID: " + i  + " ; "  + nombre );
            i+=1;
        }
    }
    
    //Metodo que muestra conexiones de un lugar
    public void mostrarConexiones(int ID){
        
        ArrayList <Integer> vecinos = listaAdyacencia.get(ID);

        //Por cada vecino de tipo int de la lista vecinos
        for (int vecino: vecinos) {
            System.out.println(nombres.get(vecino));
        }
        
    }
}
