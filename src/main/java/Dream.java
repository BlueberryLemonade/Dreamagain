import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Dream {
    private static FileWriter file;

    public static void main(String[] args) {



        JSONObject test = new JSONObject();
        test.put("1", "One");
        System.out.println(test);

        try{
            file = new FileWriter("C:/Development/DreamSample/Dream2.txt");
            file.write(test.toString());
            System.out.println("Saved JSON");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}