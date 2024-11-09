package touristfirm.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import touristfirm.Tour;

public class YamlSerializer implements Serializer<Tour> {
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    @Override
    public void serialize(List<Tour> tours, String filePath) throws IOException {
        yamlMapper.writeValue(new File(filePath), tours);
    }

    @Override
    public List<Tour> deserialize(String filePath) throws IOException {
        return yamlMapper.readValue(new File(filePath), yamlMapper.getTypeFactory().constructCollectionType(List.class, Tour.class));
    }
}
