/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;

import java.util.Stack;

/**
 *
 * @author Guilherme Rissato
 */
public class Trabalho2 {

    /**
     * @param args the command line arguments
     */
     public Stack<Integer> mochila;
     static Trabalho2 inic = new Trabalho2();
     //inicializador das variaveis e do projeto

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        frmMenu menu = new frmMenu();
        menu.setVisible(true);
    }
    
    public void inicializador(){
    this.mochila = new Stack<>();
        
       
    }
  
  
//    coloca items na mochila
    public void pushMochila(int cod){
        mochila.push(cod);
        
    }
//    retira o ultimo item colocado na mochila
    public void popMochila(){
        mochila.pop();
        
    }
    
    private void printStack(Stack<Integer> s){
        if (s.isEmpty()){
            System.out.println("you have nothing on your stack");
        }else{
         System.out.printf("%s TOP\n", s);
        }
    
}
}
