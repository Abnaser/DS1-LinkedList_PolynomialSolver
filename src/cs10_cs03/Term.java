package cs10_cs03;

public class Term {
	
	int coeff = 0;
	int exp = 0;
	int ss = 0;
	
	public Term() {
		coeff=0;
		exp=0;
		
	}
	
	public Term(int c, int e) {
		coeff = c;
		exp = e;
	}
	public Term(int c,int e,int s) {
		coeff = c;
		exp = e;
		ss=s;
	}

}
