import java.util.Date;

public class ConcreteMemento implements Memento{

    private String name, filePath, fileFormat;
    private Date date;
    public ConcreteMemento(String name, String filePath, String fileFormat, Date date){
        this.date = date;
        this.fileFormat = fileFormat;
        this.filePath = filePath;
        this.name = name;
    }
    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getFilePath(){
        return this.filePath;
    }
    public String getFileFormat(){
        return this.fileFormat;
    }
}
