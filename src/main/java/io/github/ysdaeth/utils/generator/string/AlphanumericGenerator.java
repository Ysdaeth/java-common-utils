package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

class AlphanumericGenerator extends LatinGenerator {

    protected AlphanumericGenerator(Random random) {
        super(random);
    }

    @Override
    protected char[] createAllowedCharacters() {
        char[] latinCharacters = super.createAllowedCharacters();
        char[] digits = StringGenerator.generateSequentialASCII('0','9');
        char[] merged = new char[latinCharacters.length + digits.length];

        System.arraycopy(latinCharacters,0,merged,0,latinCharacters.length);
        System.arraycopy(digits,0,merged,latinCharacters.length,digits.length);
        return merged;
    }

}
