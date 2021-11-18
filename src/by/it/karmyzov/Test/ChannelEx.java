package by.it.karmyzov.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelEx {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("\\C:\\Users\\Mi Pro\\Desktop\\test10.txt", "r");
             FileChannel channel = file.getChannel();) {
            Buffer buffer = ByteBuffer.allocate(5);
            channel.read((ByteBuffer) buffer);
            buffer.flip();
            System.out.println((char) ((ByteBuffer) buffer).get());
            System.out.println((char) ((ByteBuffer) buffer).get());
            System.out.println((char) ((ByteBuffer) buffer).get());
            buffer.rewind();
            System.out.println((char) ((ByteBuffer) buffer).get());

            System.out.println("--------------------------------------");
            ((ByteBuffer) buffer).compact();
            channel.read((ByteBuffer) buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) ((ByteBuffer) buffer).get());
                         }

            System.out.println("--------------------------------------");
            buffer.clear();
            channel.read((ByteBuffer) buffer);
            buffer.flip();
            System.out.println((char) ((ByteBuffer) buffer).get());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
