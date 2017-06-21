package org.generics;

import java.util.ArrayList;
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
	}

}
