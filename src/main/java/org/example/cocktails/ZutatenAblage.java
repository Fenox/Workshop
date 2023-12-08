package org.example.cocktails;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ZutatenAblage {

	private final Set<Zutat> zutaten = new HashSet<>();

	public void addZutat(Zutat zutat) {
		if (zutaten.contains(zutat)) {
			zutaten.stream().filter(z -> z.equals(zutat)).findFirst().get().add(zutat.getMenge());
		} else {
			zutaten.add(zutat);
		}
	}

	public boolean entnehme(Zutat zutat) {
		if (zutaten.contains(zutat)) {
			var zutatInAblage = zutaten.stream().filter(z -> z.equals(zutat)).findFirst().get();
			if (zutatInAblage.getMenge() >= zutat.getMenge()) {
				zutatInAblage.add(-zutat.getMenge());
				return true;
			}
		}
		return false;
	}

}
