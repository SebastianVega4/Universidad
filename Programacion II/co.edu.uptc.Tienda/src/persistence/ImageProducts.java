package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageProducts {
	private String rutaYNombreImagen;
	private ImageIcon imagen;
	private JFileChooser fileChooser;

	public ImageProducts() {
		fileChooser = new JFileChooser();
	}

	public boolean obtainImage(int index) {
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png", "gif");
	    fileChooser.setFileFilter(filter);

	    int seleccion = fileChooser.showOpenDialog(null);

	    if (seleccion == JFileChooser.APPROVE_OPTION) {
	        File selectedFile = fileChooser.getSelectedFile();

	        // Define la ruta y el nombre para la copia en Resources\\Icons\\
	        String copyPath = "Resourses\\Icons\\" + String.valueOf(index) + ".png";

	        try {
	            // Copia el archivo seleccionado a la ubicación deseada
	            FileInputStream fis = new FileInputStream(selectedFile);
	            FileOutputStream fos = new FileOutputStream(copyPath);
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = fis.read(buffer)) > 0) {
	                fos.write(buffer, 0, bytesRead);
	            }
	            fis.close();
	            fos.close();

	            // Puedes guardar la ruta del archivo original si lo necesitas
	            rutaYNombreImagen = selectedFile.getAbsolutePath();

	            // Crea un ImageIcon usando la ruta de la copia
	            imagen = new ImageIcon(copyPath);
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    } else {
	        return false;
	    }
	}

	public boolean renameImage(String newName) {
	    if (rutaYNombreImagen != null) {
	        File imagenAnterior = new File(rutaYNombreImagen);
	        File nuevaImagen = new File("Resourses\\Icons\\" + newName + ".png");

	        if (imagenAnterior.renameTo(nuevaImagen)) {
	            rutaYNombreImagen = nuevaImagen.getAbsolutePath();
	            return true;
	        }
	    }
	    return false;
	}

	public void DeleteImage(int index) {
		 String filePath = "Resourses\\Icons\\" + index + ".png";

		    Path target = Paths.get(filePath);

		    try {
		        Files.delete(target);
		    } catch (IOException e) {
		    }
	}

	public ImageIcon getImagen() {
		return imagen;
	}
}
