package com.gregorio.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gregorio.course.entities.Category;
import com.gregorio.course.entities.Order;
import com.gregorio.course.entities.OrderItem;
import com.gregorio.course.entities.Product;
import com.gregorio.course.entities.User;
import com.gregorio.course.entities.enums.OrderStatus;
import com.gregorio.course.repositories.CategoryRepository;
import com.gregorio.course.repositories.OrderItemRepository;
import com.gregorio.course.repositories.OrderRepository;
import com.gregorio.course.repositories.ProductRepository;
import com.gregorio.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// INJEÇÃO DE DEPENDÊNCIA USER REPOSITORY
	@Autowired
	private UserRepository userRepository;

	// INJEÇÃO DE DEPENDÊNCIA ORDER REPOSITORY
	@Autowired
	private OrderRepository orderRepository;

	// INJEÇÃO DE DEPENDÊNCIA CATEGORY REPOSITORY
	@Autowired
	private CategoryRepository categoryRepository;

	// INJEÇÃO DE DEPENDÊNCIA PRODUCT REPOSITORY
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		// PRÉ-POPULANDO O BANCO DE DADOS COM CATEGORIAS;
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Computers");
		Category cat3 = new Category(null, "Books");
		Category cat4 = new Category(null, "Furnitures");

		// PRÉ-POPULANDO O BANCO DE DADOS COM PRODUTOS;
		Product p1 = new Product(null, "The Lord Of the Rings", "Lorem Ipsum dolor sit amet...", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Philco", 1200.99, "");
		Product p3 = new Product(null, "MacBook Pro", "Apple Computer", 5029.90, "");
		Product p4 = new Product(null, "PC Gamer", "Computador para jogos", 950.89, "");
		Product p5 = new Product(null, "Apple Watch", "Smart Watch - Apple", 2000.00, "");

		// SALVAR NO BANCO DE DADOS
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// RELACIONANDO OS PRODUTOS COM SUAS RESPECTIVAS CATEGORIAS;
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat2);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat1);

		// SALVANDO OS PRODUTOS COM SUAS ASSOCIAÇÕES;
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// PRÉ-POPULANDO O BANCO DE DADOS COM USUÁRIOS;
		User u1 = new User(null, "Arnold Swhaznegger", "arnoldbomberman@gmail.com", "85998765432", "admin");
		User u2 = new User(null, "Silverster Stalonne", "rambo@gmail.com", "82973265432", "admin2");
		User u3 = new User(null, "Aaron Rodgers", "aarongreenbay@packers.com", "5519876543", "admin3");
		User u4 = new User(null, "Tom Brady", "tom@tampa.com", "123456789", "admin4");
		User u5 = new User(null, "Russel Wilson", "wilson@seahawlcks", "5466356356", "admin4");
		User u6 = new User(null, "Patrick Mahomes", "mahomespatrick@chiefs.com", "098949323004", "adim5");
		User u7 = new User(null, "Josh Allen", "josh@gmail.com", "3425436346352", "admin6");

		// PRÉ-POPULANDO O BANCO DE DADOS COM PEDIDOS;
		Order o1 = new Order(null, Instant.parse("2021-12-31T19:53:25Z"), OrderStatus.PAID, u1); // ISO-8601
		Order o2 = new Order(null, Instant.parse("2021-12-31T16:25:12Z"), OrderStatus.WAITING_PAYMENT, u3); // ISO-8601
		Order o3 = new Order(null, Instant.parse("2021-12-30T15:47:33Z"), OrderStatus.SHIPPED, u2); // ISO-8601
		Order o4 = new Order(null, Instant.parse("2021-12-29T22:55:28Z"), OrderStatus.CANCELED, u7); // ISO-8601

		// SALVAR NO BANCO DE DADOS
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p4.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p1.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

	}
}

//DATABASE SEEDING (POPULAR BANCO DE DADOS)