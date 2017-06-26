package org.generics;

import java.util.List;


/**
 * Type Erasure: - 
 * 
 * 	Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. 
 * 	The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
 *	Insert type casts if necessary to preserve type safety.
 *	Generate bridge methods to preserve polymorphism in extended generic types.
 *
 * 
 * @author ravir
 *
 */

/*=========================================================Type Erasure=====================================================*/
class B1 {
	
}

class B2 extends B1 {
	
}

class B3 extends B2 {
	
}


class TestTypeErasure {
	
	public <T> void display(T data, List<? extends B1> list) {
		System.out.println(list);
	}
}

/*
 *in the above example, the compiler will use type eraser and treat the class like this. 
 * basically, whichever class is used for upper bound, with that class actual type parameter will get replaced.
 * see the below example. 
 * 
 */
class TestTypeErasureAfterCompiler {
	
	public <B1> void display(B1 data, B1 list) {
		System.out.println(list);
	}
}

/*=========================================================End of Type Erasure=====================================================*/

class Node<T> {
	
	public T data;
	
	public Node(T data) {
		this.data = data;
	}
	
	public void setData(T data) {
		System.out.println("Node.setData");
		this.data = data;
	}
}

class MyNode extends Node<Integer> {
	
	public MyNode(Integer data) {
		super(data);
		
	}
	
	public void setData(Integer data) {
		System.out.println("Node.setData");
		super.setData(data);
	}
}

public class GenericsTypesErasure {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyNode mn = new MyNode(3);
		Node n = mn;
		n.setData("Hello");
		Integer x = mn.data; //class cast exception will be thrown.
		
		/*
		 * see how compiler creates bridge method to preserve polymorphism.
		 *  
		 *  in class Node:- 
		 *  
		 *  public void setData(Object data){
		 *  this.data = data
		 *  } 
		 *  
		 *  but in class MyNode: - 
		 *  
		 *  public void setData(Integer data) {
		 *  super.setData(data);
		 *  }
		 *  
		 *  as you can see the above two method falling the polymorphism, since the method signature got changed (Object -> Integer)
		 *  
		 *  so, compiler will generate a bridge method in sub class like this: -
		 *  
		 *  public void setData(Object data) {
		 *  setData((Integer)data);
		 *  } which preserves the polymorphism.
		 * 
		 * 
		 * 
		 */
	}

}
