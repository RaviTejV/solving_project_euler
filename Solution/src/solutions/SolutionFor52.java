package solutions;

import utils.StringUtils;

public class SolutionFor52 implements Solution {

	@Override
	public void solve() throws Exception {
//follow brute force
		for(Integer i = 1; ; i++){
			int digitHash = StringUtils.digitHash(i);
			if (digitHash == StringUtils.digitHash(2*i) &&
					digitHash == StringUtils.digitHash(3*i) &&
					digitHash == StringUtils.digitHash(4*i) &&
					digitHash == StringUtils.digitHash(5*i) &&
					digitHash == StringUtils.digitHash(6*i)){
				for(int x=1; x < 7; x++){
					System.out.print(i*x + " ");
				}
				break;
			}
		}
		
//		System.out.println(StringUtils.digitHash(2));
	}

}
