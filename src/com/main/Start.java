package com.main;

import java.io.File;
import java.util.List;

import com.util.GetFiles;
import com.util.JarUnpack;

public class Start {

	public static void main(String[] args) throws Exception {
		String path = "D:\\jar\\1.jar";
		String targetpath = "D:\\jar";
		int dotindex = path.lastIndexOf('.');
		int startindex = path.lastIndexOf("\\");
		String str  = path.substring(startindex+1, dotindex);
		JarUnpack unpack = new JarUnpack();
	//	unpack.Unpack(path, targetpath+"\\"+str);
		GetFiles getfiles = new GetFiles();
		
		getfiles.GetClassFiles(targetpath + "\\" + str);
		List<String> res = getfiles.getStringpaths();
		for (String f : res) {
			System.out.println(f);
		}
		System.out.println(res.size());
		

	}

}
