import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class Dream {
    private static FileWriter file;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL dd yyyy HH:mma");
    private LocalDateTime dateTime = LocalDateTime.now();
    private String cleanDate = dateTime.format(formatter);

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


        DreamPage dreamt = new DreamPage();
        DreamPage dreamt2 = new DreamPage();
        dreamt.setId(1);
        dreamt2.setId(2);

        dreamt.setDreamBody("electric sheep");
        dreamt2.setDreamBody("Android sheep");
        test.put("1", dreamt);
        test.put("2", dreamt2);
        System.out.println("Attempting JSON Storage: ");
        System.out.println(new Gson().toJson(test));




    }

    public static void main(String[] args) {
        Dream dream = new Dream();
        dream.PrepareJSON();

    }


}