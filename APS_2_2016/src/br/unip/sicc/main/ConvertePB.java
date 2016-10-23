package br.unip.sicc.main;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

public class ConvertePB{
	
	
      public static BufferedImage getImage() {
    	BufferedImage image = null;
		try {
			image = ImageIO.read(new File(Tela.getTextField().getText()));
		} catch (IOException e) {
			System.err.println("Erro ao ler a imagem");
		}
		return image;
	  }

	public static BufferedImage ConverteIMG(){
    	   Color color;
  		   int pixel = 0;
           try{
	             /* imagem colorida */
	             BufferedImage image = getImage();
	             
	             /*  salvando */
	             String temp = "blackAndwhiteNew.jpeg";
	             File fi = new File("C:\\Users\\Megattrol\\Desktop\\" + temp);
	             ImageIO.write(converteIMGPB(image), "jpg", fi);
	             
	             /*  mostra os pixels em RGB e calcula quantidade de pixel */
	             for (int i = 0; i < image.getWidth(); i++) {
	 				for (int j = 0; j < image.getHeight(); j++) {
	 					color = new Color(image.getRGB(i, j));
	 					System.out.println(color);
	 					pixel++;
	 				}
	 			 }
	 			 System.out.println("Quantidade de Pixels: " + pixel);
	 			 return image;
           }
           catch (Exception e) {
        	     System.out.println(e);
           }
		return null;
      }
      
      public static BufferedImage converteIMGPB(BufferedImage image){
    	  double image_width = image.getWidth();
          double image_height = image.getHeight();
          BufferedImage bimg = null;
          BufferedImage img = image;
          bimg = new BufferedImage((int)image_width, (int)image_height,BufferedImage.TYPE_BYTE_GRAY);
          Graphics2D gg = bimg.createGraphics();
          gg.drawImage(img, 0, 0, img.getWidth(null), img.getHeight(null), null);
          return bimg;
      }
      
      
}
