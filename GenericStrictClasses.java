package org.generics;

import java.util.List;


/**
 * We will see some descriptions and examples on BOUNDED TYPE PARAMETER.
 * as its name says, we are restricting the parameter type.
 * like Box<T>, in this, if we want  T can only belong to specific class then, we should give some restrictions on T.
 * like Box<T extends Number> :-  so T can only be passed for number type arguments. 
 * 
 * so it can extends or implements { <T extends SuperClass> or <T implements SuperInterface>}
 *
 */

//<============================================ one complete set of related code ======================================================>
/**
 * 
 * This below dummy example shows how we can implements bound.
 *
 */
class A {
	
}
interface B{
	
}
interface C {
	
}
/*
 * if we are including combination of any super class and interface then in bounding type parameter list super class always comes first
 * then interfaces will come. otherwise it will give compile time error.
 * cannot be like this : - class D<T extends B & C & A>{}
 * 
 */
class Test<T extends A & B & C > {
	
}


/*
 *Illustration of bound Type Parameter.  
 * 
 */
class Boxer<T> {
	
	private T t;
	
	public Boxer(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	/*here we are restricting our [Type Parameter to Number class only], so only Number class type arguments are acceptable by
		this method*/
	public <U extends Number> void getDataTypeInformation(U u) {
		System.out.println("T belongs to : " + t.getClass().getName());
		System.out.println("U belongs to : " + u.getClass().getName());
	}
	
	
}

//<---------------------------------------------------END of one Complete set of related code---------------------------------------->


//<============================================ one complete set of related code ======================================================>
/*
 * as we all know, generic functions work with only autoBoxing type of data. means can work only with class type not with primitive type.
 * so the operations which is not supported by Class Type data will too not work in generics. 
 * see the below examples.
 * 
 */

interface Comparable<T> {
	public int compareTo(T o);
}

class TestGenerics {
	
	/*public static <T> int doCompare(T[] nArray, T elem) {
		int returnValue = 0;
		for(T e : nArray) {
			if(e > elem)  at this line we are getting compile error because [>] symbol works only with primitive data Type.
			{
				returnValue = 1;
			}else {
				returnValue = -1;
			}
		}
		return returnValue;
	}*/
	
	//in order to solve the above above problem, we have to use Comparable interface 
	
	public static <T extends Comparable<T>> int CompareTo(T[] nArray, T elem) {
		int returnValue = 0;
		
		for(T e : nArray) {
			if(e.compareTo(elem) > 0) {
				returnValue++;
			}
		}
		return returnValue;
	}
}
//<---------------------------------------------------END of one Complete set of related code---------------------------------------->


//<============================================ one complete set of related code ======================================================>
/*
 *one more important concepts.
 *if class c and class B is related means it is subclass of class A, it doesn't mean that it will work same way in generics.
 *see the below hierarchy of class and it's generics usages.   
 */

class P {
	
}
//relation of class Q->p
class Q extends P {
	
}
//relation of class R->P
class R extends P {
	
}
//no generic usages 
class TestRelationShip<T extends P> {
	
}

class TestRelation {
	
	public void working(TestRelationShip<P> t) {
		
	}
}

class PassTestAgruments {
	
	public void checkWorkingMethod() {
		
		TestRelation obj = new TestRelation();
		TestRelationShip<Q> q = new TestRelationShip<>();
		TestRelationShip<Q> r = new TestRelationShip<>();
		/*obj.working(q); // here you can see Q is subClass of P Although it is not accepting arguments of TestRelationShip<x extends y>
		obj.working(r);
		*/
		

		
	}
}

//<---------------------------------------------------END of one Complete set of related code---------------------------------------->



//Main function containing classes.

public class GenericStrictClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Boxer<String> obj = new Boxer<>("ravi");
		obj.getDataTypeInformation(9);
		obj.getDataTypeInformation(9.00);
		obj.getDataTypeInformation(9.6f);
		/* below method call cannot be possible since String data doesn't belong to number class.  
		obj.getDataTypeInformation("Hello");
		*/
	}

}
