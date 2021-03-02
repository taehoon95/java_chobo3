package java_chobo3.ch14;

@FunctionalInterface // 추상메서드 하나만 있는것을 정의(원래는 메서드 없어도 상관없지만 꼭하나를 만들어 사용해야 된다는 의미)
interface MyFunction{
	void myMethod();
}


public class LambdaEx03 {

	public static void main(String[] args) {
		
		MyFunction f = () -> System.out.println("myMethod()");
		aMethod(f);
		
		aMethod(() -> System.out.println("myMethod()"));
	}
	
	public static void aMethod(MyFunction f) {
		f.myMethod();
	}
}
