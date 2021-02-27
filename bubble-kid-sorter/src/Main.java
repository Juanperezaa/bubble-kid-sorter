import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	private static ArrayList<Double> changes= new ArrayList<Double>();


	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		double change;
		int rows= Integer.parseInt(br.readLine());
		String outP="";
		for(int i=0;i<rows;i++) {
			changes.clear();
			String lines=br.readLine();
			double[] kidRowN=separate(lines);
			bubbleSort(kidRowN);
			String kidSorter=returnToString(kidRowN);
			change = amountChanges();
			
			change=change/(kidRowN.length-1);
			outP+=roundOut(change)+"-"+kidSorter;
			outP=outP.substring(0,outP.length() - 1);
			outP+="\n";
			
		}
		bw.write(outP);
		br.close();
		bw.close();
	}
	
	public static double roundOut(double a) {
		DecimalFormat df = new DecimalFormat("##.##");
		String c=a+"";
		df.format(a);
		double b=a;
		if((a-((int) a))==0){
			/*DecimalFormat df2 = new DecimalFormat("##.#");
			b=df2.format(a);
			b=String.format("%.2f", c);*/
			 b=((long)(b* 1e2)) / 1e2;
		}
		else if((a-((int) a))>0.1) {
			/*DecimalFormat df2 = new DecimalFormat("##.#");
			b=df2.format(a);
			b=String.format("%.2f", c);*/
			  b=((long)(b* 1e2)) / 1e2;
		}
		else {
			/*DecimalFormat df2 = new DecimalFormat("##.##");
			b=df2.format(a);
			b=String.format("%.3f", c);*/
			 b=((long)(b * 1e2)) / 1e2;
		}
	return b;
		 
	}
	
	public static double[] separate(String a) {
		String[] kidRows=a.split(" ");
		double[] kidRown= new double[kidRows.length];
		for(int i=0;i<kidRows.length;i++) {
			kidRown[i]=Double.parseDouble(kidRows[i]);
		}
		
		return kidRown;
		
	}
	
	public static void bubbleSort(double[] array) {
	double mChange=0;
	for(int i=1; i<array.length;i++) {
		 mChange=0;
		for(int j=0;j<array.length-i;j++) {
			if(array[j]>array[j+1]) {
				double temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;

				mChange++;
			}
		}
		changes.add(mChange);
	
	}
	
}
	
	public static String returnToString(double[] a) {
		String b="";//new String[a.length];
	for(int i=0;i<a.length;i++) {
		b+=a[i]+" ";
	}
	return b;
	}
	
	public static double amountChanges() {
		double amountChange=0;
		for(int i=0;i<changes.size();i++) {
			amountChange+=changes.get(i);
		}
		return amountChange;
	}

}
