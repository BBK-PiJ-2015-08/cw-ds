/**
 *
 StackImpl: This class must have only one constructor with only one
 parameter of type List (i.e. a stack can be created using either
 an ArrayList or a LinkedList as the underlying data structure).
 */
public class StackImpl extends AbstractStack {
    /**
     * An implementation of a stack that uses a {@List} as the underlying
     * data structure.
     *
     * Not all operations on a stack will always be successful. For
     * example, a programmer may try to pop an element from an empty
     * stack. Since we hace not covered exceptions yet, we need another
     * mechanism to report errors. In order to do that, methods of this
     * list will return a {@see ReturnObject} that will contain either an
     * object or an error value of the right kind (as defined in {@see
     * ErrorMessage}).
     */

        /**
         * Creates a new abstract stack using the provided list as the
         * underlying data structure.
         *
         * Note: This constructor does not check whether the provided list
         * is null. Programmers must do their own checks. If a null list
         * is provided, a NullPointerException will be thrown at runtime
         * as soon as any operation is attempted on the underlying list.
         *
         * @param list the list to be used
         */

        @Override

        /**
         * Returns true if the stack is empty, false otherwise.
         *
         * @return true if the stack is empty, false otherwise.
         */
        public boolean isEmpty() {
            return false;
        }

        @Override
        /**
         * Returns the number of items currently in the stack.
         *
         * @return the number of items currently in the stack
         */
        public int size() {
            return 0;
        }

        @Override

        /**
         * Adds an element at the top of the stack.
         *
         * @param item the new item to be added
         */
        public void push(Object item) {

        }

        @Override
        /**
         * Returns the element at the top of the stack. The stack is
         * left unchanged.
         *
         * @return If stack is not empty, the item on the top is returned. If the
         *         stack is empty, an appropriate error.
         */
        public ReturnObject top() {
            return null;
        }

        @Override
        /**
         * Returns the element at the top of the stack. The element is
         * removed frmo the stack.
         *
         * @return If stack is not empty, the item on the top is returned. If the
         *         stack is empty, an appropriate error.
         */
        public ReturnObject pop() {
            return null;
        }
    }
}