package testing;

public class Main {
    public static void main(String[] args) {

        DataFiltering dataFiltering = new DataFiltering();
        dataFiltering.printList(FlightBuilder.createFlights());

        dataFiltering.excludeDepartureToCurrentMomentOfTime(FlightBuilder.createFlights());

        dataFiltering.excludeSegmentsWithArrivalDateEarlierThanDepartureDate(FlightBuilder.createFlights());

        dataFiltering.excludeTotalTimeSpentOnEarthExceedTwoHours(FlightBuilder.createFlights());
    }
}
