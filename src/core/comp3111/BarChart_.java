package core.comp3111;

import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChart_ extends Application {
	@Override public void start(Stage stage) throws DataTableException {
		stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");       
        yAxis.setLabel("Value");
        
        /////////////////////////////////////////////////////////////////
        DataTable t = new DataTable();

        //
        String[] Year = new String[] {"2003", "2004", "2005"};
        DataColumn YearCol = new DataColumn("text", Year);
        
        
		// Sample: An array of integer
		Number[] austria = new Integer[] { 25601, 57401, 45000};
		DataColumn austriaCol = new DataColumn("numeric", austria);
		
		// Sample: An array of integer
		Number[] brazil = new Integer[] { 20148, 41941, 44835};
		DataColumn brazilCol = new DataColumn("numeric", brazil);
		
		// Sample: An array of integer
		Number[] france = new Integer[] { 10000, 45263, 18722};
		DataColumn franceCol = new DataColumn("numeric", france);
		
		// Sample: An array of integer
		Number[] italy = new Integer[] { 35407, 117320, 17557};
		DataColumn italyCol = new DataColumn("numeric", italy);
		
		// Sample: An array of integer
		Number[] usa = new Integer[] { 12000, 14845, 92633};
		DataColumn usaCol = new DataColumn("numeric", usa);
				

		t.addCol("Year", YearCol);
		t.addCol("Austria", austriaCol);
		t.addCol("Brazil", brazilCol);
		t.addCol("France", franceCol);
		t.addCol("Italy", italyCol);
		t.addCol("USA", usaCol);
		
		Set<String> keys_before = t.getDC().keySet();
    	for (String key_before : keys_before) {
    		System.out.print(key_before + " ");
    		for (int i = 0; i < t.getNumRow(); i++) {
    			System.out.print(t.getCol(key_before).getData()[i] + " ");
    		}
    		System.out.println();
    	}
		
		
		

        ///////////////////////////////////////////////////////////////////
        
      DataTable dataset = t;
    	int numKey = dataset.getNumCol();
    	int numTextCol = 1;
    	int numNumericCol = numKey - numTextCol;
    	int rowSize = dataset.getNumRow();
    	
    	String[] textCol = new String[rowSize];
    	String[] keyRow = new String[numKey];
    	float[][] data = new float[numNumericCol][rowSize];
    	int j = 1;
    	Set<String> keys = dataset.getDC().keySet();
    	for (String key : keys) {
    		if (dataset.getCol(key).getTypeName() == DataType.TYPE_STRING) {
    			keyRow[0] = key;
    			for (int i = 0; i < rowSize; i++) {
    				textCol[i] = (String) dataset.getCol(key).getData()[i];
    			}
    		}
    		if (dataset.getCol(key).getTypeName() == DataType.TYPE_NUMBER) {
    			keyRow[j] = key;
    			for (int i = 0; i < rowSize; i++) {
    				data[j][i] = Float.parseFloat((String) dataset.getCol(key).getData()[i]);
    			}
    			j++;
    		}
    	}
    	
    	for (int i = 0; i < numKey; i++) {
    		System.out.print(keyRow[i] + " ");
    	}
    	System.out.println();
    	for (int m = 0; m < rowSize; m++) {
    		for (int k = 0; k < numNumericCol; k++) {
    			System.out.print(textCol[m] + " ");
    			System.out.print(data[k][m]);
    		}
    		System.out.println();
    	}
    	
//    	XYChart.Series series[] = new XYChart.Series[rowSize-1];
//    	for (int i = 0; i < rowSize - 1 ; i++) {
//    		series[i].setName(textCol[i]);
//    		for (int k = 1; k < numKey; k++) {
//    			series[i].getData().add(new XYChart.Data(Key[k], data[k][i]));
//    		}
//    	}
//    	
//    	bc.getData().clear();
//
//    	
//        Scene scene  = new Scene(bc,800,600);
//    	for (int i = 0; i < rowSize - 1; i++) {
//    		bc.getData().add(series[i]);
//    	}
//        stage.setScene(scene);
//        stage.show();
    	}
	public static void main(String[] args) {
        launch(args);
    }
}