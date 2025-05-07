package lez050525;

public class FigurinaStorica extends Figurina{

	public FigurinaStorica(int id) {
		
		// Delego costruttore della superclasse
		super(id);
		
	}

	@Override
	public boolean isRare() {
		
		return this.id % 3 == 0;
		
	}
	

}
