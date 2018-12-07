public class Main {
	
	public static void main(String[] args) {
		
		Robot robot = new Robot(new Piles(10, 15));
		System.out.println(robot);
		
		robot.execute("PMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPML");
		robot.execute("PLPLPMMMMML");
		
	}
	
	private static final String TEST_COMMAND = "PMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMLPMMMLPMLPMMLPMMMMMMMMMMLPMMMMMMMMMML"; 
}