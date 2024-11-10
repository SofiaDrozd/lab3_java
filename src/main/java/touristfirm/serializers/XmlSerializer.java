package touristfirm.serializers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

public class XmlSerializer {
    private final XmlMapper xmlMapper;

    public XmlSerializer() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule()); // Підтримка LocalDate
    }

    public void serialize(Object object, String filePath) throws IOException {
        xmlMapper.writeValue(new File(filePath), object);
    }

    public <T> T deserialize(String filePath, Class<T> valueType) throws IOException {
        return xmlMapper.readValue(new File(filePath), valueType);
    }
}
