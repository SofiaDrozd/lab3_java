package touristfirm.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

public class JsonSerializer {
    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Підтримка LocalDate
    }

    public void serialize(Object object, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), object);
    }

    public <T> T deserialize(String filePath, Class<T> valueType) throws IOException {
        return objectMapper.readValue(new File(filePath), valueType);
    }
}
