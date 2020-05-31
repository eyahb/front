package tn.esprit.spring.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;




@ViewScoped
@ManagedBean(name = "fileUploadView")
public class FileUploadManagedBean {
	/*UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload(ActionEvent event) {
		String fileName = uploadedFile.getFileName();
		byte[] content = uploadedFile.getContents();
		String contentType = uploadedFile.getContentType();
		FacesContext.getCurrentInstance().addMessage(“messages”, new FacesMessage(“Successful! ” + uploadedFile.getSize()+ ” is uploaded.”));
		}*/

	public void handleFileUpload(FileUploadEvent event) {
		

	    System.out.println("calling file upload...");
	    File targetFolder = new File(Properties.class
	    		+ File.separator);

	    if (!targetFolder.exists()) {
	        targetFolder.mkdirs();
	    }
	    try {
	        InputStream inputStream = event.getFile().getInputstream();

	        OutputStream out = new FileOutputStream(new File(targetFolder,
	                event.getFile().getFileName()));

	        int read = 0;

	        byte[] bytes = new byte[1024];

	        while ((read = inputStream.read(bytes)) != -1) {

	            out.write(bytes, 0, read);

	        }
	        inputStream.close();
	        out.flush();
	        out.close();

	    } catch (IOException e) {

	        e.printStackTrace();
	    }
	    System.out.println("file upload after catch..");
	   

	    FacesMessage msg = new FacesMessage("Succesful", event.getFile()
	            .getFileName() + " is uploaded.");
	    FacesContext.getCurrentInstance().addMessage(null, msg);
	    System.out.println("last line of file upload....");
	}
}
