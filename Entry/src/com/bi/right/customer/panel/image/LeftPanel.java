/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.panel.image;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.RescaleOp;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JPanel;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class LeftPanel extends JPanel implements Printable{

    private BufferedImage current = null;
    private URL currentURL = null;

    public BufferedImage getCurrent() {
        return current;
    }

    public LeftPanel() {
      
    }

    public void setCurrent(BufferedImage current) {
        this.current = current;
    }
    private static Map<String, Image> cache =
            new ConcurrentHashMap<String, Image>();
    private static String opsName[] = {
        "Threshold", "RescaleOp", "Invert", "Yellow Invert", "3x3 Blur",
        "3x3 Sharpen", "3x3 Edge", "5x5 Edge"};
    static BufferedImageOp biop[] = new BufferedImageOp[opsName.length];
    private static int rescaleFactor = 128;
    private static float rescaleOffset = 0;
    private static int low = 100, high = 200;
    private int opsIndex, imgIndex;

    static {
        thresholdOp(low, high);
        int i = 1;
        biop[i++] = new RescaleOp(1.0f, 0, null);
        byte invert[] = new byte[256];
        byte ordered[] = new byte[256];
        for (int j = 0; j < 256; j++) {
            invert[j] = (byte) (256 - j);
            ordered[j] = (byte) j;
        }
        biop[i++] = new LookupOp(new ByteLookupTable(0, invert), null);
        byte[][] yellowInvert = new byte[][]{invert, invert, ordered};
        biop[i++] = new LookupOp(new ByteLookupTable(0, yellowInvert), null);
        int dim[][] = {{3, 3}, {3, 3}, {3, 3}, {5, 5}};
        float data[][] = {{0.1f, 0.1f, 0.1f, // 3x3 blur
                0.1f, 0.2f, 0.1f,
                0.1f, 0.1f, 0.1f},
            {-1.0f, -1.0f, -1.0f, // 3x3 sharpen
                -1.0f, 9.0f, -1.0f,
                -1.0f, -1.0f, -1.0f},
            {0.f, -1.f, 0.f, // 3x3 edge
                -1.f, 5.f, -1.f,
                0.f, -1.f, 0.f},
            {-1.0f, -1.0f, -1.0f, -1.0f, -1.0f, // 5x5 edge
                -1.0f, -1.0f, -1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f, 24.0f, -1.0f, -1.0f,
                -1.0f, -1.0f, -1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f, -1.0f, -1.0f, -1.0f}};
        for (int j = 0; j < data.length; j++, i++) {
            biop[i] = new ConvolveOp(new Kernel(dim[j][0], dim[j][1], data[j]));
        }
    }

    public static void thresholdOp(int low, int high) {
        byte threshold[] = new byte[256];
        for (int j = 0; j < 256; j++) {
            if (j > high) {
                threshold[j] = (byte) 255;
            } else if (j < low) {
                threshold[j] = (byte) 0;
            } else {
                threshold[j] = (byte) j;
            }
        }
        biop[0] = new LookupOp(new ByteLookupTable(0, threshold), null);
    }

    public Image getImage3(String name) {
        Image img = null;
        if (cache != null) {
            if ((img = cache.get(name)) != null) {
                return img;
            }
        }

        URLClassLoader urlLoader =
                (URLClassLoader) getClass().getClassLoader();
        URL fileLoc = urlLoader.findResource(name);
        return getInternalImage(fileLoc, name);
    }

    public void render(int w, int h, Graphics2D g2, Image image) {

        int iw = image.getWidth(null);
        int ih = image.getHeight(null);
        BufferedImage bi = new BufferedImage(iw, ih, BufferedImage.TYPE_INT_RGB);
        bi.createGraphics().drawImage(image, 0, 0, null);
        iw = bi.getWidth(null);
        ih = bi.getHeight(null);
        AffineTransform oldXform = g2.getTransform();
        g2.scale(((double) w) / iw, ((double) h) / ih);
        g2.drawImage(bi, biop[opsIndex], 0, 0);
        g2.setTransform(oldXform);
    }

    public void renderTampon(int w, int h, Graphics2D g2) {
        Image image = getImage("copie60x60.png");
        int iw = image.getWidth(null);
        int ih = image.getHeight(null);
        BufferedImage bi = new BufferedImage(iw, ih, BufferedImage.TYPE_INT_RGB);
        bi.createGraphics().drawImage(image, 0, 0, null);
        iw = bi.getWidth(null);
        ih = bi.getHeight(null);
        AffineTransform oldXform = g2.getTransform();
        g2.scale(((double) w) / iw, ((double) h) / ih);
        g2.drawImage(bi, biop[opsIndex], 0, 0);
        g2.setTransform(oldXform);
    }

    public Image getImage(String name) {
        Image img = null;
        if (cache != null) {
            if ((img = cache.get(name)) != null) {
                return img;
            }
        }
        URLClassLoader urlLoader =
                (URLClassLoader) getClass().getClassLoader();
        URL fileLoc = urlLoader.findResource(name);
        return getInternalImage(fileLoc, name);
    }

    public void render3(int w, int h, Graphics2D g2) {
        BufferedImage bi = current;
        bi.createGraphics().drawImage(bi, 0, 0, null);
        int iw = bi.getWidth(null);
        int ih = bi.getHeight(null);
        AffineTransform oldXform = g2.getTransform();
        g2.scale(((double) w) / iw, ((double) h) / ih);
        g2.drawImage(bi, biop[0], 0, 0);
        g2.setTransform(oldXform);
    }

    private Image getInternalImage(URL fileLoc, String name) {
        Image img;
        img = getToolkit().createImage(fileLoc);
        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(img, 0);
        try {
            tracker.waitForID(0);
            if (tracker.isErrorAny()) {
                System.out.println("Error loading image " + name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return img;
    }

    public Graphics2D createGraphics2D(int width,
            int height,
            BufferedImage bi,
            Graphics g) {

        Graphics2D g2 = null;

        if (bi != null) {
            g2 = bi.createGraphics();
        } else {
            g2 = (Graphics2D) g;
        }

        g2.setBackground(getBackground());
        /* g2.setRenderingHint(KEY_ANTIALIASING, AntiAlias);
         g2.setRenderingHint(KEY_RENDERING, Rendering);

         if (clearSurface || clearOnce) {
         g2.clearRect(0, 0, width, height);
         clearOnce = false;
         }

         if (texture != null) {
         // set composite to opaque for texture fills
         g2.setComposite(AlphaComposite.SrcOver);
         g2.setPaint(texture);
         g2.fillRect(0, 0, width, height);
         }

         if (composite != null) {
         g2.setComposite(composite);
         }*/

        return g2;
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);
        if (currentURL != null) {
            try {
            Dimension d = getSize();
            Graphics2D g2 = (Graphics2D)g;
            Image currentImage = getInternalImage(currentURL, currentURL.getPath());
            render(currentImage.getWidth(null),currentImage.getHeight(null) , g2 , currentImage);
            renderTampon(60, 60, g2);
            g2.dispose();
            } catch (Exception e) {
                currentURL = null;
                e.printStackTrace();
            }
        }

    }*/
    void setCurrentURL(URL url) {
        this.currentURL = url;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
