package io.github.ysdaeth.utils.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;


/**
 * Class for checking elements in the array
 */
public final class ArrayMatcher {

    private ArrayMatcher(){}

    /**
     * Checks if the source array contains subarray in the same order of the elements, starting at index
     * of the first matching object. Objects comparison is done by calling the {@link Object#equals(Object)} method.
     * If subarray is found in the array, then index of the first matching element is returned
     * <p>Example</p>
     * Given is the array
     * <blockquote><pre>
     *     String[] array = {"A", "B", "C", "D", "E", "F"};
     * </pre></blockquote>
     * Case 1) Subarray elements appear in the array, in the same order.
     * <blockquote><pre>
     *     String[] subarray = new byte[]{"D","E","F"};
     *     int index = indexOfSubarray(array, subarray); //return 3
     * </pre></blockquote>
     * Case 2) Subarray elements appear in the array, but order of the elements is not the same.
     * <blockquote><pre>
     *     Byte[] subarray = new byte[]{"E","F","D"};
     *     int index = indexOfSubarray(array, subarray); //return -1
     * </pre></blockquote>
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching inclusive.
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(Object[] array, Object[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> objectEquals(array[i],subarray[j])? 0 : -1,offset);
    }

    /**
     * Same behavior as {@link ArrayMatcher#findSubarray(Object[], Object[], int)}
     * but offset is set to the beginning.
     */
    public static int findSubarray(Object[] array, Object[] subarray){
        return findSubarray(array, subarray, 0);
    }

    private static boolean objectEquals(Object obj1, Object obj2){
        if(obj1 == null && obj2 == null) return true;
        else if(obj1 == null) return false;
        return obj1.equals(obj2);
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.  Subarray searching starts at a specified index in the source array.
     * <blockquote><pre>
     *      long[] array = {1L, 2L, 3L, 4L, 5L};
     *      long[] subarray =  {2L, 3L, 4L};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(long[] array, long[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> array[i] == subarray[j]? 0: -1,offset);
    }
    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object. Subarray searching starts at 0 index in the source array.
     * <blockquote><pre>
     *      long[] array = {1L, 2L, 3L, 4L, 5L};
     *      long[] subarray =  {2L, 3L, 4L};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(long[] array, long[] subarray){
        return findSubarray(array,subarray,0);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[], int)}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(int[] array, int[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)->array[i] == subarray[j]? 0 : -1,offset);
    }
    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[])}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(int[] array, int[] subarray){
        return findSubarray(array,subarray,0);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[], int)}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(short[] array, short[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> array[i] == subarray[j]? 0: -1,offset);
    }
    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[])}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(short[] array, short[] subarray){
        return findSubarray(array,subarray,0);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[], int)}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(byte[] array, byte[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> array[i] == subarray[j]? 0: -1,offset);
    }
    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[])}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(byte[] array, byte[] subarray){
        return findSubarray(array,subarray,0);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[], int)}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(char[] array, char[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> array[i] == subarray[j]? 0: -1,offset);
    }
    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[])}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(char[] array, char[] subarray){
        return findSubarray(array,subarray,0);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[], int)}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(double[] array, double[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> array[i] == subarray[j]? 0: -1,offset);
    }
    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[])}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(double[] array, double[] subarray){
        return findSubarray(array,subarray,0);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[], int)}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @param offset index where to start searching (inclusive).
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(float[] array, float[] subarray, int offset){
        return findSubarray(
                array.length, subarray.length, (i,j)-> array[i] == subarray[j]? 0 : -1,offset);
    }

    /**
     * The same behavior as {@link ArrayMatcher#findSubarray(long[], long[])}
     * @param array source array
     * @param subarray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray
     * elements in the same order, -1 when does not, or subarray is bigger than the array
     */
    public static int findSubarray(float[] array, float[] subarray){
        return findSubarray(array,subarray,0);
    }

    private static int findSubarray(int arrayLength,
                                    int subArrayLength,
                                    IntBinaryOperator comparator,
                                    int offset) {

        if (arrayLength == 0 || subArrayLength == 0) return -1;

        int index = Math.max(offset , 0);
        while (index + subArrayLength <= arrayLength) {
            boolean firstMatches = comparator.applyAsInt(index, 0) == 0;
            boolean lastMatches = comparator.applyAsInt(index + subArrayLength - 1, subArrayLength - 1) == 0;
            if (firstMatches && !lastMatches) {
                index = index + subArrayLength - 1;
                continue;
            }
            else if(!firstMatches){
                index++;
                continue;
            }
            // notation O(n^2), but in reality it works as fast as O(n)
            for (int subArrIndex = 0; subArrIndex < subArrayLength; subArrIndex++) {
                if (comparator.applyAsInt(index + subArrIndex, subArrIndex) == -1) {
                    index += subArrIndex;
                    break;
                } else if (subArrIndex >= subArrayLength - 1) return index;
            }
        }
        return -1;
    }

    public static int[] findAllNull(Object[] objects){
        ArrayList<Integer> nullIndex = new ArrayList<>();
        for(int i =0; i < objects.length; i++){
            if(objects[i] == null) nullIndex.add(i);
        }
        return nullIndex.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] findNull(Object[] objects, int offset){
        ArrayList<Integer> nullIndex = new ArrayList<>();
        for(int i = offset; i < objects.length; i++){
            if(objects[i] == null) nullIndex.add(i);
        }
        return nullIndex.stream().mapToInt(Integer::intValue).toArray();
    }
}