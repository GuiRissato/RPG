/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Rissato
 */
public class Trabalho2 {

    /**
     */
     public Stack<String> mochila;
     List<classHeroi> vetHeroi;
     List<classInimigos> vetInimigo;
     List<classArmas> vetArmas ;
     List<classPocoes> vetPocoes;
     String vetInfoI[];
     String vetInfoE[];
     static Trabalho2 inic = new Trabalho2();
     Vector<String> cintoHeroi;
     int codInimigo = 0;
     int codPocoes = 0;
     int codArmas = 0;
     int nivel = 0;
     int nivelI = 1;
     int mapaJ = 1;
     int posicao = 0;
     int pesoCinto = 0;
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
    this.cintoHeroi = new Vector<String>();
    setPocao("elixir vitae", 1.3, 2);
    setPocao("força",1.2,3);
    setPocao("defesa",0.8,1);
    setArma("espada longa",17.0,3);
    setArma("adaga",13.0,1);
    setArma("besta",14.0,2);
    setArma("clave",20.0,2);
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
    public void setCinto(String objeto){
        cintoHeroi.add(objeto);
           
    }
          
    
    public void setInimigo(String nome, Double ataque, Double multi){
        int cod = codInimigo;
        Double vida = vetHeroi.get(0).vida*multi;
        Double forca = vetHeroi.get(0).vida*ataque;
        vetInimigo.add(new classInimigos(cod,nome,forca,vida));
        codInimigo++;
    }
    public void setArma(String nome, Double ataque, int peso){
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
      if(mapaJ == 5){
          nivelI++;
          mapaJ =1;
      }
      mapaJ++;
    }
    public void nivel(int i){
      nivel = i;
      
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
   
   public void usarPocao(String nome, String armaMao){
  
//    setPocao("elixir vitae", 1.3, 2);
//    setPocao("força",1.2,3);
//    setPocao("defesa",0.8,1);

           if(nome.equals(vetPocoes.get(0).nome)){
               Double vida =  vetHeroi.get(0).vida;
               vida = vida*(vetPocoes.get(0).cura);
               vetHeroi.get(0).vida = vida;
           }else if(nome.equals(vetPocoes.get(1).nome)){
               for(int i = 0; i< vetArmas.size();i++){
                   if(armaMao.equals(vetArmas.get(i).nome)){
                      Double dano = vetArmas.get(i).ataque*vetPocoes.get(1).cura;
                      vetArmas.get(i).ataque = dano;
                   }
               }
           }else if(nome.equals(vetPocoes.get(2).nome)){
               Double vida = vetHeroi.get(0).vida + 20;
               vetHeroi.get(0).vida = vida;
           }
       
   }

   public void pesoCinto(){
       int peso = 0; 
       for(int i = 0; i < cintoHeroi.size(); i++){
           for(int j = 0; j < vetArmas.size();j++){
           if(cintoHeroi.get(i) == vetArmas.get(j).nome){
               peso = peso + vetArmas.get(j).peso;
           }
       }
       }
       for(int i = 0; i < cintoHeroi.size(); i++){
           for(int j = 0; j < vetPocoes.size();j++){
           if(cintoHeroi.get(i) == vetPocoes.get(j).nome){
               peso = peso + vetPocoes.get(j).peso;
           }
       }
       }
       if(peso > 7){
            JOptionPane.showMessageDialog(null, "O cinto está muito pesado para colocar algum item!!");
       }
       
   }
   public void capacidadeCinto(){
       if(cintoHeroi.size() >= 5){
           JOptionPane.showMessageDialog(null, "O cinto está cheio!!");
       }
   }
   
    public void GameOver() {
        if(vetHeroi.get(0).vida <= 0){
            JOptionPane.showMessageDialog(null, "Você morreu, o jogo acabou!!");
            System.exit(0);
        }else if(nivelI == nivel+1){
            JOptionPane.showMessageDialog(null, "Você Venceu!!");
            System.exit(0);
        }
        
    }
}
