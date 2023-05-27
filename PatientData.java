import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class PatientData {
     static ArrayList<TotalPatient> patients = new ArrayList<>();
     public static void main(String[] args) {
          
          Scanner awalan = new Scanner(System.in);

          while(true){
               choosedata(awalan);
               int pilihan = awalan.nextInt();

               switch(pilihan){
                    case 1:
                    inputdata(awalan);
                    break;

                    case 2:
                    Viewdata(awalan);
                    break;

                    case 3:
                    System.out.println("Program Exited");
                    return;

                    default:
                    System.out.println("Please input a valid choice!");

               }
          }
     }
     

     public static void choosedata(Scanner awalan) {
          System.out.println("\n     Patient's Data Program");
          System.out.println("======================");
          System.out.println("1. Input New data");
          System.out.println("2. View Patient's Data");
          System.out.println("3. Exit");
          System.out.println("Choose:");
     }

     public static void inputdata(Scanner awalan) {
          System.out.println("=====Input New Data=====");
          System.out.println("Enter name [3 to 20 characters]");
          awalan.nextLine();
          String name = awalan.nextLine();

          if(name.length() < 3){
               System.out.println("Your name is under 3 characters");
               return;
          }else if(name.length()>20){
               System.out.println("Your name is above 20 characters");
               return;
          }else{
               System.out.println(); 
          }

          System.out.println("Enter age [10 to 100]");
          int age = awalan.nextInt();

          if(age < 10){
               System.out.println("Your age is under 10");
               return;
          }else if(age > 100){
               System.out.println("Your age is above 100");
               return;
          }else if (age > 10 && age < 100){
               System.out.println();
     
          }else{
               System.out.println("Please enter a valid age");
          }

          System.out.println("Enter address [5-30 characters]");
          awalan.nextLine();
          String adress = awalan.nextLine();

          if(adress.length() < 5){
               System.out.println("Your address is below 5 characters");
               return;
          }else if(adress.length() > 30){
               System.out.println("Your address is above 30 cahracters");
               return;
          }else{
               System.out.println();
          }


          if(Check(name, age, adress)){
               TotalPatient patient = new TotalPatient(name, age, adress);
               patients.add(patient);
               System.out.println("Data has been successfully inserted!");
          }
     
     }

public static boolean Check(String name, int age, String adress) {
     return name.length() > 3 && name.length() < 20 && age >= 10 && age <= 100 && adress.length() >= 5 && adress.length() <= 30;
}

//This is a class, thx youtube
static class TotalPatient{
     String name;
     int age;
     String adress;

     public TotalPatient (String name, int age, String adress){
          this.name = name;
          this.age = age;
          this.adress = adress;
     }

     public String patientname(){
          return name;
     }

     public int patientage(){
          return age;
          }

          
     public String patientaddress(){
          return adress;
     }
}
//End of it



     public static void Viewdata(Scanner awalan) {
          if(patients.isEmpty()){
               System.out.println("No Data!!!");
               return;

          }
          System.out.println("No\tName\tAge\tAddress");
          for(int i = 0; i < patients.size(); i++){
               TotalPatient korban = patients.get(i);
               System.out.println((i+1) + "\t" + korban.patientname() + "\t" + korban.patientage() + "\t" + korban.patientaddress());

          }


          listmenu();
          int list = awalan.nextInt();

          switch(list){

               case 1:
               NameAscending();
               break;

               case 2:
               NameDescending();
               break;

               case 3:
               AgeAscending();
               break;

               case 4:
               AgeDescending();
               break;

               case 5:
               break;

               default:
               System.out.println("Please input a valid choice!!!");
               break;

          }

     }

public static void listmenu() {
     System.out.println("\n     Sort Data");
     System.out.println("====================");
     System.out.println("1. Sort Data by Name Ascending");
     System.out.println("2. Sort Data by Name Descending");
     System.out.println("3. Sort Data by Age Ascending");
     System.out.println("4. Sort Data by Age Descending");
     System.out.println("5. Back");
     System.out.println("Choose:");
     
}

public static void NameAscending() {
     Collections.sort(patients,Comparator.comparing(TotalPatient::patientname));
     System.out.println("Data sorted by name: Ascending");
}
public static void NameDescending() {
     Collections.sort(patients,Comparator.comparing(TotalPatient::patientname).reversed());
     System.out.println("Data sorted by name: Descending");
}
public static void AgeAscending() {
     Collections.sort(patients,Comparator.comparing(TotalPatient::patientage));
     System.out.println("Data sorted by age: Ascending");
}

public static void AgeDescending() {
     Collections.sort(patients,Comparator.comparing(TotalPatient::patientage).reversed());
     System.out.println("Data sorted by name: Descending");
}
}
