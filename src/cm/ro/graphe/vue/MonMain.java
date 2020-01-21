/**
 * 
 */
package cm.ro.graphe.vue;

import cm.ro.graphe.controler.*;

import java.util.ArrayList;
import java.util.Scanner;

import cm.ro.graphe.model.Graphe;

/**
 * @author franel
 *
 */
public class MonMain {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gestion g = new Gestion();
		g.play();
	}
	
	
	
	
	/** FILE MANIPULATION 
	private static String twoDigits(int n) {
		String str;
		if ( n < 10 ) {
			str = "0" + n;
		}
		else {
			str = "" + n;
		}
		return str;
	}
	
	// Get today's date in YYYYMMDD format, to be used as file prefix
	protected static String getDate() {
		ZonedDateTime t = ZonedDateTime.now();
		
		String str = "" + t.getYear() + twoDigits(t.getMonthValue()) + twoDigits(t.getDayOfMonth());
		return str;
	}
	
	protected static String getTime() {
		ZonedDateTime t = ZonedDateTime.now();
		String str;
		str = "" + t.getHour() + t.getMinute() + t.getSecond();
		return str;
	}
	
	// Create a file. If file exists, rename it before creating a new file.
	protected static File createFile(String fPath) {
		try {
			File f = new File(fPath);
			if ( f.exists() ) {
				String renamePath = fPath + "." + getDate() + getTime();
				boolean rename = f.renameTo( new File ( renamePath ) );
				if ( rename ) {
					System.out.println("File \n\t" + 
							fPath + "\nexists. Renamed to:\n\t" 
							+ renamePath);
				}
				else {
					System.out.println("File \n\t" + 
							fPath + "\nexists and cannot be renamed.");
					return null;
				}
			}
			//System.out.println("Ole Ole Ole " + f.createNewFile());
			f.createNewFile();
			
			//System.out.println("1.00001");
			//System.out.println("f null? " + (f == null));
			
			return f;
		}
		catch(Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return null;
		}
	}
	
	* END FILE MANIPULATION 
	
	// dessiner un png avec dot
	public void toPNG ( String nomGraphe, String fichier ) {
		try {
			File sortie = createFile(fichier);
			BufferedWriter buf = new BufferedWriter( 
					new OutputStreamWriter(
							new FileOutputStream( sortie ), Charset.forName("UTF-8").newEncoder()
							)
					);
			
			String line;
			
			buf.write("digraph " + nomGraphe + " {\n");
			
			for ( Noeud v : noeuds ) {
				if ( v.nbVoisins > 0 ) {
					for ( Noeud u : v.successeurs ) {
						line = "" + v.id + " -> " + u.id + ";\n";
						buf.write(line);
					}
				}
			}
			
			buf.write("}");
			
			buf.close();
 
			String commande = "dot -Tpng " + fichier + " -o " + fichier + ".png";
			Process process = Runtime.getRuntime().exec(commande);
			process.waitFor();
		}
		catch ( Exception e ) {			
			e.printStackTrace();
		}
	}*/
}
