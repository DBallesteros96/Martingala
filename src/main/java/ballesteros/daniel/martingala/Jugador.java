/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ballesteros.daniel.martingala;

/**
 *
 * @author Dani
 */
public class Jugador {

    private String nombre;
    private int saldo;
    private String colorApuesta;

    public Jugador(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.colorApuesta = "";
    }

    public boolean apuesta(int cantidad) {
        if (cantidad > this.saldo) {
            System.out.println("No tiene dinero suficiente");
            return false;
        } else {
            this.saldo -= cantidad;
            return true;
        }
    }

    public void gana(int cantidadApostada) {
        this.saldo += (cantidadApostada * 2);
    }

    public void setColorApuesta(String color) {
        this.colorApuesta = color;
    }

    public String getColorApuesta() {
        return this.colorApuesta;
    }
    
    public int getSaldo(){
        return this.saldo;
    }
}
