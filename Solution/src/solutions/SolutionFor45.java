package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SolutionFor45 implements Solution {
	/*
	 * Triangle Tn=n(n+1)/2 1, 3, 6, 10, 15, ... Pentagonal Pn=n(3n−1)/2 1, 5,
	 * 12, 22, 35, ... Hexagonal Hn=n(2n−1) 1, 6, 15, 28, 45, ...
	 */

	class SharedVariable {
		private volatile Long max_Elem = 40756L;
		
		volatile boolean changed = false;

		public Long getMax_Elem() {
			return max_Elem;
		}

		public void setMax_Elem(Long max_Elem) {
			this.max_Elem = max_Elem;
			changed = true;
//			this.notifyAll();
		}
	}

	final SharedVariable sharedVal = new SharedVariable();

	@Override
	public void solve() throws InterruptedException {

		List<Runnable> tasks = new ArrayList<>();

		tasks.add(new SequenceGenerator(s -> (s * (s + 1)) / 2));
		tasks.add(new SequenceGenerator(s -> (s * (3 * s - 1)) / 2));
		tasks.add(new SequenceGenerator(s -> (s * (2 * s - 1))));

		runTasks(tasks);

	}

	private void runTasks(List<Runnable> tasks) throws InterruptedException {

		List<Thread> threads = new ArrayList<>();
		for (Runnable task : tasks) {
			threads.add(new Thread(task));
		}

		for (Thread t : threads) {
			t.start();
		}

		for (Thread t : threads) {
			t.join();
		}
	}

	class SequenceGenerator implements Runnable {

		Long index;
		// List<Integer> series = new ArrayList<>();
		Long latest_element = 0L;
		final int LIMIT = 1000;

		Function<Long, Long> fn;

		public SequenceGenerator(Function<Long, Long> fn) {
			this.fn = fn;
			index = 0L;
			// latest_element = fn.apply(++index);
		}

		@Override
		public void run() {

			while (true) {

				if (latest_element != sharedVal.getMax_Elem()) {

					while (latest_element < sharedVal.getMax_Elem()) {
						latest_element = fn.apply(++index);
					}

					if (latest_element > sharedVal.getMax_Elem()) {
						sharedVal.setMax_Elem(latest_element);
					}
				}
				
				//TODO find appropriate break condition - current program relies on all threads printing the same value infinitely 
				
//				System.out.println(latest_element + " " + index);
			}
			
		}

	}

}
