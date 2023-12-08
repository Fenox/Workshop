package org.example.cocktails;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class CocktailRezept {

	private String name;
	private Set<Zutat> zutaten;

	public static class Builder {

		private String name;
		private final Set<Zutat> zutaten = new HashSet<>();

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder addZutat(Zutat zutat) {
			this.zutaten.add(zutat);
			return this;
		}

		public CocktailRezept build() {
			return new CocktailRezept(name, zutaten);
		}
	}
}
