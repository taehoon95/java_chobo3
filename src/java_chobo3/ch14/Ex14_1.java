package java_chobo3.ch14;

@FunctionalInterface
interface MyFunction01 {
	void run();
}

public class Ex14_1 {

	static void execute(MyFunction01 f) {
		f.run();
	}
	
	static MyFunction01 getMyFunction01() {
		MyFunction01 f = () -> System.out.println("f3.run()");
		return f;
	}
	
	public static void main(String[] args) {
		MyFunction01 f1 = () -> System.out.println("f1.run()");
		
		MyFunction01 f2 = new MyFunction01() {
			@Override
			public void run() {
				System.out.println("f2.run()");
			}
		};
		
		MyFunction01 f3 = getMyFunction01();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute(() -> System.out.println("run()"));
	}
}
