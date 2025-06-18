package com.inventario;

import com.inventario.modelo.Marca;
import com.inventario.modelo.Producto;
import com.inventario.repositorio.MarcaRepository;
import com.inventario.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApp {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApp.class, args);
    }

    @Bean
    CommandLineRunner initData(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return args -> {
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");
            marcaRepo.save(apple);
            marcaRepo.save(samsung);

            productoRepo.save(new Producto("iPhone 15", "Smartphone Apple", 20000, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet Apple", 15000, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone Samsung", 18000, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisor Samsung", 10000, samsung));

            System.out.println("\n📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                        .filter(p -> p.getMarca().getId().equals(marca.getId()))
                        .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
