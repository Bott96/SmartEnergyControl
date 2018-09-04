package it.unical.smartenergycontrol.logic;

import java.util.ArrayList;
import java.util.List;

public class ScheletroBactracking {

	public final int MIN, MAX;
	int SommaAttuale = 0;

	int SommaMax = 0;
	ArrayList<Integer> BestSol = new ArrayList<>();

	int KWPRODOTTIATTUALI = 0;
	ArrayList<Device> device = new ArrayList<>();
	ArrayList<Integer> sol;

	public ScheletroBactracking(ArrayList<Device> dev, int kwpro, ArrayList<Integer> sol) {
		MIN = 0;
		device = dev;
		MAX = device.size();
		KWPRODOTTIATTUALI = kwpro;
		this.sol = sol;

	}

	public final void TemplateMethod_Solve(int x) {

		//while (x < MAX) {
		if(x<MAX) {
			if (canAdd(device.get(x).getMaxKW())) {
				addSolution(device.get(x).getMaxKW());
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
				if(isComplete(x)) {
					return;
				}
				x++;
				TemplateMethod_Solve(x);
			}

		}

	}

	

	boolean isComplete(int x) {

		if (x == MAX-1) {
			if (SommaAttuale > SommaMax) {
				SommaMax = SommaAttuale;
				BestSol.clear();
				for (int i = 0; i < sol.size(); i++) {
					BestSol.add(sol.get(i));
				}

			}/*
			for (int i = 0; i < sol.size(); i++) {
				System.out.println(BestSol.get(i));
			}*/
			return true;
		}
		return false;
	}
	
	boolean canAdd(int kw) {
		System.out.println("can add-----  "+(SommaAttuale +"  "+ kw) );
		if ((SommaAttuale + kw) <= KWPRODOTTIATTUALI) {
			
			return true;
		}
		return false;
	}

	void addSolution(int kw) {
		sol.add(kw);
		SommaAttuale += kw;
		System.out.println("Somma Attuale "+ SommaAttuale);

	}

	void removeSolution(int x) {
		SommaAttuale -= sol.get(sol.size()-1);
		sol.remove(sol.size()-1);
	}
}
