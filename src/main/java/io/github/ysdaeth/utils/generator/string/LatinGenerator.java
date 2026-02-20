package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

/**
 * String generator that generates Latin characters a-z - A-Z
 * based on ASCII table.
 */
class LatinGenerator extends StringGenerator {

    /**
     * Create this instance
     * @param random random generator used to generate random strings
     */
    LatinGenerator(Random random) {
        super(random);
    }

    /**
     * Method generates Alphanumeric signs which are a-z, and A-Z
     * @return array of characters that may be used for generating string
     */
    @Override
     protected char[] createAllowedCharacters(){
        char[] lowercase = StringGenerator.generateSequentialASCII('a','z');
        char[] uppercase = StringGenerator.generateSequentialASCII('A','Z');
        char[] merged = new char[lowercase.length + uppercase.length];

        System.arraycopy(lowercase,0,merged,0,lowercase.length);
        System.arraycopy(uppercase, 0, merged, lowercase.length, uppercase.length);
        return merged;
    }
}
