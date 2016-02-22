/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result
 * in your code not compiling with the automatic tests used for
 * grading.
 * Returns a list containing the first, third, fifth...
 * items of this list, or an empty list if the list is empty.
 *
 * @return a list containing the first, third, fifth... items of this list
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
    public SampleableListImpl() {
        super();
    }

    @Override
    public SampleableList sample() {
        SampleableListImpl oddItems = new SampleableListImpl();
        if (!this.isEmpty()) {
            for (int i=0; i<this.size(); i+=2) {
                oddItems.add(this.get(i).getReturnValue());
            }
        }
        return oddItems;
    }
}