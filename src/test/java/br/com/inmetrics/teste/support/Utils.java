package br.com.inmetrics.teste.support;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class Utils {
	
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
	
	public static void sleep(long milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} 
		catch (InterruptedException e) {}
	}
	
	public static boolean isNullOrEnpty(String valor) {
		return (valor.equals("") || valor != null);
	}

}
