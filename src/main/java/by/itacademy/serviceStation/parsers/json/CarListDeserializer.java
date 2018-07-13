package by.itacademy.serviceStation.parsers.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CarListDeserializer implements JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        List<String> carsArray = new ArrayList<>();
        JsonArray cars = jsonObject.getAsJsonArray("car");
        for(JsonElement car : cars) {
            if(car.isJsonPrimitive()) {
                carsArray.add(car.getAsString());
            }
        }
        return carsArray;
    }
}
