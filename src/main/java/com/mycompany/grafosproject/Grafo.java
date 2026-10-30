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
        
        //Validación si La lista de adyacencia está vacia
        if (listaAdyacencia.isEmpty()){
            System.out.println("No hay lugares agregados en el campus");
            return;
        }
        
        ArrayList <Integer> vecinos = listaAdyacencia.get(ID);
        
        //Validación si el lugar tiene conexiones.
        if(vecinos.isEmpty()){
            System.out.println(nombres.get(ID) + " no tiene conexiones");
            return;
        }

        System.out.println(nombres.get(ID) + " tiene las siguientes conexiones: ");
        //Por cada vecino de tipo int de la lista vecinos
        for (int vecino: vecinos) {
            System.out.println(" - " + nombres.get(vecino));
        }
        
    }

    //Getters
    
    //getNombres
    public ArrayList<String> getNombres() {
        return nombres;
    }
    //getListaAdyacencia
    public ArrayList<ArrayList<Integer>> getListaAdyacencia() {
        return listaAdyacencia;
    }
    
    
}
