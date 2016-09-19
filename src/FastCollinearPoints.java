import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naveen Kumar .A on 9/15/16.
 */
public class FastCollinearPoints {

    private List<LineSegment> lineSegments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("argument is null");
        }
        checkNullOrDuplicates(points);
        int n = points.length;
        // copy the array
        Point[] pointsCopy = points.clone();
        for (int i = 0; i < n - 3; i++) {
            Arrays.sort(pointsCopy);
            //Sort the array with respect to one of the points
            Arrays.sort(pointsCopy, pointsCopy[i].slopeOrder());
            for (int p=0,j = 1, k = 2; j < n; k++) {
                while (k < n && Double.compare(pointsCopy[p].slopeTo(pointsCopy[j]), pointsCopy[p].slopeTo(pointsCopy[k])) == 0) {
                    k++;
                }
                if (k - j >= 3 && pointsCopy[p].compareTo(pointsCopy[j]) <0) {
                    lineSegments.add(new LineSegment(pointsCopy[0], pointsCopy[k - 1]));
                }
                j = k;
            }
        }


    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        int size = lineSegments.size();
        LineSegment[] lineSeg = new LineSegment[size];
        return lineSegments.toArray(lineSeg);
    }

    private void checkNullOrDuplicates(Point[] points) {
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
