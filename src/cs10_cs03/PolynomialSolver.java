package cs10_cs03;



public class PolynomialSolver  implements IPolynomialSolver {
	
	public static SLinkedList[] polynomials = {new SLinkedList(), new SLinkedList(), new SLinkedList(), new SLinkedList()};

	public static int mapIndex(char poly) {
		int i=0;
		switch (poly) {
		case 'A': i=0; break;
		case 'B': i=1; break;
		case 'C': i=2; break;
		case 'R': i=3; break;
		default: throw new RuntimeException();
		}
		return i;
	}
	private  int[][] convertarray(SLinkedList poly) {
		int sizz=2;
		int[][] res = new int[poly.size()][sizz];
		for(int i=0;i<poly.size();i++) {
			res[i][0]=((Term)poly.get(i)).coeff;
			res[i][1]=((Term)poly.get(i)).exp;
		}
		return res;
	}
    private static void sortPoly(SLinkedList poly){
        int n = poly.size();
        Term temp = new Term();
         for(int i=0; i < n; i++){
                 for(int j=1; j < (n-i); j++) {
                            if(((Term)poly.get(j-1)).exp < ((Term)poly.get(j)).exp){
                            	//swap element
                            	temp.exp = ((Term)poly.get(j-1)).exp;
                                temp.coeff = ((Term)poly.get(j-1)).coeff;
                                ((Term)poly.get(j-1)).exp = ((Term)poly.get(j)).exp;
                                ((Term)poly.get(j-1)).coeff = ((Term)poly.get(j)).coeff;
                                ((Term)poly.get(j)).exp = temp.exp;
                                ((Term)poly.get(j)).coeff = temp.coeff;
                         }
                 }
         }
    }
    private static void simplifyPoly (SLinkedList poly) {

        for (int i=0; i<poly.size()-1; i++) {
        	if (((Term)poly.get(i)).exp == ((Term)poly.get(i+1)).exp) {
        		((Term)poly.get(i)).coeff += ((Term)poly.get(i+1)).coeff;
        		poly.remove(i+1);
        		i--;
        	}
        }
    }
	
	
	/**
	* Set polynomial terms (coefficients & exponents)
	* @param poly
	* name of the polynomial
	* @param terms
	* array of [coefficients][exponents]
	*/
	public  void setPolynomial(char poly, int[][] terms) {
		
		
		int index = mapIndex(poly);
		
		clearPolynomial('R');
		clearPolynomial(poly);
		
		for (int i=0; i<terms.length; i++) {
			polynomials[index].add(new Term(terms[i][0], terms[i][1]));
		}
		sortPoly(polynomials[index]);
		simplifyPoly(polynomials[index]);
	}
	/**
	* Print the polynomial in ordered human readable representation
	* @param poly
	* name of the polynomial
	* @return polynomial in the form like 27x^2+x-1
	*/
	public String print(char poly) {
		
		String polynomial = new String();
		int index = mapIndex(poly);
		
		if (polynomials[index].size() == 0) {
			return null;
		}
		
		for (int i=0; i<polynomials[index].size(); i++) {
			if (((Term)polynomials[index].get(i)).coeff == 0) {
				continue;
			} else if (((Term)polynomials[index].get(i)).coeff > 0) {
				if (i !=0) {
					polynomial += "+";
				}
			} else if (((Term)polynomials[index].get(i)).coeff < 0) {
				polynomial += "-";
			}
			if (((Term)polynomials[index].get(i)).coeff != 1 && ((Term)polynomials[index].get(i)).coeff != -1) {
				polynomial += Integer.toString(Math.abs(((Term)polynomials[index].get(i)).coeff));
			}
			if (((Term)polynomials[index].get(i)).exp == 0) {
				if (((Term)polynomials[index].get(i)).coeff == 1 ||
						((Term)polynomials[index].get(i)).coeff == -1) {
					polynomial += "1";
				}else {
				continue;
				}
			} else {
				polynomial += "x";
				if (((Term)polynomials[index].get(i)).exp != 1) {
					polynomial += "^" + Integer.toString(((Term)polynomials[index].get(i)).exp);
				}
			}
		}
		return polynomial;
	}
	/**
	* Clear the polynomial
	* @param poly
	* name of the polynomial
	*/
	public   void clearPolynomial(char poly) {
		int index = mapIndex(poly);
		polynomials[index].clear();
	}
	/**
	* Evaluate the polynomial
	* @param poly
	* name of the polynomial
	* @param the
	* polynomial constant value
	* @return the value of the polynomial
	*/
	public  float evaluatePolynomial(char poly, float value) {
		
		float polyValue = 0;
		int index = mapIndex(poly);
		
		for (int i=0; i<polynomials[index].size(); i++) {
			if(value ==0 && ((Term)polynomials[index].get(i)).exp < 0){
				throw new RuntimeException();
			}
			polyValue += ((Term)polynomials[index].get(i)).coeff 
					* Math.pow(value,((Term)polynomials[index].get(i)).exp);
		}
		
		return polyValue;	
	}
	/**
	* Add two polynomials
	* @param poly1
	* first polynomial
	* @param poly2
	* second polynomial
	* @return the result polynomial
	*/
	public   int[][] add(char poly1, char poly2){
		
		int index1 = mapIndex(poly1);
		int index2 = mapIndex(poly2);
		
		clearPolynomial('R');
		
		for (int i=0; i<polynomials[index1].size(); i++) {
			polynomials[3].add(new Term(((Term)polynomials[index1].get(i)).coeff,((Term)polynomials[index1].get(i)).exp));
		}
		
		for (int i=0; i<polynomials[index2].size(); i++) {
			polynomials[3].add(new Term(((Term)polynomials[index2].get(i)).coeff,((Term)polynomials[index2].get(i)).exp));

		}
		
		sortPoly(polynomials[3]);
		simplifyPoly(polynomials[3]);
		
		return convertarray(polynomials[3]);

	}
	/**
	* Subtract two polynomials
	* @param poly1
	* first polynomial
	* @param poly2
	* second polynomial
	* @return the result polynomial
	*/
	public  int[][] subtract(char poly1, char poly2){
		int index1 = mapIndex(poly1);
		int index2 = mapIndex(poly2);
		
		clearPolynomial('R');
		
		for (int i=0; i<polynomials[index1].size(); i++) {
			polynomials[3].add(new Term(((Term)polynomials[index1].get(i)).coeff,((Term)polynomials[index1].get(i)).exp));
		}
		
		for (int i=0; i<polynomials[index2].size(); i++) {
			polynomials[3].add(new Term(((Term)polynomials[index2].get(i)).coeff*-1,((Term)polynomials[index2].get(i)).exp));

		}
		
		sortPoly(polynomials[3]);
		simplifyPoly(polynomials[3]);
		
		return convertarray(polynomials[3]);

	}
	/**
	* Multiply two polynomials
	* @param poly1
	* first polynomial
	* @param poly2
	* second polynomial
	* @return the result polynomial
	*/
	public  int[][] multiply(char poly1, char poly2){
		int index1 = mapIndex(poly1);
		int index2 = mapIndex(poly2);
		int temp;
		int temp1;
		
		clearPolynomial('R');
		
		for(int i=0;i<polynomials[index1].size();i++) {
			for(int j=0;j<polynomials[index2].size();j++) {
				temp=((Term)polynomials[index1].get(i)).coeff*((Term)polynomials[index2].get(j)).coeff;
				temp1=((Term)polynomials[index1].get(i)).exp+((Term)polynomials[index2].get(j)).exp;
				polynomials[3].add(new Term(temp,temp1));
		
	}}
		sortPoly(polynomials[3]);
		simplifyPoly(polynomials[3]);
		return convertarray(polynomials[3]);
	
	
	
	
	
	
	
}}