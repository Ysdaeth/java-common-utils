package io.github.ysdaeth.utils.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ArrayMatcherTest {

    // PRIMITIVE TYPES TEST
    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_longArray() {

        Long base = Long.MAX_VALUE - 4;
        long[] array = {base, base + 1, base + 2, base + 3, base + 4};
        long[] subarray = {base, base + 1, base + 2, base + 3};

        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for long");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_intArray() {
        int base = Integer.MAX_VALUE - 4;
        int[] array = {base, base + 1, base +2, base +3, base +4};
        int[] subarray = {base, base +1, base +2};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for int");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_shortArray() {
        short base = Short.MAX_VALUE -6;
        short[] array = {base, (short)(base+1), (short)(base + 2), (short)(base +3)};
        short[] subarray = {base, (short)(base+1), (short)(base + 2)};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for short");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_byteArray() {
        byte[] array = {1, 2, 3, 4, 5, 6, 7};
        byte[] subarray = {1, 2, 3};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for byte");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_charArray() {
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] subarray = {'a', 'b', 'c'};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for char");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_floatArray() {
        float[] array = {1.1F, 2.2F, 3.3F, 4.4F, 5.5F, 6.6F, 7.7F};
        float[] subarray = {1.1F, 2.2F, 3.3F};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for float");
    }

    @Test
    void indexOfSubarray_ShouldReturnTrueIndexOfArrayAtTheBeginning_doubleArray() {
        double[] array = {1.1D, 2.2D, 3.3D, 4.4D, 5.5D, 6.6D, 7.7D};
        double[] subarray = {1.1D, 2.2D, 3.3D,};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch for double");
    }

    // MAIN TESTS

    @ParameterizedTest
    @MethodSource("intSubarraysIndexes_stringArrays")
    void indexOfSubarray_ShouldReturnIndex_ObjectArray(
            Object[] array, Object[] subarray, int offset, int expected) {

        int result = ArrayMatcher.indexOfSubarray(array, subarray,offset);

        assertEquals(expected,result,
                ()->{
                    String arrayElements = Arrays.toString(array);
                    String subarrayElements = Arrays.toString(subarray);
                    return String.format(
                            "Index mismatch. Array: '%s', subarray: '%s', offset: '%d'",
                            arrayElements,subarrayElements, offset
                    );
                });
    }

    static Stream<Arguments> intSubarraysIndexes_stringArrays(){
        // array, subarray, offset, expected index
        return Stream.of(
                Arguments.of(new String[]{"1","2","1","2","3","4","5","6"}, new String[] {"1","2","3"}, 0, 2),
                Arguments.of(new String[]{"0","1","2","3","4","5","6"}, new String[]{"1","2","3"}, 0, 1),
                Arguments.of(new String[]{"0","0","0","0","0","0"}, new String[]{"1","2","3"}, 0, -1),
                Arguments.of(new String[]{"0","1"}, new String[]{"1","2","3"}, 0, -1),
                Arguments.of(new String[]{"0","1","2","1"}, new String[]{"1","2","3"}, 0, -1),
                Arguments.of(new String[]{"0","1","2","3","4"}, new String[]{"0","1","2"}, 0, 0),
                Arguments.of(new String[]{"0","1","2","3","4"}, new String[]{"1","2","3"}, 1, 1),
                Arguments.of(new String[]{"0","2","3","4","5"}, new String[]{"1","2","3"}, 1, -1),
                Arguments.of(new String[]{"0","1","2","3","4","1","2","3"}, new String[]{"1","2","3"}, 2, 5),
                Arguments.of(new String[]{"0","1","2","3","1","2","3"}, new String[]{"1","2","3"}, 2, 4),
                Arguments.of(new String[]{"1","2","3","1","2","3"}, new String[]{"1","2","3"}, 2, 3),
                Arguments.of(new String[]{"1",null,null,"1","2","3"}, new String[]{"1",null,null}, 0, 0),
                Arguments.of(new String[]{null,null,null,"1","2","3"}, new String[]{null,null,"1"}, 1, 1),
                Arguments.of(new String[]{null,null,null,"1",null,null,"1","2","3"}, new String[]{null,null,"1"}, 2, 4),
                Arguments.of(new String[]{null,null,null}, new String[]{null,null,}, 0, 0),
                Arguments.of(new String[]{null,null,null}, new String[]{null,null,}, 1, 1),
                Arguments.of(new String[]{"1","2","3"}, new String[]{"4","5","6"}, 0, -1),
                Arguments.of(new String[]{"1","2","3"}, new String[]{"2","3","4"}, 0, -1),
                Arguments.of(new String[]{}, new String[]{}, 0, -1),
                Arguments.of(new String[]{}, new String[]{}, 1, -1),
                Arguments.of(new String[]{}, new String[]{"a","b"}, 0, -1),
                Arguments.of(new String[]{"a","b"}, new String[]{}, 0, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("intSubarraysIndexes_intArrays")
    void indexOfSubarray_ShouldReturnIndex(
            int[] array, int[] subarray, int offset, int expected) {

        int result = ArrayMatcher.indexOfSubarray(array, subarray, offset);

        assertEquals(expected,result,
                ()->{
            String arrayElements = Arrays.toString(array);
            String subarrayElements = Arrays.toString(subarray);
            return String.format(
                    "Index mismatch. Array: '%s', subarray: '%s', offset: '%d'",
                    arrayElements,subarrayElements, offset
            );
        });
    }

    static Stream<Arguments> intSubarraysIndexes_intArrays(){
        // array, subarray, offset, expected index
        return Stream.of(
                Arguments.of(new int[]{1,2,1,2,3,4}, new int[]{1,2,3}, 0, 2),
                Arguments.of(new int[]{0,1,2,3,4,5,6}, new int[]{1,2,3}, 0, 1),
                Arguments.of(new int[]{0,0,0,0,0,0}, new int[]{1,2,3}, 0, -1),
                Arguments.of(new int[]{0,1}, new int[]{1,2,3}, 0, -1),
                Arguments.of(new int[]{0,1,2,1}, new int[]{1,2,3}, 0, -1),
                Arguments.of(new int[]{0,1,2,3,4}, new int[]{0,1,2}, 0, 0),
                Arguments.of(new int[]{0,1,2,3,4}, new int[]{1,2,3}, 1, 1),
                Arguments.of(new int[]{0,2,3,4,5}, new int[]{1,2,3}, 1, -1),
                Arguments.of(new int[]{0,1,2,3,4,1,2,3}, new int[]{1,2,3}, 2, 5),
                Arguments.of(new int[]{0,1,2,3,1,2,3}, new int[]{1,2,3}, 2, 4),
                Arguments.of(new int[]{1,2,3,1,2,3}, new int[]{1,2,3}, 2, 3),
                Arguments.of(new int[]{1,2,3,1,2,3}, new int[]{1,2,3}, 4, -1),
                Arguments.of(new int[]{1,2,3,1,2,3}, new int[]{1,2,3}, 5, -1),
                Arguments.of(new int[]{1,2,3,1,2,3}, new int[]{1,2,3}, 6, -1),
                Arguments.of(new int[]{1,2,3,1,2,3}, new int[]{2}, -99, 1),
                Arguments.of(new int[]{1}, new int[]{1}, 0, 0),
                Arguments.of(new int[]{}, new int[]{}, 0, -1),
                Arguments.of(new int[]{}, new int[]{}, 1, -1),
                Arguments.of(new int[]{}, new int[]{1,2,3}, 0, -1),
                Arguments.of(new int[]{1,2,3}, new int[]{}, 0, -1)
        );
    }
}