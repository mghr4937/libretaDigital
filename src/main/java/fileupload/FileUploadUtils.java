package fileupload;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

import fileupload.FileUploadType;
import utils.TranslateUtils;

@Scope(ScopeType.CONVERSATION)
@Name(value="fileUploadUtils")
public class FileUploadUtils {
	
	@In
	FacesMessages facesMessages;
	
	private List<FileUploadType> fileUploadTypeList;

	public List<FileUploadType> getFileUploadTypeList() {
		
		if (fileUploadTypeList == null) {
			
			fileUploadTypeList = new ArrayList<FileUploadType>();

		     for (FileUploadType oFileUploadType: FileUploadType.values() ) {
		            
		    	 String strFileUploadType = ("enable_fileupload_" + oFileUploadType.toString()).toLowerCase();

		    	 try {
			    	 
		    		 // Preguntar si esta habilitado el tipo de carga
			    	 String isEnableFileUpload =  TranslateUtils.translate(strFileUploadType, "enabled");
		    	 
			    	 if (isEnableFileUpload!=null && !isEnableFileUpload.equals("") && isEnableFileUpload.equals(Boolean.TRUE.toString())) {
			    		 fileUploadTypeList.add(oFileUploadType);
			    	 }
			    	 
		    	 } catch (MissingResourceException e) { }
		     }
			
		}
		
		return fileUploadTypeList;

	}

	public FacesMessages getFacesMessages() {
		return facesMessages;
	}

	public void setFacesMessages(FacesMessages facesMessages) {
		this.facesMessages = facesMessages;
	}

	public void setFileUploadTypeList(List<FileUploadType> fileUploadTypeList) {
		this.fileUploadTypeList = fileUploadTypeList;
	}
	
}
