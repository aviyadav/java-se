package com.large.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteBufferRead {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        try {
            RandomAccessFile aFile = new RandomAccessFile("E:\\Data\\fake-naaccr14inc-10000-rec\\fake-naaccr14inc-10000-rec.txt", "r");
            FileChannel inChannel = aFile.getChannel();
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            
            buffer.load();
            
            CharBuffer charBuffer = StandardCharsets.US_ASCII.decode(buffer);
            String read = charBuffer.toString();
            
            System.out.println(read);
            
            buffer.clear();
            inChannel.close();
            aFile.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ByteBufferRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ByteBufferRead.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = System.nanoTime();
        System.out.println("Total elapsed time : " + TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS) + " ms");
    }
}
