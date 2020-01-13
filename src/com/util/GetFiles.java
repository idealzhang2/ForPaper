package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFiles {
	 private List<String> Stringpaths = new ArrayList<>();
	 private List<File>  files = new ArrayList<>();
	 
     public List<String> getStringpaths() {
		return Stringpaths;
	}

	public void setStringpaths(List<String> stringpaths) {
		Stringpaths = stringpaths;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public void GetClassFiles(String path){
    	 List<File> res = new ArrayList<File>();
    	 List<File>  temp = new ArrayList<>();
    	 File tem = new File(path);
    	 if(!tem.exists()) {
    		 return ;
    	 }
    	 temp.add(tem);
    	 while(!temp.isEmpty()) {
    		 File  file= temp.remove(0);
    		File[] filestem = file.listFiles();
    		if(filestem==null || filestem.length == 0) {
    			continue;
    		}
    		for(File tt:filestem) {
    			if(tt.isDirectory()) {
    				temp.add(tt);
    			}else if(tt.isFile()&&tt.getAbsolutePath().endsWith(".class")) {    				
    				files.add(tt);
    				Stringpaths.add(tt.getAbsolutePath());
    			}
    		}
    	 }    	
    	// return res;
     }
}
