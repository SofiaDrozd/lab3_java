package touristfirm;

import touristfirm.serializers.JsonSerializer;
import touristfirm.serializers.XmlSerializer;
import touristfirm.serializers.YamlSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкти серіалізаторів
        JsonSerializer jsonSerializer = new JsonSerializer();
        XmlSerializer xmlSerializer = new XmlSerializer();
        YamlSerializer yamlSerializer = new YamlSerializer();

        // Назви файлів
        String jsonFile = "tours.json";
        String xmlFile = "tours.xml";
        String yamlFile = "tours.yaml";

        try {
            // Читання даних з YAML файлу
            TouristFirm yamlTouristFirm = yamlSerializer.deserialize(yamlFile, TouristFirm.class);
            System.out.println("Зчитані дані з YAML файлу:\n" + yamlTouristFirm);

            jsonSerializer.serialize(yamlTouristFirm, jsonFile);
            System.out.println("Дані були збережені в JSON файлі.");

            xmlSerializer.serialize(yamlTouristFirm, xmlFile);
            System.out.println("Дані були збережені в XML файлі.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
