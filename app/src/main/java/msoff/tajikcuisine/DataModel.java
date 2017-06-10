package msoff.tajikcuisine;

/**
 * Created by moshe on 01/04/2017.
 */

public class DataModel {

    String name;
    String sub_name;
    int id_;
    int image;
    String time;

    public DataModel(String name, String version, int id_, int image, String time) {
        this.name = name;
        this.sub_name = version;
        this.id_ = id_;
        this.image=image;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getSubName() {
        return sub_name;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }
    public String getTime(){
        return time;
    }
}