package com.antilia.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	static int BUFFER_SIZE = 10*1024;

    
    static public void copy(byte[] bytes, File file) throws IOException {
    	FileOutputStream out =new FileOutputStream(file);
    	copy(new ByteArrayInputStream(bytes), out);
    	out.close();
	}
    
    static public void copy(byte[] bytes, OutputStream os) throws IOException {
		copy(new ByteArrayInputStream(bytes), os);
	}
    
    /**
     * Copies one stream into the other..
	 * @param is	Stream fuente
	 * @param os	Stream destino*/
	static public void copy(InputStream is, OutputStream os) throws IOException {
		byte[] buf = new byte[BUFFER_SIZE];
		while (true) {
			int tam = is.read(buf);
			if (tam == -1) {
				return;
			}
			os.write(buf, 0, tam);
		}
	}
	
	public static  byte[] bytes(InputStream is) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copy(is, out);
		return out.toByteArray();
	}
	
	public static List<String> readLines(InputStream is) {
		try {
			List<String> lines = new ArrayList<String>();
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				if(!org.apache.commons.lang3.StringUtils.isEmpty(strLine)) {
					lines.add(strLine);
				}
			}
			in.close();
			return lines;
		} catch (Exception e) {// Catch exception if any
			return null;
		}		
	}


    public static String escapeEmail(String text) {
        BufferedReader bufReader = new BufferedReader(new StringReader(text));
        String line=null;
        StringBuilder builder = new StringBuilder();
        try {
            while( (line=bufReader.readLine()) != null ) {
                builder.append("|").append(line).append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();
    }
}
