package tp_pendu;

import java.util.ArrayList;

public class DessinPendu {
	
	private ArrayList<String> dessin;
	private int token;
	
	public DessinPendu()
	{
		initalise();
	}
	
	public void initalise()
	{
		dessin = new ArrayList<String>();
		for(int i =0; i<6;i++)
		{
			dessin.add(" ");
		}
		token = 0;
	}
	
	public ArrayList<String> getDessin()
	{
		return new ArrayList<String>(dessin);
	}
	
	public void affiche()
	{
		System.out.println("**"+dessin.get(dessin.size()-1));
		for (String string : dessin) {
			System.out.println(string);
		}
//		dessin.stream()
//			.forEach(s->System.out.println(s));
	}
	
	public void lostLife()
	{
		System.out.println("lostlife : "+token);
		switch (token++) {
		case 0:
			addSol();
			System.out.println("*"+dessin.get(dessin.size()-1));
			break;
		case 1:
			addPilier();
			System.out.println("*"+dessin.get(dessin.size()-2));
			break;
		case 2:
			addUp();
			break;
		case 3:
			addRope();
			break;
		case 4:
			addHead();
			break;
		case 5:
			addBody();
			break;
		case 6:
			addLegs();
			break;
		default:
			break;
		}
	}
	
	private void addSol()
	{
		dessin.set(dessin.size()-1,"|_____");
		
	}
	
	private void addPilier()
	{
		for(int i=1; i<5;i++)
		{
			dessin.set(i, "|      ");
		}	
	}
	
	private void addUp()
	{
		dessin.set(0," ____");
	}
	
	private void addRope()
	{
		dessin.set(1,"|    |");
	}
	
	private void addHead()
	{
		dessin.set(2,"|   \\O/");
	}
	
	private void addBody()
	{
		dessin.set(3,"|    |");
	}
	
	private void addLegs()
	{
		dessin.set(4, "|   / \\");
	}
	

}
