import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWoodLoader implements WoodLoader{
    private final BufferedReader reader;
    private final WoodDeserializer deserializer;

    public FileWoodLoader(File file, WoodDeserializer deserializer) throws IOException {
        this.deserializer = deserializer;
        this.reader = new BufferedReader(new FileReader(file));
        skipHeader();
    }

    private void skipHeader() throws IOException {
        reader.readLine();
    }

    @Override
    public List<Wood> load() throws IOException {
        List<Wood> woodList = new ArrayList<>();
        while(true) {
            String line = reader.readLine();
            if(line == null) break;
            woodList.add(deserializer.deserrialize(line));
        }
        return List.of();
    }
}
