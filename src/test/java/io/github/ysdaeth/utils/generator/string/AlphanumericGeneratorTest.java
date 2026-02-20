package io.github.ysdaeth.utils.generator.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


class AlphanumericGeneratorTest {

    private String allowedChars ="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private Set<Character> allowedCharSet = new HashSet<>(allowedChars.length());

    StringGenerator generator = StringGenerator.getInstance(GeneratorType.ALPHANUMERIC);

    public AlphanumericGeneratorTest(){
        char[] chars = allowedChars.toCharArray();
        for(char c: chars){
            allowedCharSet.add(c);
        }
    }

    @Test
    void generate_shouldReturnUrlSafeString(){

        for(int i=0; i<10_000; i++){
            String randomString = generator.generate(64);
            for(int j=0; j<randomString.length(); j++){
                char currentChar = randomString.charAt(j);
                boolean isAllowed = allowedCharSet.contains(currentChar);
                Assertions.assertTrue(isAllowed,"Generated string contains illegal character: "+ currentChar);
            }
        }

    }

}