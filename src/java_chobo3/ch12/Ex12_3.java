package java_chobo3.ch12;

class Fruit implements Eatable {
	public String toString() {
		return "Fruit";
	}
}

class Apple extends Fruit {
	public String toString() {
		return "Apple";
	}
}

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
}

class Toy {
	public String toString() {
		return "Toy";
	}
}

interface Eatable {}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

public class Ex12_3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> AppleBox = new FruitBox<Apple>();
		FruitBox<Grape> GrapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> Grape2Box = new FruitBox<Apple>();
//		FruitBox<Toy> toyBox = new FruitBox<Toy>();

		fruitBox.add(new Fruit());
		fruitBox.add(new Grape());
		fruitBox.add(new Apple());
		AppleBox.add(new Apple());
//		AppleBox.add(new Grape());
		GrapeBox.add(new Grape());

		System.out.println("fruitBox-" + fruitBox);
		System.out.println("AppleBox-" + AppleBox);
		System.out.println("GrapeBox-" + GrapeBox);
	}

}
