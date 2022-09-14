import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DreamPage {

    private int id;

    private String dreamBody;

    public int getId(){
        return id;
    }

    public String getDreamBody(){
        return dreamBody;
    }

    public void setId(int newId){
        this.id = newId;
    }

    public void setDreamBody(String newDreamBody){
        this.dreamBody = newDreamBody;
    }

}
