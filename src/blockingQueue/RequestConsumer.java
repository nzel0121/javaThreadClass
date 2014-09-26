package blockingQueue;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.activation.MimetypesFileTypeMap;

public class RequestConsumer implements Runnable {

	
	private volatile LinkedBlockingQueue<Socket> queue;

	public RequestConsumer(LinkedBlockingQueue<Socket> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		Socket socket = null;
		
		try {
			socket = queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader in = null;
		DataOutputStream out = null;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new DataOutputStream(socket.getOutputStream());
			
			String requestMessageLine = in.readLine();
			if (requestMessageLine == null) return;
			StringTokenizer requestToken = new StringTokenizer(requestMessageLine);
			
			//GET 요청처리 
			if(requestToken.nextToken().equals("GET")){
				String fileName = requestToken.nextToken();
				//  "/" 제거
				if(fileName.startsWith("/")){
					if(fileName.length()>1){
						fileName = fileName.substring(1);
					}
				}
				
				File file = new File("src\\" + fileName);
				if(file !=null && file.exists()){
					String mimeType = new MimetypesFileTypeMap().getContentType(file);
					int numOfBytes = (int) file.length();
					
					//파일스트림 
					FileInputStream fileStream = new FileInputStream("src\\" + fileName);
					byte[] fileByteArray = new byte[numOfBytes];
					fileStream.read(fileByteArray);
					
					
					//결과리턴
					String newLine ="\r\n";
					
					out.writeBytes("HTTP/1.0 200 Document Follows " + newLine);
					out.writeBytes("Content-Type: " + mimeType + newLine);
					out.writeBytes("Content-Length: " + numOfBytes + newLine);
					out.writeBytes(newLine);
					
					out.write(fileByteArray,0,numOfBytes);
					out.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something Wrong");
		}finally{
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
