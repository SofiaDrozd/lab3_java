package touristfirm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Tour implements Comparable<Tour> {
    private String name;
    private int duration;
    private double price;

    public Tour() {}

    @JsonCreator
    public Tour(@JsonProperty("name") String name,
                @JsonProperty("duration") int duration,
                @JsonProperty("price") double price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder {
        private String name;
        private int duration;
        private double price;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Tour build() {
            return new Tour(name, duration, price);
        }
    }

    @Override
    public String toString() {
        return String.format("Tour{name='%s', duration=%d, price=%.2f}", name, duration, price);
    }

    @Override
    public int compareTo(Tour other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tour)) return false;
        Tour other = (Tour) obj;
        return duration == other.duration &&
                Double.compare(other.price, price) == 0 &&
                Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, price);
    }
}
