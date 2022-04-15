package Driver;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.SectionDaoImplementation;
import Dao.StudentDaoImplement;
import model.Section;
import model.Student;
import model.Temporary;

import java.util.Scanner;


public class Controller {




    public static void main(String[] args) throws SQLException
    {



        Scanner sc= new Scanner(System.in);
//Registration process:
        Requests requests = new Requests();

        System.out.println("Type 1 to Login  <<>>  Type 2 to Register");
        int regchk = sc.nextInt();
        if (regchk == 2) {
            String reg= requests.regReq();
            if (reg.equals("succesful")){
                System.out.println("Regestered! Please log in....");
                String logreq=requests.logreq(1);
                if(logreq.equals("succesful")) {
                    requests.sectionStatus();
                }
                else {System.out.println(logreq);}


            }
            else {System.out.println(reg);}

        }
        else {
            int logchk;
            System.out.println("Login as a student or faculty?");
            System.out.println("Type 1 if you are student  <<>>  Type 2 if you are faculty");
            logchk = sc.nextInt();
            if (logchk == 1) { // student side
                String logreq=requests.logreq(1);
                if(logreq.equals("succesful")) {
                    requests.sectionStatus();
                }
                else {System.out.println(logreq);}

            }
            else {
                String section = requests.logreq(2); // faculty side
                SectionDaoImplementation sectionDaoImplementation=new SectionDaoImplementation();
                List<Section> ss =sectionDaoImplementation.getSection();
                StudentDaoImplement studentDaoImplement=new StudentDaoImplement();
                List<Student> ls=studentDaoImplement.getStudents();
               // System.out.println("hahahaha "+section);
                if(section.equals("succesful")){
                    StudentDaoImplement studentDaoImplement1=new StudentDaoImplement();
                    List   <Student> ls1=studentDaoImplement.getStudents();
                    sc.nextLine();
                    System.out.println("Select section to see details: Type 1 or 2");
                    String sec=sc.next(); // here
                   // System.out.println(ls1.size());
                    boolean flag = false;
                    for(int i=0;i<ls1.size();i++){
                        if(ls1.get(i).getStd_sec().equals(sec)){
                            System.out.println("Name \t\t"+"SID");
                            System.out.println(ls.get(i).getStd_name() +"         ");
                            System.out.print(ls1.get(i).getStd_id());
                            System.out.println();
                            flag = true;
                        }
                        else{
                            flag = false;
                        }

                    }
                    if (!flag){
                        System.out.println("There's no student yet in your selected section!");
                    }

                }
            }
        }

    }


}


