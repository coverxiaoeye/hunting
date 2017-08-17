package bigfilecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 使用NIO进行快速的文件拷贝
 * @author wangyg
 *
 */
public class FileCopyMain {

	public static void main(String[] args) {
		File copyfrom = new File("D:\\SourceCodes\\Study\\Interview\\javase_nio\\files\\xianneizhiyin.mp4");
		File copyto = new File("D:\\SourceCodes\\Study\\Interview\\javase_nio\\files\\xianneizhiyin-fuben.mp4");
		//File copyfrom = new File("E:\\QLDownload\\龙门飞甲 超清(1080P).mp4");
		//File copyto = new File("E:\\QLDownload\\龙门飞甲 超清(1080P)-fuben.mp4");
		
		
		try {
			fileCopy(copyfrom,copyto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileCopy( File in, File out )  
            throws IOException  
    {  
        FileChannel inChannel = new FileInputStream( in ).getChannel();  
        FileChannel outChannel = new FileOutputStream( out ).getChannel();  
        try 
        {  
//          inChannel.transferTo(0, inChannel.size(), outChannel);      
        	// original -- apparently has trouble copying large files on Windows  
  
            // magic number for Windows, 64Mb - 32Kb)  
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);  
            long size = inChannel.size();  
            long position = 0;  
            
            long startTime = System.nanoTime();

            while ( position < size )  
            {  
               position += inChannel.transferTo( position, maxCount, outChannel );  
            }  
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000000.0) + " seconds");
        }  
        finally 
        {  
            if ( inChannel != null )  
            {  
               inChannel.close();  
            }  
            if ( outChannel != null )  
            {  
                outChannel.close();  
            }  
        }  
    } 

}
