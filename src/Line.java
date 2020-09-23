
//16.3 Line Class
public class Line {
    protected Point start;
    protected Point end;
    protected double slope;
    protected double y_intercept;
    public Line(Point start_point, Point end_point) {
        start = start_point;
        end = end_point;
        slope = (end.y - start.y)/(end.x - start.x);
        y_intercept = start.y - (slope*start.x);
    }
}
