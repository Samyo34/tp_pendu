package tp_pendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dico {
	
	private ArrayList<String> words;
	
	public Dico()
	{
		words = new ArrayList<String>();
//		words.add("SUPER");
//		words.add("MANGER");
//		words.add("INGENIERIE");
	}
	
	public Dico(String pathFile) throws IOException
	{
		this();
		this.loadDico(pathFile);
	}
	
	
	public void loadDico(String pathFile) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(pathFile));
		String ligne = br.readLine();
		if(ligne != null)
		{
			words.add(ligne.toUpperCase());
		}
		
		while(ligne != null)
		{	
			words.add(ligne.toUpperCase());
			ligne = br.readLine();
			
		}
		
		br.close();
		
	}
	
	public ArrayList<Character> getRandomWord()
	{
		int i =(int) (Math.random()*words.size());
		char[] chars = words.get(i).toCharArray();
		ArrayList<Character> word = new ArrayList<Character>();
		for(int j = 0 ; j<chars.length;j++)
		{
			word.add(new Character(chars[j]));
		}
		
		return word;
		
	}
}
