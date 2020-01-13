package com.util;

import java.io.File;
import java.lang.Thread.State;
import java.util.List;

public class ClassToJava {
	public boolean ClassToJava(String source, String target) throws Exception {
		String path = source;
		String targetpath = target;
		int dotindex = path.lastIndexOf('.');
		int startindex = path.lastIndexOf("\\");
		String str = path.substring(startindex + 1, dotindex);//解压目标文件夹   目标文件下创建与压缩名相同的文件夹
		JarUnpack unpack = new JarUnpack();
		unpack.Unpack(path, targetpath + "\\" + str);//解压
		GetFiles getfiles = new GetFiles();
		getfiles.GetClassFiles(targetpath + "\\" + str);
		List<String> res = getfiles.getStringpaths();
		for (String f : res) {
			System.out.println(f);
		}
		System.out.println(res.size());
		return true;
	}
}
