/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result
 * in your code not compiling with the automatic tests used for
 * grading.
 */
public class SampleableListImpl implements SampleableList {
    @Override
    //not done
    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty.
     *
     * @return a list containing the first, third, fifth... items of this list
     */
    public SampleableList sample() {
        return null;
    }

    @Override
    //not done
    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return false;
    }

    @Override
    //not done
    /**
    * Returns the number of items currently in the list.
    *
            * @return the number of items currently in the list
    */
    public int size() {
        return 0;
    }

    @Override
    //not done
    /**
    * Returns the element at the given position.
    *
            * If the index is negative or greater or equal than the size of
    * the list, then an appropriate error must be returned.
            *
            * @param index the position in the list of the item to be retrieved
    * @return the element or an appropriate error message,
            *         encapsulated in a ReturnObject
    */
    public ReturnObject get(int index) {
        return null;
    }

    @Override
    //not done
    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject remove(int index) {
        return null;
    }

    @Override
    //not done
    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
    public ReturnObject add(int index, Object item) {
        return null;
    }

    @Override
    //not done
    /**
    * Adds an element at the end of the list.
    *
            * If a null object is provided to insert in the list, the
    * request must be ignored and an appropriate error must be
    * returned.
    *
            * @param item the value to insert into the list
    * @return an ReturnObject, empty if the operation is successful
    *         or containing an appropriate error message otherwise
    */
    public ReturnObject add(Object item) {
        return null;
    }

}