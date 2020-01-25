package cm.ro.graphe.model;
import java.util.ArrayList;

public class Graphe {
	protected String nom;
	protected int nbNoeuds;
	protected ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
	
	public Graphe(String n) {
		//a completer
		nom = n;
		this.nbNoeuds = 0;
	}
	
	public Graphe(Noeud[] nds, String n) {
		nom = n;
		nbNoeuds = nds.length;
		for(Noeud nd : nds) {
			noeuds.add(nd);
		}
	}
	
	public void creerNoeud(Noeud neu) {
		if(!contentNoeud(neu.label)) {
			noeuds.add(neu);
			nbNoeuds = noeuds.size();
		}
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbNoeuds() {
		return this.nbNoeuds;
	}
	
	public void setNbNoeuds() {
		
	}
	
	public String getNoeuds() {
		String r = "";
		for(Noeud nd : noeuds)
			r += nd.getLabel()+" | ";
		return r;
	}
	
	public Noeud getNoeud(String nom) {
		for(Noeud nd : noeuds) {
			if(nd.label.equals(nom)) {
				return nd;
			}
		}
		return null;
	}
	
	public boolean contentNoeud(String c) {
		for(Noeud nd : noeuds) {
			if(nd.label.equals(c))
				return true;
		}
		return false;
	}
	
	public boolean contentNoeudIndex(int c) {
		for(int i = 0; i < noeuds.size(); i++) {
			if(i == c)
				return true;
		}
		return false;
	}
	
	public void deleteNoeud(Noeud neu) {
		for(Noeud n : noeuds) {
			n.enleveVoisin(neu);
		}
		noeuds.remove(noeuds.indexOf(neu));
		this.nbNoeuds--;
	}
	
	public ArrayList<Noeud> getListeNoeud(){
		return this.noeuds;
	}
	
	public void affiche() {
    //a completer
	}	
}
