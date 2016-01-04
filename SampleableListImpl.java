/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result
 * in your code not compiling with the automatic tests used for
 * grading.
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
    public SampleableListImpl() {
        super();
    }

    @Override
    //not done
    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty.
     *
     * @return a list containing the first, third, fifth... items of this list
     */
    public SampleableList sample() {
        SampleableListImpl firstThirdFifth = new SampleableListImpl();
        if (this.isEmpty()) {
            return firstThirdFifth;
        } else {
            firstThirdFifth.add(this.get(0).getReturnValue());
            firstThirdFifth.add(this.get(2).getReturnValue());
            firstThirdFifth.add(this.get(4).getReturnValue());
            return firstThirdFifth;

        }
    }

}