package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Test_list {

    public void goToViewAlgorithms(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    public void goToTestList(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("runTest.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public TextArea textToSort;
    public int counter=0;
    public void getFile() throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        StringBuilder stringBuilder = new StringBuilder();
        textToSort.setText("");

        if(fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
            java.io.File file = fileChooser.getSelectedFile();
            Scanner input = new Scanner(file);

            while (input.hasNext()){
                counter++;
                stringBuilder.append(input.nextLine());
                stringBuilder.append("\n");
            }

            input.close();

            textToSort.setText(stringBuilder.toString());
            textToSort.setEditable(false);
            //System.out.println(textToSort.getText());
        }

        else{
            stringBuilder.append("No file selected...");
        }
    }


    public RadioButton radioButtonText;
    public RadioButton radioButtonNumbers;
    public HBox swapThing;

    public void checkList(){
        //Initialising Chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Sorting algorithms");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Efficiency in percentage");
        BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Results");
        XYChart.Series series = new XYChart.Series();
        series.setName("Test results");
        bc.setLegendVisible(false);



        //Calculating results
        if(radioButtonNumbers.isSelected()){
            //Initialising list
            String tempStr = new String(textToSort.getText());
            String[] tempStringArray = tempStr.split("\n");
            int[] intListArray = Arrays.stream(tempStringArray).mapToInt(Integer::parseInt).toArray();
            int[] tempArray;
            double[] results = new double[8];

            //Bubble Sort
            tempArray = intListArray;
            System.gc();
            int startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            long startTime = System.nanoTime();

            executeListCheck.doBubbleSort(tempArray);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            int endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray){
                System.out.print(i);
                System.out.print(", ");
            }
            results[0]=duration;


            //Bucket Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doBucketSort(tempArray);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[1]=duration;


            //Heap Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doHeapSort(tempArray , 0 , (intListArray.length-1));

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[2]=duration;


            //Insertion Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doInsertionSort(tempArray);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[3]=duration;


            //Merge Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doMergeSort(tempArray);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[4]=duration;


            //Selection Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doSelectionSort(tempArray);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[5]=duration;


            //Shell Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doShellSort(tempArray);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[6]=duration;


            //Quick Sort
            tempArray = intListArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            //executeListCheck.doQuickSort(tempArray);
            executeListCheck.quickSort(tempArray , 0,tempArray.length-1);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(int i:tempArray) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[7]=duration;

            double tempMinNum = results[0];
            for (int i=0 ; i < 8 ; i++){
                if (tempMinNum > results[i]){
                    tempMinNum = results[i];
                }
            }

            series.getData().add(new XYChart.Data("Bubble sort", tempMinNum/results[0]*100));
            series.getData().add(new XYChart.Data("Bucket sort", tempMinNum/results[1]*100));
            series.getData().add(new XYChart.Data("Heap sort", tempMinNum/results[2]*100));
            series.getData().add(new XYChart.Data("Insertion sort", tempMinNum/results[3]*100));
            series.getData().add(new XYChart.Data("Merge sort", tempMinNum/results[4]*100));
            series.getData().add(new XYChart.Data("Selection sort", tempMinNum/results[5]*100));
            series.getData().add(new XYChart.Data("Shell sort", tempMinNum/results[6]*100));
            series.getData().add(new XYChart.Data("Quick sort", tempMinNum/results[7]*100));

            /*
            series.getData().add(new XYChart.Data("Bubble sort", results[0]));
            series.getData().add(new XYChart.Data("Bucket sort", results[1]));
            series.getData().add(new XYChart.Data("Heap sort", results[2]));
            series.getData().add(new XYChart.Data("Insertion sort", results[3]));
            series.getData().add(new XYChart.Data("Merge sort", results[4]));
            series.getData().add(new XYChart.Data("Selection sort", results[5]));
            series.getData().add(new XYChart.Data("Shell sort", results[6]));
            series.getData().add(new XYChart.Data("Quick sort", results[7]));
            */
        }

        else if (radioButtonText.isSelected()){
            //Initialising list
            String tempStr = new String(textToSort.getText());
            String[] tempStringArray = tempStr.split("\n");
            String[] tempString;
            double[] results = new double[4];

            //Bubble Sort (Text)
            tempString = tempStringArray;
            System.gc();
            int startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            long startTime = System.nanoTime();

            executeListCheck.doBubbleSortText(tempString);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            int endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(String i:tempString) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[0]=duration;


            //Insertion Sort (Text)
            tempString = tempStringArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doInsertionSortText(tempString);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(String i:tempString) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[1]=duration;


            //MSD String Sort
            tempString = tempStringArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doMSDStringSort(tempString);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(String i:tempString) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[2]=duration;


            //Three Way String QuickSort
            tempString = tempStringArray;
            System.gc();
            startMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            startTime = System.nanoTime();

            executeListCheck.doThreeWSQS(tempString);

            endTime = System.nanoTime();
            duration = (endTime - startTime);
            endMem = (int) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

            System.out.println("\n" + startMem + "  |  " + endMem);
            System.out.println("Calculation time : " + duration);
            for(String i:tempString) {
                System.out.print(i);
                System.out.print(", ");
            }
            results[3]=duration;

            double tempMinNum = results[0];
            for (int i=0 ; i < 4 ; i++){
                if (tempMinNum > results[i]){
                    tempMinNum = results[i];
                }
            }
            series.getData().add(new XYChart.Data("Bubble Sort(String)", tempMinNum/results[0]*100));
            series.getData().add(new XYChart.Data("Insertion Sort(Text)", tempMinNum/results[1]*100));
            series.getData().add(new XYChart.Data("MSD String sort", tempMinNum/results[2]*100));
            series.getData().add(new XYChart.Data("Tree way strong quick sort", tempMinNum/results[3]*100));

        }

        bc.getData().add(series);
        swapThing.setHgrow(bc , Priority.ALWAYS);
        swapThing.getChildren().remove(textToSort);
        swapThing.getChildren().add(bc);
    }
}