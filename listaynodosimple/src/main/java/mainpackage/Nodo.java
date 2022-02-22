/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;
import interfa.LinkedList;
import interfa.LinkedListNode;
/**
 *
 * @author juanp
 */
public class Nodo implements LinkedListNode{
    
    private Object valor;
    private Nodo next=null;
    
    public Nodo(Object valor){
        this.valor=valor;
    }
    public Object getvalor(){
        return valor;
    }
    public void setvalor(Object valor){
        this.valor=valor;
    }
    public Nodo getnext(){
        return next;
    }
    public void setnext(Nodo nodo){
        this.next=nodo;
    }
    public String ToString(){
        return valor.toString();
    }
    
    
}
