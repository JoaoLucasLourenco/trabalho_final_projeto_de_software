public class Main {
    public static void main(String[] args) {
        ImageEditor imageEditor = new ImageEditor("png","../Downloads/gatinho");
        ImageEditorBackupManager backupManager = new ImageEditorBackupManager(imageEditor);

        imageEditor.info();
        backupManager.backup(); //salva o png

        imageEditor.convertFileFormat("gif");
        imageEditor.info();
        backupManager.backup();//salva o gif

        imageEditor.convertFileFormat("bmp");
        imageEditor.info();
        backupManager.backup();//salva o bmp

        backupManager.showMementos();

        backupManager.undo();
        imageEditor.info();

        backupManager.undo();
        imageEditor.info();

        backupManager.undo();
        imageEditor.info();


    }
}