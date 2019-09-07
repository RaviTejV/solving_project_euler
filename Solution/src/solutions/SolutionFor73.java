package solutions;

public class SolutionFor73 implements Solution {

	@Override
	public void solve() throws Exception {

		Long answer = 0L;
		/*
		 * 
		 * DOESN'T WORK
		 * Long secondAnswer = 0L;
		 * 
		 * for (int i = 2; i <= 12_000; i++) { Integer totientVal =
		 * MathFunctions.totientFunction(i); answer += Math.round((double)
		 * totientVal / 6); secondAnswer+=Math.round((double) totientVal / 2) -
		 * Math.round((double) totientVal / 3); }
		 * 
		 * System.out.println(answer + " " + secondAnswer);
		 */
		
		//Trying farey's sequence
		
		Integer a = 1;
		Integer b = 3;
		Integer c = 4000;
		Integer d = 11999;
		
		while(!(c==1 && d==2)){
			
			answer++;
			
			
			Integer k = (12000 + b) / d;
			Integer e = k * c - a;
			Integer f = k * d - b;
			
			a = c;
			b = d;
			c = e;
			d = f;
			
		}
		
		System.out.println("Answer: " + answer);
		

	}

}
