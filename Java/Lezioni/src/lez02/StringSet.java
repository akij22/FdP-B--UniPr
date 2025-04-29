package lez02;



public class StringSet {
	
	private String[] s;

	public StringSet() {
		s = new String[0];
	}

	public void add(String x) {
		if (!contains(x)) {
			String[] newSet = new String[s.length + 1];
			for (int i = 0; i < s.length; i++)
				newSet[i] = s[i];

			newSet[s.length] = x;
			s = newSet;
		}
	}

	public boolean contains(String elem) {
		for (int i = 0; i < s.length; i++)
			if (s[i].equals(elem))
				return true;
		return false;
	}

	public int size() {
		return s.length;
	}

	public boolean isSubsetOf(StringSet other) {
		if (size() > other.size())
			return false;

		for (int i = 0; i < s.length; i++)
			if (!other.contains(s[i]))
				return false;
		return true;
	}

	public StringSet intersection(StringSet other) {
		StringSet result = new StringSet();
		for (int i = 0; i < size(); i++)
			if (contains(s[i]) && other.contains(s[i]))
				result.add(s[i]);

		return result;
	}

	public StringSet union(final StringSet other) {
		StringSet result = new StringSet();

		for (int i = 0; i < size(); i++)
			result.add(s[i]);

		for (int i = 0; i < other.size(); i++)
			result.add(other.s[i]);

		return result;
	}

	public void print() {
		String r = "{";
		for (int i = 0; i < size(); i++) {
			r += s[i];

			if (i < size() - 1)
				r += ", ";
		}
		r += "}\n";

		System.out.println(r);
	}


	public static void main(String[] args) {
		StringSet S1 = new StringSet();
		S1.add("topo");
		S1.add("gatto");
		S1.add("il");
		S1.add("e");

		S1.print();

		StringSet S2 = new StringSet();
		S2.add("e");
		S2.add("il");
		S2.add("ciao");

		S2.print();

		StringSet S3 = S1.union(S2);
		S3.print();
		System.out.println(S1.isSubsetOf(S3));
		System.out.println(S2.isSubsetOf(S3));
		
		StringSet S4 = S1.intersection(S2);
		S4.print();
	}
}
