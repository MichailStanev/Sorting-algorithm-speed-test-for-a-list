package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class View_Controller {

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

    public TextArea sortingInformation;
    public TextArea sortingCode;
    public Label viewInfoText;
    String workingDirectory = System.getProperty("user.dir");
    public void showBubbleSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\bubbleInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\bubbleCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Bubble sort information.");
    }

    public void showSelectionSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\selectionInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\selectionCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Selection sort information");
    }

    public void showInsertionSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\insertionInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\insertionCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Insertion sort information.");
    }

    public void showShellSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\shellInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\shellCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Shell sort information.");
    }

    public void showMergeSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\mergeInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\mergeCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Merge sort information.");
    }

    public void showHeapSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\heapInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\heapCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Heap sort information.");
    }

    public void showQuickSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\quickInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\quickCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Quick sort information.");
    }

    public void showBucketSort() {
        String innerPath_1 = new String("out\\production\\Test\\sample\\TextFiles\\bucketInfo.txt");
        String innerPath_2 = new String("out\\production\\Test\\sample\\TextFiles\\bucketCode.txt");

        String infoString = readLineByLineJava8(workingDirectory + File.separator + innerPath_1);
        String codeString = readLineByLineJava8(workingDirectory + File.separator + innerPath_2);

        sortingInformation.setText(infoString);
        sortingCode.setText(codeString);

        viewInfoText.setText("Bucket sort information.");
    }

    private static String readLineByLineJava8(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }



}