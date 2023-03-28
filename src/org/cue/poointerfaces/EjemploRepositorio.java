package org.cue.poointerfaces;

import org.cue.poointerfaces.modelo.Cliente;
import org.cue.poointerfaces.repositorio.ClienteListRepositorio;
import org.cue.poointerfaces.repositorio.Direccion;
import org.cue.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;

import java.util.List;
import java.util.Scanner;

public class EjemploRepositorio {
    public static void main(String[] args) {
        String op = "1";
        OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Agregar  \n 2. Listar \n 3. Ordenar \n 4. Editar " +
                    "\n 5. elliminar \n 6. Contar \n 7. salir \n =>");
            op = s.next();
            switch (op) {
                case "1": {
                    System.out.println("ingrese nombre: ");
                    String nom = s.next();
                    System.out.println("ingrese apellido: ");
                    String ape = s.next();
                    repo.crear(new Cliente(nom, ape));
                    break;
                }
                case "2": {
                    List<Cliente> clientes = repo.listar();
                    clientes.forEach(System.out::println);
                    System.out.println("===== paginable =====");
                    List<Cliente> paginable = repo.listar(1, 1);
                    paginable.forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("===== ordenar =====");
                    List<Cliente> clientesOrdenAsc = repo.listar("apellido", Direccion.ASC);
                    for (Cliente c : clientesOrdenAsc) {
                        System.out.println(c);
                    }
                    break;
                }

                case "4": {
                    System.out.println("===== editar =====");
                    System.out.println("ingrese id del registro: ");
                    Integer id = s.nextInt();
                    System.out.println("ingrese nombre: ");
                    String nom = s.next();
                    System.out.println("ingrese apellido: ");
                    String ape = s.next();
                    Cliente beaActualizar = new Cliente(nom, ape);
                    beaActualizar.setId(id);
                    repo.editar(beaActualizar);
                    break;
                }
                case "5": {
                    System.out.println("===== eliminar ======");
                    System.out.println("ingrese id del registro: ");
                    Integer id = s.nextInt();
                    repo.eliminar(id);
                    repo.listar().forEach(System.out::println);
                    break;
                }
                case "6": {
                    System.out.println("===== total ===== ");
                    System.out.println("Total registros: " + repo.total());
                    break;
                }
                case "7": {
                    op = "7";
                    break;
                }
            }
        } while (op != "7");
    }
}
