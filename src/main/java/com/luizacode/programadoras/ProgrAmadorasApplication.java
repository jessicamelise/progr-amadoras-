package com.luizacode.programadoras;

import com.luizacode.programadoras.models.Produto;
import com.luizacode.programadoras.models.Wishlist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class ProgrAmadorasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrAmadorasApplication.class, args);

		Produto p1 = new Produto("p1",Long.parseLong("1", 10));
		Produto p2 = new Produto("p2", Long.parseLong("2", 10));
		Produto p3 = new Produto("p3", Long.parseLong("3", 10));
		Produto p4 = new Produto("p4", Long.parseLong("4", 10));

		List<Produto> l1 = new ArrayList<>();
		List<Produto> l2 =  new ArrayList<>();

		l1.add(p1);
		l1.add(p2);

		l2.add(p3);
		l2.add(p4);


//		System.out.println("Lista 1");
//		for(int i=0; i< l1.size();i++){
//			System.out.println(l1.get(i).getDetalheDoProduto());
//		}
//		System.out.println("Lista 2");
//		for(int i=0; i< l2.size();i++){
//			System.out.println(l2.get(i).getDetalheDoProduto());
//		}


		Wishlist w1 = new Wishlist(l1, Long.parseLong("0", 10));
		Wishlist w2 = new Wishlist(l2, Long.parseLong("1", 10));




		w2.get_wishlist_by_id( Long.parseLong("0", 10));
		w1.get_wishlist_by_id( Long.parseLong("0", 10));




	}

}
