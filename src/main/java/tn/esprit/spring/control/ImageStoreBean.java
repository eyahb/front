package tn.esprit.spring.control;


import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;


@ManagedBean
@RequestScoped
public class ImageStoreBean {

	private String folder = "C:\\jsf-upload\\";
	
	private Part uploadedFile;


	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}




	public void saveFile() {
		
		System.out.println("saveFile method invoked..");
		System.out.println( "content-type:{0}" + uploadedFile.getContentType());
		System.out.println("filename:{0}" + uploadedFile.getName());
		System.out.println( "submitted filename:{0}"+ uploadedFile.getSubmittedFileName());
		System.out.println( "size:{0}" + uploadedFile.getSize());
		 String fileName = "";
		
		  try {
			  
			  fileName = getFilename(uploadedFile);
			  
			  System.out.println("fileName  " + fileName);
			  
			  uploadedFile.write(folder+fileName);
			  
	            
	        } catch (IOException ex) {
	            System.out.println(ex);
	            
	            
	        }
		  FacesMessage msg = new FacesMessage("File " + fileName+ " Uploaded!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		  //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));
		
	}
	
	
	private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;

	
}
}
