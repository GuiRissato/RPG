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
     int nivel = 0;
     int tamMapa = 0;
     
     
    /**
     *
     * @param args
     */
//inicializador das variaveis e do projeto
       public static void main(String[] args){
        frmMenu menu = new frmMenu();
        menu.setVisible(true);
        
    } 
    //inicializador das variaveis e do projeto
    public void inicializador(){
    this.mochila = new Stack<>();
    this.vetHeroi = new ArrayList<>();
    this.vetInimigo = new ArrayList<>();
    this.vetArmas = new ArrayList<>();
    this.vetPocoes = new ArrayList<>();
    this.cintoHeroi = new int[4];
    setPocao("elixir vitae", 1.3, 2);
    setPocao("forca",1.2,3);
    setPocao("defesa",0.8,1);
    setArma("espada longa",17,3);
    setArma("adaga",13,1);
    setArma("besta",14,2);
    setArma("clave",20,2);
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
            System.out.println("nao existe elementos na mochila");
        }
}
    public void setHeroi(String nome, Double vida){
        vetHeroi.add(new classHeroi(nome,vida));
    }
    public void setCinto(int objeto,int posicao){
        cintoHeroi[posicao] = objeto;
//        fazer verificacao qnd estiver cheio
    }
    public void setInimigo(String nome, Double ataque, Double multi){
        int cod = codInimigo;
        Double vida = vetHeroi.get(0).vida*multi;
        vetInimigo.add(new classInimigos(cod,nome,ataque,vida));
        codInimigo++;
    }
    public void setArma(String nome, int ataque, int peso){
         int cod = codArmas;
        vetArmas.add(new classArmas(cod,nome,ataque,peso));
        codArmas++;
    }
    public void setPocao(String nome, double cura, int peso){
        int cod = codPocoes;
        vetPocoes.add(new classPocoes(cod,nome,cura,peso));
        codPocoes++;
    }
    public int numAleatorioIntevalo(int max,int min){
    int num;
    Random aleatorio = new Random();
    num = aleatorio.nextInt((max - min) + 1)+ min;
        
        return num;
    }
    
    public void mapa(){
          int tipo =  numAleatorioIntevalo(3,1);
          fases(tipo);
    }
    public void nivel(int i){
      nivel = i;
      tamMapa = 5;
      
    }
    
    public void fases(int i){
         switch (i) {
             case 1:
                 faseInimigo();
                 break;
             case 2:
                 faseVazio();
                 break;
             case 3:
                 faseElemento();
                 break;
         }
    }
   public void faseInimigo(){
   
   }
   public void faseVazio(){
   
   }
   public void faseElemento(){
   
   }
}
