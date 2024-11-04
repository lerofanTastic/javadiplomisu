package application;

import java.io.BufferedReader;  

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.io.FileOutputStream;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;  
import java.io.FileNotFoundException;
import java.util.*;


public class MainSceneController {
	
	@FXML
	ObservableList<String> rowList = FXCollections.observableArrayList();
	@FXML
	ObservableList<String> rowList2 = FXCollections.observableArrayList();
	@FXML
	ObservableList<String> rowList3 = FXCollections.observableArrayList();

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnback;
    @FXML
    private Button btnVetv;
    @FXML
    private Button btnVeng;
    @FXML
    private Button btnSimp;
    @FXML
    private Button btnSolveVetvi;
    @FXML
    private Button btnSolveVeng;
    @FXML
    private Button btnSolveVeng2;
    @FXML
    private Button btnSolveSimp;
    
    @FXML
    private ListView<String> listSimp;
    @FXML
    private ListView<String> listVetv;
    @FXML
    private ListView<String> listVeng;
    @FXML
    private ListView<String> listVeng2;

    @FXML
    private Pane paneSimp;
    @FXML
    private Pane paneVetv;
    @FXML
    private Pane paneVeng;
    
    @FXML
    private TextArea txtSimp;
    @FXML
    private TextArea txtVetvi;
    @FXML
    private TextArea txtVeng;
    @FXML
    private TextArea txtOgr;
    @FXML
    private TextArea txtPerem;
    
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    public void handleBtn1() throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("Vetv.fxml"));
		Stage window = (Stage) btn1.getScene().getWindow();
    	window.setScene(new Scene(root, 1000, 800));
    }
    
    public void handleBtn2() throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("Veng.fxml"));
		Stage window = (Stage) btn2.getScene().getWindow();
    	window.setScene(new Scene(root, 1000, 800));
    }
    
    public void handleBtn3() throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("Simpl.fxml"));
		Stage window = (Stage) btn3.getScene().getWindow();
    	window.setScene(new Scene(root, 1000, 800));
    }
    
    public void handleBtnBack() throws Exception{
    	Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Stage window = (Stage) btnback.getScene().getWindow();
    	window.setScene(new Scene(root, 800, 400));
    }
    
    public void handleBtnVetv() throws Exception{
    	
    	String str = txtVetvi.getText(); 
        File f = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\file.txt"); 
        try (FileWriter fw = new FileWriter(f)) {
			fw.write(str+"\n"); 
		}
    }
    
     
    public void handleBtnSolveVetvi() throws Exception{   	 
    	
    	 File  file = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\answer.txt");
         FileOutputStream fileOutputStream = new FileOutputStream(file);
         PrintStream printStream1 = new PrintStream(fileOutputStream);
         System.setOut(printStream1);
    	    final String PATH = "D:\\prg\\eclipse\\codes\\MathApp\\src\\file.txt";
    	  new Vetvi(PATH).bfs();
    	  
    	 try { 
    	 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    	 String line=reader.readLine();
    	 rowList.add(line);
    	 while(line!=null) {
    		 line=reader.readLine();
    		 if(line!=null) {
    			 rowList.add(line);
    		 }
    	 }
    	 
    	 } catch(FileNotFoundException e) {
    		 
    	 } catch(IOException e) {
    		 
    	 }
    	 listVetv.setItems(rowList);
     	 
    }
    
    public void handleBtnVeng() throws Exception{
    	String str = txtVeng.getText(); // Получаем текст из tf и присваиваем его в str.
        File f = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\fileveng.txt"); // Создаем файл в корне проекта
        try (FileWriter fw = new FileWriter(f)) {
			fw.write(str+"\n"); // Запись текста в файл
		}

    }
    
    public void handleBtnSolveVeng() throws Exception{
    	
    	File  f = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\answerveng.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream1 = new PrintStream(fileOutputStream);
        System.setOut(printStream1);
    	
    	File file = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\fileveng.txt");
        Scanner scan = new Scanner(file); 
        int row = 0;
        int col = 0;
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            row++;     
        }
        System.out.println("Количество рядов: " +row);

         scan = new Scanner (file);
        String sn = scan.nextLine();
        String [] otLine = sn.split(" ");
        for (int i = 0; i < otLine.length; i++){
            col++;
        }
        System.out.println("Количество столбцов: "+col);
        
         scan = new Scanner (file);
        double [][] arr = new double[row][col];   
        for(int i = 0; i < row; i++) {       
            for(int j = 0; j < col; j++) {
                arr[i][j] = scan.nextDouble();
                System.out.print("\t"+arr[i][j] );
               
            }
            System.out.println();
        }
        VengrMin hbm = new VengrMin(arr);
        int[] result = hbm.execute();
        System.out.println("Оптимальное назначение: " + Arrays.toString(result));
        scan.close(); 
        
        
        try { 
       	 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
       	 String line=reader.readLine();
       	 rowList.add(line);
       	 while(line!=null) {
       		 line=reader.readLine();
       		 if(line!=null) {
       			 rowList.add(line);
       		 }
       	 }
       	 
       	 } catch(FileNotFoundException e) {
       		 
       	 } catch(IOException e) {
       		 
       	 }
       	 listVeng.setItems(rowList);
        

    }
    
    public void handleBtnSolveVeng2() throws Exception {
    	File  f = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\answerveng2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream1 = new PrintStream(fileOutputStream);
        System.setOut(printStream1);
        
    	File file = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\fileveng.txt");
        Scanner scan = new Scanner(file); 
       int row = 0;
        int col = 0;
        while (scan.hasNextLine()){
            String line = scan.nextLine();
           row++;     
        }
        System.out.println("Количество рядов: " +row);

         scan = new Scanner (file);
        String sn = scan.nextLine();
        String [] otLine = sn.split(" ");
        for (int i = 0; i < otLine.length; i++){
            col++;
        }
        System.out.println("Количество столбцов: "+col);
         
         scan = new Scanner (file);
        int[][] arr = new int[row][col];   
        for(int i = 0; i < row; i++) {       
            for(int j = 0; j < col; j++) {
                arr[i][j] = scan.nextInt();
               System.out.print("\t"+arr[i][j] );
              
            }
              System.out.println();
              
         }
        
        //
         scan.close(); 	
    	
      // the problem is written in the form of a matrix
    

      //find optimal assignment
      VengMax ha = new VengMax(arr);
      int[][] assignment = ha.findOptimalAssignment();

      if (assignment.length > 0) {
        // print assignment
        for (int i = 0; i < assignment.length; i++) {
          System.out.print("Столбец " + assignment[i][0] + " => Ряд " + assignment[i][1] + " (" + arr[assignment[i][0]][assignment[i][1]] + ")");
          System.out.println();
        }
      } else {
        System.out.println("Назначение не найдено!");
      }
      try { 
        	 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        	 String line=reader.readLine();
        	 rowList2.add(line);
        	 while(line!=null) {
        		 line=reader.readLine();
        		 if(line!=null) {
        			 rowList2.add(line);
        		 }
        	 }
        	 
        	 } catch(FileNotFoundException e) {
        		 
        	 } catch(IOException e) {
        		 
        	 }
        	 listVeng2.setItems(rowList2);
    }
    
    public void handleBtnSimp() throws Exception{
    	String str = txtSimp.getText(); // Получаем текст из tf и присваиваем его в str.
        File f = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\filesimp.txt"); // Создаем файл в корне проекта
        try (FileWriter fw = new FileWriter(f)) {
			fw.write(str+"\n"); // Запись текста в файл
		}
    	
    }
    public void handleBtnSolveSimp() throws Exception {
    	File  f = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\answersimp.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        PrintStream printStream1 = new PrintStream(fileOutputStream);
        System.setOut(printStream1);
    	
    	 File file = new File("D:\\prg\\eclipse\\codes\\MathApp\\src\\filesimp.txt");
         Scanner scan = new Scanner(file); 
        int row = 0;
         int col = 0;
         while (scan.hasNextLine()){
             String line = scan.nextLine();
            row++;     
         }
         System.out.println("Количество рядов: " +row);

          scan = new Scanner (file);
         String sn = scan.nextLine();
         String [] otLine = sn.split(" ");
         for (int i = 0; i < otLine.length; i++){
             col++;
         }
         System.out.println("Количество столбцов: "+col);
          
          scan = new Scanner (file);
         float[][] arr = new float[row][col];   
         for(int i = 0; i < row; i++) {       
             for(int j = 0; j < col; j++) {
                 arr[i][j] = scan.nextInt();
                System.out.print("\t"+arr[i][j] );
               
             }
               System.out.println();
               
          }
         
         //
          scan.close(); 
    		
        
        boolean quit = false;
        int a = Integer.parseInt(txtPerem.getText());
        int b = Integer.parseInt(txtOgr.getText());
        
        Simplex simplex = new Simplex(b, a);
        
        simplex.fillTable(arr);

        // print it out
        System.out.println("Начальная позиция");
        simplex.print();
        
        // if table is not optimal re-iterate
        while(!quit){
            Simplex.ERROR err = simplex.compute();

            if(err == Simplex.ERROR.IS_OPTIMAL){
            	System.out.println("Конечная позиция: ");
                simplex.print();
                simplex.printLast(); 
                quit = true;
            }
            else if(err == Simplex.ERROR.UNBOUNDED){
                System.out.println("Ошибка!");
                quit = true;
            }
        }
        try { 
          	 BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
          	 String line=reader.readLine();
          	 rowList3.add(line);
          	 while(line!=null) {
          		 line=reader.readLine();
          		 if(line!=null) {
          			 rowList3.add(line);
          		 }
          	 }
          	 
          	 } catch(FileNotFoundException e) {
          		 
          	 } catch(IOException e) {
          		 
          	 }
          	 listSimp.setItems(rowList3);
    }
    
    @FXML
    public void peremPressHandler(ActionEvent event) {
    	txtPerem.setText("");
        Button b = (Button) event.getSource();
        txtPerem.appendText(b.getText());
    }
    @FXML
    public void ogrPressHandler(ActionEvent event) {
    	txtOgr.setText("");
        Button b = (Button) event.getSource();
        txtOgr.appendText(b.getText());
    }

}
