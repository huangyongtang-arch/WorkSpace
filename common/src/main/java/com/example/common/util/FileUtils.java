package com.example.common.util;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author shumin.zheng
 * 
 */

public class FileUtils {

	/**
	 * 文件的写入
	 * 
	 * @param filePath(文件路径)
	 * @param fileName(文件名)
	 * @throws IOException
	 */
	public void writeFile(String filePath, String fileName, String[] args)
			throws IOException {
		FileWriter fw = new FileWriter(filePath + fileName);
		PrintWriter out = new PrintWriter(fw);
		for (int i = 0; i < args.length; i++) {
			out.write(args[i]);
			out.println();
			out.flush();
		}
		fw.close();
		out.close();
	}
	
	/**
	 * 文件的写入
	 * 
	 * @param filePath(文件路径)
	 * @param fileName(文件名)
	 * @throws IOException
	 */
	public void writeFile(String filePath, String fileName, List<String> list)
			throws IOException {
		FileWriter fw = new FileWriter(filePath + fileName);
		PrintWriter out = new PrintWriter(fw);
		for (int i = 0; i < list.size(); i++) {
			out.write(list.get(i));
			out.println();
			out.flush();
		}
		fw.close();
		out.close();
	}

	/**
	 * 文件的写入
	 * 
	 * @param filePath(文件路径)
	 * @param fileName(文件名)
	 * @param args
	 * @throws IOException
	 */
	public void writeFile(String filePath, String fileName, String args)
			throws IOException {
		FileWriter fw = new FileWriter(filePath + fileName);
		fw.write(args);
		fw.close();
	}

	/**
	 * 创建与删除文件
	 * 
	 * @param filePath
	 * @param fileName
	 * @return 创建成功返回true
	 * @throws IOException
	 */
	public boolean createAndDeleteFile(String filePath, String fileName)
			throws IOException {
		boolean result = false;
		File file = new File(filePath, fileName);
		if (file.exists()) {
			file.delete();
			result = true;
//			log.debug("文件已经删除！");
			System.out.println("文件已经删除！");
		} else {
			file.createNewFile();
			result = true;
//			log.debug("文件已经创建！");
			System.out.println("文件已经创建！");
		}
		return result;
	}

