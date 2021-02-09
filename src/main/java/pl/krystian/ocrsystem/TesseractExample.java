package pl.krystian.ocrsystem;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TesseractExample {

    public static void main(String[] args) throws IOException {

        URL imageFile = new URL("https://3.allegroimg.com/original/03c76d/cbeba99f41b2968c7f3d6f1fc943/Plakat-Cytat-Saint-Exupery-Maly-Ksiaze-A3-30x40");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        ITesseract instance = new Tesseract();

        instance.setDatapath("D:\\Pobrane");
        instance.setLanguage("pol");

        try{
            String result = instance.doOCR(bufferedImage);
            System.out.println(result);
        }catch (TesseractException e){
            System.err.println(e.getMessage());
        }

    }
}
