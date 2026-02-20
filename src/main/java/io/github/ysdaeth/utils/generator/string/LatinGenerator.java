package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

/**
 * String generator that generates Latin characters a-z - A-Z
 * based on ASCII table.
 */
class LatinGenerator extends StringGenerator {

    LatinGenerator(Random random) {
        super(random);
    }

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
