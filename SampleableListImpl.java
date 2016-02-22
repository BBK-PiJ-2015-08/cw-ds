/**
 * @author Jade Dickinson jdicki04
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
    public SampleableListImpl() {
        super();
    }

    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty.
     *
     * @return a list containing the first, third, fifth... items of this list
     */
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