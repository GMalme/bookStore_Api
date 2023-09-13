package com.gmalme.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmalme.bookstore.domain.Categoria;
import com.gmalme.bookstore.domain.Livro;
import com.gmalme.bookstore.repositories.CategoriaRepository;
import com.gmalme.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Comedia", "Livros de Comedia");
		Categoria cat3 = new Categoria(null, "Drama", "Livros de Drama");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "SOLID", "Robert Martin", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Anjos da Lei", "Robert Dwayne Jr.", "Lorem ipsum", cat2);
		Livro l4 = new Livro(null, "Anjos da Lei 2", "Robert Dwayne Jr.", "Lorem ipsum", cat2);
		Livro l5 = new Livro(null, "A garota no vagão", "Matheus sesso", "Lorem ipsum", cat3);
		Livro l6 = new Livro(null, "It a Coisa", "João Dias", "Lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		cat3.getLivros().addAll(Arrays.asList(l5, l6));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
	}

}
