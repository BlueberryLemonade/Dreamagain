import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileReader;
import java.util.Map;


public class Dream {
    private static FileWriter filew;
    private FileReader filer;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL dd yyyy HH:mma");
    private LocalDateTime dateTime = LocalDateTime.now();
    private String cleanDate = dateTime.format(formatter);
    private Gson gson = new Gson();

    LocalDateTime now = LocalDateTime.now();
    JSONObject test = new JSONObject();


    public void saveFile(String fileTBS){

        try{
            filew = new FileWriter("C:/Development/DreamSample/Dream2.json");
            filew.write(fileTBS);
            System.out.println("Saved JSON");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                filew.flush();
                filew.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

   public void loadFile() {
       try {

           filer = new FileReader("C:/Development/DreamSample/Dream2.json");
           System.out.println("File Read");

           Map<?,?> map = gson.fromJson(filer, Map.class);

           for(Map.Entry<?, ?> entry : map.entrySet()) {
               System.out.println(entry.getKey() + " = " + entry.getValue());
           }

           filer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    public void prepareJSON(){


        DreamPage dreamt = new DreamPage();
        DreamPage dreamt2 = new DreamPage();
        dreamt.setId(1);
        dreamt2.setId(2);

        dreamt.setDreamBody("electric sheep");
        dreamt2.setDreamBody("Android sheep");
        test.put("1", dreamt);
        test.put("2", dreamt2);
        System.out.println(test);
        System.out.println("Attempting JSON Storage: ");
        gson = new Gson();
        String createdJson = gson.toJson(dreamt);
        System.out.println("Created string:" + createdJson);
        saveFile(createdJson);



    }

    public static void main(String[] args) {
        Dream dream = new Dream();
        dream.loadFile();
        dream.prepareJSON();


    }


}