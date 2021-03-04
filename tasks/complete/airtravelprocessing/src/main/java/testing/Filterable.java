package testing;

import java.util.List;

public interface Filterable {
    void excludeDepartureToCurrentMomentOfTime(List<Flight> flightList);
    void excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flightList);
    void excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flightList);

}
