package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class JarUnpack {
	public List<String> GetClassFiles(String sourcepath,String targetpath){
		String sourepath = sourcepath;
		//String targetpath = targetpath;
		int dotindex = sourcepath.lastIndexOf('.');
		int startindex = sourcepath.lastIndexOf("\\");
		String str  = sourcepath.substring(startindex+1, dotindex);
		JarUnpack unpack = new JarUnpack();
	//	unpack.Unpack(path, targetpath+"\\"+str);
		GetFiles getfiles = new GetFiles();		
		  getfiles.GetClassFiles(targetpath+"\\"+str);
		  List<String> res = getfiles.getStringpaths();
//		for(File f:res) {
//			System.out.println(f.getAbsolutePath());
//		}
//		System.out.println(res.size());
		return res;
	}
	public boolean checkDir(String path) {
		File filetem = new File(path);
		if (!filetem.exists()) {
			filetem.mkdir();			
		}
		if(!filetem.isDirectory()) {
			return false;
		}
		
		return true;
	}

	public boolean exist(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	public boolean Unpack(String sourcepath, String targetpath) throws Exception {
		System.out.println(sourcepath+"    "+targetpath);
		if (!exist(sourcepath)) {
			return false;
		}
		if(!checkDir(targetpath)) {
			return false;
		}		
		File file = new File(sourcepath);// ѹ���ļ�
		ZipFile zipFile = new ZipFile(file);// ʵ����ZipFile��ÿһ��zipѹ���ļ������Ա�ʾΪһ��ZipFile
		// ʵ����һ��Zipѹ���ļ���ZipInputStream���󣬿������ø����getNextEntry()���������õ�ÿһ��ZipEntry����
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file), Charset.forName("GBK"));
		ZipEntry zipEntry = null;
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			String fileName = zipEntry.getName();
			File temp = new File(targetpath + "\\"+ fileName);
			if (!temp.getParentFile().exists())
				temp.getParentFile().mkdirs();
			OutputStream os = new FileOutputStream(temp);
			// ͨ��ZipFile��getInputStream�����õ������ZipEntry��������
			InputStream is = zipFile.getInputStream(zipEntry);
			int len = 0;
			while ((len = is.read()) != -1)
				os.write(len);
			os.close();
			is.close();
		}
		zipInputStream.close();
		return true;
	}
}
