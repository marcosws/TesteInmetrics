package br.com.inmetrics.teste.support;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.imageio.ImageIO;

public class Utils {
	
	/**
	 * @author Marcos
	 * @param name
	 */
	public static void print(String name){
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateTime = localDateTime.format(formatter);
		dateTime = dateTime.replaceAll("/", "-").replaceAll(" ", "_").replaceAll(":", "-");
		String partialPath = System.getProperty("user.dir") + "//evidencias//";
		String finalPath = partialPath + name + "_" + dateTime + ".jpg";
		File directory = new File(partialPath);
		if (!directory.exists()){
			directory.mkdirs();
		}
        try{
            Robot robot = new Robot();
            BufferedImage bufferedImage= robot.createScreenCapture(new Rectangle((int)screenSize.getWidth(), (int)screenSize.getHeight()));
            ImageIO.write(bufferedImage, "jpg", new File(finalPath)); 
        } 
        catch (IOException | AWTException e) {
            e.printStackTrace();
        } 
		
	}
	
	/**
	 * @author Marcos
	 * @param milisegundos
	 */
	public static void sleep(long milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} 
		catch (InterruptedException e) {}
	}
	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static boolean isNullOrEnpty(String valor) {
		return (valor.equals("") || valor != null);
	}
	/**
	 * @author Marcos
	 * @param filePath
	 * @return
	 */
	public static String readFile(String filePath) {
		
		String line;
        String fileContent = "";
        String returnContent = "";
        BufferedReader in = null;

        try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        
		while(true)
		{
			try {
				line = in.readLine();
				if(line == null)
					break;
				fileContent += line;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte ptext[] = fileContent.getBytes();
		try {
			returnContent = new String(ptext, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnContent;
		
	}
	/**
	 * @author Marcos
	 * @return
	 */
	public static String getDataPath() {
		return System.getProperty("user.dir") + "//src//test//resources//data//";
	}
	/**
	 * @author Marcos
	 * @param jsonFile
	 * @return
	 */
	public static String retornaJson(String jsonFile) {
		String jsonPath = getDataPath() + jsonFile;
		return Utils.readFile(jsonPath);
	}
	public static String randomNumber(int range){
		Random rand = new Random();
		int intRandom = rand.nextInt(range); 
		return String.valueOf(intRandom);
	}
	
}
