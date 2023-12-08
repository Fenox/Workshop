package org.example.cocktails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CocktailZubereitung {

	private final ZutatenAblage zutatenAblage;

	public Cocktail mix(String name) {
		// hole cocktail aus Menu
		var cocktail = Menu.cocktailRezepts.stream().filter(c -> c.getName().equals(name)).findFirst()
			.orElseThrow(() -> new CocktailException("Cocktail " + name + " not found"));

		// Prüfe, ob alle Zutaten in der zutaten ablage vorhanden sind
		cocktail.getZutaten().forEach(zutat -> {
			if (!zutatenAblage.entnehme(zutat)) {
				throw new CocktailException("Zutat " + zutat.getName() + " nicht ausreichend vorhanden");
			}
		});

		return new Cocktail(name);
	}
}

class CocktailException extends RuntimeException {

	public CocktailException(String message) {
		super(message);
	}
}
