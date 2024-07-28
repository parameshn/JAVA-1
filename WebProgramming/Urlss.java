package WebProgramming;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URI;
import java.net.URLConnection;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.awt.Toolkit;
import java.io.*;

public class Urlss {
    

    public static void main(String[] args) {
        try{
            URI uri = new URI("https://th.bing.com/th/id/OIP.XpqvzCnY4doYgQ0YqLupuwHaEo?rs=1&pid=ImgDetMain");
        
            URL url = uri.toURL();

            /*We can get a URLConnection from our URL directly with the openConnection()
            method. One of the things we can do with the URLConnection is ask for the object’s
            content type before reading data
            */
            URLConnection connection = url.openConnection();
            String con = connection.getContentType();
            
            /*The URLConnection does not talk to the source
            until data is requested or its connect() method is explicitly invoked
            */

            /*Prior to connec‐
            tion, network parameters and protocol-specific features can be set up
            */

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            InputStream in = connection.getInputStream();

            ImageProducer ip = (ImageProducer) connection.getContent();
            Image image = Toolkit.getDefaultToolkit().createImage(ip);


            System.out.println(con);// text/html; charset=utf-8
            System.out.println(image);

            BufferedReader bin = new BufferedReader(new InputStreamReader(url.openStream()));
            

            String line;
            while ((line = bin.readLine()) != null) {
              //  System.out.println(line);
            }

    } catch (MalformedURLException e) {
    }
    catch (URISyntaxException a) {
    }
        catch(IOException o){}

    }
}


/*
 * A MIME type (Multipurpose Internet Mail Extensions type) is a standard way to
 * indicate the nature and format of a file or data. MIME types are used in
 * various internet protocols such as HTTP, SMTP, and more to convey information
 * about the content type of the transmitted data.
 * 
 * MIME types consist of a primary type and a subtype, separated by a slash (/).
 * For example, text/html indicates that the content is HTML text.
 * 
 * Here are some common MIME types:
 * 
 * Text
 * text/plain: Plain text
 * text/html: HTML text
 * text/css: CSS
 * text/javascript: JavaScript
 * Images
 * image/jpeg: JPEG images
 * image/png: PNG images
 * image/gif: GIF images
 * Audio
 * audio/mpeg: MP3 audio
 * audio/wav: WAV audio
 * Video
 * video/mp4: MP4 video
 * video/x-msvideo: AVI video
 * Application
 * application/json: JSON data
 * application/xml: XML data
 * application/pdf: PDF documents
 * application/zip: ZIP files
 * How to Determine the MIME Type
 * File Extension: The MIME type is often determined based on the file
 * extension. For example, a file ending in .html typically has the MIME type
 * text/html.
 * 
 * Content Inspection: Sometimes, the content itself is inspected to determine
 * the MIME type. This is more reliable but also more complex.
 */