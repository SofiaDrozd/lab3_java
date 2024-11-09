package touristfirm.serializers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import touristfirm.Tour;

public class XmlSerializer implements Serializer<Tour> {
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void serialize(List<Tour> tours, String filePath) throws IOException {
        xmlMapper.writeValue(new File(filePath), tours);
    }

    @Override
    public List<Tour> deserialize(String filePath) throws IOException {
        return xmlMapper.readValue(new File(filePath), xmlMapper.getTypeFactory().constructCollectionType(List.class, Tour.class));
    }
}
