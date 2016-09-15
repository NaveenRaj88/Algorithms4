import java.util.List;

/**
 * Created by Naveen Kumar .A on 9/15/16.
 */
public class FastCollinearPoints {

    private List<LineSegment> lineSegments;

    public FastCollinearPoints(){

    }


    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        int size = lineSegments.size();
        LineSegment[] lineSeg = new LineSegment[size];
        return  lineSegments.toArray(lineSeg);
    }

    private  void checkNullOrDuplicates(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i] == null || points[j] == null) {
                    throw new NullPointerException("null element in the array");
                }
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("duplicate points in the array");
                }
            }
        }
    }
}
