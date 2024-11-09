package touristfirm;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TouristFirm {
    private List<Tour> tours;
    private LocalDate foundationDate;

    // конструктор для ініціалізації турів і дати створення
    public TouristFirm(List<Tour> tours, LocalDate foundationDate) {
        this.tours = tours;
        this.foundationDate = foundationDate;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    // дешевше за ціною
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
}
