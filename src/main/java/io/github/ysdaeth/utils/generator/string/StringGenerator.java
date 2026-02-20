package io.github.ysdaeth.utils.generator.string;

import java.util.Random;

public abstract class StringGenerator {

    private final Random random;
    private final char[] characters;

    protected StringGenerator(Random random){
        this.random = random;
        this.characters = createAllowedCharacters();
    }

    /**
     * Provide instance of random string generator that will generate strings based on
     * specified generator type.
     * @param type type of string generator
     * @param random random generator instance
     * @return String generator
     */
    public static StringGenerator getInstance(GeneratorType type, Random random){
        StringGenerator generator;
        switch (type){
            case LATIN : {generator = new LatinGenerator(random);break;}
            case ALPHANUMERIC :{generator= new AlphanumericGenerator(random); break;}
            case URL_SAFE: {generator= new UrlSafeGenerator(random);break;}
            default:{throw new RuntimeException("No such instance "+ type);}
        }
        return generator;
    }

    /**
     * Provide instance of random string generator that will generate strings based on
     * specified generator type. By default, it uses {@link Random} instance to generate a string.
     * For other implementation of the random use {@link this#getInstance(GeneratorType, Random)};
     * @param type type of string generator
     * @return String generator
     */
    public static StringGenerator getInstance(GeneratorType type){
        return getInstance(type, new Random());
    }

    /**
     * Create array of allowed characters that will be used to generate random string.
     * @return array of allowed characters to be used for string generation.
     */
    protected abstract char[] createAllowedCharacters();


    /**
     * Generate random String based on specified implementation by {@link this#getInstance(GeneratorType)} method
     * @param length length of the randomly generated string
     * @return random string
     */
    public String generate(int length){
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<length; i++){
            int randomIndex = random.nextInt(characters.length);
            builder.append(characters[randomIndex]);
        }
        return builder.toString();
    }

    /**
     * Generate characters based on ASCII table where start is first character and end is last character.
     * Returned array contains first character, last character and every character between
     * <p>Example</p>
     * {@code generateFromASCII( 'a', 'c' ); // ['a', 'b', 'c'] }
     * @param first first character of ASCII
     * @param last last Character of ASCII
     * @return first, last and every character between
     */
    public static char[] generateSequentialASCII(char first, char last){

        if(first > last){
            char holder = first;
            first = last;
            last = holder;
        }

        char[] chars = new char[last - first + 1];
        int index = 0;
        for(int i = first; i <= last; i++){
            chars[index++] = (char)i;
        }
        return chars;
    }

}
