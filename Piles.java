public class Piles {
	
	public Piles(int width, int height) {
		this.width = width - 1; // - 1 because of zreo indexing
		this.height = height;
		piles = new int[width];
	}
	
	public boolean drop(int position) {
		boolean positionValid = position <= (this.width - 1);
		boolean pileAvailable = this.piles[position] < this.height;
		
		if (positionValid && pileAvailable) {
			piles[position]++;
		}
		
		return positionValid && pileAvailable;
	}
	
	@Override
	public String toString() {
		StringBuffer res = new StringBuffer();
		
		for (int i = 0; i < piles.length; i++) {
			res.append(String.format("%d: %02x ", i, piles[i]));
		}
		return res.toString();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	/* PRIVATE */
	private final int width;
	private final int height;
	
	private final int[] piles;
	
}