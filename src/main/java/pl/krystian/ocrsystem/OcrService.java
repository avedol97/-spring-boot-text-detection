package pl.krystian.ocrsystem;

import net.sourceforge.tess4j.*;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class OcrService {

    public String doOcr(String url) throws IOException {
        try {
            URL imageFile = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageFile);

            ITesseract instance = new Tesseract();
            instance.setDatapath("D:\\Pobrane");
            instance.setLanguage("pol");

            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Failed!";
    }
}
//https://3.allegroimg.com/original/03c76d/cbeba99f41b2968c7f3d6f1fc943/Plakat-Cytat-Saint-Exupery-Maly-Ksiaze-A3-30x40
