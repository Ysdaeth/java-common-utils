package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

/**
 * Class provides characters that contains a-z, A-Z, 0-9, '-' and '_', that are used
 * by {@link StringGenerator} to generate random string
 */
class UrlSafeGenerator extends AlphanumericGenerator{

    /**
     * Create this instance
     * @param random random generator used to generate random strings
     */
    protected UrlSafeGenerator(Random random) {
        super(random);
    }

    /**
     * Method generates Alphanumeric signs which are a-z, A-Z and 0-9
     * @return array of characters that may be used for generating string
     */
    @Override
    protected char[] createAllowedCharacters() {
        char[] alphanumeric = super.createAllowedCharacters();
        char[] signs = new char[]{'-','_'};
        char[] merged = new char[alphanumeric.length + signs.length];

        System.arraycopy(alphanumeric,0,merged,0,alphanumeric.length);
        System.arraycopy(signs,0,merged,alphanumeric.length,signs.length);
        return merged;
    }
}
