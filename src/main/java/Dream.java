import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Dream {
    private static FileWriter file;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL dd yy");
    LocalDateTime now = LocalDateTime.now();
    JSONObject test = new JSONObject();


    public void SaveFile(JSONObject fileTBS){

        try{
            file = new FileWriter("C:/Development/DreamSample/Dream2.txt");
            file.write(fileTBS.toString());
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

    public void PrepareJSON(){
        System.out.println(formatter.format(now));
        test.put("Date", formatter.format(now));
        test.put("Text", "Dream");
        test.put("Third", "3");
        System.out.println(test);
        SaveFile(test);
    }

    public static void main(String[] args) {
        Dream dream = new Dream();
        dream.PrepareJSON();

    }


}