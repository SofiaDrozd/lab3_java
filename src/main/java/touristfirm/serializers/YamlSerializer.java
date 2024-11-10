package touristfirm.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

public class YamlSerializer {
    private final ObjectMapper yamlMapper;

    public YamlSerializer() {
        yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.registerModule(new JavaTimeModule()); // Підтримка LocalDate
    }

    public void serialize(Object object, String filePath) throws IOException {
        yamlMapper.writeValue(new File(filePath), object);
    }

    public <T> T deserialize(String filePath, Class<T> valueType) throws IOException {
        return yamlMapper.readValue(new File(filePath), valueType);
    }
}
