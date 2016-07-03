package site.lovecode.wechat.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.ruedigermoeller.serialization.FSTConfiguration;
import de.ruedigermoeller.serialization.FSTObjectInput;
import de.ruedigermoeller.serialization.FSTObjectOutput;

/**
 * 对象序列化反序列化工具类
 * 
 * @author kingzhu E-mail:darkwing.zhu@gmail.com
 * @version 创建时间：2012-11-17 下午08:25:50
 *
 */
public class SerializeUtil {

	static FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();


	public static byte[] fastSerialize( Object object ) {
		if ( object == null ) { return null; }
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FSTObjectOutput out = conf.getObjectOutput(baos);
		try {
			out.writeObject(object);
			// DON'T out.close() when using factory method;
			out.flush();
			baos.close();
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
		return baos.toByteArray();
	}


	@SuppressWarnings( "unchecked" )
	public static <T> T fastDeserialize( byte[] bytes ) {
		try {
			if ( bytes == null ) { return null; }
			// 反序列化
			FSTObjectInput in = conf.getObjectInput(bytes);
			return (T) in.readObject();
		} catch ( Exception e ) {
			throw new RuntimeException(e);
		}
	}


	public static byte[] serialize( Object object ) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		if ( object == null ) { return null; }
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch ( Exception e ) {
			throw new RuntimeException(e);
		}
	}


	public static Object unserialize( byte[] bytes ) {
		ByteArrayInputStream bais = null;
		if ( bytes == null ) { return null; }
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch ( Exception e ) {
			throw new RuntimeException(e);
		}
	}


	public static void main( String[] args ) {
		//int ii = fastDeserialize(fastSerialize(123));
		// String sss = fastDeserialize(fastSerialize("123"));
	}
}
