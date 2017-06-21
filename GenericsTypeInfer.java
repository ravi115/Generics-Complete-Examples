package org.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Type inference in generic.
 * 
 * Type inference is a Java compiler's ability to look at each method invocation and corresponding declaration
 * to determine the type argument (or arguments) that make the invocation applicable. 
 * The inference algorithm determines the types of the arguments and, if available, 
 * the type that the result is being assigned, or returned. 
 * Finally, the inference algorithm tries to find the most specific type that works with all of the arguments.
 * @author ravir
 *
 */

class Container<U> {
	
	private U u;
	

	public U getU() {
		return u;
	}

	public void setU(U u) {
		this.u = u;
	}
	
	
}


class ContainerDemo {
	
	public static <U> void fillContainer(U u, List<Container<U>> objContainer) {
		Container<U> container = new Container<>();
		container.setU(u);
		objContainer.add(container);
	}
	
	public static <U> void displayContainer(List<Container<U>> objContainer) {
		
		int counter = 0;
		for(Container<U> container : objContainer) {
			
			U containerData = container.getU();
			System.out.println( " Conatainer # " + counter + " contains [" + containerData + "]");
			counter++;
		}
	}
}

/*
 * here if you use Class<DataType1, DataType2> obj = new Class(); //then this will compile fine but it will give an unchecked
 * warning, saying that constructor refers to the Class raw type . so it is necessary to declare like below this. 
 * class<DataType1, DataType2>  obj = new Class<>();
 * 
 * 
 */

/*
 * special note: - in JAVA SE 7 Compiler,-
 * class Collections {
 * 
 *  	public <T> List<T> emptyList() // this methods return List<T>. 
 *  	{
 *  
 * 	 	}
 * } 
 * 
 * 
 * see the callee class :  List<String> list = Collections.emptyList(); works fine similar to List<String> list = Collections.<String>emptyList(); 
 * but suppose there is another functions like: - 
 * 
 * class X {
 * 		public static void processList(List<String> list)
 * 		{
 * 
 * 		}
 * }
 * 
 * now call the above method.
 * X.processList(Collections.emptyList()); // this will produce compile time error, saying that Collections.emptyList() functions
 * returns List<Object> witch is not acceptable by List<String> in function processList(List<String)
 * 
 * so in order to solve the above error, we must have to call the function in this way, - 
 * 
 * X.prosessList(Collections.<String>emptyList())
 * 
 * but this problem got resolved in JAVA SE 8 Compiler, - 
 * 
 * we can infer type this way, - 
 * X.processList(Collections.emptyList()) //works fine in JAVA SE 8.
 */
public class GenericsTypeInfer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		List<Container<Integer>> list = new ArrayList<>();
		ContainerDemo.fillContainer(Integer.valueOf(10), list);
		ContainerDemo.<Integer>fillContainer(Integer.valueOf(20), list);
		ContainerDemo.<Integer>fillContainer(Integer.valueOf(30), list);
		ContainerDemo.fillContainer(Integer.valueOf(40), list);
		ContainerDemo.displayContainer(list);

	}

}
