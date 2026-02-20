package io.github.ysdaeth.utils.generator.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StringGeneratorTest {

    @Test
    void getInstance_ShouldReturnUrlSafeGenerator(){
        StringGenerator generator = StringGenerator.getInstance(GeneratorType.URL_SAFE);
        boolean isUrlSafeInstance = generator instanceof UrlSafeGenerator;
        Assertions.assertTrue(isUrlSafeInstance,"Returned instance is not a "+ UrlSafeGenerator.class);
    }

    @Test
    void getInstance_ShouldReturnAlphanumericGenerator(){
        StringGenerator generator = StringGenerator.getInstance(GeneratorType.ALPHANUMERIC);
        boolean isUrlSafeInstance = generator instanceof AlphanumericGenerator;
        Assertions.assertTrue(isUrlSafeInstance,"Returned instance is not a "+ AlphanumericGenerator.class);
    }

    @Test
    void getInstance_ShouldReturnLatinGenerator(){
        StringGenerator generator = StringGenerator.getInstance(GeneratorType.LATIN);
        boolean isUrlSafeInstance = generator instanceof LatinGenerator;
        Assertions.assertTrue(isUrlSafeInstance,"Returned instance is not a "+ LatinGenerator.class);
    }

    @Test
    void generateSequentialASCII_shouldReturnCharacters(){
        char[] expected = new char[]{'a','b','c','d'};
        char[] actual = StringGenerator.generateSequentialASCII('a','d');
        boolean equals =Arrays.equals(expected,actual);
        Assertions.assertTrue(equals,"Arrays expected array not match actual");
    }

    @Test
    void generateSequentialASCII_shouldReturnCharactersWhenFirstAndLastAreSwapped(){
        char[] expected = new char[]{'a','b','c','d'};
        char[] actual = StringGenerator.generateSequentialASCII('d','a');
        boolean equals =Arrays.equals(expected,actual);
        Assertions.assertTrue(equals,"Arrays expected array not match actual");
    }

}