import java.util.ArrayList;

public class Clothing{
    private String sourcePath;
    private ArrayList<String> category;
    private String nameOfClothing;

    public Clothing(String nameOfClothing, String sourcePath, ArrayList<String> category){
        this.sourcePath = sourcePath;
        this.category = category;
        this.nameOfClothing = nameOfClothing;
    }

    public String getNameOfClothing(){
        return this.nameOfClothing;
    }





}