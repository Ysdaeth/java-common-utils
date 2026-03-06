package io.github.ysdaeth.utils.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMatcherTest {

    // SUB ARRAY AT THE BEGINNING TEST ==============================================================
    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_ObjectArray() {
        Object[] array = {"A", "B", "C", "D", "E", "F", "G"};
        Object[] subarray = {"A", "B", "C"};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_longArray() {

        long[] array = {2147483650L, 2147483651L, 2147483652L,
                2147483653L, 2147483654L, 2147483655L, 2147483656L};

        long[] subarray = {2147483650L, 2147483651L, 2147483652L};

        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_intArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] subarray = {1, 2, 3};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_shortArray() {
        short[] array = {1, 2, 3, 4, 5, 6, 7};
        short[] subarray = {1, 2, 3};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_byteArray() {
        byte[] array = {1, 2, 3, 4, 5, 6, 7};
        byte[] subarray = {1, 2, 3};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_charArray() {
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] subarray = {'a', 'b', 'c'};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheBeginning_floatArray() {
        float[] array = {1.1F, 2.2F, 3.3F, 4.4F, 5.5F, 6.6F, 7.7F};
        float[] subarray = {1.1F, 2.2F, 3.3F};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    @Test
    void indexOfSubarray_ShouldReturnTrueIndexOfArrayAtTheBeginning_doubleArray() {
        double[] array = {1.1D, 2.2D, 3.3D, 4.4D, 5.5D, 6.6D, 7.7D};
        double[] subarray = {1.1D, 2.2D, 3.3D,};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Index mismatch when subarray is in the beginning");
    }

    // SUB ARRAY AT THE MIDDLE TEST =================================================================
    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_ObjectArray() {
        Object[] array = {"A", "B", "C", "D", "E", "F", "G"};
        Object[] subarray = {"C", "D", "E"};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_longArray() {

        long[] array = {2147483650L, 2147483651L, 2147483652L,
                2147483653L, 2147483654L, 2147483655L, 2147483656L};

        long[] subarray = {2147483652L, 2147483653L, 2147483654L};

        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_intArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] subarray = {3, 4, 5};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_shortArray() {
        short[] array = {1, 2, 3, 4, 5, 6, 7};
        short[] subarray = {3, 4, 5};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnTrueIndexOfArrayAtTheMiddle_byteArray() {
        byte[] array = {1, 2, 3, 4, 5, 6, 7};
        byte[] subarray = {3, 4, 5};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_charArray() {
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] subarray = {'c', 'd', 'e'};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_floatArray() {
        float[] array = {1.1F, 2.2F, 3.3F, 4.4F, 5.5F, 6.6F, 7.7F};
        float[] subarray = {3.3F, 4.4F, 5.5F};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheMiddle_doubleArray() {
        double[] array = {1.1D, 2.2D, 3.3D, 4.4D, 5.5D, 6.6D, 7.7D};
        double[] subarray = {3.3D, 4.4D, 5.5D};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(2,result,"Index mismatch when subarray is in the middle");
    }

    // SUB ARRAY AT THE END TEST ====================================================================
    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_ObjectArray() {
        Object[] array = {1, 2, 3, 4, 5, 6, 7};
        Object[] subarray = {5, 6, 7};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_longArray() {

        long[] array = {2147483650L, 2147483651L, 2147483652L,
                2147483653L, 2147483654L, 2147483655L, 2147483656L};

        long[] subarray = {2147483654L, 2147483655L, 2147483656L};

        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_intArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] subarray = {5, 6, 7};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_shortArray() {
        short[] array = {1, 2, 3, 4, 5, 6, 7};
        short[] subarray = {5, 6, 7};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnTrueIndexOfArrayAtTheEnd_byteArray() {
        byte[] array = {1, 2, 3, 4, 5, 6, 7};
        byte[] subarray = {5, 6, 7};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_charArray() {
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] subarray = {'e', 'f', 'g'};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_floatArray() {
        float[] array = {1.1F, 2.2F, 3.3F, 4.4F, 5.5F, 6.6F, 7.7F};
        float[] subarray = { 5.5F, 6.6F, 7.7F};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Index mismatch when subarray is at the end");
    }

    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubArrayAtTheEnd_doubleArray() {
        double[] array = {1.1D, 2.2D, 3.3D, 4.4D, 5.5D, 6.6D, 7.7D};
        double[] subarray = {5.5D, 6.6D, 7.7D};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(4,result,"Subarray index expected was 4");
    }

    // ARRAYS ARE THE SAME TEST =====================================================================
    @Test
    void indexOfSubarray_ShouldReturnTrueWhenArraysAreTheSame_ObjectArray() {
        Object[] array = {1, 2, 3};
        Object[] subarray = {1, 2, 3};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(0,result,"Subarray index expected was 0");
    }

    // ARRAYS WITH NULL NO EXCEPTION TEST ===========================================================
    @Test
    void indexOfSubarray_ShouldNotThrowExceptionWithNullElements_ObjectArray() {
        Object[] array = {1, null, 3};
        Object[] subarray = {null};
        assertDoesNotThrow(() -> ArrayMatcher.indexOfSubarray(array, subarray),
                "Exception was thrown when array contains null value");
    }

    // ARRAYS WITH NULL TEST ========================================================================
    @Test
    void indexOfSubarray_ShouldReturnIndexOfSubarrayWithNullElements_ObjectArray() {
        Object[] array = {1, 2, null, 4, 5, 6, 7};
        Object[] subarray = {2, null, 4};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(1,result,"Subarray index expected was 1");
    }

    // SUB ARRAY IS BIGGER TEST =====================================================================
    @Test
    void indexOfSubarray_ShouldReturnNegativeIndexWhenSubArrayIsBigger_ObjectArray() {
        Object[] array = {1, 2, 3};
        Object[] subarray = {1, 2, 3, 4, 5};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(-1,result,"Subarray index expected was -1");
    }

    // CONTAINS ELEMENTS, BUT DIFFERENT ORDER TEST ==================================================
    @Test
    void containsOrdered_ShouldReturnNegativeIndexWhenArrayContainsSubArrayElementsButOrderDoesNotMatch_ObjectArray() {
        Object[] array = {1, 2, 3, 4, 5, 6, 7};
        Object[] subarray = {1, 3, 5};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(-1,result,"Subarray index expected was -1");
    }


    //  DOES NOT CONTAIN ALL ELEMENTS TEST
    @Test
    void indexOfSubarray_ShouldReturnFalseWhenSubArrayNotMatches_ObjectArray() {
        Object[] array = {1, 2, 3, 4, 5, 6, 7};
        Object[] subarray = {6, 7, 8};
        int result = ArrayMatcher.indexOfSubarray(array, subarray);
        assertEquals(-1,result,"Subarray index expected was -1");
    }

}