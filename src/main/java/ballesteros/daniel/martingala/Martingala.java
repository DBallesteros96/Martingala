/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ballesteros.daniel.martingala;

import java.util.Scanner;

/**
 *
 * @author Dani
 */
public class Martingala {

    public static void main(String[] args) {

        String temporal;
        String ultimoColor;
        boolean continuaJugando = true;
        int contadorApuestas = 0;

        int cantidadApuesta;
        String resultadoApuesta;

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca el nombre del jugador: ");
        String nombreJugador = teclado.nextLine();

        do {
            System.out.print("Introduce el saldo inicial: ");
            temporal = teclado.nextLine();
        } while (!esEntero(temporal));

        int saldo = Integer.parseInt(temporal);

        Jugador usuario = new Jugador(nombreJugador, saldo);
        Ruleta ruleta = new Ruleta();

        while (continuaJugando) {

            ultimoColor = ruleta.girar();

            if (ruleta.girar().equals(ultimoColor)) {
                if (ultimoColor.equals("Verde")) {
                    continue;
                } else if (ultimoColor.equals("Negro")) {

                    cantidadApuesta = 1;
                    usuario.setColorApuesta("Rojo");
                    System.out.println("Han salido dos Negros seguidos.");
                    do {
                        if (usuario.apuesta(cantidadApuesta)) {
                            System.out.println("El usuario ha apostado " + cantidadApuesta + " euros al Rojo.");
                            contadorApuestas += 1;
                        } else {
                            //No tiene dinero suficiente para doblar la apuesta
                            continuaJugando = false;
                            break;
                        }

                        resultadoApuesta = ruleta.girar();
                        System.out.println("Ha salido " + resultadoApuesta);
                        if (resultadoApuesta == usuario.getColorApuesta()) {
                            usuario.gana(cantidadApuesta);
                            System.out.println("El usuario gana la apuesta. Tiene ahora " + usuario.getSaldo() + " euros.");
                        }
                        cantidadApuesta *= 2;
                    } while (resultadoApuesta != usuario.getColorApuesta());

                } else if (ultimoColor.equals("Rojo")) {
                    cantidadApuesta = 1;
                    usuario.setColorApuesta("Negro");

                    System.out.println("Han salido dos Rojos seguidos.");
                    do {
                        if (usuario.apuesta(cantidadApuesta)) {
                            System.out.println("El usuario ha apostado " + cantidadApuesta + " euros al Negro.");
                            contadorApuestas += 1;
                        } else {
                            //No tiene dinero suficiente para doblar la apuesta
                            continuaJugando = false;
                            break;
                        }
                        resultadoApuesta = ruleta.girar();
                        System.out.println("Ha salido " + resultadoApuesta);
                        if (resultadoApuesta == usuario.getColorApuesta()) {
                            usuario.gana(cantidadApuesta);
                            System.out.println("El usuario gana la apuesta. Tiene ahora " + usuario.getSaldo() + " euros.");
                        }
                        cantidadApuesta *= 2;
                    } while (resultadoApuesta != usuario.getColorApuesta());
                }

            }

        }
        System.out.println("El usuario se ha quedado con " + usuario.getSaldo() + " euros.");
        System.out.println("El usuario ha apostado " + contadorApuestas + " veces.");
    }

    public static boolean esEntero(String texto) {
        int valorEntero;
        try {
            valorEntero = Integer.parseInt(texto);
            return true;

        } catch (NumberFormatException error) {
            System.err.println("Introduzca un número entero.");
            return false;
        }

    }
}
