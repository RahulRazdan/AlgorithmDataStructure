import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Point> point = Arrays.asList(new Point(1,1),new Point(1,2),new Point(2,1),new Point(2,2),new Point(2,3),new Point(3,3));
		
		Algo a = new Algo(point);
		System.out.println(a.solveProblem());
	}

}
