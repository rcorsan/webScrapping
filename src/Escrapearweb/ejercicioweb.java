package Escrapearweb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ejercicioweb {

	public static void main(String[] args) {
		String url = "https://www.amazon.com/s?k=juegos";

	        try {
	            Document doc = Jsoup.connect(url).get(); 

	            Elements products = doc.select(".s-result-item"); 

	            BufferedWriter wr = new BufferedWriter(new FileWriter("resultados.csv"));
	            wr.write("Título, Precio \n"); 
	            for (Element product : products) {
	            	if(product.select(".a-size-base-plus.a-color-base.a-text-normal").text()==""||product.select(".a-price-whole").text()=="") {
	            		continue;
	            	}
	                String titulo = product.select(".a-size-base-plus.a-color-base.a-text-normal").text(); 
	                String precio = product.select(".a-price-whole").text(); 
	                wr.write( "TITULO: "+titulo  + ",PRECIO: " + precio +"(EUR"+ "\n");
	            }

	            wr.close(); 

	            System.out.println("Ejercicio resuelto correctamente");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	}

}
