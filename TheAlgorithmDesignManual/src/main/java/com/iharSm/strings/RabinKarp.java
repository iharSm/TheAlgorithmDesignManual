package com.iharSm.strings;


class RabinKarp {

	public long alpha;
	public long alphaPowM;
	public String input;
	public String substr;

	private long hash;

	private long initHash(String strToHash, int len) {
		long h = 0;
		long pow = 1;

		for (int i = len - 1; i >= 0; i--) {
			h += pow * (int) strToHash.charAt(i); // h(x) = c_n + c_n-1 * pow +
													// ... c_0 * pow^len-1
			pow *= alpha;
			if (pow < 0)
				pow = -1 * pow;
		}
		return h;
	}

	private long updateHash(long hash, char add, char remove) {
		return hash * alpha - alphaPowM * (int) remove + (int) add;
	}

	public int findSubstr() {
		hash = initHash(input, substr.length());
		long substrHash = initHash(substr, substr.length());

		int i = 0;
		while (i <= (input.length() - substr.length())) {
			if (substrHash == hash)
				return i;

			hash = updateHash(hash, input.charAt(i + substr.length()),
					input.charAt(i));
			i++;

		}
		return -1;
	}

	public static void main(String[] args) {
		RabinKarp rk = new RabinKarp();
		rk.alpha = 13;

		rk.input = "google";
		rk.substr = "e";
		rk.alphaPowM = (long) Math.pow(rk.alpha, rk.substr.length());
		System.out.println(rk.findSubstr());

	}

};
