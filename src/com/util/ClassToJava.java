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
		String str = path.substring(startindex + 1, dotindex);//��ѹĿ���ļ���   Ŀ���ļ��´�����ѹ������ͬ���ļ���
		JarUnpack unpack = new JarUnpack();
		unpack.Unpack(path, targetpath + "\\" + str);//��ѹ
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
