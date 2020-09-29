/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;
import java.util.*;

/**
 *
 * @author Guilherme Rissato
 */
public class Trabalho2 {

    /**
     * @param args the command line arguments
     */
     public Stack<Integer> mochila;
     List<classHeroi> vetHeroi;
     List<classInimigos> vetInimigo;
     List<classArmas> vetArmas ;
     List<classPocoes> vetPocoes;
     static Trabalho2 inic = new Trabalho2();
     int cintoHeroi[];
     int codInimigo = 0;
     int codPocoes = 0;
     int codArmas = 0;
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
    this.vetHeroi = new ArrayList<>();
    this.vetInimigo = new ArrayList<>();
    this.vetArmas = new ArrayList<>();
    this.vetPocoes = new ArrayList<>();
    this.cintoHeroi = new int[4];
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
//        if (s.isEmpty()){
//            System.out.println("you have nothing on your stack");
//        }else{
//         System.out.printf("%s TOP\n", s);
//        }
    
}
    public void setHeroi(String nome, int vida){
        vetHeroi.add(new classHeroi(nome,vida));
    }
    
    public void setCinto(int objeto,int posicao){
        cintoHeroi[posicao] = objeto;
//        fazer verificacao qnd estiver cheio
    }
    
    public void setInimigo(String nome, int ataque, int vida){
        int cod = codInimigo;
        vetInimigo.add(new classInimigos(cod,nome,ataque,vida));
        codInimigo++;
    }
     public void setArma(String nome, int ataque, int peso){
         int cod = codArmas;
        vetArmas.add(new classArmas(cod,nome,ataque,peso));
        codArmas++;
    }
      public void setPocao(String nome, int cura, int peso){
        int cod = codPocoes;
        vetPocoes.add(new classPocoes(cod,nome,cura,peso));
        codPocoes++;
    }
    
}
