package com.homework.read;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.homework.util.Tool;

public class ReadJPG {

	/**
	 * 锟斤拷图片锟侥讹拷锟斤拷锟斤拷锟斤拷锟捷憋拷锟芥到锟侥硷拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷要锟角撅拷图片锟侥讹拷锟斤拷锟斤拷锟斤拷锟捷憋拷锟芥到excel锟斤拷锟斤拷锟�
	 * 
	 * @param fileName
	 *            要锟斤拷锟叫讹拷锟斤拷锟絡pg图片锟斤拷锟侥硷拷路锟斤拷
	 * @param saveFileName
	 *            要锟斤拷锟斤拷锟斤拷募锟斤拷锟斤拷锟斤拷锟�
	 * 
	 */
	public static void OutputJPGToBinaryFile(String fileName,
			String saveFileName) {
		// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File(saveFileName));
			// 锟斤拷锟街斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟阶拷锟轿拷址锟斤拷锟�
			String data = Tool.Bytes2HexString(FromJPGToByte(fileName));
			// 锟斤拷锟街凤拷锟斤拷写锟诫到锟侥硷拷锟斤拷
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < data.length(); i = i + 2) {
				if (i % 32 == 0 && i > 0) {
					// System.out.println();
					stringBuffer.append("\r\n");
				}
				// System.out.print(data.substring(i,i+2)+"   ");
				stringBuffer.append(data.substring(i, i + 2) + "   ");
			}
			os.write(stringBuffer.toString().getBytes());
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 锟斤拷一锟斤拷jpg锟斤拷图片锟侥硷拷转锟斤拷为锟斤拷锟斤拷锟斤拷锟斤拷锟捷ｏ拷锟斤拷诺锟斤拷纸锟斤拷锟斤拷锟斤拷锟�
	 * 
	 * @param fileName
	 *            图片锟斤拷锟斤拷实路锟斤拷
	 * @return 锟斤拷锟截碉拷锟角革拷图片锟侥讹拷锟斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 */
	public static byte[] FromJPGToByte(String fileName) {
		InputStream is = null;
		// 锟斤拷锟斤拷锟街斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷锟斤拷荻锟斤拷氲斤拷纸锟斤拷锟斤拷锟斤拷锟�
		ByteArrayOutputStream arrayOutputStream = null;
		byte[] buffer = null;
		try {
			is = new FileInputStream(new File(fileName));
			arrayOutputStream = new ByteArrayOutputStream();
			int len = 0;
			buffer = new byte[1024];
			// 锟斤拷锟斤拷锟侥硷拷锟斤拷锟街斤拷锟斤拷锟斤拷锟斤拷
			while ((len = is.read(buffer)) != -1) {
				arrayOutputStream.write(buffer, 0, len);
			}
			arrayOutputStream.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return arrayOutputStream.toByteArray();
	}

//	public static void main(String[] args) {
//
//		OutputJPGToBinaryFile(JpgFile.READFILENAME, JpgFile.SAVEFILENAME);
//		System.out.println("\nsuccess");
//	}

}
