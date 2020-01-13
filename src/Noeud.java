import java.util.ArrayList;

public class Noeud implements Comparable<Noeud> {
	protected int id;
	protected int nbVoisins;
	// c'est plus simple d'ajouter et d'enlever des elements avec une liste qu'avec un array
	protected ArrayList<Noeud>  successeurs;
	protected ArrayList<Integer> arcs; //arcs sortant 
	
	// cree un noeud isole
	public Noeud(int i) {
    //a completer
	}
	
	// cree un noeud a partir d'une liste de voisins
	// les arcs sont de poids 1
	public Noeud(int i, Noeud[] noeuds) {
    //a completer
	}
	
	// renvoie le nombre de voisins
	public int nbVoisins() {
    //a completer
		
		return 1;
	}
	
	// renvoie le degre sortant, qui vaut la somme des elements de arcs
	public int degreSortant() {
    //a completer
		
		return 1;
	}
	
	// renvoie l'indice de v dans voisins si v est voisin
	// renvoie -1 si v n'est pas voisin
	public int estVoisin(Noeud v) {
    //a completer
		return 1;
	}
	
	// renvoie le poids de l'arc correspondant si v est voisin, 0 sinon
	public int nbArcs(Noeud v) {
    //a completer
		
		return 1;
	}
	
	
	// si v est deja voisin, modifie la poids de l'arc correspondant
	// sinon, ajoute v comme un nouveau voisin avec un arc de poids d
	// (il faut incrementer nbArcs si c'est un nouveau voisin)
	// revoie le nouveau nombre de voisins
	public int ajouteVoisin(Noeud v, int d) {
    //a completer
		
		return 1;
	}
	
	// si v n'est pas voisin, ne fait rien
	// sinon enleve v de la liste de voisins
	// renvoie le nouveau nombre de voisins
	public int enleveVoisin(Noeud v) {
    //a completer
		
		return 1;
	}
	
	@Override
	public int compareTo(Noeud o) {
		if ( id > o.id ) {
			return 1;
		}
		else if ( id < o.id ) {
			return -1;
		}
		else {
			return 0;
		}
	}
	

}
