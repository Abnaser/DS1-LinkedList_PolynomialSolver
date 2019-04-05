package cs10_cs03;

public class Garbage {

	public static void main(String[] args) {
        PolynomialSolver instance = new PolynomialSolver();
        instance.setPolynomial('A',
                new int[][]{ {10,10}, {9,9}, {8,8}, {7,7}, {6,6}, {5,5}, {4,4}, {3,3}, {2,2}, {1,1}, {10,0} });
        
        int[][] result1 = instance.subtract('A', 'A');

        
        System.out.println(instance.print('R'));
        System.out.println(result1[0][1]);

        


        








	}

}
