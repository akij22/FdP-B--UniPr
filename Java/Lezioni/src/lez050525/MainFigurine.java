package lez050525;

import java.util.*;

public class MainFigurine {

	public static void main(String[] args) {
		
		Figurina f1 = new FigurinaSportiva(53);
		Figurina f2 = new FigurinaSportiva(39);
		Figurina f3 = new FigurinaSportiva(99);
		
		Figurina ff1 = new FigurinaStorica(91);
		
		Album a1 = new Album("MyAlbum");
		
		a1.add(ff1);
		a1.add(f1);
		a1.add(f2);
		a1.add(f3);
		
		Collection<Figurina> s1 = a1.getAllFigurineSportive();
		Collection<Figurina> s2 = a1.getAllFigurineStoriche();
		

	}

}
