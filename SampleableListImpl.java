/**
 * @author Jade Dickinson jdicki04
 */
public class SampleableListImpl extends ArrayList implements SampleableList {
    /**
     * @see SampleableList
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