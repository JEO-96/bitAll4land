package day5.factoryMethod;

public class FactoryPatterTest {

	public static void main(String[] args) {

		// 팩토리 클래스에서 객체를 생성 후 반환
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape shape1 = shapeFactory.getShape("CIRCLE");

		shape1.draw();

		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		shape2.draw();

		Shape shape3 = shapeFactory.getShape("SQUARE");

		shape3.draw();
	}

}