	/**
	 * 删除目录
	 * @param folderName
	 * @param filePath
	 * @return 删除成功或没找到目录返回true
	 */
	public static boolean deleteFolder(String folderName, String filePath) {
		boolean result = false;
		try {
			File file = new File(filePath + folderName);
			if (file.exists()) {
				file.delete();
				System.out.println("目录已删除！");
			} else {
				System.out.println("目录不存在，已经建立！");
			}
			result = true;
		} catch (Exception ex) {
			result = false;
			ex.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 创建目录
	 * @param folderName
	 * @param filePath
	 * @return 创建成功返回true,
	 * 已经存在或创建失败返回false
	 */
	public static boolean createDir(String folderName, String filePath) {
		return createDir(filePath + folderName);
	}

	/**
	 * 创建目录
	 * @param folderName
	 * @return 创建成功返回true,
	 * 已经存在或创建失败返回false
	 */
	public static boolean createDir(String folderName) {
		boolean result = false;
		try {
			File file = new File(folderName);
			result = !file.exists() && file.mkdirs();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 输出目录中的所有文件的名字
	 * 
	 * @param filePath
	 */
	public static List<String> readFolderByFile(String filePath) {
		
		File file = new File(filePath);
		File[] tempFile = file.listFiles();
		List<String> fileNames = new ArrayList<String>();
		
		for (int i = 0; i < tempFile.length; i++) {
			if (tempFile[i].isFile()) {
				fileNames.add(tempFile[i].getName());
//				log.debug("File : " + tempFile[i].getName());
				//System.out.println("File : " + tempFile[i].getName());
			}
//			if (tempFile[i].isDirectory()) {//是否为文件夹
//				log.debug("Directory : " + tempFile[i].getName());
//			}
		}
		return fileNames;
	}

	/**
	 * 检查文件中是否为一个空
	 * 
	 * @param filePath
	 * @param fileName
	 * @return 为空返回true
	 * @throws IOException
	 */
	public boolean fileIsNull(String filePath, String fileName)
			throws IOException {
		boolean result = false;
		FileReader fr = new FileReader(filePath + fileName);
		if (fr.read() == -1) {
			result = true;
//			log.debug(fileName + " 文件中没有数据!");
			System.out.println(fileName + " 文件中没有数据!");
		} else {
//			log.debug(fileName + " 文件中有数据!");
			System.out.println(fileName + " 文件中有数据!");
		}
		fr.close();
		return result;
	}

	/**
	 * 读取文件中的所有内容
	 * 
	 * @param filePath
	 * @param fileName
	 * @throws IOException
	 */
	public void readAllFile(String filePath, String fileName)
			throws IOException {
		FileReader fr = new FileReader(filePath + fileName);
		int count = fr.read();
		while (count != -1) {
			System.out.print((char) count);
			count = fr.read();
			if (count == 13) {
				fr.skip(1);
			}
		}
		fr.close();
	}

	/**
	 * 一行一行的读取文件中的数据
	 * 
	 * @param fileName(包含filePath)
	 * @throws IOException
	 * 
	 */
	public String readAllLineFile(String fileName) throws IOException {
		StringBuffer filedata = new StringBuffer("");
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String tmplin = null;
			tmplin = br.readLine();
			while (tmplin != null) {
				filedata.append(tmplin);
				tmplin = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
//			log.error("读取本地文件失败.....");
			System.out.println("读取本地文件失败.....");
			filedata = null;
		}
		return filedata.toString();
	}
	
	/**
	 * 一行一行的读取文件中的数据
	 * 
	 * @param fileName(包含filePath)
	 * @param sep(分隔符)
	 * @throws IOException
	 * 
	 */
	public static String readAllLineFileSep(String fileName, String sep)
			throws IOException {
		StringBuffer filedata = new StringBuffer("");
		try {
            //FileReader fr = new FileReader(fileName);
            //BufferedReader br = new BufferedReader(fr);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));
            String tmplin = null;
			tmplin = br.readLine();
			while (tmplin != null) {
				filedata.append(tmplin);
				tmplin = br.readLine();
				if(sep!=null && !sep.equals(""))
					filedata.append(sep);
			}
			br.close();
            //fr.close();
        } catch (Exception e) {
//			log.error("读取本地文件失败.....");
			System.out.println("读取本地文件失败.....");
			filedata = null;
		}
		return filedata == null ? null : filedata.toString();
	}
	
	/**
     * 3*. 从输入流中拷贝内容到输入流中
     * @throws IOException
     */
    public void copyStream(InputStream is, OutputStream os) throws IOException {
        // 这个读过过程可以参阅 readToBuffer 中的注释
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
        line = reader.readLine();
        while (line != null) {
            writer.println(line);
            line = reader.readLine();
        }
        writer.flush();     // 最后确定要把输出流中的东西都写出去了
                            // 这里不关闭 writer 是因为 os 是从外面传进来的
                            // 既然不是从这里打开的，也就不从这里关闭
                            // 如果关闭的 writer，封装在里面的 os 也就被关了
    }
	
	 /**
     * 3. 调用 copyStream(InputStream, OutputStream) 方法拷贝文本文件
     */
    public void copyTextFile(String inFilename, String outFilename)
        throws IOException {
        // 先根据输入/输出文件生成相应的输入/输出流
        InputStream is = new FileInputStream(inFilename);
        OutputStream os = new FileOutputStream(outFilename);
        copyStream(is, os);     // 用 copyStream 拷贝内容
        is.close(); // is 是在这里打开的，所以需要关闭
        os.close(); // os 是在这里打开的，所以需要关闭
    }
    
    /**
	 * 删除文件
	 * 
	 * @param filePath
	 * @param fileName
	 * @return 删除成功返回true
	 * @throws IOException
	 */
	public static boolean deleteFile(String filePath, String fileName)
			throws IOException {
		boolean result = false;
		File file = new File(filePath, fileName);
		if (file.exists()) {
			file.delete();
			result = true;
//			log.debug("文件已经删除！");
			System.out.println("文件已经删除！");
		} 
		return result;
	}
	
	public static boolean deleteFile(String filePathAndName)
			throws IOException {
		String sep = null;
		if (filePathAndName.indexOf("/")!=-1) {
			sep = "/";
		}else {
			sep = "\\";
		}
		String filePath = filePathAndName.substring(0,filePathAndName.lastIndexOf(sep)+1);
		String fileName = filePathAndName.substring(filePathAndName.lastIndexOf(sep)+1);
		boolean result = false;
		File file = new File(filePath, fileName);
		if (file.exists()) {
			file.delete();
			result = true;
			// log.debug("文件已经删除！");
//			System.out.println("文件已经删除！");
		}
		return result;
	}
	
	public byte[] getBytesFromFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);
	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];

	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }
	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }
	    is.close();
	    return bytes;
	}

	/** 
     * 复制单个文件 
     * @param oldPath String 原文件路径 如：c:/fqf.txt 
     * @param newPath String 复制后路径 如：f:/fqf.txt 
     * @return boolean 
     */ 
   public static boolean copyFile(String oldPath, String newPath) { 
	   InputStream inStream = null;
	   FileOutputStream fs = null;
       try { 
           int bytesum = 0; 
           int byteread = 0; 
           File oldfile = new File(oldPath); 
           if (oldfile.exists()) { //文件存在时 
               inStream = new FileInputStream(oldPath); //读入原文件 
               fs = new FileOutputStream(newPath); 
               byte[] buffer = new byte[1444]; 
               int length; 
               while ( (byteread = inStream.read(buffer)) != -1) { 
                   bytesum += byteread; //字节数 文件大小 
                   //System.out.println(bytesum); 
                   fs.write(buffer, 0, byteread); 
               } 
           } 
       } 
       catch (Exception e) { 
           System.out.println("复制单个文件操作出错"); 
           e.printStackTrace(); 
           return false;
       } finally{
		   try {
	    	   if (inStream!=null) {
    			   inStream.close();
    			   inStream = null;
	    	   }
	    	   if (fs!=null) {
	    		   fs.close();
	    		   fs= null;
	    	   }
			} catch (IOException e) {
				e.printStackTrace();
		        return false;
			} 
       }
       return true;
   } 

   /** 
     * 复制整个文件夹内容 
     * @param oldPath String 原文件路径 如：c:/fqf 
     * @param newPath String 复制后路径 如：f:/fqf/ff 
     * @return boolean 
     */ 
   public static void copyFolder(String oldPath, String newPath) { 

       try { 
           (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
           File a=new File(oldPath); 
           String[] file=a.list(); 
           File temp=null; 
           for (int i = 0; i < file.length; i++) { 
               if(oldPath.endsWith(File.separator)){ 
                   temp=new File(oldPath+file[i]); 
               } 
               else{ 
                   temp=new File(oldPath+File.separator+file[i]); 
               } 

               if(temp.isFile()){ 
                   FileInputStream input = new FileInputStream(temp); 
                   FileOutputStream output = new FileOutputStream(newPath + "/" + 
                           (temp.getName()).toString()); 
                   byte[] b = new byte[1024 * 5]; 
                   int len; 
                   while ( (len = input.read(b)) != -1) { 
                       output.write(b, 0, len); 
                   } 
                   output.flush(); 
                   output.close(); 
                   input.close(); 
               } 
               if(temp.isDirectory()){//如果是子文件夹 
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
               } 
           } 
       } 
       catch (Exception e) { 
           System.out.println("复制整个文件夹内容操作出错"); 
           e.printStackTrace(); 

       } 
   }
   
	/**
	 * 删除文件夹及下面的所有文件夹和文件
	 * 
	 * @param delpath String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return boolean
	 */
	public static boolean deleteFolderAndFile(String delpath) throws Exception {
		try {

			File file = new File(delpath);
			// 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
			if (!file.isDirectory()) {
				file.delete();
			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delpath + "/" + filelist[i]);
					if (!delfile.isDirectory()) {
						delfile.delete();
						System.out
								.println(delfile.getAbsolutePath() + "删除文件成功");
					} else if (delfile.isDirectory()) {
						deleteFolderAndFile(delpath + "/" + filelist[i]);
					}
				}
				System.out.println(file.getAbsolutePath() + "删除成功");
				file.delete();
			}

		} catch (FileNotFoundException e) {
			System.out.println("deletefile() Exception:" + e.getMessage());
		}
		return true;
	}

	public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) {
		File srcFile = new File(srcFileName);
		if(!srcFile.exists()) {
			return false;
		} else if(!srcFile.isFile()) {
			return false;
		} else {
			File destFile = new File(destFileName);
			if(destFile.exists()) {
				if(overlay) {
					(new File(destFileName)).delete();
				}
			} else if(!destFile.getParentFile().exists() && !destFile.getParentFile().mkdirs()) {
				return false;
			}

			boolean byteread = false;
			FileInputStream in = null;
			FileOutputStream out = null;

			boolean var9;
			try {
				in = new FileInputStream(srcFile);
				out = new FileOutputStream(destFile);
				byte[] e = new byte[1024];

				int byteread1;
				while((byteread1 = in.read(e)) != -1) {
					out.write(e, 0, byteread1);
				}

				out.flush();
				var9 = true;
				return var9;
			} catch (FileNotFoundException var21) {
				var9 = false;
				return var9;
			} catch (IOException var22) {
				var9 = false;
			} finally {
				try {
					if(out != null) {
						out.close();
					}

					if(in != null) {
						in.close();
					}
				} catch (IOException var20) {
					var20.printStackTrace();
				}

			}

			return var9;
		}
	}

	public static boolean copyDirectory(String srcDirName, String destDirName, boolean overlay) {
		File srcDir = new File(srcDirName);
		if(!srcDir.exists()) {
			return false;
		} else if(!srcDir.isDirectory()) {
			return false;
		} else {
			if(!destDirName.endsWith(File.separator)) {
				destDirName = destDirName + File.separator;
			}

			File destDir = new File(destDirName);
			if(destDir.exists()) {
				if(!overlay) {
					return false;
				}

				(new File(destDirName)).delete();
			} else {
				System.out.println("目的目录不存在，准备创建。。。");
				if(!destDir.mkdirs()) {
					System.out.println("复制目录失败：创建目的目录失败！");
					return false;
				}
			}

			boolean flag = true;
			File[] files = srcDir.listFiles();

			for(int i = 0; i < files.length; ++i) {
				if(files[i].isFile()) {
					flag = copyFile(files[i].getAbsolutePath(), destDirName + files[i].getName(), overlay);
					if(!flag) {
						break;
					}
				} else if(files[i].isDirectory()) {
					flag = copyDirectory(files[i].getAbsolutePath(), destDirName + files[i].getName(), overlay);
					if(!flag) {
						break;
					}
				}
			}

			if(!flag) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static String createFile(String path, String fileName, InputStream is) throws Exception {

		FileOutputStream fos = null;

		StringBuffer filePathName = new StringBuffer();
		//filePathName.append(Configuration.FILE_UPLOAD_PATH);
		filePathName.append(path);
		filePathName.append(fileName);
		filePathName.append(".uploading");

		try {
			//创建文件目录
			File dir = new File(path);
			dir.mkdirs();

			fos = new FileOutputStream(filePathName.toString());
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			try {
				if (fos != null) {
					fos.close();
					fos = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}

		String newName = filePathName.substring(0, filePathName.length() - 10);
		//删除旧文件
		FileUtils.deleteFile(newName);
		//去掉.uploading后缀
		new File(filePathName.toString()).renameTo(new File(newName));

		return newName;
	}

	/**
	 * 压缩文件(zip)
	 * @param srcFiles
	 * @param zippath
	 * @throws Exception
	 */
	public static void Zip(List<File> srcFiles , String zippath)throws Exception {
		File file=new File(zippath);
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		long start = System.currentTimeMillis();
		ZipOutputStream zos = null ;
		try {
			zos = new ZipOutputStream(out);
			for (File srcFile : srcFiles) {
				byte[] buf = new byte[4096 * 1024];
				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int len;
				FileInputStream in = new FileInputStream(srcFile);
				while ((len = in.read(buf)) != -1){
					zos.write(buf, 0, len);
				}
				zos.closeEntry();
				in.close();
			}
			long end = System.currentTimeMillis();
			System.out.println("压缩完成，耗时：" + (end - start) +" ms");
		} catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils",e);
		}finally{
			if(zos != null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 *获取路径下所有文件(递归遍历)
	 * @param fileList
	 * @param path
	 * @throws Exception
	 */
	public static void getFiles(List<File>fileList, String path){
		try {
			File file = new File(path);
			if(file.isDirectory()){
				File []files = file.listFiles();
				for(File fileIndex:files){
					//如果这个文件是目录，则进行递归搜索
					if(fileIndex.isDirectory()){
						getFiles(fileList,fileIndex.getPath());
					}else {
						//如果文件是普通文件，则将文件句柄放入集合中
						fileList.add(fileIndex);
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
