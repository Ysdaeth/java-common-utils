package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

/**
 * Class provides characters that contains a-z, A-Z, and 0-9, that are used
 * by {@link StringGenerator} to generate random string
 */
class AlphanumericGenerator extends LatinGenerator {

    /**
     * Create this instance
     * @param random random generator used to generate random strings
     */
    protected AlphanumericGenerator(Random random) {
        super(random);
    }

    /**
     * Method generates Alphanumeric signs which are a-z, A-Z and 0-9
     * @return array of characters that may be used for generating string
     */
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
