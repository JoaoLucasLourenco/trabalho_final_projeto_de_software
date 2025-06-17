import java.util.Date;

public class ImageEditor {
    private String filePath;
    private String fileFormat;

    public ImageEditor(String fileFormat, String filePath){
        this.filePath = filePath;
        this.fileFormat = fileFormat;
    }

    public Memento save(){
        final Date date = new Date();
        return new ConcreteMemento(date.toString()+" "+this.filePath+"."+this.fileFormat, this.filePath, this.fileFormat, date);
    }

    public void restore(Memento memento){
        this.fileFormat = ((ConcreteMemento) memento).getFileFormat();
    }


    public void info(){
        System.out.println("Filepath: "+this.filePath);
        System.out.println("Fileformat: "+this.fileFormat +"\n");
    }

    public void convertFileFormat(String fileFormat){
        this.fileFormat = fileFormat;
    }

}
