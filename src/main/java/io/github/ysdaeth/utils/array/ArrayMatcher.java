package io.github.ysdaeth.utils.array;


import java.util.function.IntBinaryOperator;


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
     *     indexOfSubarray(array, subarray); //return 3
     * </pre></blockquote>
     * Case 2) Subarray elements appear in the array, but order of the elements is not the same.
     * <blockquote><pre>
     *     Byte[] subarray = new byte[]{"E","F","D"};
     *     indexOfSubarray(array, subarray); //return -1
     * </pre></blockquote>
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(Object[] array, Object[] subarray){

        for(int i = 0; i < array.length; i++){
            if( i + subarray.length > array.length ) return -1;

            // notation O(n^2), but in reality it works as fast as O(n)
            for(int j=0; j< subarray.length; j++){
                Object element = array[i + j];
                Object subElement = subarray[j];
                if(element == null && subElement == null) continue;
                if(element == null || !element.equals(subElement) ){
                    i += j;
                    break;
                }
                else if(j == subarray.length -1) return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      long[] array = {1L, 2L, 3L, 4L, 5L};
     *      long[] subarray =  {2L, 3L, 4L};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(long[] array, long[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)-> array[i] == subArray[j]? 0: -1);
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      int[] array = {1, 2, 3, 4, 5};
     *      int[] subarray =  {2, 3, 4};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(int[] array, int[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)->array[i] == subArray[j]? 0 : -1 );
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      short[] array = {1, 2, 3, 4, 5};
     *      short[] subarray =  {2, 3, 4};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(short[] array, short[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)-> array[i] == subArray[j]? 0: -1);
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      byte[] array = {1, 2, 3, 4, 5};
     *      byte[] subarray =  {2, 3, 4};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(byte[] array, byte[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)-> array[i] == subArray[j]? 0: -1);
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      char[] array = {'a', 'b', 'c', 'd', 'e'};
     *      char[] subarray =  {'b','c','d'};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(char[] array, char[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)-> array[i] == subArray[j]? 0: -1);
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      double[] array = {1.1D, 2.2D, 3.3D, 4.4D, 5.5D};
     *      double[] subarray = {2.2D, 3.3D,4.4D};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(double[] array, double[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)-> array[i] == subArray[j]? 0: -1);
    }

    /**
     * Checks if the source array contains subarray with the elements in the same order, starting at index
     * of the first matching object.
     * <blockquote><pre>
     *      float[] array = {1.1F, 2.2F, 3.3F, 4.4F, 5.5F};
     *      float[] subarray = {2.2F, 3.3F,4.4F};
     *      int index = indexOfSubarray(array, subarray); // return 1
     * </pre></blockquote>
     * @param array source array
     * @param subArray subarray to be found in the array
     * @return index of the first matching element in the array, when array contains subarray elements in the same order, -1 when does not,
     * or subarray is bigger than the array
     */
    public static int indexOfSubarray(float[] array, float[] subArray){
        return indexOfSubarray(
                array.length, subArray.length, (i,j)-> array[i] == subArray[j]? 0 : -1);
    }

    private static int indexOfSubarray(int arrayLength, int subArrayLength, IntBinaryOperator comparator) {

        if (arrayLength == 0 && subArrayLength == 0) return 0;

        int index = 0;
        while (index + subArrayLength <= arrayLength) {
            boolean lastMatches = comparator.applyAsInt(index + subArrayLength - 1, subArrayLength - 1) == 0;
            if (!lastMatches) {
                index = index + subArrayLength - 1;
                continue;
            }

            boolean firstMatches = comparator.applyAsInt(index, 0) == 0;
            if(!firstMatches){
                index++;
                continue;
            }
            // notation O(n^2), but in reality it works as fast as O(n)
            for (int subArrIndex = 0; subArrIndex < subArrayLength; subArrIndex++) {
                if (comparator.applyAsInt(index + subArrIndex, subArrIndex) == -1) {
                    index += subArrIndex;
                    break;
                } else if (subArrIndex == subArrayLength - 1) return index;
            }
        }
        return -1;
    }
}
