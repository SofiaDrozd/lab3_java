package touristfirm.serializers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import touristfirm.Tour;

public class JsonSerializer implements Serializer<Tour> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(List<Tour> tours, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), tours);
    }

    @Override
    public List<Tour> deserialize(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Tour>>() {});
    }
}
