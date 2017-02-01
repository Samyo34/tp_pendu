package tp_pendu;

import java.util.ArrayList;

public class Mot {
	
	private ArrayList<Character> mot;

	private DessinPendu d;
	
	public Mot(ArrayList<Character> mot)
	{
		this.mot = mot;
		d = new DessinPendu();
	}
	
	public Mot(int size)
	{
		mot = new ArrayList<Character>();
		for(int i = 0; i<size;i++)
		{
			addChar('_');
		}
		d = new DessinPendu();
	}
	
	public int getSizeOfWord()
	{
		return mot.size();
	}

	public ArrayList<Integer> checkLettre(char c)
	{
		if(this.mot.contains(new Character(Character.toUpperCase(c))))
		{
			return getIndexOfChar(Character.toUpperCase(c));
		}
		return new ArrayList<Integer>();
	}

	public void lostLife()
	{
		d.lostLife();
	}
	
	public void addChar(char c)
	{
		mot.add(new Character(Character.toUpperCase(c)));
	}
	
	public void addCharAt(int index, char c)
	{
		mot.remove(index);
		mot.add(index, new Character(Character.toUpperCase(c)));
		
	}
	
	public boolean isWordFound()
	{
		return !mot.contains('_');
	}
	
	public void affiche()
	{
		mot.stream().forEach(c->System.out.print(c+" "));
		System.out.println();
		d.getDessin().stream()
			.forEach(s->System.out.println(s));
	}

	
	private ArrayList<Integer> getIndexOfChar(char c)
	{
		ArrayList<Integer> index = new ArrayList<Integer>();
		int cpt = 0;
		for (Character lettre : this.mot) 
		{
			if(lettre.equals(c))
			{
				index.add(new Integer(cpt));
			}
			cpt++;
		}
		
		return index;
	}
	
	
	

}
