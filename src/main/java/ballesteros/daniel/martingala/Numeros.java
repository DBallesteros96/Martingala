/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ballesteros.daniel.martingala;

/**
 *
 * @author Dani
 */
public class Numeros {

    private int numero;
    private String color;

    public Numeros(int numero) {
        this.numero = numero;
        if (numero == 0) {
            this.color = "Verde";
        } else {
            if (numero % 2 == 0) {
                this.color = "Rojo";
            } else {
                this.color = "Negro";
            }
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public String getColor() {
        return this.color;
    }

}
