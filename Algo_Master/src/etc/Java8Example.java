package etc;

import java.util.function.Function;

public class Java8Example {

	// Functional interface 란? 
	// abstract function 한개만을 가진 interface
	
	public static void main(String[] args) {
		
		// Clean way
		Function<String, Integer> toIntFn = value -> Integer.parseInt(value);
		
		System.out.println(toIntFn.apply("1212"));
		
		// Identity Function
		final Function<Integer, Integer> identity = Function.identity();
		// input t, output t
		final Function<Integer, Integer> identity1 = t -> t;
		System.out.println(identity.apply(100));
		
		
		
		// 기존 방법
		Function<String, Integer> toInt = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		
		Integer apply = toInt.apply("123");
		System.out.println(apply);
		
		
		
	}
}
