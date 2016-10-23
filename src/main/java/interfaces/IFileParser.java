package interfaces;

import exceptions.BuildLineException;
import fileupload.FileLine;
import fileupload.FileUploadBlockManager;

public interface IFileParser {
	
	String getBlockSizeParameterName();
	
	void beforeParseFile();
	
	FileLine parseLine(String line, FileUploadBlockManager manager) throws BuildLineException;

}
