import java.util.Stack;

public class ImageEditorBackupManager {
    private Stack<Memento> mementos;
    private ImageEditor imageEditor;

    public ImageEditorBackupManager(ImageEditor imageEditor){
        this.imageEditor = imageEditor;
        this.mementos = new Stack<>();
    }

    public void backup(){
        System.out.println("Salvando o estado de ImageEditor");
        this.mementos.push(this.imageEditor.save());
    }

    public void undo(){
        if (this.mementos.isEmpty()) {
            System.out.println("Sem mementos para restaurar");
            return;
        }
        Memento mementoUndo = this.mementos.pop();
        this.imageEditor.restore(mementoUndo);
        System.out.println("O Backup: " + mementoUndo.getName() + " foi restaurado com sucesso");
    }

    public void showMementos(){
        if (this.mementos.isEmpty()) {
            System.out.println("Nenhum backup salvo.");
            return;
        }

        System.out.println("Backups salvos:");
        for (Memento m : this.mementos) {
            System.out.println("- " + m.getName());
        }
    }
}
