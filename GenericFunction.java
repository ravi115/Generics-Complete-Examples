package org.generics;

/**
 * Generics class: - 
 * public class Box<T1,T2,T3,T4,......Tn> 
 * {
 * 
 * }
 * @author ravir
 *
 * Box<T> is known as type parameter.
 * Box<String> is known as type arguments.
 */


/**
 * We can have generics interfaces.
 *
 */

interface Box<K, V> {
	
	K getKey();
	V getValue();
}
/**
 * 
 * Circle class is implementing interface box generics interface. 
 * we can use directly Box without passing type parameter(Box<K, V>) but we will get compiler warnings.(i.e : row type)
 * @param <K>
 * @param <V>
 */
class Circle<K, V> implements Box<K, V> {

	private K data1;
	private V data2;
	
	public Circle(K data1, V data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return data1;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return data2;
	}

}

/**
 * Generics methods.
 * The syntax for a generic method: - 
 *  includes a type parameter, inside angle brackets, and appears before the method's return type. 
 *  (e.g: assess_Specifier <T> returnType methodName)
 *  For static generic methods, the type parameter section must appear before the method's return type.
 * 
 */

class Utill {
	
	//generics methods
	
	public static <K, V> boolean compareFruits( Fruits<K, V> f1, Fruits<K, V> f2)  {
		
		return (f1.getData1().equals(f2.getData1()) && (f1.getData2().equals(f2.getData2())));	
	}
}

class Fruits<K, V> {

	private K data1;
	private V data2;
	
	public Fruits(K data1, V data2 ) {
		this.data1 = data1;
		this.data2 = data2;
	}

	public K getData1() {
		return data1;
	}

	public void setData1(K data1) {
		this.data1 = data1;
	}

	public V getData2() {
		return data2;
	}

	public void setData2(V data2) {
		this.data2 = data2;
	}
	
	
}

public class GenericFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Generics interfaces--->");
		
		Circle<String, Integer> obj1 = new Circle<String, Integer>("ravi from interface", 5);
		
		Circle<String, Integer> obj2 = new Circle<>("ranjan from interface", 55);
		
		String str = obj1.getKey();
		int n = obj2.getValue();
		
		System.out.println("value K : = " + str + " " + " value V : = " + n);
		
		System.out.println("usage of genertics method implenetation : ---->");
		
		Fruits<String, Integer> f1 = new Fruits<>("apple", 3);
		Fruits<String, Integer> f2 = new Fruits<>("carrot", 4);
		
		boolean bResult = Utill.compareFruits(f1, f2);
		System.out.println("Result of above is : " + bResult);
		
		Fruits<String, Integer> f3 = new Fruits<>("orange", 3);
		Fruits<String, Integer> f4 = new Fruits<>("orange", 3);
		
		//can call this way also
		boolean bResultSame = Utill.<String, Integer>compareFruits(f3, f4);
		System.out.println("Same : " + bResultSame);
	}

}
