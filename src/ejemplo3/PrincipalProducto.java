package ejemplo3;


import ejemplo3.modelo.Producto;
import ejemplo3.repositorio.ProductoRepository;
import ejemplo3.repositorio.ProductoRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class PrincipalProducto {
    public static void main(String[] args) {
        String opc = "1";
        ProductoRepository repo = new ProductoRepositoryImpl();
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Agregar  \n 2. Listar \n 3. Editar " +
                    "\n 4. Eliminar  \n 5. Salir \n =>");
            opc = s.next();
            switch (opc) {
                case "1": {
                    System.out.println("Id producto: ");
                    Integer id = s.nextInt();
                    System.out.println("Nombre producto: ");
                    String nom = s.next();
                    System.out.println("categoria: ");
                    String cat = s.next();
                    System.out.println("cantidad: ");
                    double ca = s.nextDouble();
                    repo.save(new Producto(id,nom, cat, ca ));
                    break;
                }
                case "2": {
                    List<Producto> productos = repo.findAll();
                    productos.forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("===== editar ====");
                    System.out.print("id  producto: ");
                    Integer idp = s.nextInt();
                    System.out.print("ingrese nombre: ");
                    String nom = s.next();
                    System.out.print("ingrese categoria: ");
                    String cat = s.next();
                    System.out.print("ingrese cantidad: ");
                    double ca = s.nextDouble();
                    Producto beaActualizar = new Producto(idp, nom, cat, ca);
                    repo.update(beaActualizar);
                    break;
                }
                case "4": {
                    System.out.println("===== eliminar ======");
                    System.out.print("ingrese id del registro: ");
                    Integer id = s.nextInt();
                    repo.delete(repo.findById(id));
                    repo.findAll().forEach(System.out::println);
                    break;
                }
                case "5": {
                    opc = "5";
                    break;
                }
            }
        } while (opc != "5");
    }
    }

