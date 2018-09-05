package it.unical.smartenergycontrol.logic;

import java.util.ArrayList;

public class ScheletroBactracking {

	public final int MIN, MAX;
	int SommaAttuale = 0;
	int PriorityActual = 0;

	int SommaMax = 0;
	int MaxPriority = 0;
	ArrayList<Device> BestSol = new ArrayList<>();

	int KWPRODOTTIATTUALI = 0;
	ArrayList<Device> device = new ArrayList<>();
	ArrayList<Device> sol;

	public ScheletroBactracking(ArrayList<Device> dev, int kwpro, ArrayList<Device> sol) {
		MIN = 0;
		device = dev;
		MAX = device.size();
		KWPRODOTTIATTUALI = kwpro;
		this.sol = sol;

	}

	public final void TemplateMethod_Solve(int x) {

		// while (x < MAX) {
		if (x < MAX) {
			if (canAdd(device.get(x))) {
				addSolution(device.get(x));
				isComplete(x);

				x++;
				TemplateMethod_Solve(x);
				x--;
				if (x < MAX) {
					removeSolution(x);
					x++;
					TemplateMethod_Solve(x);
				}

			} else {
				if (isComplete(x)) {
					return;
				}
				x++;
				TemplateMethod_Solve(x);
			}

		}

	}

	boolean isComplete(int x) {

		if (x == MAX - 1) {
			if (PriorityActual >= MaxPriority && (SommaAttuale > SommaMax ) ) {
				SommaMax = SommaAttuale;
				MaxPriority = PriorityActual;
				BestSol.clear();
				for (int i = 0; i < sol.size(); i++) {
					BestSol.add(sol.get(i));
				}

			} /*
				 * for (int i = 0; i < sol.size(); i++) { System.out.println(BestSol.get(i)); }
				 */
			return true;
		}
		return false;
	}

	boolean canAdd(Device dv) {
		// System.out.println("can add----- "+(SommaAttuale +" "+ kw) );
		if ((SommaAttuale + dv.getMaxKW()) <= KWPRODOTTIATTUALI ) {

			return true;
		}
		return false;
	}

	void addSolution(Device dv) {
		sol.add(dv);
		SommaAttuale += dv.getMaxKW();
		if (PriorityActual < dv.getPriority())
			PriorityActual = dv.getPriority();
		// System.out.println("Somma Attuale "+ SommaAttuale);

	}

	void removeSolution(int x) {
		SommaAttuale -= sol.get(sol.size() - 1).getMaxKW();
		PriorityActual =0;
		for(int i =0; i<sol.size(); i++) {
			if (PriorityActual< sol.get(i).getPriority()) {
				PriorityActual = sol.get(i).getPriority();
			}
		}
		//PriorityActual = sol.get(sol.size() - 1).getPriority();
		sol.remove(sol.size() - 1);

	}
}
