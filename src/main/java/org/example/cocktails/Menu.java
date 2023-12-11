package org.example.cocktails;

import java.util.Set;

public class Menu {

	private Menu() {}

	static CocktailRezept mojito = new CocktailRezept.Builder()
		.name("Mojito")
		.addZutat(new Zutat("Rum", "cl", 4))
		.addZutat(new Zutat("Zucker", "cl", 2))
		.addZutat(new Zutat("Limettensaft", "cl", 2))
		.addZutat(new Zutat("Minze", "cl", 2))
		.addZutat(new Zutat("Soda", "cl", 8))
		.addZutat(new Zutat("Eiswürfel", "cl", 8))
		.build();

	// TODO: add Whiskey Sour

	public static Set<CocktailRezept> cocktailRezepts = Set.of(mojito);
}
