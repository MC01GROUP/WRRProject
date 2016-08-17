package nmmu.wrap302.Task01;

/**
 * Created by s214252914 on 2016/08/16.
 */
public class Routes {
    public class Route
    {
        String routeNr, StartDest, EndDest, Description;
        int dist;

        public Route(String routeNr, String startDest, String endDest, String description, int dist) {
            this.routeNr = routeNr;
            StartDest = startDest;
            EndDest = endDest;
            Description = description;
            this.dist = dist;
        }
    }

}
