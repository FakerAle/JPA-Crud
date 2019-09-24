package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.ecodeup.model.Producto;

public class MainApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Producto producto;
		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion != 5) {
			String menu="";
			menu+="1. Crear Producto\n";
			menu+="2. Buscar Producto\n";
			menu+="3. Actualizar Producto\n";
			menu+="4. Eliminar Producto\n";
			menu+="5. Salir\n";
			menu+="Elija una opción:";
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			String nombre;
			double precio;
			switch (opcion) {

			case 1:
				producto = new Producto();
				producto.setId(null);
				nombre= JOptionPane.showInputDialog("Digite el nombre del producto:");
				producto.setNombre(nombre);
				precio= Double.parseDouble(JOptionPane.showInputDialog("Digite el precio del producto:"));
				producto.setPrecio(precio);
				JOptionPane.showMessageDialog(null, "Producto resgitrado");
				entity.getTransaction().begin();
				entity.persist(producto);
				entity.getTransaction().commit();
				break;

			case 2:
				Long id =Long.parseLong(JOptionPane.showInputDialog("Digite el id del producto a buscar:"));
				producto = new Producto();
				producto = entity.find(Producto.class, id);
				if (producto != null) {
					JOptionPane.showMessageDialog(null,producto);
				} else {
					JOptionPane.showMessageDialog(null,"Producto no encontrado... Vuelve a buscar");
					List<Producto> listaProductos = new ArrayList<Producto>();
					Query query = entity.createQuery("SELECT p FROM Producto p");
					listaProductos = query.getResultList();
					for (Producto p : listaProductos) {
						/*  La informacion de la lista no es complatible con el usuario,
						se deja en consola  */
						System.out.println(p);
					}
					System.out.println();
				}
				break;
				
			case 3:
				Long id2=Long.parseLong(JOptionPane.showInputDialog("Digite el id del producto a actualizar:"));
				producto = new Producto();
				producto = entity.find(Producto.class, id2);
				if (producto != null) {
					JOptionPane.showMessageDialog(null, producto);
					String nombre2= JOptionPane.showInputDialog("Digite el nombre del producto:");
					producto.setNombre(nombre2);
					double precio2=Double.parseDouble(JOptionPane.showInputDialog("Digite el precio del producto:"));
					producto.setPrecio(precio2);
					entity.getTransaction().begin();
					entity.merge(producto);
					entity.getTransaction().commit();
					JOptionPane.showMessageDialog(null, "Producto actualizado..");
				} else {
					JOptionPane.showMessageDialog(null, "Producto no encontrado....");
			
				}
				break;
				
			case 4:
				Long id3=Long.parseLong(JOptionPane.showInputDialog("Digite el id del producto a eliminar:"));
				producto = new Producto();
				producto = entity.find(Producto.class, id3);
				if (producto != null) {
					JOptionPane.showMessageDialog(null,producto);
					entity.getTransaction().begin();
					entity.remove(producto);
					entity.getTransaction().commit();
					JOptionPane.showMessageDialog(null,"producto eliminado");
				} else {
					JOptionPane.showMessageDialog(null,"Producto no encontrado...");
				}
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, "Adios, Gracias por utilizar nuestra app");
				entity.close();
				JPAUtil.shutdown();
				break;
			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}
}