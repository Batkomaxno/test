import com.google.gson.JsonParser;

public class RestApi {

    public static String get_value_from_json(String json, String value){
        String json_param = null;
        JsonParser parser = new JsonParser();
        try {
            json_param = parser.parse(json).getAsJsonObject().get(value).getAsString();
        }catch (IllegalStateException e){
            json_param = null;
        }catch (NullPointerException e){
            json_param = null;
        }
        return json_param;
    }
}
