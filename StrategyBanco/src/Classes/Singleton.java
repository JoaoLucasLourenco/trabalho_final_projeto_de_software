package Classes;

public class Singleton {
    private static Singleton instancia;
    private Singleton(){};
    public static Singleton GetInstacia(){
        if(instancia==null)
            instancia=new Singleton();
        return instancia;
    }
}
