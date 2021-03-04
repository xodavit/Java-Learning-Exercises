package testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class DataFiltering implements Filterable {

    public void printList(List<Flight> flightList){
        System.out.println("все рейсы:");
        flightList.forEach(System.out::println);
        System.out.println("--------------------------------");
    }
    @Override
    public void excludeDepartureToCurrentMomentOfTime(List<Flight> flightList)
    {
        //1.	вылет до текущего момента времени
        LocalDateTime now = LocalDateTime.now();
//        for (Flight fl: flightList
//        ) {
//            for (Segment seg: fl.getSegments()
//            ) {
//                if (seg.getDepartureDate().isBefore(now)) {
//                    System.out.println(seg.toString());
//                }
//            }
//        }
        System.out.println("отфильтровано по условию - вылет до текущего момента времени");
        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getDepartureDate().isBefore(now))
                .forEach(segment -> System.out.println(segment.toString())));
    }
    //2.	имеются сегменты с датой прилёта раньше даты вылета
    @Override
    public void excludeSegmentsWithArrivalDateEarlierThanDepartureDate(List<Flight> flightList) {
//        for (Flight fl: flightList
//        ) {
//            for (Segment seg : fl.getSegments()
//            ) {
//                if (seg.getArrivalDate().isBefore(seg.getDepartureDate())) {
//                    System.out.println(seg.toString());
//                }
//            }
//        }
        System.out.println("отфильтровано по условию - имеются сегменты с датой прилёта раньше даты вылета");
        flightList.forEach(flight -> flight.getSegments().stream()
                .filter(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                .forEach(segment -> System.out.println(segment.toString())));
    }

    //3.	общее время, проведённое на земле превышает два часа
    //(время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
    @Override
    public void excludeTotalTimeSpentOnEarthExceedTwoHours(List<Flight> flightList) {
        System.out.println("отфильтровано по условию - общее время, проведённое на земле превышает два часа");
        for (Flight flight: flightList
        ) {
            for (int indexSegment = 0; indexSegment < flight.getSegments().size() ; indexSegment++) {

                for (int indexNextSegment = indexSegment+1; indexNextSegment < flight.getSegments().size(); indexNextSegment++) {

                    if (!(between(flight.getSegments().get(indexSegment).getArrivalDate(),
                            flight.getSegments().get(indexNextSegment).getDepartureDate())>2)){

                        indexSegment++;
                        
                    } else System.out.println(flight.getSegments());
                }
            }
        }
    }
    public int between(LocalDateTime data1, LocalDateTime data2){

        return (int) ChronoUnit.HOURS.between(data1,data2);
    }
}
