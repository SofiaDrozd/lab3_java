package touristfirm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TouristFirm {
    private List<Tour> tours;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")  // Формат дати
    private LocalDate foundationDate;

    @JsonCreator
    public TouristFirm(
            @JsonProperty("tours") List<Tour> tours,
            @JsonProperty("foundationDate") LocalDate foundationDate) {
        this.tours = tours;
        this.foundationDate = foundationDate;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public List<Tour> findToursCheaperThan(double maxPrice) {
        return tours.stream()
                .filter(tour -> tour.getPrice() < maxPrice)
                .collect(Collectors.toList());
    }

    public List<Tour> sortToursByDuration() {
        return tours.stream()
                .sorted(Comparator.comparingInt(Tour::getDuration))
                .collect(Collectors.toList());
    }

    public Optional<Tour> findTourByName(String name) {
        return tours.stream()
                .filter(tour -> tour.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public void printAllTours() {
        tours.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "TouristFirm{" +
                "tours=" + tours +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
