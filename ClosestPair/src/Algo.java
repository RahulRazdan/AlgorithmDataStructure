import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class Algo.
 */
public class Algo {

	/** The points. */
	private List<Point> points;
	
	/**
	 * Instantiates a new algo.
	 *
	 * @param points the points
	 */
	public Algo(List<Point> points) {
		super();
		this.points = points;
	}

	/**
	 * Distance.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the double
	 */
	private double distance(Point x, Point y) {
		
		double x1 = Math.abs(x.getX()-y.getX());
		double y1 = Math.abs(x.getY()-y.getY());
		
		return Math.sqrt(x1*x1 + y1*y1);
	}

	/**
	 * Closest strip.
	 *
	 * @param pointsInStrip the points in strip
	 * @param sigma the sigma
	 * @return the double
	 */
	private double closestStrip(List<Point> pointsInStrip,double sigma) {
		
		double  minDistance = sigma;
		
		for(int i=0;i<pointsInStrip.size();i++) {
			for(int j=i+1;j<pointsInStrip.size() && (pointsInStrip.get(j).getY() - pointsInStrip.get(i).getY()) < minDistance;j++) {
				if(distance(pointsInStrip.get(i), pointsInStrip.get(j)) < minDistance) {
					minDistance = distance(pointsInStrip.get(i), pointsInStrip.get(j));
				}
			}
		}
		
		return minDistance;
	}
	
	/**
	 * Solve problem.
	 *
	 * @return the double
	 */
	public double solveProblem() {
		List<Point> xpoint = new ArrayList<>();
		List<Point> ypoint = new ArrayList<>();
		
		for(Point point : points) {
			xpoint.add(point);
			ypoint.add(point);
		}
		
		Collections.sort(xpoint, new XSorter());

		return findClosestStrip(xpoint,ypoint,xpoint.size());
	}
	
	
	/**
	 * Find closest strip.
	 *
	 * @param xpoint the xpoint
	 * @param ypoint the ypoint
	 * @param size the size
	 * @return the double
	 */
	private double findClosestStrip(List<Point> xpoint, List<Point> ypoint, int size) {
		if(size <=3) return bruteForce(xpoint);
		
		int middleIndex = size/2;
		
		Point middlePoint = xpoint.get(middleIndex);
		
		List<Point> leftSubY = new ArrayList<>();
		List<Point> leftSubX = new ArrayList<>();
		List<Point> rightSubY = new ArrayList<>();
		List<Point> rightSubX = new ArrayList<>();
		
		for(int index=0;index<size;index++) {
			if(ypoint.get(index).getX() <= middlePoint.getX()) {
				leftSubY.add(ypoint.get(index));
				leftSubX.add(xpoint.get(index));
			}else {
				rightSubY.add(ypoint.get(index));
				rightSubX.add(xpoint.get(index));	
			}
		}
		
		
		double leftSigme = findClosestStrip(leftSubX, leftSubY, middleIndex);
		double rightSigma = findClosestStrip(rightSubX, rightSubY, size-middleIndex);
		
		double sigma =  Math.min(leftSigme, rightSigma);
		
		List<Point> pointsInStrip =  new ArrayList<>();
		
		for(int index=0;index<size;index++) {
			if(Math.abs(ypoint.get(index).getX() - middlePoint.getX()) < sigma)
				pointsInStrip.add(ypoint.get(index));
		}
		
		double minDistanceStrip = closestStrip(pointsInStrip , sigma);
		
		return Math.min(sigma,minDistanceStrip);
	}

	/**
	 * Brute force.
	 *
	 * @param points the points
	 * @return the double
	 */
	public double bruteForce(List<Point> points) {
		  double minDistance = Double.MAX_VALUE;
		  
		  for(int i=0;i<points.size();i++) {
			  for(int j=i+1;j<points.size();j++) {
				  if(distance(points.get(i),points.get(j)) < minDistance)
					  minDistance = distance(points.get(i),points.get(j));
			  }
		  }
		  return minDistance;	
	}
}
