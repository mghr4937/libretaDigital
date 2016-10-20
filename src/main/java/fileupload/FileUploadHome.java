package fileupload;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.richfaces.application.FacesMessages;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import interfaces.FileUploadService;
import fileupload.FileUploadType;

public class FileUploadHome implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final int UPLOADS_AVAILABLE=1;
	private static String CATALINA_HOME = System.getenv("CATALINA_HOME");
	private Logger logger = Logger.getLogger(FileUploadHome.class);
	private static String acceptedTypes = "csv";
	private boolean useFlash = false;
	private ArrayList<UploadItem> files;	
	private boolean autoUpload;
	private int uploadsAvailable;
	private FileUploadType selectedFileType;
	
	@In
	FacesMessages facesMessages;

	public FileUploadHome() {
		clearPage();
	}

	public int getSize() {
		if (files.size() > 0)
			return files.size();	
		else
			return 0;
	}

	public void listener(UploadEvent event) throws Exception {
		files.add(event.getUploadItem());
		uploadsAvailable--;
	}

	@End
	public void clearUploadData() {
		files = new ArrayList<UploadItem>();
		this.setUploadsAvailable(UPLOADS_AVAILABLE);
		autoUpload = false;
	}
	
	@End
	public void clearPage() {
		files = new ArrayList<UploadItem>();
		this.setUploadsAvailable(UPLOADS_AVAILABLE);
		autoUpload = false;
	}

	@Begin(join=true)
	public List<File> getLoadFiles() {
		List<File> selectedFiles = new ArrayList<File>();
		if (this.getFiles() != null && this.getFiles().size() > 0) {
			for (Iterator<UploadItem> iterator = this.getFiles().iterator(); iterator.hasNext();) {
				UploadItem uploadItem = (UploadItem) iterator.next();
				
				selectedFiles.add(uploadItem.getFile());
			}
		} else {
			facesMessages.addFromResourceBundle(Severity.ERROR,"upload_label_error_no_files");
			return null;
		}
		return selectedFiles;
	}	
	
	@Begin(join=true)
	public String sendFile() throws Exception {

		String toReturn = "";
		
		File newFile = null;
		
		try {
			if (CATALINA_HOME == null || CATALINA_HOME.equals("")) {
				
				this.clearUploadData();
				facesMessages.addFromResourceBundle(Severity.ERROR,"upload_war_catalina_home_not_set");
				toReturn = "";
				
			} else {
				ResourceBundle rb = ResourceBundle.getBundle("messages_es");
				String uploadDirectory = CATALINA_HOME.replace("\\", "/") + rb.getString("upload_tomcat_directoy");

				for (Iterator<File> iterator = this.getLoadFiles().iterator(); iterator.hasNext();) {
					File file = (File) iterator.next();
					
					try {
						if (file.length() > 0) {

							newFile = FileUtilities.copyCSVFile(file, uploadDirectory);

							String localPort = rb.getString("service.port");
							String http_address = rb.getString("http_address");
							String uploadTomcatDirectory = rb.getString("upload_tomcat_directoy");
							String tomcat_address = http_address+":"+ localPort + uploadTomcatDirectory;
						
							String cleanFileName = cleanFileName(files.get(0).getFileName());
							
							// Audit
							FileUploadAuditObject fuao = new FileUploadAuditObject(cleanFileName);
							auditUtil.auditOperation(AuditUtil.Services.FILE_UPLOAD, loginUtils.getUserVO(), fuao);
							
							fileUploadService.fileUpload(tomcat_address + newFile.getName(), cleanFileName, loginUtils.getUserVO().getUsername(), selectedFileType.getValue());

							toReturn = "sucessfull_upload";
							facesMessages.addFromResourceBundle(Severity.INFO,"upload_success_message");
							
						} else {
							facesMessages.addFromResourceBundle(Severity.ERROR,"upload_label_error_empy_file");
							logger.error("Error archivo vacio");
							toReturn = "";
						}
						
						clearUploadData();

					} catch (IOException e) {
						facesMessages.addFromResourceBundle(Severity.ERROR,"upload_label_error_empy_file");
						logger.error("Error archivo vacio");
						toReturn = "";
					}		
				}
			}
		} catch(MissingResourceException e) {
			facesMessages.addFromResourceBundle(Severity.ERROR, "upload.systemerror");
			logger.error("Hubo un error durante la carga de archivo de cupones");
			throw e;
		}
		
		return toReturn;
	}
	
	private static String cleanFileName(String originalName) {
		if (originalName == null)
			return "";
		return originalName.replace(" ", "").replace("+", "").replace("-", "").replace("%", "").replace(":", "");
	}
	
	

	public FileUploadType[] getFilestype(){
		return FileUploadType.values();
	}

	public void warnInvalidFileType(){
		facesMessages.addFromResourceBundle(Severity.WARN,"upload_label_invalid_format");
	}

	public void cleanMessages() {
		facesMessages = null;
	}
	
	public FacesMessages getFacesMessages() {
		return facesMessages;
	}

	public void setFacesMessages(FacesMessages facesMessages) {
		this.facesMessages = facesMessages;
	}

	public LoginUtils getLoginUtils() {
		return loginUtils;
	}

	public void setLoginUtils(LoginUtils loginUtils) {
		this.loginUtils = loginUtils;
	}

	public AuditUtil getAuditUtil() {
		return auditUtil;
	}

	public void setAuditUtil(AuditUtil auditUtil) {
		this.auditUtil = auditUtil;
	}

	public ArrayList<UploadItem> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<UploadItem> files) {
		this.files = files;
	}

	public boolean isAutoUpload() {
		return autoUpload;
	}

	public void setAutoUpload(boolean autoUpload) {
		this.autoUpload = autoUpload;
	}

	public int getUploadsAvailable() {
		return uploadsAvailable;
	}

	public void setUploadsAvailable(int uploadsAvailable) {
		this.uploadsAvailable = uploadsAvailable;
	}

	public String getAcceptedTypes() {
		return acceptedTypes;
	}

	public boolean isUseFlash() {
		return useFlash;
	}

	public void setUseFlash(boolean useFlash) {
		this.useFlash = useFlash;
	}

	public String getSelectedFileType() {
		return (selectedFileType == null) ? null : selectedFileType.getValue();
	}

	public void setSelectedFileType(String selFileType) {
		selectedFileType = FileUploadType.valueOf( selFileType );
	}

	public static String getCatalinaHome() {
		return CATALINA_HOME;
	}

	public static void setCatalinaHome(String catalinaHome) {
		CATALINA_HOME = catalinaHome;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public static String getAcceptedtypes() {
		return acceptedTypes;
	}

	public static void setAcceptedtypes(String acceptedtypes) {
		acceptedTypes = acceptedtypes;
	}

	public void setSelectedFileType(FileUploadType selectedFileType) {
		this.selectedFileType = selectedFileType;
	}

	public static String getCATALINA_HOME() {
		return CATALINA_HOME;
	}

	public static void setCATALINA_HOME(String cATALINA_HOME) {
		CATALINA_HOME = cATALINA_HOME;
	}

	public static void setAcceptedTypes(String acceptedTypes) {
		FileUploadHome.acceptedTypes = acceptedTypes;
	}
}
