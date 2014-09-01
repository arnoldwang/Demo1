package IOExample;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BinaryFile {

	public static byte[] read(File file) throws Exception{
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		try{
			byte[] data = new byte[in.available()];
			in.read(data);//把数据流读入到一个byte数组中
			return data;
		}finally{
			in.close();
		}
	}
}
