import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Naveen Kumar .A on 9/15/16.
 */
public class FastCollinearPoints {

    private int minCollinearCount = 3;

    List<LineSegment> lineSegments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("argument is null");
        }
        checkNullOrDuplicates(points);
        // sort the array
        Arrays.sort(points);
        Point[] jCopy = points.clone();
        Arrays.sort(jCopy);

        for (int i = 0; i < jCopy.length - 3; i++) {
            Arrays.sort(jCopy);

            // Sort the points according to the slopes they makes with p.
            // Check if any 3 (or more) adjacent points in the sorted order
            // have equal slopes with respect to p. If so, these points,
            // together with p, are collinear.

            Arrays.sort(jCopy, jCopy[i].slopeOrder());

            for (int p = 0, first = 1, last = 2; last < jCopy.length; last++) {
                // find last collinear to p point
                while (last < jCopy.length
                        && Double.compare(jCopy[p].slopeTo(jCopy[first]), jCopy[p].slopeTo(jCopy[last])) == 0) {
                    last++;
                }
                // if found at least 3 elements, make segment if it's unique
                if (last - first >= 3 && jCopy[p].compareTo(jCopy[first]) < 0) {
                    lineSegments.add(new LineSegment(jCopy[p], jCopy[last - 1]));
                }
                // Try to find next
                first = last;
            }
        }
        // finds all line segments containing 4 or more points
//    }


        int n = points.length;
        // copy the array
        Point[] pointsCopy = points.clone();
        for(int i = 0; i < n-1; i++) {
            //Sort the array with respect to one of the points
            Arrays.sort(pointsCopy, points[i].slopeOrder());
            int adjacentSlopeCount = 0;
            double previousSlope = Double.NEGATIVE_INFINITY;
            for (int j = 1; j <n ; j++) {
                double currentSlope = pointsCopy[0].slopeTo(pointsCopy[j]);
                if(currentSlope == previousSlope){
                    adjacentSlopeCount++;
                }else{
                    if(adjacentSlopeCount >= minCollinearCount){
                        lineSegments.add(new LineSegment(pointsCopy[0], pointsCopy[j-1]));
                    }
                    previousSlope = currentSlope;
                    adjacentSlopeCount=0;
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
