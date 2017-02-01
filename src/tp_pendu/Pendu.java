package tp_pendu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pendu {

	public static void main(String[] args) throws IOException {
		System.out.println("Jeu du pendu");
		Dico dico = new Dico("dico.txt");
		Mot mot = new Mot(dico.getRandomWord());
		Mot progression = new Mot(mot.getSizeOfWord());
		Scanner scan = new Scanner(System.in);
		ArrayList<Character> pick = new ArrayList<Character>();
		
		int nbErrorPossible = 7;
		int nbError = 0;
		
		while(progression.isWordFound() == false && nbError <= nbErrorPossible)
		{
			progression.affiche();
			System.out.println();
			String in = "";
			while(in.length() != 1)
			{
				System.out.print("Veuillez entrer une lettre ");
				pick.stream()
				.forEach(c->System.out.print(c+" "));
				System.out.println();
				
				System.out.println("Erreurs : "+nbError+"/"+nbErrorPossible);
				if(scan.hasNext())
				{
					in = scan.next();
				}
			}
			
			ArrayList<Integer> index = mot.checkLettre(in.charAt(0));
			if(index.size() == 0)
			{
				progression.lostLife();
			}
			if(!pick.contains(new Character(Character.toUpperCase(in.charAt(0)))))
			{
				pick.add(new Character(Character.toUpperCase(in.charAt(0))));
			}
			
			
			if(index.stream().count() > 0)
			{
				for(Integer i : index)
				{
					progression.addCharAt(i, in.charAt(0));
				}
			}
			else
			{
				nbError++;
			}
		}
		
		scan.close();
		
		if(nbError > nbErrorPossible)
		{
			System.out.print("GAME OVER ! La réponse était : ");
			mot.affiche();
		}
		else
		{
			System.out.print("VICTORY ! ");
			mot.affiche();
		}
		
		

	}
	
	
	
	
	
	

}
