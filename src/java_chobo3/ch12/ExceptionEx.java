package java_chobo3.ch12;

class Parent{
	void parentMethod() {}
}

class Child extends Parent{
	@Override
	void parentMethod() {}	
}

@SuppressWarnings("serial")
public class ExceptionEx extends Exception {

}
