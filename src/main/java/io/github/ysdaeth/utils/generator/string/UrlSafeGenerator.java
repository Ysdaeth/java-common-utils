package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

class UrlSafeGenerator extends AlphanumericGenerator{

    protected UrlSafeGenerator(Random random) {
        super(random);
    }

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
