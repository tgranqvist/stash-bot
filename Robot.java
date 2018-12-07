public class Robot {
	
	public Robot(Piles piles) {
		this.maxWidth = piles.getWidth();
		this.piles = piles;
		
	}
	
	public void execute(String command) {
		for (char cmd : command.toCharArray()) {
			switch (cmd) {
				case 'P': 
					pickup(); 
					break;
				case 'M':
					move();
					break;
				case 'L':
					lower();
					break;
				default:
					System.out.format("Unknown command %c", cmd);
			}
		}
		System.out.println(piles);
	}
	
	@Override
	public String toString() {
		return String.format("Robot is at position %d %s a block", position, hasBlock ? "with" : "without");
	}
	
	/* PRIVATE */
	
	private final Piles piles;
	private final int maxWidth;
	private int position = 0;
	private boolean hasBlock = false;
	
	/* Pick up a block from the stash.
	 * The rules are:
	 * - the stash is never empty
	 * - after pickup, move to position 0
	 * - if the robot already holds a block, reset position to 0
	 */
	private void pickup() {
		hasBlock = true;
		position = 0;
	}
	
	
	/* Advance the robot one step
	 * The rules are:
	 * - the robot will not go beyond maxWidth, trying to move further does nothing.
	 */
	private void move() {
		position = Math.min(++position, maxWidth);
	}
	
	
	/* Lower a block to the pile at the current location.
	 * The rules are:
	 * - lowering the block on a pile of 15 does nothing
	 * - lowering without a block does nothing
	 */
	private void lower() {
		if (piles.drop(position)) {
			hasBlock = false;
		}
	}
}