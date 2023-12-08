package org.example.cocktails;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CocktailZubereitungTest {

	@InjectMocks
	CocktailZubereitung cocktailZubereitung;

	@Mock
	ZutatenAblage zutatenAblage;


	@Nested
	@DisplayName("Given cocktail not exists")
	class GivenCocktailNotExists {

		@Test
		@DisplayName("When mix then throw exception")
		void whenMixThenThrowException() {
			var cocktailName = "not existing cocktail";

			assertThrows(CocktailException.class, () -> cocktailZubereitung.mix(cocktailName));
		}
	}

	@Nested
	@DisplayName("Given zutat not exists")
	class GivenZutatNotExists {

		@BeforeEach
		void init() {
			when(zutatenAblage.entnehme(any())).thenReturn(false);
		}

		@Test
		@DisplayName("When mix then throw exception")
		void whenMixThenThrowException() {
			var cocktailName = "Mojito";

			assertThrows(CocktailException.class, () -> cocktailZubereitung.mix(cocktailName));
		}
	}

	@Nested
	@DisplayName("Given zutat exists")
	class GivenZutatExists {
		// TODO: write test
	}
}
