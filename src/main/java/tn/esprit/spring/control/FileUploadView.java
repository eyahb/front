package tn.esprit.spring.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;


@ViewScoped
@ManagedBean(name = "fileUploadManagedBean")
public class FileUploadView {

	private String destination = "/home/documents";

	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
/*public class FileUploadView  implements Serializable {

private List<UploadedFile> uploadAttachment = new LinkedList<UploadedFile>();//getters and setters
public void handleFileUpload(FileUploadEvent event) throws IOException {
		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/template/" +event.getFile().getFileName());
		File targetFolder = new File(path);
		InputStream inputStream = event.getFile().getInputstream();
		OutputStream out = new FileOutputStream(targetFolder);
		int read = 0;
		byte[] bytes = new byte[1024];

		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		inputStream.close();
		out.flush();
		out.close();
		uploadAttachment.add(event.getFile());

	}*/

	
	
}
	 
