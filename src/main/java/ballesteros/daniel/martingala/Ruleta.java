/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ballesteros.daniel.martingala;

/**
 *
 * @author Dani
 */
public class Ruleta {
    
    private Numeros []arrayNumeros = new Numeros[37];
    
    public Ruleta (){
        for (int i = 0; i <= 36; i++){
            arrayNumeros[i] = new Numeros(i);
        }
    }
    
    public String girar(){
        int numeroObtenido = (int) Math.floor(Math.random()*37);
        
        return arrayNumeros[numeroObtenido].getColor();

    }
    
}
