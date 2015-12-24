package sample4.annotation;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath;
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}

	@Override
	public void output(String msg) throws IOException {
		// TODO Auto-generated method stub
		FileWriter out = new FileWriter(filePath);
		out.write(msg);
		out.close();
	}
}
