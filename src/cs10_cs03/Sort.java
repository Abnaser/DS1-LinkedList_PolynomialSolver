package cs10_cs03;

import java.util.Comparator;

public class Sort implements Comparator<Term>  {
	public int compare(Term term1, Term term2) {
		return term1.exp - term2.exp;
	}

}
