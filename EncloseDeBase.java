package lesEnclos;

import java.util.List;
import java.util.ArrayList;
import lesAnimaux.Animaux;

public class EncloseDeBase {
	

	public enum proprete{
		Propre,Correcte,Sale
	}
	
	private String degreProprete;
	private String nom;
	private double superficie;
	private int animauxPresent;
	private int animauxMax;
	private ArrayList dansEnclos=new ArrayList();
	
	public EncloseDeBase(String nom, double superficie, int animauxMax) {
		this.degreProprete =proprete.Propre.toString();
		this.nom = nom;
		this.superficie = superficie;
		this.animauxPresent =0;
		this.animauxMax = animauxMax;
	}

	public String getDegreProprete() 						{return degreProprete;}
	public String getNom() 									{return nom;}
	public double getSuperficie() 							{return superficie;}
	public int getAnimauxPresent()							{return animauxPresent;}
	public int getAnimauxMax() 								{return animauxMax;}
	public ArrayList getDansEnclos() 						{return dansEnclos;}
	
	
	public void setDegreProprete(String degreProprete) 							{this.degreProprete = degreProprete;}
	public void setNom(String nom) 												{this.nom = nom;}
	public void setSuperficie(double superficie) 								{this.superficie = superficie;}
	public void setAnimauxPresent(int animauxPresent) 							{this.animauxPresent = animauxPresent;}
	public void setAnimauxMax(int animauxMax) 									{this.animauxMax = animauxMax;}
	public void setDansEnclos(ArrayList dansEnclos) 							{dansEnclos = dansEnclos;}
	
	public void afficherInfo(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		String infoEnclos;
		infoEnclos=nom+" a une superficie de "+superficie+" ,il est"+degreProprete+" et il y a "+animauxPresent
				+" sur une capacité de "+animauxMax;
		return infoEnclos;
	}
	
	public void ajoutAnimaux(Animaux nouvelAnimal){			//retravailler, c'est laid
		if(!dansEnclos.isEmpty()){
			if(nouvelAnimal.getClass().toString()!=dansEnclos.get(0).getClass().toString())
				System.out.println("Les animaux cohabitent mal ensemble");
			else{
				if(dansEnclos.size()<animauxMax){
					dansEnclos.add(nouvelAnimal);
					System.out.println("vous placez l'animal dans l'enclos");
				}
			}
		}
		else{
			dansEnclos.add(nouvelAnimal);
			System.out.println("vous placez l'animal dans l'enclos");
		}
	}
	
	public void enleverAnimal(int position){
		if(dansEnclos.isEmpty()&&position>0)
			dansEnclos.remove(position-1);
	}
	
	public void nettoyerEnclos(){
		if(dansEnclos.isEmpty())
			degreProprete=proprete.Propre.toString();
	}
}
