package org.example.cocktails;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Zutat {
	private String name;
	private String einheit;
	private int menge;

	public void add(int menge) {
		this.menge += menge;
	}
}
