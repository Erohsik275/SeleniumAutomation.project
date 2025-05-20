package Practice_01;

import java.io.File;

public class foldersearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		File folder  = new File("C:\\Users\\Kishore");
		int count = folder.listFiles(f -> f.isFile()).length;
		File[] folders = folder.listFiles(f -> f.isDirectory());
		System.out.println(count);
		if (folders != null) {
            System.out.println("Folders inside " + folder.getPath() + ":");
            for (File subFolder : folders) {
                System.out.println(subFolder.getName());
            }
        }
		
	}

}
