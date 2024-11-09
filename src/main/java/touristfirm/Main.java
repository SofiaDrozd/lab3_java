package touristfirm;

import touristfirm.serializers.JsonSerializer;
import touristfirm.serializers.XmlSerializer;
import touristfirm.serializers.YamlSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Tour> tourList = new ArrayList<>(Arrays.asList(
                new Tour.Builder().setName("Europe Adventure").setDuration(10).setPrice(1500).build(),
                new Tour.Builder().setName("Asia Discovery").setDuration(15).setPrice(1200).build(),
                new Tour.Builder().setName("America Highlights").setDuration(7).setPrice(1800).build(),
                new Tour.Builder().setName("Africa Safari").setDuration(12).setPrice(1400).build()
        ));

        LocalDate foundationDate = LocalDate.of(2000, 5, 15); // Дата заснування фірми
        TouristFirm touristFirm = new TouristFirm(tourList, foundationDate);

        System.out.println("Date of foundation: " + touristFirm.getFoundationDate()); // Виведення дати заснування

        JsonSerializer jsonSerializer = new JsonSerializer();
        XmlSerializer xmlSerializer = new XmlSerializer();
        YamlSerializer yamlSerializer = new YamlSerializer();

        String jsonFile = "tours.json";
        String xmlFile = "tours.xml";
        String yamlFile = "tours.yaml";

        try {
            // Сериалізація у JSON
            jsonSerializer.serialize(tourList, jsonFile);
            List<Tour> jsonTours = jsonSerializer.deserialize(jsonFile);
            System.out.println("JSON serialized data:\n" + new ObjectMapper().writeValueAsString(jsonTours));

            // Сериалізація у XML
            xmlSerializer.serialize(tourList, xmlFile);
            List<Tour> xmlTours = xmlSerializer.deserialize(xmlFile);
            System.out.println("XML serialized data:\n" + new XmlMapper().writeValueAsString(xmlTours));

            // Сериалізація у YAML
            yamlSerializer.serialize(tourList, yamlFile);
            List<Tour> yamlTours = yamlSerializer.deserialize(yamlFile);
            System.out.println("YAML serialized data:\n" + new YAMLMapper().writeValueAsString(yamlTours));

//            // Десеріалізація з YAML
//            List<Tour> toursFromYaml = yamlSerializer.deserialize(yamlFile);
//            System.out.println("YAML deserialized data:\n" + new YAMLMapper().writeValueAsString(toursFromYaml));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
