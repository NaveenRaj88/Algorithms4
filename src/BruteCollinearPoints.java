import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naveen Kumar .A on 9/15/16.
 */
public class BruteCollinearPoints {

    private List<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("argument is null");
        }
        checkNullOrDuplicates(points);
        lineSegments = new ArrayList<>();
        Point[] pointsCopy = points.clone();
        Arrays.sort(pointsCopy);
        int n = pointsCopy.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        double slope = pointsCopy[i].slopeTo(pointsCopy[j]);
                        if (slope == pointsCopy[i].slopeTo(pointsCopy[k]) && slope == pointsCopy[i].slopeTo(pointsCopy[l])) {
                            lineSegments.add(new LineSegment(pointsCopy[i], pointsCopy[l]));
                        }
                    }
                }
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
