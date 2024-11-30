import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/gorka/Downloads/WoodsData.tsv");
        FileWoodLoader loader = new FileWoodLoader(file, new TsvWoodDeserializer());
        List<Wood> woodList = loader.load();
        System.out.println(woodList);;
    }
}
