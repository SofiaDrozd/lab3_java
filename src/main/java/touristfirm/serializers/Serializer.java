package touristfirm.serializers;

import java.io.IOException;
import java.util.List;

public interface Serializer<T> {
    void serialize(List<T> objects, String filePath) throws IOException;
    List<T> deserialize(String filePath) throws IOException;
}
