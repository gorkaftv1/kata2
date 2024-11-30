import java.util.ArrayList;
import java.util.List;

public class TsvWoodDeserializer implements WoodDeserializer{
    @Override
    public Wood deserrialize(String line) {
        String[] fields = line.split("\t");
        return new Wood(
                fields[0], fields[1],
                getContinentOf(normalize(fields[2])),
                getToneOf(normalize(fields[3])),
                getCountry(normalize(fields[4])),
                getQuality(fields[5]),
                getPrice(fields[6]),
                getImporters(fields[7])
        );
    }

    private List<Wood.Country> getImporters(String field) {
        List<Wood.Country> countries = new ArrayList<>();
        for(String n : field.split(",")) {
            countries.add(getCountry(normalize(n)));
        }
        return countries;
    }

    private String normalize(String n) {
        return n.replace(" " ,  "");
    }

    private Float getPrice(String field) {
        return Float.valueOf(field);
    }

    private Wood.Quality getQuality(String field) {
        return Wood.Quality.valueOf(field);
    }

    private Wood.Country getCountry(String field) {
        return Wood.Country.valueOf(field);
    }

    private Wood.Tone getToneOf(String field) {
        return Wood.Tone.valueOf(field);
    }

    private Wood.Continent getContinentOf(String field) {
        return Wood.Continent.valueOf(field);
    }
}
