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
     public Stack<String> mochila;
     List<classHeroi> vetHeroi;
     List<classInimigos> vetInimigo;
     List<classArmas> vetArmas ;
     List<classPocoes> vetPocoes;
     String vetInfoI[];
     String vetInfoE[];
     static Trabalho2 inic = new Trabalho2();
     int cintoHeroi[];
     int codInimigo = 0;
     int codPocoes = 0;
     int codArmas = 0;
     int nivel = 0;
     int tamMapa = 0;
     int nivelI = 1;
     int mapaJ = 1;
     Double vidaInicial;
     public String inimigoItem;
     public int codArmaMao;
     public String nivelFrm;
     public String tipoNivel;
     
     
     
     
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
    this.cintoHeroi = new int[5];
    setPocao("elixir vitae", 1.3, 2);
    setPocao("força",1.2,3);
    setPocao("defesa",0.8,1);
    setArma("espada longa",17,3);
    setArma("adaga",13,1);
    setArma("besta",14,2);
    setArma("clave",20,2);
    }
//    coloca items na mochila
    public void pushMochila(String nome){
        mochila.push(nome);   
    }
//    retira o ultimo item colocado na mochila
    public void popMochila(){
        mochila.pop();
        
    }
    public void setHeroi(String nome, Double vida){
        vetHeroi.add(new classHeroi(nome,vida));
        vidaInicial = vida;
    }
    public void setCinto(int objeto,int posicao){
        cintoHeroi[posicao] = objeto;
//        fazer verificacao qnd estiver cheio
    }
    public void setInimigo(String nome, Double ataque, Double multi){
        int cod = codInimigo;
        Double vida = vetHeroi.get(0).vida*multi;
        Double forca = vetHeroi.get(0).vida*ataque;
        vetInimigo.add(new classInimigos(cod,nome,forca,vida));
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
      int g = numAleatorioIntevalo(3,1);
      nivelFrm = "Nivel: " + nivelI + " - " + mapaJ; 
      fases(g);
      mapaJ++;
      if(mapaJ == 5){
          nivelI++;
          mapaJ =0;
      }
      if(nivelI > nivel){
          GameOver();
      }
    }
    public void nivel(int i){
      nivel = i;
      tamMapa = 5;
      
    }
    
    public void fases(int i){
         switch (i) {
             case 1:
                 faseInimigo();
                 tipoNivel = "Nivel Inimigo" ;
                 break;
             case 2:
                 faseVazio();
                 tipoNivel = "Nivel Vazio";
                 break;
             case 3:
                 faseElemento();
                 tipoNivel = "Nivel Elementos";
                 break;
         }
    }
   public void faseInimigo(){
      int i =  numAleatorioIntevalo(4,0);
      vetInfoI = new String[3]; 
      vetInfoI[0] = vetInimigo.get(i).nome;
      vetInfoI[1] = String.valueOf(vetInimigo.get(i).vida);
      vetInfoI[2] = String.valueOf(vetInimigo.get(i).ataque);
      inimigoItem = "Inimigo: " + vetInfoI[0];
      
      
      
   }
   public void faseVazio(){
      
   }
   
   public void faseElemento(){
      int i = numAleatorioIntevalo(3,0);
      vetInfoE = new String[6];
      vetInfoE[0] = vetArmas.get(i).nome;
      vetInfoE[1] = String.valueOf(vetArmas.get(i).ataque);
      vetInfoE[2] = String.valueOf(vetArmas.get(i).peso);
      i = numAleatorioIntevalo(2,0);
      vetInfoE[3] = vetPocoes.get(i).nome;
      vetInfoE[4] = String.valueOf(vetPocoes.get(i).cura);
      vetInfoE[5] = String.valueOf(vetPocoes.get(i).peso);
     inimigoItem = "Elementos: " + vetInfoE[0] + " e " + vetInfoE[3];
         
      
   }

    public void GameOver() {
        System.out.print("Acabou!!");
    }
}
