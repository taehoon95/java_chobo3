package java_chobo3.ch09;

class Circle implements Cloneable {
	Point p;
	double r;

	public Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
			Circle c = (Circle)obj;
			c.p = new Point(this.p.x, this.p.y);
//			c.p = (Point) this.p.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String toString() {
		return String.format("Circle p=%s, r=%s", p, r);
	}

}

public class Point implements Cloneable {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return String.format("Point x=%s, y=%s", x, y);
	}

	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static void main(String[] args) {
		Point p1 = new Point(3, 4);
//		Point cpP1 = (Point) p1.clone();
		System.out.println(p1);
//		System.out.println(cpP1);

		Circle c1 = new Circle(p1, 3);
		Circle c2 = (Circle) c1.clone();
		System.out.println(System.identityHashCode(c1));
		System.out.println(System.identityHashCode(c2));
		System.out.println(System.identityHashCode(c1.p));
		System.out.println(System.identityHashCode(c2.p));
		System.out.println(c1.equals(c2));
		System.out.println(c2.p);

	}
}
