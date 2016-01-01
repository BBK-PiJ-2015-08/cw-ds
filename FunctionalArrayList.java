/**
 * Most classes must have only the default constructor, with no
 * arguments. The exceptions are described below. Classes may not
 * have any constructor not described in this document — be careful
 * about this because using the wrong constructors may result in
 * your code not compiling with the automatic tests used for
 * grading.
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {
	public ReturnObject head () {
		return null;
	}

	@Override
	public FunctionalList rest() {
		return null;
	}
}

/**
class A {


}
class B extends A {

}
/**class C extends B{
	CANNOT do
}
class C {
	B b;
}
*/