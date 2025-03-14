import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		LinkedHashMap<String, Integer> inCar = new LinkedHashMap<>();

		for(int i = 0; i < N; i ++) {
			inCar.put(sc.next(), i);
		}
		
		int count = 0;

		for(int i = 0; i < N; i ++) {
			String outCar = sc.next();
			
			Iterator<String> it = inCar.keySet().iterator();
			while(it.hasNext()) {
				if(inCar.get(outCar) > inCar.get(it.next())) {
					count++;
					break;
				}
			}
            
            inCar.remove(outCar);
		}

		System.out.println(count);
	}
}