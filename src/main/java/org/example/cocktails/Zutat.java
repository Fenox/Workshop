package org.example.cocktails;

import lombok.AllArgsConstructor;
import lombok.Data;

// TODO: review this class
// TODO: write tests for this class
@Data
@AllArgsConstructor
public class Zutat {
	private String name;
	private String einheit;
	private int menge;

	public void add(int menge) {
		this.menge -= menge;
	}
}
