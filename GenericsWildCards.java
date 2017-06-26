package org.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * In generic code, the question mark (?), called the wildcard, represents an unknown type.
 * 
 * To declare an upper-bounded wildcard, use the wildcard character ('?'), followed by the extends keyword, 
 * followed by its upper bound. 
 * Note that, in this context, extends is used in a general sense to mean 
 * either "extends" (as in classes) or "implements" (as in interfaces).
 * 
 * e.g: - 
 * 
 * List<? extends Foo> list
 * @author ravir
 *
 */
/*
 * see the below example illustrated by class heirarchy. 
 */
/*==============================================UPPER BOUND=====================================================*/
interface U {
	
}

class S implements U {
	
}

class T extends S {
	
}

class WildCardDemo {
	
	public static void display(List<? extends S> list) { //as you see, all the subclass of S is acceptable here.
		
		for(S s : list) {
			System.out.println("Class : " + s.getClass().getName());
		}
	}
}
class Wildcards {
	
	
	public void diaplay(List<? extends Number> list) {
		
	}
}

/*================================================== End of UPPER Bound ================================================*/


/*================================================== Start of UnBound WildCards ================================================*/


/*The unbounded wildcard type is specified using the wildcard character (?), 
 * for example, List<?>. This is called a list of unknown type. 
 * There are two scenarios where an unbounded wildcard is a useful approach:

If you are writing a method that can be implemented using functionality provided in the Object class.
When the code is using methods in the generic class that don't depend on the type parameter. 
For example, List.size or List.clear. In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.*/

class UnBounded {
	
	
	public static void displayAnything(List<?> list) {
		for(Object elem : list) {
			System.out.println("List Contents are : " + elem);
		}
	}
}



/*================================================== End of UnBound WildCards ================================================*/


/*================================================== Start of LowerBounded WildCards ================================================*/


/*
 * The Upper Bounded Wildcards section shows that an upper bounded wildcard restricts the unknown type to be a specific type or 
 * a subtype of that type and is represented using the extends keyword. 
 * In a similar way, a lower bounded wildcard restricts the unknown type to be a specific type or a super type of that type.

 *A lower bounded wildcard is expressed using the wildcard character ('?'), following by the super keyword, 
 *followed by its lower bound: <? super A>.

 *Note: You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both.
 *Say you want to write a method that puts Integer objects into a list. To maximize flexibility, 
 *you would like the method to work on List<Integer>, List<Number>, and List<Object> — anything that can hold Integer values.

 *To write the method that works on lists of Integer and the supertypes of Integer, 
 *such as Integer, Number, and Object, you would specify List<? super Integer>. 
 *The term List<Integer> is more restrictive than List<? super Integer> because the former matches a list of type Integer only, */

class LowerBounded {
	
	
	public static void displayAnything(List<? super Integer> list) {
		for(Object elem : list) {
			System.out.println("List Contents are : " + elem);
		}
	}
}

interface I {
	
}
class A1 implements I{
	
}

class A2 extends A1 {
	
}
class A3 extends A2 {

}
/*the type parameter (?) - can be anything like - I,A1,A2,A3*/
class LowerBoundedDemo {
	
	public static void demo(List<? super A3> list) {
		for(Object elem : list) {
			System.out.println("display : " + elem);
		}
	}
}
/*================================================== End of LowerBounded WildCards ================================================*/

/*================================================SPECIAL POINTS===================================================================*/

/*when ever we are inserting data then always use super wildcard: (Like: - List<? super Class> obj)*/
class G {
	public static void insert(List<? super Integer> list) {
		list.add(1);
	}
}
/*whenever we are reading data then always use Extends wildCard: (Like:-  List<? extends class> obj)*/ 

class G1 {
	public static void getListData(List<? extends Integer> list) {
		list.get(0);
	}
}

/*when ever we are performing both reading and writing of data, never use wildcard.*/

class G2 {
	public static void updateList(List<Integer> list) {
		//reading list
		list.get(0);
		//writing list
		list.add(1);
		/*so no need of using wildCard at all*/
	}
}

/*=================================================================================================================================*/


public class GenericsWildCards {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<S> list = new ArrayList<>();
		S s = new S();
		list.add(s);
		
		List<T> list_t = new ArrayList<>();
		T t = new T();
		list_t.add(t);
		
		U u = new S();
		List<U> list_u = new ArrayList<>();
		list_u.add(u);
		
		WildCardDemo.display(list);
		WildCardDemo.display(list_t);
		WildCardDemo.display((List<? extends S>) list_u);
		
		List<Integer> list_i = Arrays.asList(1,2,3,4,5);
		UnBounded.displayAnything(list_i);
		
		List<String> list_s = Arrays.asList("raj","kaj","naj","saj");
		UnBounded.displayAnything(list_s);
		
		List<Integer> lst =  Arrays.asList(1,2,3,4,5);
		LowerBounded.displayAnything(lst);
		
		List<String> lsts =  Arrays.asList("raj","kaj","naj","saj");
		/*below line is an error because the lower bound has restricted the parameter type which can be superclass  of Integer only*/
		//LowerBounded.displayAnything(lsts);
	
		/*see the below example;-  in the function demo the parameter type can be anything who is super-class of A3.
		 * 
		 */
		List<A1> list_a1 = new ArrayList<>();
		LowerBoundedDemo.demo(list_a1);
		
		List<A2> list_a2 = new ArrayList<>();
		LowerBoundedDemo.demo(list_a2);
		
		List<A3> list_a3 = new ArrayList<>();
		LowerBoundedDemo.demo(list_a3);
		
		List<I> list_I = new ArrayList<>();
		LowerBoundedDemo.demo(list_I);
	}

}
